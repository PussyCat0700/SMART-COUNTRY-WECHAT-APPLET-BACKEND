package com.miniprogram.zhihuicunwu.controller;

import com.miniprogram.zhihuicunwu.util.Base64Util;
import com.miniprogram.zhihuicunwu.util.ImageIOUtils;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

/**
 * 用于测试图片服务器交互的Controller
 */
@RestController
@RequestMapping("imagetest")
public class ImageTestController {
    @PostMapping("/base64")
    public String base64a(@RequestBody String base64) throws IOException {
        String relativePath = ImageIOUtils.uploadImg(Base64Util.replaceEnter(base64));
        return ImageIOUtils.getUrlFromDBRecord(relativePath);
    }
    @PostMapping("/url")
    public String url(@RequestBody String url) throws IOException {
        String relativePath = ImageIOUtils.uploadImg(Base64Util.imageUrlToBase64(url));
        return ImageIOUtils.getUrlFromDBRecord(relativePath);
    }
}
