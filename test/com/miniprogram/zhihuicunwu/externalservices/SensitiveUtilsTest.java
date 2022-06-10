package com.miniprogram.zhihuicunwu.externalservices;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class SensitiveUtilsTest {
    @Test
    public void requestSensitiveService() throws NoSuchAlgorithmException, UnsupportedEncodingException, InvalidKeyException {
        String content = "救命！食材打人啦！";
        JSONObject ret = SensitiveUtils.requestSensitiveService(content);

        System.out.println(ret);
    }
}
