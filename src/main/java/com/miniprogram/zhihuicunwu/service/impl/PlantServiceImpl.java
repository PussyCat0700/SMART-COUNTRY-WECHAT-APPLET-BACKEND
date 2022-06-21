package com.miniprogram.zhihuicunwu.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.miniprogram.zhihuicunwu.externalservices.OCRUtils;
import com.miniprogram.zhihuicunwu.externalservices.PlantUtils;
import com.miniprogram.zhihuicunwu.externalservices.SensitiveUtils;
import com.miniprogram.zhihuicunwu.service.OCRService;
import com.miniprogram.zhihuicunwu.service.PlantService;
import com.miniprogram.zhihuicunwu.util.Base64Util;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@Service("PlantService")
public class PlantServiceImpl implements PlantService {

    @Override
    public JSONObject parseBase64(String base64) {
        return PlantUtils.plant(base64);
    }
}
