package com.edou.blog.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName Request
 * @Description 请求输出日志类
 * @Author 中森明菜
 * @Date 2020/9/22 9:18
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestLog {
    private String url;
    private String ip;
    private String classMethod;
    private Object[] args;
}