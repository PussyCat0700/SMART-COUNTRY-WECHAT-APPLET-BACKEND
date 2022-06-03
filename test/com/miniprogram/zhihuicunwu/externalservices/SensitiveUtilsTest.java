package com.miniprogram.zhihuicunwu.externalservices;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class SensitiveUtilsTest {
    @Test
    public void requestSensitiveService() throws NoSuchAlgorithmException, UnsupportedEncodingException, InvalidKeyException {
        String content = "救命！法轮功打人啦！";
        SensitiveUtils.requestSensitiveService(content);
    }
}
