package com.miniprogram.zhihuicunwu.externalservices;

import cn.hutool.core.codec.Base64Encoder;
import com.alibaba.fastjson.JSONObject;
import com.miniprogram.zhihuicunwu.util.UnirestUtils;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.*;

public class SensitiveUtils {
    public static String calcAuthorization(String source, String secretId, String secretKey, String datetime)
            throws NoSuchAlgorithmException, UnsupportedEncodingException, InvalidKeyException {
        String signStr = "x-date: " + datetime + "\n" + "x-source: " + source;
        Mac mac = Mac.getInstance("HmacSHA1");
        Key sKey = new SecretKeySpec(secretKey.getBytes(StandardCharsets.UTF_8), mac.getAlgorithm());
        mac.init(sKey);
        byte[] hash = mac.doFinal(signStr.getBytes(StandardCharsets.UTF_8));
        String sig = new Base64Encoder().encode(hash);

        String auth = "hmac id=\"" + secretId + "\", algorithm=\"hmac-sha1\", headers=\"x-date x-source\", signature=\"" + sig + "\"";
        return auth;
    }

    public static String urlencode(Map<?, ?> map) throws UnsupportedEncodingException {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(String.format("%s=%s",
                    URLEncoder.encode(entry.getKey().toString(), "UTF-8"),
                    URLEncoder.encode(entry.getValue().toString(), "UTF-8")
            ));
        }
        return sb.toString();
    }
    public static JSONObject requestSensitiveService(String content) throws NoSuchAlgorithmException, IOException, InvalidKeyException {
        //云市场分配的密钥Id
        String secretId = "AKID9b649kbCH5KcrLIUs2fU27XFCppHzw0pzjO0";
        //云市场分配的密钥Key
        String secretKey = "D45S6UUEQH4DVi1sAj1W212kUc5Orh38rrKDvOU2";
        String source = "market";
        Calendar cd = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        String datetime = sdf.format(cd.getTime());
        // 签名
        String auth = calcAuthorization(source, secretId, secretKey, datetime);
        Map<String, String> headers = new HashMap<>();
        headers.put("X-Source", source);
        headers.put("X-Date", datetime);
        headers.put("Authorization", auth);
        // 查询参数
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("content", content);
        // 请求方法
        JSONObject jsonObject = UnirestUtils.INSTANCE.getJsonForResult("https://service-owyxx71r-1255468759.ap-shanghai.apigateway.myqcloud.com/release/sensitiveWords", headers, queryParams);
        return jsonObject;
    }
}
