package com.miniprogram.zhihuicunwu.service;

import com.alibaba.fastjson.JSONObject;

import java.io.IOException;

public interface OCRService {
    JSONObject parseBase64(String base64);
    JSONObject parseUrl(String url) throws IOException;
}
