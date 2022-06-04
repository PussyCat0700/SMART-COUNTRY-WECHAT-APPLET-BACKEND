package com.miniprogram.zhihuicunwu.controller;

import com.alibaba.fastjson.JSONObject;
import com.miniprogram.zhihuicunwu.MainApplication;
import com.miniprogram.zhihuicunwu.entity.Feedback;
import com.miniprogram.zhihuicunwu.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest(classes = MainApplication.class)
class FeedbackControllerTest {

    @Resource
    private FeedbackController feedbackController;
    @Resource
    private UserController userController;

    @Test
    //获取所有反馈
    void queryAll() {
//        List<Feedback> feedbacks = feedbackController.queryAll();
//        //需要反馈的pid->related_article fContent->content fTime->date
//        //根据uid返回用户的头像url和昵称->userInfo(Json)
//        List<User> users = new ArrayList<User>();
//        for(int i = 0; i < feedbacks.size(); i++)
//        {
//            users.add(userController.queryById(feedbacks.get(i).getUid()));
//        }
//        List<JSONObject> allFeedBack = new ArrayList<JSONObject>();
//        for(int i = 0; i < feedbacks.size(); i++)
//        {
//            //TODO:用户信息和反馈的id
//            if(feedbacks.get(i) != null)
//            {
//                JSONObject tempJSON = new JSONObject();
//                tempJSON.put("content", feedbacks.get(i).getFcontent());
//                tempJSON.put("related_article", feedbacks.get(i).getPid());
//                tempJSON.put("date", feedbacks.get(i).getFtime());
//                allFeedBack.add(tempJSON);
//            }
//        }

        //allFeedBack返回给前端
    }

    @Test
    //模糊查询
    void queryFuzzyByContent()
    {
//        //跟上面这个函数类似的操作了
//        String content = "abc";
//        List<Feedback> feedbacks = feedbackController.queryFuzzyByContent(content);
//        //需要反馈的pid->related_article fContent->content fTime->date
//        //根据uid返回用户的头像url和昵称->userInfo(Json)
//        List<User> users = new ArrayList<User>();
//        for(int i = 0; i < feedbacks.size(); i++)
//        {
//            users.add(userController.queryById(feedbacks.get(i).getUid()));
//        }
//        List<JSONObject> allFeedBack = new ArrayList<JSONObject>();
//        for(int i = 0; i < feedbacks.size(); i++)
//        {
//            //TODO:用户信息和反馈的id
//            if(feedbacks.get(i) != null)
//            {
//                JSONObject tempJSON = new JSONObject();
//                tempJSON.put("content", feedbacks.get(i).getFcontent());
//                tempJSON.put("related_article", feedbacks.get(i).getPid());
//                tempJSON.put("date", feedbacks.get(i).getFtime());
//                allFeedBack.add(tempJSON);
//            }
//        }
    }
}