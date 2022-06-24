package com.miniprogram.zhihuicunwu.controller;

import com.alibaba.fastjson.JSONArray;
import com.miniprogram.zhihuicunwu.entity.Department;
import com.miniprogram.zhihuicunwu.entity.User;
import com.miniprogram.zhihuicunwu.entity.Work;
import com.miniprogram.zhihuicunwu.service.DepartmentService;
import com.miniprogram.zhihuicunwu.service.UserService;
import com.miniprogram.zhihuicunwu.service.WorkService;
import com.alibaba.fastjson.JSONObject;
import com.miniprogram.zhihuicunwu.util.DateUtil;
import com.miniprogram.zhihuicunwu.util.ImageIOUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
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
    @Resource
    private DepartmentService departmentService;

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

    private ResponseEntity<JSONObject> doQuery(List<Department> departments, boolean deptInfoRequired, String searchName){
        JSONObject ret = new JSONObject();
        JSONArray people = new JSONArray();

        ret.put("result", true);

        for(int i = 0; i < departments.size(); i++)
        {
            JSONObject dept = new JSONObject();
            List<JSONObject> personnel = new ArrayList<>();

            if(deptInfoRequired) {
                dept.put("deptName", departments.get(i).getDname());
            }

            List<Work> works = this.workService.queryById(departments.get(i).getDid());
            for(int j = 0; j < works.size(); j++)
            {
                JSONObject temp = new JSONObject();
                User user = this.userService.queryById(works.get(j).getUid());
                if(searchName == null || user.getUname().contains(searchName)) {
                    temp.put("name", user.getUname());
                    temp.put("uid", user.getUid());
                    temp.put("real_name", user.getRealName());
                    temp.put("status", user.getStatus());
                    temp.put("avatar", ImageIOUtils.getUrlFromDBRecord(user.getUphoto()));
                    temp.put("wname", works.get(j).getWname());
                    temp.put("wtime", works.get(j).getWtime());
                    temp.put("phone", user.getUphone());
                    temp.put("gender", user.getUgender());

                    personnel.add(temp);
                }
            }
            if(deptInfoRequired) {
                dept.put("personnel", personnel);
                people.add(dept);
            }else if(!personnel.isEmpty()){
                people.addAll(personnel);
            }
        }

        ret.put("people", people);

        return ResponseEntity.ok(ret);
    }

    @GetMapping("/all/{cid}")
    public ResponseEntity<JSONObject> queryByCid(@PathVariable("cid") Integer cid) {
        List<Department> departments = this.departmentService.queryByCid(cid);
        return doQuery(departments, true, "");
    }
    @GetMapping("/all/personnel/{cid}")
    public ResponseEntity<JSONObject> queryPersonnelByCid(@PathVariable("cid") Integer cid) {
        List<Department> departments = this.departmentService.queryByCid(cid);
        return doQuery(departments, false, "");
    }

    @GetMapping("/all/dept/{did}")
    public ResponseEntity<JSONObject> queryByDid(@PathVariable("did") Integer did){
        Department department = this.departmentService.queryById(did);
        return doQuery(Arrays.asList(department), true, "");
    }

    @PostMapping("/search/dept")
    public ResponseEntity<JSONObject> queryByDidName(@RequestBody JSONObject params){
        Department department = this.departmentService.queryById(params.getInteger("did"));
        return doQuery(Arrays.asList(department), false, params.getString("searchValue"));
    }

    @PostMapping("/search/country")
    public ResponseEntity<JSONObject> queryByCidName(@RequestBody JSONObject params){
        List<Department> departments = this.departmentService.queryByCid(params.getInteger("cid"));
        return doQuery(departments, true, params.getString("searchValue"));
    }

    /**
     * 新增数据
     *
     * @param params 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<JSONObject> add(@RequestBody JSONObject params) {
        Work work = new Work();
        Department department = this.departmentService.queryByDcode(params.getString("dCode"));
        JSONObject ret = new JSONObject();

        work.setDid(department.getDid());
        work.setUid(params.getInteger("uid"));

        List<Work> works = this.workService.queryById(department.getDid());
        Integer status = works.size() == 0 ? 3 : 2;
        String wname = works.size() == 0 ? "负责人" : "干事";
        work.setWname(wname);

        User user = this.userService.queryById(params.getInteger("uid"));
        user.setStatus(status);
        this.userService.update(user);

        if(this.workService.insert(work) != null)
        {
            ret.put("result", true);
            ret.put("work", work);
            ret.put("status", user.getStatus());
            ret.put("department", department);
        }
        else
        {
            ret.put("result", false);
        }

        return ResponseEntity.ok(ret);
    }

    /**
     * 编辑数据
     *
     * @param params 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<JSONObject> edit(@RequestBody JSONObject params) {
        JSONObject ret = new JSONObject();
        Work work = this.workService.queryByUid(params.getInteger("uid"));

        if(work != null)
        {
            ret.put("result", true);
            work.setWname(params.getString("wname"));
            this.workService.update(work);
        }
        else
        {
            ret.put("result", false);
        }
        return ResponseEntity.ok(ret);
    }

    @PutMapping("/setting")
    public ResponseEntity<JSONObject> setManager(@RequestBody JSONObject params) {
        JSONObject ret = new JSONObject();
        Work work = this.workService.queryByUid(params.getInteger("uid"));

        if(work != null)
        {
            ret.put("result", true);
            work.setWname("负责人");
            this.workService.update(work);

            User user = this.userService.queryById(params.getInteger("uid"));
            user.setStatus(3);
            this.userService.update(user);
        }
        else
        {
            ret.put("result", false);
        }
        return ResponseEntity.ok(ret);
    }

    /**
     * 删除数据
     *
     * @param uid 主键
     * @return 删除是否成功
     */
    @DeleteMapping("/delete/{uid}")
    public ResponseEntity<JSONObject> deleteById(@PathVariable("uid") Integer uid) {
        JSONObject ret = new JSONObject();

        if(this.workService.queryByUid(uid) != null)
        {
            ret.put("result", true);
            this.workService.deleteById(uid);

            User user = this.userService.queryById(uid);
            user.setStatus(1);
            this.userService.update(user);
        }
        else
        {
            ret.put("result", false);
        }

        return ResponseEntity.ok(ret);
    }

}

