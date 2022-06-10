package com.miniprogram.zhihuicunwu.controller;

import com.alibaba.fastjson.JSONObject;
import com.miniprogram.zhihuicunwu.entity.Department;
import com.miniprogram.zhihuicunwu.entity.Departmentimg;
import com.miniprogram.zhihuicunwu.entity.Deptgovaffairs;
import com.miniprogram.zhihuicunwu.entity.Govaffairs;
import com.miniprogram.zhihuicunwu.service.DepartmentService;
import com.miniprogram.zhihuicunwu.service.DepartmentimgService;
import com.miniprogram.zhihuicunwu.service.DeptgovaffairsService;
import com.miniprogram.zhihuicunwu.service.GovaffairsService;
import com.miniprogram.zhihuicunwu.util.ImageIOUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;
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
    @Resource
    private GovaffairsService govaffairsService;
    @Resource
    private DeptgovaffairsService deptgovaffairsService;
//    @Resource
//    private CountrydepartmentService countrydepartmentService;

    /**
     * 通过主键查询单条数据
     *
     * @param did 主键
     * @return 单条数据
     */
    //显示部门详细信息以及该部门所有的业务
    @GetMapping("/department/{did}")
    public ResponseEntity<JSONObject> queryById(@PathVariable("did") Integer did) {
        Department department = this.departmentService.queryById(did);
        JSONObject ret = new JSONObject();

        if(department==null)
        {
            ret.put("result", false);
        }
        else
        {
            List<JSONObject> arrivals = new ArrayList<>();
            List<JSONObject> spots = new ArrayList<>();

            //存基本信息
            List<Departmentimg> departmentimgs = this.departmentimgService.queryByDid(department.getDid());
            List<String> images = new ArrayList<>();

            for(int i = 0; i < departmentimgs.size(); i++)
            {
                images.add(departmentimgs.get(i).getDpic());
            }

            ret.put("result", true);
            ret.put("headPic", images);
            ret.put("deptName", department.getDname());
            ret.put("desc", department.getDdescription());
            ret.put("phoneNum", department.getDphone());
            ret.put("location", department.getDaddress());

            //存政务
            //获取政务id
            List<Deptgovaffairs> deptgovaffairs = this.deptgovaffairsService.queryByDid(department.getDid());

            for(int i = 0; i < deptgovaffairs.size(); i++) {
                JSONObject temp = new JSONObject();
                Integer GAid = deptgovaffairs.get(i).getGaid();
                //获取政务详细信息
                Govaffairs govaffairs = this.govaffairsService.queryById(GAid);

                temp.put("name", govaffairs.getGaname());
                temp.put("id", GAid);

                boolean isArrival = govaffairs.getIsarrival() != 0;
                if (isArrival) {
                    arrivals.add(temp);
                }
                else
                {
                    spots.add(temp);
                }
            }

            ret.put("arrivals", arrivals);
            ret.put("spots", spots);
        }


        return ResponseEntity.ok(ret);
    }

    //查询某个村下所有的部门信息
    @GetMapping("/country/{cid}")
    public ResponseEntity<List> queryByCid(@PathVariable("cid") Integer cid) {
        List<Department> departments = this.departmentService.queryByCid(cid);
        List<JSONObject> ret = new ArrayList<JSONObject>();

        for(int i = 0; i < departments.size(); i++)
        {
            JSONObject temp = new JSONObject();
            temp.put("address", departments.get(i).getDaddress());
            temp.put("desc", departments.get(i).getDdescription());
            temp.put("did", departments.get(i).getDid());
            temp.put("name", departments.get(i).getDname());
            temp.put("phone", departments.get(i).getDphone());

            List<Departmentimg> departmentimgs = this.departmentimgService.queryByDid(departments.get(i).getDid());
            List<String> images = new ArrayList<>();
            for(int j = 0; j < departmentimgs.size(); j++)
            {
                String url = ImageIOUtils.getUrlFromDBRecord(departmentimgs.get(j).getDpic());
                images.add(url);
            }

            temp.put("images", images);

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
    public ResponseEntity<JSONObject> add(@RequestBody JSONObject params) throws IOException {
        JSONObject ret = new JSONObject();
        //先在Department表中添加
        Department department = new Department();
        department.setCid(params.getInteger("cid"));
        department.setDaddress(params.getString("address"));
        department.setDdescription(params.getString("desc"));
        department.setDname(params.getString("name"));
        department.setDphone(params.getString("phone"));
        this.departmentService.insert(department);

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
            String url = ImageIOUtils.uploadImg(images.get(i));
            departmentimg.setDpic(url);
            this.departmentimgService.insert(departmentimg);
        }

        ret.put("result", true);

        return ResponseEntity.ok(ret);
    }

    /**
     * 编辑数据
     *
     * @param params 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<JSONObject> edit(@RequestBody JSONObject params) throws IOException {
        Department department = this.departmentService.queryById(params.getInteger("did"));
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
        try {
            this.departmentService.update(department);
        }catch (BadSqlGrammarException e){
            /**
             * 这是一个粗略的错误处理方法
             * 我们在这里假设BadSQLGrammerException一定是由没有更新字段造成的！
             */
            ret.put("extra", "除图片外，部门其他字段未修改");
        }finally {
            String image = params.getString("dImage");

            Departmentimg departmentimg = new Departmentimg();
            departmentimg.setDid(department.getDid());
            String url = ImageIOUtils.uploadImg(image);
            departmentimg.setDpic(url);
            this.departmentimgService.insert(departmentimg);

            if(department == null)
            {
                ret.put("result", false);
            }
            else
            {
                ret.put("result", true);
            }
        }

        return ResponseEntity.ok(ret);
    }

    /**
     * 删除数据
     *
     * @param did 主键
     * @return 删除是否成功
     */
    @DeleteMapping("{did}")
    public ResponseEntity<JSONObject> deleteById(@PathVariable("did") Integer did) {
        Department department = this.departmentService.queryById(did);
        List<Departmentimg> departmentimgs = this.departmentimgService.queryByDid(department.getDid());
        JSONObject ret = new JSONObject();

        for(int i = 0; i < departmentimgs.size(); i++)
        {
            this.departmentimgService.deleteById(departmentimgs.get(i).getImgId());
        }

        if(!this.departmentService.deleteById(did))
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

