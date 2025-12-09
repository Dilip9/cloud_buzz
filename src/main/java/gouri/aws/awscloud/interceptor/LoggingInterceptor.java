package gouri.aws.awscloud.interceptor;

import jakarta.servlet.http.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

@Slf4j
public class LoggingInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler) {
        log.info("➡️ {} {}", req.getMethod(), req.getRequestURI());
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest req, HttpServletResponse res, Object handler, Exception ex) {
        log.info("⬅️ {} {} (status={})", req.getMethod(), req.getRequestURI(), res.getStatus());
    }
}

