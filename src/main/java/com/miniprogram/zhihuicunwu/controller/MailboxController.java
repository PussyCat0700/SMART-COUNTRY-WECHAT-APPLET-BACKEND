package com.miniprogram.zhihuicunwu.controller;

import com.miniprogram.zhihuicunwu.entity.Mailbox;
import com.miniprogram.zhihuicunwu.service.MailboxService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Mailbox)表控制层
 *
 * @author makejava
 * @since 2022-05-24 17:56:23
 */
@RestController
@RequestMapping("mailbox")
public class MailboxController {
    /**
     * 服务对象
     */
    @Resource
    private MailboxService mailboxService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Mailbox> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.mailboxService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param mailbox 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Mailbox> add(@RequestBody Mailbox mailbox) {
        return ResponseEntity.ok(this.mailboxService.insert(mailbox));
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

