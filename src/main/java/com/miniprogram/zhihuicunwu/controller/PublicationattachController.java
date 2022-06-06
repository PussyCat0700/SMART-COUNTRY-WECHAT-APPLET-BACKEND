package com.miniprogram.zhihuicunwu.controller;

import com.miniprogram.zhihuicunwu.entity.Publicationattach;
import com.miniprogram.zhihuicunwu.service.PublicationattachService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Publicationattach)表控制层
 *
 * @author makejava
 * @since 2022-06-06 16:53:53
 */
@RestController
@RequestMapping("publicationattach")
public class PublicationattachController {
    /**
     * 服务对象
     */
    @Resource
    private PublicationattachService publicationattachService;

    /**
     * 分页查询
     *
     * @param publicationattach 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Publicationattach>> queryByPage(Publicationattach publicationattach, PageRequest pageRequest) {
        return ResponseEntity.ok(this.publicationattachService.queryByPage(publicationattach, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Publicationattach> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.publicationattachService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param publicationattach 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Publicationattach> add(Publicationattach publicationattach) {
        return ResponseEntity.ok(this.publicationattachService.insert(publicationattach));
    }

    /**
     * 编辑数据
     *
     * @param publicationattach 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Publicationattach> edit(Publicationattach publicationattach) {
        return ResponseEntity.ok(this.publicationattachService.update(publicationattach));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.publicationattachService.deleteById(id));
    }

}

