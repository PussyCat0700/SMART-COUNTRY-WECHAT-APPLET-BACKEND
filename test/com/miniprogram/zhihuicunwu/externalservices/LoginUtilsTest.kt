package com.miniprogram.zhihuicunwu.externalservices

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class LoginUtilsTest {

    @Test
    fun getSessionKey() {
        println(LoginUtils.getSessionKey("ssss"))
    }
}