package com.miniprogram.zhihuicunwu.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.miniprogram.zhihuicunwu.externalservices.AnimalUtils;
import com.miniprogram.zhihuicunwu.externalservices.PlantUtils;
import com.miniprogram.zhihuicunwu.service.AnimalService;
import com.miniprogram.zhihuicunwu.service.PlantService;
import org.springframework.stereotype.Service;

@Service("AnimalService")
public class AnimalServiceImpl implements AnimalService {

    @Override
    public JSONObject parseBase64(String base64) {
        return AnimalUtils.animal(base64);
    }
}