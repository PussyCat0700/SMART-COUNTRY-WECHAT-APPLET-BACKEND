package com.miniprogram.zhihuicunwu.externalservices

import com.alibaba.fastjson.JSONObject
import com.miniprogram.zhihuicunwu.util.UnirestUtils
import cn.hutool.core.codec.Base64
import com.miniprogram.zhihuicunwu.config.WebMvcConfig
import org.bouncycastle.jce.provider.BouncyCastleProvider
import javax.crypto.spec.SecretKeySpec
import java.security.AlgorithmParameters
import java.security.Security
import java.util.*
import javax.crypto.Cipher
import javax.crypto.spec.IvParameterSpec

object LoginUtils {
    fun login(encryptedData:String,code: String,iv:String): JSONObject {
        val sessionKeyObject = getSessionKey(code)
        return if(sessionKeyObject.containsKey("session_key")){
            sessionKeyObject
        }else{
            getUserInfo(encryptedData, sessionKeyObject.getString("session_key"), iv)
        }
    }
    fun getUserInfo(encryptedData: String, sessionkey:String, iv: String): JSONObject {
        // 被加密的数据
        val dataByte = Base64.decode(encryptedData)
        // 加密秘钥
        var keyByte = Base64.decode(sessionkey)
        // 偏移量
        val ivByte = Base64.decode(iv)
        // 如果密钥不足16位，那么就补足.  这个if 中的内容很重要
        val base = 16
        if (keyByte.size % base != 0) {
            val groups = keyByte.size / base + if (keyByte.size % base != 0) 1 else 0
            val temp = ByteArray(groups * base)
            Arrays.fill(temp, 0.toByte())
            System.arraycopy(keyByte, 0, temp, 0, keyByte.size)
            keyByte = temp
        }
        // 初始化
        Security.addProvider(BouncyCastleProvider())
        val cipher = Cipher.getInstance("AES/CBC/PKCS7Padding", "BC")
        val spec = SecretKeySpec(keyByte, "AES")
        val parameters = AlgorithmParameters.getInstance("AES")
        parameters.init(IvParameterSpec(ivByte))
        cipher.init(Cipher.DECRYPT_MODE, spec, parameters) // 初始化
        val resultByte = cipher.doFinal(dataByte)
        return if (null != resultByte && resultByte.isNotEmpty()) {
            val result = String(resultByte, Charsets.UTF_8)
            JSONObject.parseObject(result)
        }else{
            JSONObject().also {
                it["result"] = "failed"
            }
        }
    }
    fun getSessionKey(code: String) =
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