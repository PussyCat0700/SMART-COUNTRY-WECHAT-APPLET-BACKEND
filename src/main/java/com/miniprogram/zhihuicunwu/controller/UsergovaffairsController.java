package com.miniprogram.zhihuicunwu.controller;

import com.alibaba.fastjson.JSONObject;
import com.miniprogram.zhihuicunwu.entity.Usergovaffairs;
import com.miniprogram.zhihuicunwu.service.UsergovaffairsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * (Usergovaffairs)表控制层
 *
 * @author makejava
 * @since 2022-06-02 22:26:12
 */
@RestController
@RequestMapping("usergovaffairs")
public class UsergovaffairsController {
    /**
     * 服务对象
     */
    @Resource
    private UsergovaffairsService usergovaffairsService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Usergovaffairs> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.usergovaffairsService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param usergovaffairs 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Usergovaffairs> add(@RequestBody JSONObject params) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Usergovaffairs usergovaffairs = new Usergovaffairs();

        String appoint_time_str = params.getString("appoint_time");
        Date appoint_time = simpleDateFormat.parse(appoint_time_str);

        //TODO:改成前端的字段名
        usergovaffairs.setGaid(params.getInteger("affairId"));
        usergovaffairs.setUid(params.getInteger("uid"));
        usergovaffairs.setAddress(params.getString("arrival_location"));
        usergovaffairs.setAppointTime(appoint_time);
        usergovaffairs.setGaname(params.getString("service"));
        usergovaffairs.setStatus(0);  //默认
        usergovaffairs.setRate(0);  //默认
        usergovaffairs.setComment("");  //默认
        usergovaffairs.setContent(params.getString("content"));

        return ResponseEntity.ok(this.usergovaffairsService.insert(usergovaffairs));
    }

    /**
     * 编辑数据
     *
     * @param usergovaffairs 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Usergovaffairs> edit(@RequestBody Usergovaffairs usergovaffairs) {
        return ResponseEntity.ok(this.usergovaffairsService.update(usergovaffairs));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.usergovaffairsService.deleteById(id));
    }

}

