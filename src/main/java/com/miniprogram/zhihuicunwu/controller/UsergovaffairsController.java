package com.miniprogram.zhihuicunwu.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.miniprogram.zhihuicunwu.config.AffairStatus;
import com.miniprogram.zhihuicunwu.entity.*;
import com.miniprogram.zhihuicunwu.externalservices.MailDTO;
import com.miniprogram.zhihuicunwu.externalservices.SubscribeSend;
import com.miniprogram.zhihuicunwu.service.*;
import com.miniprogram.zhihuicunwu.util.DateUtil;
import com.miniprogram.zhihuicunwu.util.MyAsyncTask;
import com.miniprogram.zhihuicunwu.util.MyCallback;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.DecimalFormat;
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
@Slf4j
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
    @Resource
    private WorkService workService;
    @Resource
    private ResidentService residentService;

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
        jsonObject.put("arrival_location", usergovaffairs.getAddress());
        jsonObject.put("status", usergovaffairs.getStatus());
        jsonObject.put("rate", usergovaffairs.getRate());
        jsonObject.put("comment", usergovaffairs.getComment());
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
    public ResponseEntity<JSONArray> queryByDid(@PathVariable("did") Integer did)
    {
        JSONArray ret = new JSONArray();
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
            temp.put("content", usergovaffairs.get(i).getContent());
            Integer uid = usergovaffairs.get(i).getUid();
            User user = this.userService.queryById(uid);
            temp.put("userInfo", user==null?null:user.getBriefInfo());
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

    @GetMapping("/allByCid/{cid}")
    public ResponseEntity<List> queryByCid(@PathVariable("cid") Integer cid) {
        List<Resident> residents = this.residentService.queryByCid(cid);
        List<Usergovaffairs> usergovaffairs = new ArrayList<>();
        List<JSONObject> ret = new ArrayList<>();

        for(int i=0; i<residents.size(); i++)
        {
            List<Usergovaffairs> uUsergovaffairs = this.usergovaffairsService.queryByUid(residents.get(i).getUid());
            if(uUsergovaffairs.size()!=0)
            {
                for(int j=0; j<uUsergovaffairs.size(); j++)
                {
                    usergovaffairs.add(uUsergovaffairs.get(j));
                }
            }
        }

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
            temp.put("content", usergovaffairs.get(i).getContent());
            Integer uid = usergovaffairs.get(i).getUid();
            User user = this.userService.queryById(uid);
            temp.put("userInfo", user==null?null:user.getBriefInfo());
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
    public ResponseEntity<JSONObject> add(@RequestBody JSONObject params) throws ParseException {
        Usergovaffairs usergovaffairs = new Usergovaffairs();
        Application application = new Application();
        JSONObject ret = new JSONObject();

        String appoint_time_str = params.getString("appoint_time");

        //存入到Usergovaffairs实体中
        Integer did = params.getInteger("did");
        String content = params.getString("content");
        usergovaffairs.setGaid(params.getInteger("affairId"));
        usergovaffairs.setUid(params.getInteger("uid"));
        usergovaffairs.setDid(did);
        usergovaffairs.setAddress(params.getString("arrival_location"));
        usergovaffairs.setAppointTime(DateUtil.Companion.dateFromString(appoint_time_str));
        usergovaffairs.setGaname(params.getString("service"));
        usergovaffairs.setStatus(AffairStatus.ORDERED.ordinal());  //默认
        usergovaffairs.setComment("");  //默认
        usergovaffairs.setContent(content);
        this.usergovaffairsService.insert(usergovaffairs);

        //存入到Application实体中
        JSONObject applicant_info = params.getJSONObject("application_info");
        if(applicant_info!=null) {
            application.setName(applicant_info.getString("name"));
            application.setGender(applicant_info.getInteger("gender"));
            application.setPhone(applicant_info.getString("phone"));
            application.setAddress(applicant_info.getString("address"));
            application.setUsergaid(usergovaffairs.getUsergaid());
            applicationService.insert(application);

            ret.put("result", true);
            ret.put("usergaid", usergovaffairs.getUsergaid());
            new MyAsyncTask().task(() -> {
                JSONArray jsonArray = SubscribeSend.INSTANCE.sendNoticeToDept(new MailDTO("您所在的部门有一个新业务", content, "请及时查看"), did, userService, workService);
                log.warn("通知情况:{}", jsonArray);
            });
        }
        else
        {
            ret.put("result", false);
        }
        return ResponseEntity.ok(ret);
    }

    @PutMapping
    public ResponseEntity<JSONObject> edit(@RequestBody JSONObject params) {
        JSONObject ret = new JSONObject();
        Usergovaffairs usergovaffairs = this.usergovaffairsService.queryById(params.getInteger("usergaid"));

        if(usergovaffairs!=null) {
            ret.put("result",true);
            usergovaffairs.setAppointTime(params.getDate("appointTime"));
            usergovaffairs.setAddress(params.getString("address"));
            usergovaffairs.setAppointTime(params.getDate("gatime"));
            this.usergovaffairsService.update(usergovaffairs);
        }
        else{
            ret.put("result",false);
        }
        return ResponseEntity.ok(ret);
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