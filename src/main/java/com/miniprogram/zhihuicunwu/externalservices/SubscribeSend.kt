package com.miniprogram.zhihuicunwu.externalservices

import com.alibaba.fastjson.JSONObject
import com.miniprogram.zhihuicunwu.service.DepartmentService
import com.miniprogram.zhihuicunwu.service.UserService
import com.miniprogram.zhihuicunwu.service.WorkService
import com.miniprogram.zhihuicunwu.util.UnirestUtils

data class MailDTO(val theme: String, val content: String, val notice: String)
object SubscribeSend {
    private const val templateID = "BYk7_Ubv1g9036staGeEhXq0EH_v7zFPUnOd7dZD3wc"
    fun sendNoticeToDept(mailDTO: MailDTO, did:Int, userService:UserService, workService: WorkService){
        val workRelations = workService.queryById(did)
        for (workRelation in workRelations){
            sendNoticeToUser(mailDTO = mailDTO, uid = workRelation.uid, userService)
        }
    }
    fun sendNoticeToUser(mailDTO: MailDTO, uid: Int, userService:UserService){
        val user = userService.queryById(uid)
        user?.uwxid?.let { openId->
            sendSubscribeMsg(wxOpenID = openId, templateID = templateID, mailDTO = mailDTO)
        }
    }
    fun sendSubscribeMsg(wxOpenID: String, templateID: String, mailDTO: MailDTO): JSONObject {
        val accessToken = WxAccessTokenUtil.getAccessToken()
        return UnirestUtils.postJsonForResult(
            url = "https://api.weixin.qq.com/cgi-bin/message/subscribe/send",
            body = "{\r\n    \"touser\": \"${wxOpenID}\",\r\n    \"template_id\": \"${templateID}\",\r\n    \"data\":{\r\n        \"thing1\":{\r\n            \"value\":\"${mailDTO.theme}\"\r\n        },\r\n        \"thing2\":{\r\n            \"value\":\"${mailDTO.content}\"\r\n        },\r\n        \"thing3\":{\r\n            \"value\":\"${mailDTO.notice}\"\r\n        }\r\n    }\r\n}",
            queryString = mapOf("access_token" to accessToken)
        )
    }
}