package com.miniprogram.zhihuicunwu.externalservices

import com.miniprogram.zhihuicunwu.util.UnirestUtils
import com.miniprogram.zhihuicunwu.config.WebMvcConfig
import com.miniprogram.zhihuicunwu.entity.User
import com.miniprogram.zhihuicunwu.service.UserService
import java.security.MessageDigest




object LoginUtils {
    fun getSessionResult(code: String, userService: UserService) =
        UnirestUtils.postJsonForResult(
            url = "https://api.weixin.qq.com/sns/jscode2session",
            fields = mapOf(
                "appid" to WebMvcConfig.appId,
                "secret" to WebMvcConfig.appSecret,
                "js_code" to code,
                "grant_type" to "authorization_code"
            )
        ).also { result->
            val openid:String? = result.getString("openid")
            val sessionKey:String? = result.getString("session_key")
            if(sessionKey!=null&&openid!=null) {
                val thirdSessionKey = sha(sessionKey + openid)
                val user: User? = userService.queryByOpenId(openid)
                if (user == null) {
                    // Register
                    userService.insert(User().also {
                        it.uwxid = openid
                        it.thirdSessionKey = thirdSessionKey
                    })
                } else {
                    // update third sessionKey
                    user.thirdSessionKey = thirdSessionKey
                    userService.update(user)
                }
                result["session"] = thirdSessionKey
            }
        }

    private fun sha(strText: String?): String? {
        // 返回值
        var strResult: String? = null

        // 是否是有效字符串
        if (strText != null && strText.isNotEmpty()) {
            // SHA 加密开始
            // 创建加密对象 并傳入加密類型
            val messageDigest: MessageDigest = MessageDigest.getInstance("SHA-256")
            // 传入要加密的字符串
            messageDigest.update(strText.toByteArray())
            // 得到 byte 类型结果
            val byteBuffer: ByteArray = messageDigest.digest()

            // 將 byte 转换为 string
            val strHexString = StringBuilder()
            // 遍历 byte buffer
            for (b in byteBuffer) {
                val hex = Integer.toHexString(0xff and b.toInt())
                if (hex.length == 1) {
                    strHexString.append('0')
                }
                strHexString.append(hex)
            }
            // 得到返回結果
            strResult = strHexString.toString()
        }
        return strResult
    }
}