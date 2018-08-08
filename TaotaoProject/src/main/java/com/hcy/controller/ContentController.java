package com.hcy.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

/**
 * 好好学习 不做咸鱼
 * Created by Hcy on 18/8/8.
 */
@RequestMapping("/content")
public class ContentController {

    @RequestMapping("showContent.do")
    public String someurl() {
        // 服务端跳转， 推荐使用
        //UrlBasedViewResolver.FORWARD_URL_PREFIX 就是字符串 “forward:"
        return UrlBasedViewResolver.FORWARD_URL_PREFIX + "content.html";
    }
}
