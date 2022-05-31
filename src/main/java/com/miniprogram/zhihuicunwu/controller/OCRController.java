package com.miniprogram.zhihuicunwu.controller;

import com.alibaba.fastjson.JSONObject;
import com.miniprogram.zhihuicunwu.service.OCRService;
import com.miniprogram.zhihuicunwu.util.Base64Util;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;

@RestController
@RequestMapping("ocr")
public class OCRController {
    @Resource
    private OCRService ocrService;
    @PostMapping("/image")
    public ResponseEntity<JSONObject> getOCRResultsForBase64(@RequestBody String base64){
        return ResponseEntity.ok(this.ocrService.parseBase64(base64));
    }
    @PostMapping("/url")
    public ResponseEntity<JSONObject> getOCRResultsForUrl(@RequestBody String url) throws IOException {
        return ResponseEntity.ok(this.ocrService.parseBase64(Base64Util.imageUrlToBase64(url)));
    }
}
