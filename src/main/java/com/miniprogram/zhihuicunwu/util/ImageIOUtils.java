package com.miniprogram.zhihuicunwu.util;

import com.miniprogram.zhihuicunwu.config.WebMvcConfig;
import org.springframework.beans.factory.annotation.Value;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.UUID;

public class ImageIOUtils {
    /**
     * 传入base64编码后的图片
     * 1.在application.yml中指定的路径保存图片
     * 2.返回相对路径
     * 调用者应该直接保存该相对路径于数据库中，
     * 但注意，数据库中保存的路径被查阅返回前端前，应该经过getUrlFromDBRecord函数处理，否则前端无法通过相对路径访问图片。
     * @param base64
     * @return
     * @throws IOException
     */
    public static String uploadImg(String base64) throws IOException {
        byte[] result= Base64.getDecoder().decode(base64);
        File filePath=new File(WebMvcConfig.absoluteImgPath+WebMvcConfig.sonImgPath);//创建文件夹
        if(!filePath.exists()){//如果没有文件夹，新建
            filePath.mkdirs();
        }
        String uuid=  UUID.randomUUID().toString().replaceAll("-", "");
        String fileName = uuid+".png";
        File picFile=new File(WebMvcConfig.absoluteImgPath+WebMvcConfig.sonImgPath+fileName);//保存文件
        FileOutputStream out=new FileOutputStream(picFile);
        out.write(result);
        out.close();
        //随机生成文件名
        String imgUrl = WebMvcConfig.sonImgPath +fileName;
        return imgUrl;
    }

    /**
     * 传入相对路径
     * @param relativeUrl
     * 然后返回
     * @return 能够被前端直接点开访问的url
     */
    public static String getUrlFromDBRecord(String relativeUrl){
        return WebMvcConfig.serverUrl+":"+WebMvcConfig.serverPort+relativeUrl;
    }
}
