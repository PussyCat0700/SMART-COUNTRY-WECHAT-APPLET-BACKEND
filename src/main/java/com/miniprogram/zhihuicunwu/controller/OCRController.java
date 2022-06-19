package com.miniprogram.zhihuicunwu.controller;

import com.alibaba.fastjson.JSONObject;
import com.miniprogram.zhihuicunwu.service.OCRService;
import com.miniprogram.zhihuicunwu.util.Base64Util;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

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
    @PostMapping("/detect/url")
    public ResponseEntity<JSONObject> getMaliceForUrl(@RequestBody String url) throws IOException, NoSuchAlgorithmException, InvalidKeyException {
        return ResponseEntity.ok(this.ocrService.getMalevolenceFromUrl(url));
    }
    @PostMapping("/detect/image")
    public ResponseEntity<JSONObject> getMaliceForImage(@RequestBody JSONObject jsonObject) throws IOException, InvalidKeyException, NoSuchAlgorithmException {
        return ResponseEntity.ok(this.ocrService.getMalevolenceFromBase64(jsonObject.getString("base64")));
    }
}
