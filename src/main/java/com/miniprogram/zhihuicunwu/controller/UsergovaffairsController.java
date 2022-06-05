package com.miniprogram.zhihuicunwu.controller;

import com.alibaba.fastjson.JSONObject;
import com.miniprogram.zhihuicunwu.entity.*;
import com.miniprogram.zhihuicunwu.service.*;
import com.miniprogram.zhihuicunwu.util.DateUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * (Usergovaffairs)表控制层
 *
 * @author makejava
 * @since 2022-06-05 15:18:48
 */
@RestController
@RequestMapping("usergovaffairs")
public class UsergovaffairsController {
    /**
     * 服务对象
     */
    @Resource
    private GovaffairsService govaffairsService;
    @Resource
    private UsergovaffairsService usergovaffairsService;
    @Resource
    private DeptgovaffairsService deptgovaffairsService;
    @Resource
    private DepartmentService departmentService;

    /**
     * 通过主键查询单条数据
     *
     * @param usergaid 主键
     * @return 单条数据
     */
    @GetMapping("{usergaid}")
    public ResponseEntity<JSONObject> queryById(@PathVariable("usergaid") Integer usergaid) {
        Usergovaffairs usergovaffairs = this.usergovaffairsService.queryById(usergaid);
        JSONObject ret = new JSONObject();
        if(usergovaffairs!=null){
            ret.put("place", usergovaffairs.getAddress());
            ret.put("comment", usergovaffairs.getComment());
            ret.put("rate", usergovaffairs.getRate());
            Date date = usergovaffairs.getAppointTime();
            if(date!=null){
                DateFormat dateFormat = DateFormat.getDateInstance();
                DateFormat timeFormat = DateFormat.getTimeInstance();
                ret.put("showCurrentDate", dateFormat.format(date));
                ret.put("currentTime", timeFormat.format(date));
            }
            Govaffairs govaffairs = this.govaffairsService.queryById(usergovaffairs.getGaid());
            if(govaffairs!=null) {
                ret.put("ganame", govaffairs.getGaname());
                ret.put("desc", govaffairs.getGadescription());
                ret.put("type", govaffairs.getIsarrival() == 0 ? "spot" : "arrival");
            }
            Deptgovaffairs t_deptgovaffairs = new Deptgovaffairs();
            t_deptgovaffairs.setGaid(usergovaffairs.getGaid());
            List<Deptgovaffairs> deptgovaffairs = this.deptgovaffairsService.queryAllByAny(t_deptgovaffairs);
            if(deptgovaffairs!=null&&!deptgovaffairs.isEmpty()){
                Department department = departmentService.queryById(deptgovaffairs.get(0).getDid());
                if(department!=null){
                    ret.put("address", department.getDaddress());
                }
            }
        }
        ret.put("result",!ret.isEmpty());
        return ResponseEntity.ok(ret);
    }

    /**
     * 新增数据
     *
     * @param params 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Usergovaffairs> add(@RequestBody JSONObject params) throws ParseException {
        Usergovaffairs usergovaffairs = new Usergovaffairs();

        String appoint_time_str = params.getString("appoint_time");

        //TODO:改成前端的字段名
        usergovaffairs.setGaid(params.getInteger("affairId"));
        usergovaffairs.setUid(params.getInteger("uid"));
        usergovaffairs.setAddress(params.getString("arrival_location"));
        usergovaffairs.setAppointTime(DateUtil.Companion.dateFromString(appoint_time_str));
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

