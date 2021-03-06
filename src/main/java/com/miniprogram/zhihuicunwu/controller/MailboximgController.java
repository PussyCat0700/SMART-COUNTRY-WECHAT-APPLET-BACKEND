package com.miniprogram.zhihuicunwu.controller;

import com.miniprogram.zhihuicunwu.entity.Mailboximg;
import com.miniprogram.zhihuicunwu.service.MailboximgService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Mailboximg)表控制层
 *
 * @author makejava
 * @since 2022-06-06 16:09:15
 */
@RestController
@RequestMapping("mailboximg")
public class MailboximgController {
    /**
     * 服务对象
     */
    @Resource
    private MailboximgService mailboximgService;

    /**
     * 分页查询
     *
     * @param mailboximg 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Mailboximg>> queryByPage(Mailboximg mailboximg, PageRequest pageRequest) {
        return ResponseEntity.ok(this.mailboximgService.queryByPage(mailboximg, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Mailboximg> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.mailboximgService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param mailboximg 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Mailboximg> add(Mailboximg mailboximg) {
        return ResponseEntity.ok(this.mailboximgService.insert(mailboximg));
    }

    /**
     * 编辑数据
     *
     * @param mailboximg 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Mailboximg> edit(Mailboximg mailboximg) {
        return ResponseEntity.ok(this.mailboximgService.update(mailboximg));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.mailboximgService.deleteById(id));
    }

}

