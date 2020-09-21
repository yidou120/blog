package com.edou.blog.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * @ClassName ControllerExceptionHandler
 * @Description 统一异常控制器
 * @Author 中森明菜
 * @Date 2020/9/20 17:38
 * @Version 1.0
 */
@ControllerAdvice
public class ControllerExceptionHandler {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(Exception.class)
    public ModelAndView exceptionHandler(HttpServletRequest request, Exception e) throws Exception {
        LOGGER.error("Request URL : {}, Exception : {}",request.getRequestURL(),e.getClass());
        if(Objects.nonNull(AnnotationUtils.findAnnotation(e.getClass(),ResponseStatus.class))){
            throw e;
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("error/error");
        modelAndView.addObject("url",request.getRequestURL());
        modelAndView.addObject("exception",e);
        return modelAndView;
    }

}
