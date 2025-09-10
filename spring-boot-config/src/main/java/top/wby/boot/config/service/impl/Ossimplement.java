package top.wby.boot.config.service.impl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.ObjectMetadata;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import top.wby.boot.config.config.OssConfig;
import top.wby.boot.config.service.OssService;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

@Slf4j
@Service
public class Ossimplement implements OssService {
    @Resource // 注入 OssConfig 配置类
    private OssConfig ossConfig;
    @Override
    public String upload(MultipartFile file) {
        if (file != null) {
            String originalFilename = file.getOriginalFilename();
//            获取文件后缀名加上时间戳
            assert originalFilename != null;
            String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
            String newFileName = UUID.randomUUID() + suffix;
            log.info("新文件名:{}",newFileName );
//            读取配置文件
            String endpoint = ossConfig.getEndpoint();
            String bucketName = ossConfig.getBucketName();
            String accessKeyId = ossConfig.getAccessKeyId();
            String accessKeySecret = ossConfig.getAccessKeySecret();
            String dir = ossConfig.getDir();
            String uploadPath = dir + newFileName;
            OSS oss = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
            ObjectMetadata meta = new ObjectMetadata();
            meta.setContentType("image/jpg");
            try {
                InputStream inputStream = file.getInputStream();
                oss.putObject(bucketName, uploadPath,inputStream, meta);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            oss.shutdown();
           return "https://" + bucketName + "." + endpoint + "/" + uploadPath;
        }
        return "上传失败";
    }
}
