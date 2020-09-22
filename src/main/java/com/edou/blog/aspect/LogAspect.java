package com.edou.blog.aspect;

import com.edou.blog.model.RequestLog;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName LoginAspect
 * @Description 日志切面类
 * @Author 中森明菜
 * @Date 2020/9/21 20:37
 * @Version 1.0
 */
@Aspect
@Component
public class LogAspect {

    private final Logger LOGGER = LoggerFactory.getLogger(LogAspect.class);

    @Pointcut("execution(* com.edou.blog.web.*.*(..))")
    public void logPointCut() {
    }

    @Before("logPointCut()")
    public void doBefore(JoinPoint joinPoint) {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();
        String url = request.getRequestURL().toString();
        String ip = request.getRemoteAddr();
        String declaringTypeName = joinPoint.getSignature().getDeclaringTypeName();
        String name = joinPoint.getSignature().getName();
        String classMethod = declaringTypeName + "." + name;
        RequestLog requestLog = new RequestLog(url, ip, classMethod, joinPoint.getArgs());
        LOGGER.info("Request ------------ {}", requestLog);
    }

    @After("logPointCut()")
    public void doAfter() {

    }

    @AfterReturning(returning = "result", pointcut = "logPointCut()")
    public void doAfterReturning(Object result) {
        LOGGER.info("Return ------------ {}", result);
    }
}
