package com.miniprogram.zhihuicunwu.controller;

import com.alibaba.fastjson.JSONObject;
import com.miniprogram.zhihuicunwu.config.AffairStatus;
import com.miniprogram.zhihuicunwu.entity.*;
import com.miniprogram.zhihuicunwu.service.*;
import com.miniprogram.zhihuicunwu.util.DateUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
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
    @Resource
    private ApplicationService applicationService;
    @Resource
    private UserService userService;

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
            ret.put("status", usergovaffairs.getStatus());
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

    @GetMapping("/admin/{usergaid}")
    public ResponseEntity<JSONObject> queryDetailById(@PathVariable("usergaid") Integer usergaid) {
        JSONObject jsonObject = new JSONObject();
        Usergovaffairs usergovaffairs= this.usergovaffairsService.queryById(usergaid);
        jsonObject.put("affair", usergovaffairs.getGaname());
        jsonObject.put("booking_content", usergovaffairs.getContent());
        jsonObject.put("time", usergovaffairs.getAppointTime());
        JSONObject applicantInfo = new JSONObject();
        applicantInfo.put("address", usergovaffairs.getAddress());
        User user = this.userService.queryById(usergovaffairs.getUid());
        if(user!=null){
            jsonObject.put("userInfo", user.getBriefInfo());
        }
        Application application = new Application();
        application.setUsergaid(usergaid);
        List<Application> application2 = this.applicationService.queryAllByAny(application);
        if(application2!=null&&!application2.isEmpty()){
            Application application1 = application2.get(0);
            applicantInfo.put("address", application1.getAddress());
            applicantInfo.put("gender", application1.getGender()==0?"女":"男");
            applicantInfo.put("name", application1.getName());
            applicantInfo.put("phone", application1.getPhone());
        }
        jsonObject.put("applicantInfo", applicantInfo);
        return ResponseEntity.ok(jsonObject);
    }

    //获取所有预约列表
    @GetMapping("/allByDid/{did}")
    public ResponseEntity<List> queryByDid(@PathVariable("did") Integer did)
    {
        List<JSONObject> ret = new ArrayList<>();
        List<Usergovaffairs> usergovaffairs = this.usergovaffairsService.queryByDid(did);

        for(int i = 0; i < usergovaffairs.size(); i++)
        {
            JSONObject temp = new JSONObject();
            Govaffairs govaffairs = this.govaffairsService.queryById(usergovaffairs.get(i).getGaid());

            temp.put("aid", usergovaffairs.get(i).getUsergaid());
            temp.put("name", usergovaffairs.get(i).getGaname());
            temp.put("status", usergovaffairs.get(i).getStatus());
            temp.put("create_time", usergovaffairs.get(i).getCreateTime());
            String type = govaffairs.getIsarrival() == 1 ? "arrival" : "spot";
            temp.put("type", type);

            ret.add(temp);
        }

        return ResponseEntity.ok(ret);
    }

    @GetMapping("/allByUid/{uid}")
    public ResponseEntity<List> queryByUid(@PathVariable("uid") Integer uid)
    {
        List<JSONObject> ret = new ArrayList<>();
        List<Usergovaffairs> usergovaffairs = this.usergovaffairsService.queryByUid(uid);

        for(int i = 0; i < usergovaffairs.size(); i++)
        {
            JSONObject temp = new JSONObject();
            Govaffairs govaffairs = this.govaffairsService.queryById(usergovaffairs.get(i).getGaid());

            temp.put("aid", usergovaffairs.get(i).getUsergaid());
            temp.put("name", usergovaffairs.get(i).getGaname());
            temp.put("status", usergovaffairs.get(i).getStatus());
            temp.put("create_time", usergovaffairs.get(i).getCreateTime());
            String type = govaffairs.getIsarrival() == 1 ? "arrival" : "spot";
            temp.put("type", type);

            ret.add(temp);
        }

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
        Application application = new Application();
        JSONObject applicant_info = new JSONObject();

        String appoint_time_str = params.getString("appoint_time");

        //存入到Usergovaffairs实体中
        usergovaffairs.setGaid(params.getInteger("affairId"));
        usergovaffairs.setUid(params.getInteger("uid"));
        usergovaffairs.setDid(params.getInteger("did"));
        usergovaffairs.setAddress(params.getString("arrival_location"));
        usergovaffairs.setAppointTime(DateUtil.Companion.dateFromString(appoint_time_str));
        usergovaffairs.setGaname(params.getString("service"));
        usergovaffairs.setStatus(AffairStatus.ORDERED.ordinal());  //默认
        usergovaffairs.setRate(0);  //默认
        usergovaffairs.setComment("");  //默认
        usergovaffairs.setContent(params.getString("content"));
        this.usergovaffairsService.insert(usergovaffairs);

        //System.out.println(usergovaffairs.getUsergaid());

        //存入到Application实体中
        applicant_info = params.getJSONObject("application_info");
        application.setName(applicant_info.getString("name"));
        application.setGender(applicant_info.getInteger("gender"));
        application.setPhone(applicant_info.getString("phone"));
        application.setAddress(applicant_info.getString("address"));
        application.setUsergaid(usergovaffairs.getUsergaid());
        applicationService.insert(application);

        return ResponseEntity.ok(usergovaffairs);
    }

    private ResponseEntity<JSONObject> getEditResult(Usergovaffairs usergovaffairs, AffairStatus newStatus){
        JSONObject jsonObject = new JSONObject();
        usergovaffairs.setStatus(newStatus.ordinal());
        jsonObject.put("result", this.usergovaffairsService.update(usergovaffairs)!=null);
        return ResponseEntity.ok(jsonObject);
    }
    private ResponseEntity<JSONObject> getBadResult(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("result", false);
        return ResponseEntity.ok(jsonObject);
    }
    private Integer getInputStatus(Usergovaffairs usergovaffairs){
        return this.usergovaffairsService.queryById(usergovaffairs.getUsergaid()).getStatus();
    }
    /**
     * For Government Staff
     * accept an order
     *
     * @param usergovaffairs 实体
     * @return 编辑结果
     */
    @PutMapping("/accept")
    public ResponseEntity<JSONObject> markAsAccepted(@RequestBody Usergovaffairs usergovaffairs) {
        if(getInputStatus(usergovaffairs)!=AffairStatus.ORDERED.ordinal()){
            return getBadResult();
        }
        return getEditResult(usergovaffairs, AffairStatus.ACCEPTED);
    }
    /**
     * For User
     * mark order as accomplished
     *
     * @param usergovaffairs 实体
     * @return 编辑结果
     */
    @PutMapping("/accomplish")
    public ResponseEntity<JSONObject> markAsFinished(@RequestBody Usergovaffairs usergovaffairs) {
        if(getInputStatus(usergovaffairs)>AffairStatus.FINISHED.ordinal()){
            return getBadResult();
        }
        return getEditResult(usergovaffairs, AffairStatus.FINISHED);
    }

    /**
     * For User
     * mark order as commented
     *
     * @param usergovaffairs 实体
     * @return 编辑结果
     */
    @PutMapping("/comment")
    public ResponseEntity<JSONObject> markAsCommented(@RequestBody Usergovaffairs usergovaffairs) {
        if(getInputStatus(usergovaffairs)!=AffairStatus.FINISHED.ordinal()){
            return getBadResult();
        }
        return getEditResult(usergovaffairs, AffairStatus.COMMENTED);
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping("/delete/{usergaid}")
    public ResponseEntity<Boolean> deleteById(@PathVariable("usergaid") Integer id) {
        return ResponseEntity.ok(this.usergovaffairsService.deleteById(id));
    }

}

