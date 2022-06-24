package com.miniprogram.zhihuicunwu.externalservices

import com.alibaba.fastjson.JSONObject
import com.miniprogram.zhihuicunwu.util.UnirestUtils

data class MailDTO(val theme: String, val content: String, val notice: String)
object SubscribeSend {
    fun sendSubscribeMsg(wxOpenID: String, templateID: String, mailDTO: MailDTO): JSONObject {
        val accessToken = WxAccessTokenUtil.getAccessToken()
        return UnirestUtils.postJsonForResult(
            url = "https://api.weixin.qq.com/cgi-bin/message/subscribe/send",
            body = "{\r\n    \"touser\": \"${wxOpenID}\",\r\n    \"template_id\": \"${templateID}\",\r\n    \"data\":{\r\n        \"thing01\":{\r\n            \"value\":\"${mailDTO.theme}\"\r\n        },\r\n        \"thing02\":{\r\n            \"value\":\"${mailDTO.content}\"\r\n        },\r\n        \"thing03\":{\r\n            \"value\":\"${mailDTO.notice}\"\r\n        }\r\n    }\r\n}",
            queryString = mapOf("access_token" to accessToken)
        )
    }
}