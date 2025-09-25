package top.wby.service;

import org.springframework.stereotype.Service;
import top.wby.exception.Myexception;
@Service
public class ExceptionService {
    public void unAuthorized() throws Myexception {
        throw new Myexception("权限不足");
    }
    public  void systemError(){
        throw new Myexception("系统异常");
    }
}
