package com.miniprogram.zhihuicunwu.controller;

import com.alibaba.fastjson.JSONObject;
import com.miniprogram.zhihuicunwu.entity.Country;
import com.miniprogram.zhihuicunwu.entity.Resident;
import com.miniprogram.zhihuicunwu.entity.User;
import com.miniprogram.zhihuicunwu.service.CountryService;
import com.miniprogram.zhihuicunwu.service.ResidentService;
import com.miniprogram.zhihuicunwu.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Resident)表控制层
 *
 * @author makejava
 * @since 2022-06-01 14:39:27
 */
@RestController
@RequestMapping("resident")
public class ResidentController {
    /**
     * 服务对象
     */
    @Resource
    private ResidentService residentService;
    @Resource
    private CountryService countryService;
    @Resource
    private UserService userService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Resident> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.residentService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param params 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<JSONObject> add(@RequestBody JSONObject params) {
        JSONObject ret = new JSONObject();
        Resident resident = new Resident();
        Resident resident_1 = this.residentService.queryById(params.getInteger("uid"));
        User user = this.userService.queryById(params.getInteger("uid"));
        Country country = this.countryService.queryByCcode(params.getString("countryCode"));

        if(user == null || country == null || resident_1 != null)
        {
            ret.put("result", false);
        }
        else
        {
            resident.setCid(country.getCid());
            resident.setUid(params.getInteger("uid"));
            this.residentService.insert(resident);

            user.setStatus(1);
            this.userService.update(user);

            ret.put("result", true);
            ret.put("cid", country.getCid());
            ret.put("score", country.getScore());
            ret.put("location", country.getLocation());
            ret.put("cname", country.getCname());
            ret.put("ccode", country.getCcode());
        }
        return ResponseEntity.ok(ret);
    }

    /**
     * 编辑数据
     *
     * @param resident 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Resident> edit(@RequestBody Resident resident) {
        return ResponseEntity.ok(this.residentService.update(resident));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.residentService.deleteById(id));
    }

}

