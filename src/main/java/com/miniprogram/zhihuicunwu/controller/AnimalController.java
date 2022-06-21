package com.miniprogram.zhihuicunwu.controller;

import com.alibaba.fastjson.JSONObject;
import com.miniprogram.zhihuicunwu.service.AnimalService;
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

@RestController
@RequestMapping("animal")
public class AnimalController {
    @Resource
    private AnimalService animalService;

    @PostMapping("/image")
    public ResponseEntity<JSONObject> getPlantResultsForBase64(@RequestBody String base64) throws IOException{
        String url = ImageIOUtils.getUrlFromDBRecord(ImageIOUtils.uploadImg(Base64Util.replaceEnter(base64)));
        System.out.println(url);
        return ResponseEntity.ok(this.animalService.parseBase64(url));
    }
}
