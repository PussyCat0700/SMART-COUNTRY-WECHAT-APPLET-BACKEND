package com.miniprogram.zhihuicunwu.externalservices

import com.alibaba.fastjson.JSONObject
import com.miniprogram.zhihuicunwu.exception.OCRAccessTokenException
import com.miniprogram.zhihuicunwu.util.UnirestUtils

object OCRUtils {
    private fun acquireAccessTokenResponse(): JSONObject {
        val response = UnirestUtils.sendJsonForResult(
                url = "https://aip.baidubce.com/oauth/2.0/token",
                headers = mapOf("Content-Type" to "application/x-www-form-urlencoded"),
                fields = mapOf("grant_type" to "client_credentials",
                        "client_id" to "ZuOm8Fe17GdGGG7WsRBdKFfm",
                        "client_secret" to "oGXwnZM9edAbdAuU9SvQIatTN88MASub"
                ))
        return JSONObject.parseObject(response.toString())
    }
    fun acquireAccessToken(): String{
        val jsonResponse = acquireAccessTokenResponse()
        return if (jsonResponse.containsKey("access_token")) {
            jsonResponse.getString("access_token")
        }else if(jsonResponse.containsKey("error_description")){
            throw OCRAccessTokenException(jsonResponse.getString("error_description"))
        }else{
            throw OCRAccessTokenException("OCR鉴权出错：未知错误")
        }
    }
}