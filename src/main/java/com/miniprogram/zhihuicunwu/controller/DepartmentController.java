package com.miniprogram.zhihuicunwu.controller;

import com.alibaba.fastjson.JSONObject;
import com.miniprogram.zhihuicunwu.entity.Countrydepartment;
import com.miniprogram.zhihuicunwu.entity.Department;
import com.miniprogram.zhihuicunwu.service.CountrydepartmentService;
import com.miniprogram.zhihuicunwu.service.DepartmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * (Department)表控制层
 *
 * @author makejava
 * @since 2022-06-01 14:39:27
 */
@RestController
@RequestMapping("department")
public class DepartmentController {
    /**
     * 服务对象
     */
    @Resource
    private DepartmentService departmentService;
    @Resource
    private CountrydepartmentService countrydepartmentService;

    /**
     * 通过主键查询单条数据
     *
     * @param did 主键
     * @return 单条数据
     */
    @GetMapping("/{did}")
    public ResponseEntity<Department> queryById(@PathVariable("did") Integer did) {
        return ResponseEntity.ok(this.departmentService.queryById(did));
    }

    //查询某个村下所有的部门信息
    @GetMapping("/country/{cid}")
    public ResponseEntity<List> queryByCid(@PathVariable("cid") Integer cid) {
        List<Countrydepartment> countrydepartments = this.countrydepartmentService.queryByCid(cid);
        List<Department> departments = new ArrayList<>();

        for(int i = 0; i < countrydepartments.size(); i++)
        {
            departments.add(this.departmentService.queryById(countrydepartments.get(i).getDid()));
        }

        return ResponseEntity.ok(departments);
    }

    /**
     * 新增数据
     *
     * @param params 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Department> add(@RequestBody JSONObject params) {
        //先在Department表中添加
        Department department = new Department();
        department.setDaddress(params.getString("address"));
        department.setDdescription(params.getString("desc"));
        department.setDname(params.getString("name"));
        department.setDphone(params.getString("phone"));
        this.departmentService.insert(department);

        //再在CountryDepartment表里添加关系
        Countrydepartment countrydepartment = new Countrydepartment();
        countrydepartment.setCid(params.getInteger("cid"));
        //TODO: 获取新增数据的did countrydepartment.setDid(this.);
        this.countrydepartmentService.insert(countrydepartment);

        return ResponseEntity.ok(this.departmentService.insert(department));
    }

    /**
     * 编辑数据
     *
     * @param params 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Department> edit(@RequestBody JSONObject params) {
        Department department = this.departmentService.queryById(params.getInteger("department_id"));
        department.setDaddress(params.getString("address"));
        department.setDdescription(params.getString("desc"));
        department.setDname(params.getString("name"));
        department.setDphone(params.getString("phone"));

        return ResponseEntity.ok(this.departmentService.update(department));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.departmentService.deleteById(id));
    }

}

