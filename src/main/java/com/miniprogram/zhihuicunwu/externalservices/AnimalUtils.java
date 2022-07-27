package com.miniprogram.zhihuicunwu.externalservices;

import com.alibaba.fastjson.JSONObject;
import com.miniprogram.zhihuicunwu.externalservices.Base64Util;
import com.miniprogram.zhihuicunwu.externalservices.FileUtil;
import com.miniprogram.zhihuicunwu.externalservices.HttpUtil;

import java.net.URLEncoder;

/**
 * 动物识别
 */
public class AnimalUtils {

    /**
     * 重要提示代码中所需工具类
     * FileUtil,Base64Util,HttpUtil,GsonUtils请从
     * https://ai.baidu.com/file/658A35ABAB2D404FBF903F64D47C1F72
     * https://ai.baidu.com/file/C8D81F3301E24D2892968F09AE1AD6E2
     * https://ai.baidu.com/file/544D677F5D4E4F17B4122FBD60DB82B3
     * https://ai.baidu.com/file/470B3ACCA3FE43788B5A963BF0B625F3
     * 下载
     */
    public static JSONObject animal(String base64) {
        // 请求url
        String url = "https://aip.baidubce.com/rest/2.0/image-classify/v1/animal";
        try {
            Integer baike_num = 1;
            base64 = URLEncoder.encode(base64, "UTF-8");
            String param = "image=" + base64 + "&baike_num=" + baike_num;

            // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
            String accessToken = "24.501d14f9f5f008a4e63d2be1b2a39334.2592000.1661499904.282335-26508112";

            String result = HttpUtil.post(url, accessToken, param);
            System.out.println(result);
            JSONObject jsonObject = JSONObject.parseObject(result);
            return jsonObject;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}