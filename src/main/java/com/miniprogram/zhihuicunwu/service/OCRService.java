package com.miniprogram.zhihuicunwu.service;

import com.alibaba.fastjson.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public interface OCRService {
    JSONObject parseBase64(String base64);
    JSONObject parseUrl(String url) throws IOException;
    JSONObject getMalevolenceFromBase64(String base64) throws NoSuchAlgorithmException, InvalidKeyException, IOException;
    JSONObject getMalevolenceFromUrl(String url) throws IOException, InvalidKeyException, NoSuchAlgorithmException;
}
