package com.miniprogram.zhihuicunwu.util

import com.alibaba.fastjson.JSONObject
import com.mashape.unirest.http.HttpResponse
import kotlin.Throws
import com.mashape.unirest.http.exceptions.UnirestException
import com.mashape.unirest.http.Unirest

object UnirestUtils {
    @Throws(UnirestException::class)
    fun postJsonForResult(url: String, headers: Map<String, String>? = mapOf("Content-Type" to "application/x-www-form-urlencoded"), fields: Map<String, String>? = null, queryString:Map<String, String>? = null): JSONObject {
        Unirest.setTimeouts(0, 0)
        val response: HttpResponse<*> = Unirest.post(url).run {
            headers?.let { headers(it) }
            fields?.let{ fields(it) }
            queryString?.let{queryString(it)}
            asJson()
        }
        return JSONObject.parseObject(response.body.toString())
    }
}