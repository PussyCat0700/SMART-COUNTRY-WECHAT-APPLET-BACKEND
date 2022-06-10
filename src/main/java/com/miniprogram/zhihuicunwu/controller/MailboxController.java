package com.miniprogram.zhihuicunwu.controller;

import com.alibaba.fastjson.JSONObject;
import com.miniprogram.zhihuicunwu.entity.Mailbox;
import com.miniprogram.zhihuicunwu.entity.Mailboximg;
import com.miniprogram.zhihuicunwu.entity.User;
import com.miniprogram.zhihuicunwu.service.MailboxService;
import com.miniprogram.zhihuicunwu.service.MailboximgService;
import com.miniprogram.zhihuicunwu.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * (Mailbox)表控制层
 *
 * @author makejava
 * @since 2022-06-01 14:39:27
 */
@RestController
@RequestMapping("mailbox")
public class MailboxController {
    /**
     * 服务对象
     */
    @Resource
    private MailboxService mailboxService;
    @Resource
    private UserService userService;
    @Resource
    private MailboximgService mailboximgService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<JSONObject> queryById(@PathVariable("id") Integer id) {
        Mailbox mailbox = this.mailboxService.queryById(id);
        JSONObject jsonObject = new JSONObject();
        if(mailbox!=null) {
            jsonObject.put("content", mailbox.getMailcontent());
            jsonObject.put("id", mailbox.getMid());
            User user = this.userService.queryById(mailbox.getUid());
            if (user != null) {
                jsonObject.put("userInfo", user.getBriefInfo());
            }
        }
        return ResponseEntity.ok(jsonObject);
    }

    /**
     * 新增数据
     *
     * @param params 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Mailbox> add(@RequestBody JSONObject params) {
        //存到mailbox
        Mailbox mailbox = new Mailbox();
        mailbox.setUid(params.getInteger("uid"));
        mailbox.setMailcontent(params.getString("content"));
        mailbox.setCid(params.getInteger("cid"));
        this.mailboxService.insert(mailbox);

        String base64 = params.getString("postImage");
        Mailboximg mailboximg = new Mailboximg();
        mailboximg.setMailboxid(mailbox.getMid());
        mailboximg.setImagebase64(base64);

        this.mailboximgService.insert(mailboximg);


        return ResponseEntity.ok(mailbox);
    }

    /**
     * 编辑数据
     *
     * @param mailbox 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Mailbox> edit(@RequestBody Mailbox mailbox) {
        return ResponseEntity.ok(this.mailboxService.update(mailbox));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.mailboxService.deleteById(id));
    }

}

