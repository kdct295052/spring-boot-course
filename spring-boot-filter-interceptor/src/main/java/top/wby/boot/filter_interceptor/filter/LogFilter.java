package top.wby.boot.filter_interceptor.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Enumeration;

@Slf4j
@Component
public class LogFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig){
        log.info("LogFilter 初始化");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String url = httpRequest.getRequestURL().toString();
        String method = httpRequest.getMethod();
        String ip = httpRequest.getRemoteAddr();
        StringBuilder params = new StringBuilder();
        Enumeration<String> paramNames = httpRequest.getParameterNames();
        while (paramNames.hasMoreElements()) {
            String name = paramNames.nextElement();
            params.append(name).append("=").append(httpRequest.getParameter(name)).append("&");
        }
        String paramStr = !params.isEmpty() ? params.substring(0, params.length() - 1) : "";

        log.info("请求开始 - URL: {}, 方法: {}, IP: {}, 参数: {}", url, method, ip, paramStr);

        // 2. 放行请求（必须调用，否则请求会被拦截）
        long startTime = System.currentTimeMillis();
        // 执行后续过滤器或控制器
        chain.doFilter(request, response);
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        long endTime = System.currentTimeMillis();

        // 3. 后处理：记录耗时
        log.info("请求结束 - URL: {}, 耗时: {}ms", url, endTime - startTime);
    }
    @Override
    public void destroy() {
        log.info("LogFilter 销毁...");
    }

}
