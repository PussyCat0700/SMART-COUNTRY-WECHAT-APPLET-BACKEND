package com.miniprogram.zhihuicunwu.controller;

import com.alibaba.fastjson.JSONObject;
import com.miniprogram.zhihuicunwu.entity.Deptgovaffairs;
import com.miniprogram.zhihuicunwu.entity.Govaffairs;
import com.miniprogram.zhihuicunwu.service.DeptgovaffairsService;
import com.miniprogram.zhihuicunwu.service.GovaffairsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * (Deptgovaffairs)表控制层
 *
 * @author makejava
 * @since 2022-06-06 22:09:51
 */
@RestController
@RequestMapping("deptgovaffairs")
public class DeptgovaffairsController {
    /**
     * 服务对象
     */
    @Resource
    private DeptgovaffairsService deptgovaffairsService;
    @Resource
    private GovaffairsService govaffairsService;

    /**
     * 通过主键查询单条数据
     *
     * @param did 主键
     * @return 单条数据
     */
    @GetMapping("{did}")
    public ResponseEntity<List> queryById(@PathVariable("did") Integer did) {
        Deptgovaffairs deptgovaffairs = new Deptgovaffairs();
        deptgovaffairs.setDid(did);
        List<Deptgovaffairs> deptgovaffairs1 = this.deptgovaffairsService.queryAllByAny(deptgovaffairs);
        List<JSONObject> ret = new ArrayList<>();
        for(Deptgovaffairs deptgovaffairs2:deptgovaffairs1){
            JSONObject item = new JSONObject();
            item.put("service_id", deptgovaffairs2.getGaid());
            Govaffairs govaffairs = this.govaffairsService.queryById(deptgovaffairs2.getGaid());
            if(govaffairs!=null){
                item.put("service_name", govaffairs.getGaname());
                item.put("service_desc", govaffairs.getGadescription());
            }
            ret.add(item);
        }
        return ResponseEntity.ok(ret);
    }

    /**
     * 新增数据
     *
     * @param deptgovaffairs 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Deptgovaffairs> add(@RequestBody Deptgovaffairs deptgovaffairs) {
        return ResponseEntity.ok(this.deptgovaffairsService.insert(deptgovaffairs));
    }

    /**
     * 编辑数据
     *
     * @param deptgovaffairs 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Deptgovaffairs> edit(@RequestBody Deptgovaffairs deptgovaffairs) {
        return ResponseEntity.ok(this.deptgovaffairsService.update(deptgovaffairs));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.deptgovaffairsService.deleteById(id));
    }

}

