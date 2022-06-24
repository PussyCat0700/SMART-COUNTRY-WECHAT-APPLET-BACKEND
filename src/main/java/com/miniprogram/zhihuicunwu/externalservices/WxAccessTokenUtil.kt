package com.miniprogram.zhihuicunwu.externalservices

import com.miniprogram.zhihuicunwu.config.WebMvcConfig
import com.miniprogram.zhihuicunwu.util.UnirestUtils

object WxAccessTokenUtil {
    fun getAccessToken() =
        UnirestUtils.getJsonForResult(
            url = "https://api.weixin.qq.com/cgi-bin/token",
            queryString = mapOf(
                "grant_type" to "client_credential",
                "appid" to WebMvcConfig.appId,
                "secret" to WebMvcConfig.appSecret
            )
        )?.getString("access_token")
}