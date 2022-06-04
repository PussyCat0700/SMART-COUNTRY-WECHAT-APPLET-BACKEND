package com.miniprogram.zhihuicunwu.controller;

import com.miniprogram.zhihuicunwu.MainApplication;
import com.miniprogram.zhihuicunwu.entity.Usergovaffairs;
import com.miniprogram.zhihuicunwu.service.UsergovaffairsService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = MainApplication.class)
class UsergovaffairsControllerTest {

    @Resource
    UsergovaffairsService usergovaffairsService;

    @Test
    void add() {

    }
}