package com.miniprogram.zhihuicunwu.controller;

import com.miniprogram.zhihuicunwu.entity.User;
import com.miniprogram.zhihuicunwu.entity.Work;
import com.miniprogram.zhihuicunwu.service.UserService;
import com.miniprogram.zhihuicunwu.service.WorkService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * (Work)表控制层
 *
 * @author makejava
 * @since 2022-06-05 17:03:30
 */
@RestController
@RequestMapping("work")
public class WorkController {
    /**
     * 服务对象
     */
    @Resource
    private WorkService workService;
    @Resource
    private UserService userService;

    /**
     * 通过主键查询单条数据
     *
     * @param did 部门主键
     * @return 单条数据
     */
    @GetMapping("/employees/{did}")
    public ResponseEntity<List> queryById(@PathVariable("did") Integer did) {
        Work work = new Work();
        work.setDid(did);
        List<Work> worklist = this.workService.queryAllByAny(work);
        List<JSONObject> ret = new ArrayList<>();
        for(Work work1:worklist){
            User user = this.userService.queryById(work1.getUid());
            JSONObject userInfo = user.getBriefInfo();
            userInfo.put("field", work1.getWname());
            userInfo.put("jointime", work1.getWtime());
            ret.add(userInfo);
        }
        return ResponseEntity.ok(ret);
    }

    /**
     * 新增数据
     *
     * @param work 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Work> add(@RequestBody Work work) {
        return ResponseEntity.ok(this.workService.insert(work));
    }

    /**
     * 编辑数据
     *
     * @param work 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Work> edit(@RequestBody Work work) {
        return ResponseEntity.ok(this.workService.update(work));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.workService.deleteById(id));
    }

}

