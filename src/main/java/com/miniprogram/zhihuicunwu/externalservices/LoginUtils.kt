package com.miniprogram.zhihuicunwu.externalservices

import com.miniprogram.zhihuicunwu.util.UnirestUtils
import com.miniprogram.zhihuicunwu.config.WebMvcConfig

object LoginUtils {
    fun login(code: String) = getSessionResult(code)
    fun getSessionResult(code: String) =
        UnirestUtils.postJsonForResult(
            url = "https://api.weixin.qq.com/sns/jscode2session",
            fields = mapOf(
                "appid" to WebMvcConfig.appId,
                "secret" to WebMvcConfig.appSecret,
                "js_code" to code,
                "grant_type" to "authorization_code"
            )
        ).also { result->
            result.apply {
                val openid = result.getString("openid")
                val sessionKey = result.getString("session_key")
                put("openid", openid)
                put("session_key", sessionKey)
                put("unionid", "")
            }
        }
}