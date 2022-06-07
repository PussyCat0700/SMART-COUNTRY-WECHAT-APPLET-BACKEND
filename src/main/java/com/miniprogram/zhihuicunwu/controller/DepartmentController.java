package com.miniprogram.zhihuicunwu.controller;

import com.alibaba.fastjson.JSONObject;
import com.miniprogram.zhihuicunwu.entity.Department;
import com.miniprogram.zhihuicunwu.entity.Departmentimg;
import com.miniprogram.zhihuicunwu.service.DepartmentService;
import com.miniprogram.zhihuicunwu.service.DepartmentimgService;
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
    private DepartmentimgService departmentimgService;
//    @Resource
//    private CountrydepartmentService countrydepartmentService;

    /**
     * 通过主键查询单条数据
     *
     * @param did 主键
     * @return 单条数据
     */
    @GetMapping("/department/{did}")
    public ResponseEntity<JSONObject> queryById(@PathVariable("did") Integer did) {
        Department department = this.departmentService.queryById(did);

        JSONObject temp = new JSONObject();
        temp.put("department_address", department.getDaddress());
        temp.put("department_desc", department.getDdescription());
        temp.put("department_id", department.getDid());
        temp.put("department_name", department.getDname());
        temp.put("department_phone", department.getDphone());

        List<Departmentimg> departmentimgs = this.departmentimgService.queryByDid(department.getDid());
        List<String> images = new ArrayList<>();
        for(int j = 0; j < departmentimgs.size(); j++)
        {
            images.add(departmentimgs.get(j).getDpic());
        }

        temp.put("department_images", images);

        return ResponseEntity.ok(temp);
    }

    //查询某个村下所有的部门信息
    @GetMapping("/country/{cid}")
    public ResponseEntity<List> queryByCid(@PathVariable("cid") Integer cid) {
        List<Department> departments = this.departmentService.queryByCid(cid);
        List<JSONObject> ret = new ArrayList<JSONObject>();

        for(int i = 0; i < departments.size(); i++)
        {
            JSONObject temp = new JSONObject();
            temp.put("department_address", departments.get(i).getDaddress());
            temp.put("department_desc", departments.get(i).getDdescription());
            temp.put("department_id", departments.get(i).getDid());
            temp.put("department_name", departments.get(i).getDname());
            temp.put("department_phone", departments.get(i).getDphone());

            List<Departmentimg> departmentimgs = this.departmentimgService.queryByDid(departments.get(i).getDid());
            List<String> images = new ArrayList<>();
            for(int j = 0; j < departmentimgs.size(); j++)
            {
                images.add(departmentimgs.get(j).getDpic());
            }

            temp.put("department_images", images);

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
    public ResponseEntity<JSONObject> add(@RequestBody JSONObject params) {
        JSONObject ret = new JSONObject();
        //先在Department表中添加
        Department department = new Department();
        department.setCid(params.getInteger("cid"));
        department.setDaddress(params.getString("address"));
        department.setDdescription(params.getString("desc"));
        department.setDname(params.getString("name"));
        department.setDphone(params.getString("phone"));
        this.departmentService.insert(department);

        //TODO：需要将获得的String(base64)转换成图片，再将图片的url存入数据库
        Object images_obj = params.get("images");
        List<String> images = new ArrayList<String>();
        if (images_obj instanceof ArrayList<?>)
        {
            for(Object o : (List<?>) images_obj)
            {
                images.add(String.class.cast(o));
            }
        }

        for(int i = 0; i < images.size(); i++)
        {
            Departmentimg departmentimg = new Departmentimg();
            departmentimg.setDid(department.getDid());
            departmentimg.setDpic(images.get(i));
            this.departmentimgService.insert(departmentimg);
        }

        if(department == null)
        {
            ret.put("result", false);
        }
        else
        {
            ret.put("result", true);
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
        Department department = this.departmentService.queryById(params.getInteger("department_id"));
        List<Departmentimg> departmentimgs = this.departmentimgService.queryByDid(department.getDid());
        JSONObject ret = new JSONObject();

        for(int i = 0; i < departmentimgs.size(); i++)
        {
            this.departmentimgService.deleteById(departmentimgs.get(i).getImgId());
        }

        department.setDaddress(params.getString("address"));
        department.setDdescription(params.getString("desc"));
        department.setDname(params.getString("name"));
        department.setDphone(params.getString("phone"));

        //TODO：需要将获得的String(base64)转换成图片，再将图片的url存入数据库
        Object images_obj = params.get("images");
        List<String> images = new ArrayList<String>();
        if (images_obj instanceof ArrayList<?>)
        {
            for(Object o : (List<?>) images_obj)
            {
                images.add(String.class.cast(o));
            }
        }

        for(int i = 0; i < images.size(); i++)
        {
            Departmentimg departmentimg = new Departmentimg();
            departmentimg.setDid(department.getDid());
            departmentimg.setDpic(images.get(i));
            this.departmentimgService.insert(departmentimg);
        }

        if(department == null)
        {
            ret.put("result", false);
        }
        else
        {
            ret.put("result", true);
        }

        return ResponseEntity.ok(ret);
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<JSONObject> deleteById(Integer id) {
        Department department = this.departmentService.queryById(id);
        List<Departmentimg> departmentimgs = this.departmentimgService.queryByDid(department.getDid());
        JSONObject ret = new JSONObject();

        for(int i = 0; i < departmentimgs.size(); i++)
        {
            this.departmentimgService.deleteById(departmentimgs.get(i).getImgId());
        }

        if(!this.departmentService.deleteById(id))
        {
            ret.put("result", false);
        }
        else
        {
            ret.put("result", true);
        }

        return ResponseEntity.ok(ret);
    }

}

