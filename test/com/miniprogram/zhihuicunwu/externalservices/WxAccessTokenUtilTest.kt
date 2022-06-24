package com.miniprogram.zhihuicunwu.externalservices

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class WxAccessTokenUtilTest {

    @Test
    fun getAccessToken() {
        print(WxAccessTokenUtil.getAccessToken())
    }
}