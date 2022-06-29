package com.miniprogram.zhihuicunwu.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.miniprogram.zhihuicunwu.entity.Mailbox;
import com.miniprogram.zhihuicunwu.entity.Mailboximg;
import com.miniprogram.zhihuicunwu.entity.User;
import com.miniprogram.zhihuicunwu.service.MailboxService;
import com.miniprogram.zhihuicunwu.service.MailboximgService;
import com.miniprogram.zhihuicunwu.service.UserService;
import com.miniprogram.zhihuicunwu.util.ImageIOUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;
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

    @GetMapping("/country/all/{cid}")
    public ResponseEntity<List> queryAllByCid(@PathVariable("cid") Integer cid) {
        List<Mailbox> mailboxes = this.mailboxService.queryByCid(cid);
        List<JSONObject> ret = queryMails(mailboxes, true);
        return ResponseEntity.ok(ret);
    }
    @GetMapping("/country/{cid}")
    public ResponseEntity<List> queryByCid(@PathVariable("cid") Integer cid) {
        Mailbox mailbox = new Mailbox();
        mailbox.setAnonymous(0);
        mailbox.setCid(cid);
        List<Mailbox> mailboxes = this.mailboxService.queryAllByAny(mailbox);
        List<JSONObject> ret = queryMails(mailboxes, true);
        return ResponseEntity.ok(ret);
    }
    @GetMapping("/country/anonymous/{cid}")
    public ResponseEntity<List> queryAnonymousByCid(@PathVariable("cid") Integer cid) {
        Mailbox mailbox = new Mailbox();
        mailbox.setAnonymous(1);
        mailbox.setCid(cid);
        List<Mailbox> mailboxes = this.mailboxService.queryAllByAny(mailbox);
        List<JSONObject> ret = queryMails(mailboxes, true);
        return ResponseEntity.ok(ret);
    }
    private List<JSONObject> queryMails(List<Mailbox> mailboxes, boolean anonymous){
        List<JSONObject> ret = new ArrayList<>();
        if(mailboxes!=null) {
            for(int i = 0; i < mailboxes.size(); i++) {
                List<String> image_urls = new ArrayList<>();
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("content", mailboxes.get(i).getMailcontent());
                jsonObject.put("id", mailboxes.get(i).getMid());
                jsonObject.put("create_time", mailboxes.get(i).getCreateTime());
                if(!anonymous) {
                    User user = this.userService.queryById(mailboxes.get(i).getUid());
                    if (user != null) {
                        jsonObject.put("userInfo", user.getBriefInfo());
                    }
                }

                List<Mailboximg> images = this.mailboximgService.queryByMid(mailboxes.get(i).getMid());
                for(int j = 0; j < images.size(); j++)
                {
                    String url = ImageIOUtils.getUrlFromDBRecord(images.get(j).getImagebase64());
                    image_urls.add(url);
                }
                jsonObject.put("postImages", image_urls);

                ret.add(jsonObject);
            }
        }
        return ret;
    }

    /**
     * 新增数据
     *
     * @param params 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Mailbox> add(@RequestBody JSONObject params) throws IOException {
        Mailbox mailbox = addMail(params, false);
        return ResponseEntity.ok(mailbox);
    }
    @PostMapping("/anonymous")
    public ResponseEntity<Mailbox> addAnonymous(@RequestBody JSONObject params) throws IOException {
        Mailbox mailbox = addMail(params, true);
        return ResponseEntity.ok(mailbox);
    }
    private Mailbox addMail(JSONObject jsonObject, boolean anonymous) throws IOException {
        //存到mailbox
        Mailbox mailbox = new Mailbox();
        mailbox.setUid(jsonObject.getInteger("uid"));
        mailbox.setMailcontent(jsonObject.getString("content"));
        mailbox.setCid(jsonObject.getInteger("cid"));
        mailbox.setAnonymous(anonymous?1:0);
        this.mailboxService.insert(mailbox);

        JSONArray base64List = jsonObject.getJSONArray("postImages");
        for(Object base64:base64List){
            Mailboximg mailboximg = new Mailboximg();
            mailboximg.setMailboxid(mailbox.getMid());
            String path = ImageIOUtils.uploadImg((String) base64);
            mailboximg.setImagebase64(path);
            this.mailboximgService.insert(mailboximg);
        }
        return mailbox;
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

