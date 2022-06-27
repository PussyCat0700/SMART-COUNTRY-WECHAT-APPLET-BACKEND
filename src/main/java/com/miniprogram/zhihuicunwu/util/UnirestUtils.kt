package com.miniprogram.zhihuicunwu.util

import com.alibaba.fastjson.JSONObject
import com.mashape.unirest.http.HttpResponse
import com.mashape.unirest.http.Unirest

object UnirestUtils {
    fun postJsonForResult(url: String, headers: Map<String, String>? = mapOf("Content-Type" to "application/x-www-form-urlencoded"), fields: Map<String, String>? = null, queryString:Map<String, String>? = null): JSONObject {
        val response: HttpResponse<*> = Unirest.post(url).run {
            headers?.let { headers(it) }
            fields?.let{ fields(it) }
            queryString?.let{queryString(it)}
            asJson()
        }
        return sendUnirestRequest(response)
    }
    fun postJsonForResult(url: String, headers: Map<String, String>? = mapOf("Content-Type" to "application/x-www-form-urlencoded"),  body:String? = null, queryString:Map<String, String>? = null): JSONObject {
        val response: HttpResponse<*> = Unirest.post(url).run {
            headers?.let { headers(it) }
            body?.let{ body(it) }
            queryString?.let{queryString(it)}
            asJson()
        }
        return sendUnirestRequest(response)
    }
    private fun sendUnirestRequest(response: HttpResponse<*>): JSONObject {
        Unirest.setTimeouts(0, 0)
        return JSONObject.parseObject(response.body.toString())
    }
    fun getJsonForResult(url: String, headers: Map<String, String>? = mapOf("Content-Type" to "application/x-www-form-urlencoded"), queryString:Map<String, String>? = null): JSONObject {
        val response: HttpResponse<*> = Unirest.get(url).run {
            headers?.let { headers(it) }
            queryString?.let{queryString(it)}
            asJson()
        }
        return sendUnirestRequest(response)
    }
}