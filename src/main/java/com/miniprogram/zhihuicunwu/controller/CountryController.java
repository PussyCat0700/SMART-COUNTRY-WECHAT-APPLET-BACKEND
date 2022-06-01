package com.miniprogram.zhihuicunwu.controller;

import com.miniprogram.zhihuicunwu.entity.Country;
import com.miniprogram.zhihuicunwu.service.CountryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Country)表控制层
 *
 * @author makejava
 * @since 2022-06-01 14:39:27
 */
@RestController
@RequestMapping("country")
public class CountryController {
    /**
     * 服务对象
     */
    @Resource
    private CountryService countryService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Country> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.countryService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param country 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Country> add(@RequestBody Country country) {
        return ResponseEntity.ok(this.countryService.insert(country));
    }

    /**
     * 编辑数据
     *
     * @param country 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Country> edit(@RequestBody Country country) {
        return ResponseEntity.ok(this.countryService.update(country));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.countryService.deleteById(id));
    }

}

