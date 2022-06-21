package com.miniprogram.zhihuicunwu.controller;

import com.alibaba.fastjson.JSONObject;
import com.miniprogram.zhihuicunwu.service.OCRService;
import com.miniprogram.zhihuicunwu.service.PlantService;
import com.miniprogram.zhihuicunwu.util.Base64Util;
import com.miniprogram.zhihuicunwu.util.ImageIOUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@RestController
@RequestMapping("plant")
public class PlantController {
    @Resource
    private PlantService plantService;

    @PostMapping("/image")
    public ResponseEntity<JSONObject> getPlantResultsForBase64(@RequestBody String base64) throws IOException{
        String url = ImageIOUtils.getUrlFromDBRecord(ImageIOUtils.uploadImg(Base64Util.replaceEnter(base64)));
        System.out.println(url);
        return ResponseEntity.ok(this.plantService.parseBase64(url));
    }
}
