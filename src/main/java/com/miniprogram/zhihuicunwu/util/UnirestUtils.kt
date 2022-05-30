package com.miniprogram.zhihuicunwu.util

import com.alibaba.fastjson.JSONObject
import com.mashape.unirest.http.HttpResponse
import kotlin.Throws
import com.mashape.unirest.http.exceptions.UnirestException
import com.mashape.unirest.http.Unirest

object UnirestUtils {
    @Throws(UnirestException::class)
    fun sendJsonForResult(url: String, headers: Map<String, String>? = null, fields: Map<String, String>? = null): JSONObject {
        Unirest.setTimeouts(0, 0)
        val response: HttpResponse<*> = Unirest.post(url).run {
            headers?.let { headers(it) }
            fields?.let{ fields(it) }
            asJson()
        }
        return JSONObject.parseObject(response.body.toString())
    }
}