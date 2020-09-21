package com.edou.blog.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @ClassName NotFoundExcepiton
 * @Description 自定义异常类
 * @Author 中森明菜
 * @Date 2020/9/20 17:59
 * @Version 1.0
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundExcepiton extends RuntimeException {
    public NotFoundExcepiton() {
        super();
    }

    public NotFoundExcepiton(String message) {
        super(message);
    }

    public NotFoundExcepiton(String message, Throwable cause) {
        super(message, cause);
    }
}
