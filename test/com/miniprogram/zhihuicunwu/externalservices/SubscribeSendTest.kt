package com.miniprogram.zhihuicunwu.externalservices

import org.junit.jupiter.api.Test

internal class SubscribeSendTest {

    @Test
    fun sendSubScribeMsg() {
        print(SubscribeSend.sendSubscribeMsg("oUcg55XbIY948o9eQGrk-5PZslMc","BYk7_Ubv1g9036staGeEhXq0EH_v7zFPUnOd7dZD3wc", MailDTO("主题","内容","提示")))
    }
}