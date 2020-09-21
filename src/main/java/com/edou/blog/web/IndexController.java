package com.edou.blog.web;

import com.edou.blog.exception.NotFoundExcepiton;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Objects;

/**
 * @ClassName IndexController
 * @Description 首页控制器
 * @Author 中森明菜
 * @Date 2020/9/20 17:34
 * @Version 1.0
 */
@Controller
public class IndexController {

    @GetMapping("/")
    public String index() {
        int i = 1/0;
        /*String blog = null;
        if(Objects.isNull(blog)){
            throw new NotFoundExcepiton("博客不存在");
        }*/
        return "index";
    }

}
