package com.miniprogram.zhihuicunwu.externalservices

import com.miniprogram.zhihuicunwu.util.Base64Util
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class OCRUtilsTest {

    @Test
    fun requestOCRService() {
        println(OCRUtils.requestOCRService(Base64Util.imageUrlToBase64("https://baidu-ai.bj.bcebos.com/ocr/ocr.jpg")))
    }
}