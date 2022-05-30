package com.miniprogram.zhihuicunwu.exception

import lombok.NoArgsConstructor

@NoArgsConstructor
class OCRAccessTokenException(val msg:String): RuntimeException(msg) {
    private val serialVersionUID = 1L
}