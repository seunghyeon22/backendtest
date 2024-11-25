package co.kr.metacoding.backendtest.util;

import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

// Spring AOP를 활용한 로깅 구현
@Aspect
@Component
public class LogUserAgentAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(LogUserAgentAspect.class);

    @Before("execution(* co.kr.metacoding.backendtest.user.UserController.*(..))")
    public void log(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if(attributes != null ) {
            HttpServletRequest request = attributes.getRequest();
            String userAgent = request.getHeader("User-Agent");
            LOGGER.info("Client Agent" + userAgent);
        }
    }
}
