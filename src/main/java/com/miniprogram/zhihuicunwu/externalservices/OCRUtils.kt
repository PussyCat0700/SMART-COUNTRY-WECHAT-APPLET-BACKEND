package com.miniprogram.zhihuicunwu.externalservices

import com.alibaba.fastjson.JSONObject
import com.miniprogram.zhihuicunwu.exception.OCRAccessTokenException
import com.miniprogram.zhihuicunwu.util.Base64Util
import com.miniprogram.zhihuicunwu.util.ImageIOUtils
import com.miniprogram.zhihuicunwu.util.UnirestUtils

object OCRUtils {
    private fun acquireAccessTokenResponse(): JSONObject {
        val response = UnirestUtils.postJsonForResult(
                url = "https://aip.baidubce.com/oauth/2.0/token",
                fields = mapOf("grant_type" to "client_credentials",
                        "client_id" to "ZuOm8Fe17GdGGG7WsRBdKFfm",
                        "client_secret" to "oGXwnZM9edAbdAuU9SvQIatTN88MASub")
        )
        return JSONObject.parseObject(response.toString())
    }

    private fun acquireAccessToken(): String {
        val jsonResponse = acquireAccessTokenResponse()
        return if (jsonResponse.containsKey("access_token")) {
            jsonResponse.getString("access_token")
        } else if (jsonResponse.containsKey("error_description")) {
            throw OCRAccessTokenException(jsonResponse.getString("error_description"))
        } else {
            throw OCRAccessTokenException("OCR鉴权出错：未知错误")
        }
    }

    fun requestOCRService(base64String: String): JSONObject {
        val accessToken = acquireAccessToken()
        return UnirestUtils.postJsonForResult(
                url = "https://aip.baidubce.com/rest/2.0/ocr/v1/accurate_basic",
                fields = mapOf(
                        "image" to base64String,
                        "language_type" to "CHN_ENG",
                        "detect_direction" to "false",
                        "paragraph" to "false",
                        "probability" to "false"),
                queryString = mapOf("access_token" to accessToken)
        )
    }

    fun bas64ToJSONString(base64String: String) = requestOCRService(base64String).toJSONString()
    fun urlToJSONString(url:String) = bas64ToJSONString(Base64Util.imageUrlToBase64(url));

}