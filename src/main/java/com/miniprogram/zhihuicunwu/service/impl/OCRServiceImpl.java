package com.miniprogram.zhihuicunwu.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.miniprogram.zhihuicunwu.externalservices.OCRUtils;
import com.miniprogram.zhihuicunwu.service.OCRService;
import com.miniprogram.zhihuicunwu.util.Base64Util;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service("ocrService")
public class OCRServiceImpl implements OCRService {

    @Override
    public JSONObject parseBase64(String base64) {
        return OCRUtils.INSTANCE.requestOCRService(base64);
    }

    @Override
    public JSONObject parseUrl(String url) throws IOException {
        return parseBase64(Base64Util.imageUrlToBase64(url));
    }
}
