package com.miniprogram.zhihuicunwu.controller;

import com.alibaba.fastjson.JSONObject;
import com.miniprogram.zhihuicunwu.entity.*;
import com.miniprogram.zhihuicunwu.service.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.util.Date;

/**
 * (Govaffairs)表控制层
 *
 * @author makejava
 * @since 2022-06-02 22:26:09
 */
@RestController
@RequestMapping("govaffairs")
public class GovaffairsController {
    /**
     * 服务对象
     */
    @Resource
    private GovaffairsService govaffairsService;
    @Resource
    private DeptgovaffairsService deptgovaffairsService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping(value = "{id}", produces="application/json;charset=UTF-8")
    public ResponseEntity<Govaffairs> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.govaffairsService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param jsonObject 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<JSONObject> add(@RequestBody JSONObject jsonObject) {
        JSONObject ret = new JSONObject();

        Govaffairs govaffairs = JSONObject.parseObject(JSONObject.toJSONString(jsonObject), Govaffairs.class);
        this.govaffairsService.insert(govaffairs);

        Deptgovaffairs deptgovaffairs = new Deptgovaffairs();
        deptgovaffairs.setDid(jsonObject.getInteger("did"));
        deptgovaffairs.setGaid(govaffairs.getGaid());
        this.deptgovaffairsService.insert(deptgovaffairs);

        ret.put("result", true);

        return ResponseEntity.ok(ret);
    }

    /**
     * 编辑数据
     *
     * @param jsonObject 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Govaffairs> edit(@RequestBody JSONObject jsonObject) {
        Govaffairs govaffairs = new Govaffairs();
        govaffairs.setGadescription(jsonObject.getString("service_desc"));
        govaffairs.setGaname(jsonObject.getString("service_name"));
        govaffairs.setGaid(jsonObject.getInteger("service_id"));
        return ResponseEntity.ok(this.govaffairsService.update(govaffairs));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping("{service_id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable("service_id") Integer id) {
        return ResponseEntity.ok(this.govaffairsService.deleteById(id));
    }
}

