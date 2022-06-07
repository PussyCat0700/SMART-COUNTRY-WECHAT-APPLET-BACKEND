package com.miniprogram.zhihuicunwu.controller;

import com.miniprogram.zhihuicunwu.util.ImageIOUtils;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

/**
 * 用于测试图片服务器交互的Controller
 */
@RestController
@RequestMapping("imagetest")
public class ImageTestController {
    @PostMapping
    public String queryById(@RequestBody String base64) throws IOException {
        String relativePath = ImageIOUtils.uploadImg(base64);
        return ImageIOUtils.getUrlFromDBRecord(relativePath);
    }
}
