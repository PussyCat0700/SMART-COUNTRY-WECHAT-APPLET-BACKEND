package com.miniprogram.zhihuicunwu.controller;

import com.miniprogram.zhihuicunwu.entity.Publicationpic;
import com.miniprogram.zhihuicunwu.service.PublicationpicService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Publicationpic)表控制层
 *
 * @author makejava
 * @since 2022-06-06 16:54:05
 */
@RestController
@RequestMapping("publicationpic")
public class PublicationpicController {
    /**
     * 服务对象
     */
    @Resource
    private PublicationpicService publicationpicService;

    /**
     * 分页查询
     *
     * @param publicationpic 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Publicationpic>> queryByPage(Publicationpic publicationpic, PageRequest pageRequest) {
        return ResponseEntity.ok(this.publicationpicService.queryByPage(publicationpic, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Publicationpic> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.publicationpicService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param publicationpic 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Publicationpic> add(Publicationpic publicationpic) {
        return ResponseEntity.ok(this.publicationpicService.insert(publicationpic));
    }

    /**
     * 编辑数据
     *
     * @param publicationpic 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Publicationpic> edit(Publicationpic publicationpic) {
        return ResponseEntity.ok(this.publicationpicService.update(publicationpic));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.publicationpicService.deleteById(id));
    }

}

