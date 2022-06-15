package com.miniprogram.zhihuicunwu.controller;

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

    @GetMapping("/all/{cid}")
    public ResponseEntity<JSONObject> queryByCid(@PathVariable("Cid") Integer cid) {
        JSONObject ret = new JSONObject();

        List<Department> departments = this.departmentService.queryByCid(cid);
        List<Integer> dids = new ArrayList<>();
        List<JSONObject> people = new ArrayList<>();

        ret.put("result", true);

        for(int i = 0; i < departments.size(); i++)
        {
            JSONObject dept = new JSONObject();
            List<JSONObject> personnel = new ArrayList<>();

            dept.put("deptName", departments.get(i).getDname());

            List<Work> works = this.workService.queryById(departments.get(i).getDid());
            for(int j = 0; j < works.size(); j++)
            {
                JSONObject temp = new JSONObject();
                User user = this.userService.queryById(works.get(i).getUid());
                temp.put("name", user.getUname());
                temp.put("avatar", ImageIOUtils.getUrlFromDBRecord(user.getUphoto()));
                temp.put("wname", works.get(i).getWname());
                temp.put("wtime", works.get(i).getWtime());
                temp.put("phone", user.getUphone());
                temp.put("gender", user.getUgender());

                personnel.add(temp);
            }

            dept.put("personnel", personnel);
            people.add(dept);
        }

        ret.put("people", people);

        return ResponseEntity.ok(ret);
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
        work.setWname("");

        List<Work> works = this.workService.queryById(department.getDid());
        Integer status;
        status = works.size() == 0 ? 3 : 2;

        User user = this.userService.queryById(params.getInteger("uid"));
        user.setStatus(status);
        this.userService.update(user);

        if(this.workService.insert(work) != null)
        {
            ret.put("result", true);


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
     * @param work 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<List> edit(@RequestBody Work work) {
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

