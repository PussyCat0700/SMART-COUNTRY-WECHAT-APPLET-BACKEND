package com.miniprogram.zhihuicunwu.service;

import com.alibaba.fastjson.JSONObject;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public interface PlantService {
    JSONObject parseBase64(String base64);
}
