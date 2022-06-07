package com.miniprogram.zhihuicunwu.controller;

import com.miniprogram.zhihuicunwu.entity.Departmentimg;
import com.miniprogram.zhihuicunwu.service.DepartmentimgService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Departmentimg)表控制层
 *
 * @author makejava
 * @since 2022-06-07 13:22:44
 */
@RestController
@RequestMapping("departmentimg")
public class DepartmentimgController {
    /**
     * 服务对象
     */
    @Resource
    private DepartmentimgService departmentimgService;

    /**
     * 分页查询
     *
     * @param departmentimg 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Departmentimg>> queryByPage(Departmentimg departmentimg, PageRequest pageRequest) {
        return ResponseEntity.ok(this.departmentimgService.queryByPage(departmentimg, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Departmentimg> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.departmentimgService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param departmentimg 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Departmentimg> add(Departmentimg departmentimg) {
        return ResponseEntity.ok(this.departmentimgService.insert(departmentimg));
    }

    /**
     * 编辑数据
     *
     * @param departmentimg 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Departmentimg> edit(Departmentimg departmentimg) {
        return ResponseEntity.ok(this.departmentimgService.update(departmentimg));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.departmentimgService.deleteById(id));
    }

}

