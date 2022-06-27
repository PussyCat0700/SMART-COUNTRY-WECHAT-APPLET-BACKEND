package com.miniprogram.zhihuicunwu.externalservices;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class SensitiveUtilsTest {
    @Test
    public void requestSensitiveService() throws NoSuchAlgorithmException, IOException, InvalidKeyException {
        String content = "救命！食材打人啦！";
        JSONObject jsonObject = SensitiveUtils.requestSensitiveService(content);
        System.out.println(jsonObject);
    }
    @Test
    public void coherent() throws Exception{
        String content = OCRUtils.INSTANCE.urlToJSONString("https://tse1-mm.cn.bing.net/th/id/R-C.0397a1650f07c6233960548de8ddc9a9?rik=on%2byMQ%2bU4XyCBQ&riu=http%3a%2f%2fwww.hndzyx.com%2fxxjsjc%2f%e4%b8%83%e5%b9%b4%e7%ba%a7%e4%b8%8b%e5%86%8c%ef%bc%882020%e7%89%88%ef%bc%89%2f%e7%ac%ac%e4%b8%80%e7%ab%a0+%e7%94%b5%e5%ad%90%e6%8a%a5%e7%9a%84%e5%88%b6%e4%bd%9c%2f%e7%ac%ac%e4%ba%8c%e8%8a%82+%e6%96%87%e5%ad%97%e7%b4%a0%e6%9d%90%e7%9a%84%e9%87%87%e9%9b%86%2f%e8%af%be%e5%a0%82%e5%ae%9e%e4%be%8b%2fOCR%e8%af%86%e5%88%ab%e5%9b%be%e7%89%87.jpg&ehk=vKuUTZ7Rm6Bv3c5xec1Q4%2fiiG9ZlNeY1lo7q%2fPG5EE0%3d&risl=&pid=ImgRaw&r=0");
        JSONObject jsonObject = SensitiveUtils.requestSensitiveService(content);
        System.out.println(jsonObject);
    }
}
