package com.miniprogram.zhihuicunwu.controller;

import com.miniprogram.zhihuicunwu.entity.Publication;
import com.miniprogram.zhihuicunwu.service.PublicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Publication)表控制层
 *
 * @author makejava
 * @since 2022-05-24 17:56:23
 */
@RestController
@RequestMapping("publication")
public class PublicationController {
    /**
     * 服务对象
     */
    @Resource
    private PublicationService publicationService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Publication> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.publicationService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param publication 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Publication> add(@RequestBody Publication publication) {
        return ResponseEntity.ok(this.publicationService.insert(publication));
    }

    /**
     * 编辑数据
     *
     * @param publication 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Publication> edit(@RequestBody Publication publication) {
        return ResponseEntity.ok(this.publicationService.update(publication));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.publicationService.deleteById(id));
    }

}

