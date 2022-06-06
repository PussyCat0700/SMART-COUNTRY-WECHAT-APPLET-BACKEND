package com.miniprogram.zhihuicunwu.controller;

import com.miniprogram.zhihuicunwu.entity.Publication;
import com.miniprogram.zhihuicunwu.service.PublicationService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Publication)表控制层
 *
 * @author makejava
 * @since 2022-06-06 16:54:43
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
     * 分页查询
     *
     * @param publication 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Publication>> queryByPage(Publication publication, PageRequest pageRequest) {
        return ResponseEntity.ok(this.publicationService.queryByPage(publication, pageRequest));
    }

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
    public ResponseEntity<Publication> add(Publication publication) {
        return ResponseEntity.ok(this.publicationService.insert(publication));
    }

    /**
     * 编辑数据
     *
     * @param publication 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Publication> edit(Publication publication) {
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

