package com.miniprogram.zhihuicunwu.util

import java.text.SimpleDateFormat
import java.util.*

class DateUtil {
    companion object{
        fun dateFromString(str:String): Date {
            val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
            return simpleDateFormat.parse(str)
        }
    }
}