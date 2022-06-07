package com.miniprogram.zhihuicunwu.controller;

import com.miniprogram.zhihuicunwu.entity.Countryimg;
import com.miniprogram.zhihuicunwu.service.CountryimgService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Countryimg)表控制层
 *
 * @author makejava
 * @since 2022-06-07 13:21:12
 */
@RestController
@RequestMapping("countryimg")
public class CountryimgController {
    /**
     * 服务对象
     */
    @Resource
    private CountryimgService countryimgService;

    /**
     * 分页查询
     *
     * @param countryimg 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Countryimg>> queryByPage(Countryimg countryimg, PageRequest pageRequest) {
        return ResponseEntity.ok(this.countryimgService.queryByPage(countryimg, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Countryimg> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.countryimgService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param countryimg 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Countryimg> add(Countryimg countryimg) {
        return ResponseEntity.ok(this.countryimgService.insert(countryimg));
    }

    /**
     * 编辑数据
     *
     * @param countryimg 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Countryimg> edit(Countryimg countryimg) {
        return ResponseEntity.ok(this.countryimgService.update(countryimg));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.countryimgService.deleteById(id));
    }

}

