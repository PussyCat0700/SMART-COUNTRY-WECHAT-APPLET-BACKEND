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

    @GetMapping("/country/{cid}")
    public ResponseEntity<List> queryByCid(@PathVariable("cid") Integer cid) {
        List<Mailbox> mailboxs = this.mailboxService.queryByCid(cid);
        List<JSONObject> ret = new ArrayList<>();
        if(mailboxs!=null) {
            for(int i = 0; i < mailboxs.size(); i++) {
                List<String> image_urls = new ArrayList<>();
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("content", mailboxs.get(i).getMailcontent());
                jsonObject.put("id", mailboxs.get(i).getMid());
                jsonObject.put("create_time", mailboxs.get(i).getCreateTime());
                User user = this.userService.queryById(mailboxs.get(i).getUid());
                if (user != null) {
                    jsonObject.put("userInfo", user.getBriefInfo());
                }

                List<Mailboximg> images = this.mailboximgService.queryByMid(mailboxs.get(i).getMid());
                for(int j = 0; j < images.size(); j++)
                {
                    String url = ImageIOUtils.getUrlFromDBRecord(images.get(j).getImagebase64());
                    image_urls.add(url);
                }
                jsonObject.put("postImages", image_urls);

                ret.add(jsonObject);
            }
        }
        return ResponseEntity.ok(ret);
    }

    /**
     * 新增数据
     *
     * @param params 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Mailbox> add(@RequestBody JSONObject params) throws IOException {
        //存到mailbox
        Mailbox mailbox = new Mailbox();
        mailbox.setUid(params.getInteger("uid"));
        mailbox.setMailcontent(params.getString("content"));
        mailbox.setCid(params.getInteger("cid"));
        this.mailboxService.insert(mailbox);

        System.out.println(mailbox.getCreateTime());

        JSONArray base64List = params.getJSONArray("postImages");
        for(Object base64:base64List){
            Mailboximg mailboximg = new Mailboximg();
            mailboximg.setMailboxid(mailbox.getMid());
            String path = ImageIOUtils.uploadImg((String) base64);
            mailboximg.setImagebase64(path);
            this.mailboximgService.insert(mailboximg);
        }

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

