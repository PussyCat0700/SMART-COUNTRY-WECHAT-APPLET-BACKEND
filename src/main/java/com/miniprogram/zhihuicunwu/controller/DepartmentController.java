package com.miniprogram.zhihuicunwu.controller;

import com.alibaba.fastjson.JSONObject;
import com.miniprogram.zhihuicunwu.entity.*;
import com.miniprogram.zhihuicunwu.service.*;
import com.miniprogram.zhihuicunwu.util.ImageIOUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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
    @Resource
    private CreatesService createsService;
    @Resource
    private UsergovaffairsService usergovaffairsService;
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
        List<JSONObject> arrivals = new ArrayList<>();
        List<JSONObject> spots = new ArrayList<>();
        double[] rates;

        //获取部门评分
        //获取该部门所有的 未评价&已评价订单
        List<Usergovaffairs> usergovaffairs = this.usergovaffairsService.queryByDid(did);
        //获取该部门所有的业务
        List<Deptgovaffairs> deptgovaffairs = this.deptgovaffairsService.queryByDid(did);
        //获取对应业务的所有信息
        List<Govaffairs> govaffairs = new ArrayList<>();
        //存储GAid
        List<Integer> gaids = new ArrayList<>();

        rates = new double[deptgovaffairs.size()];

        for(int i = 0; i < deptgovaffairs.size(); i++)
        {
            gaids.add(deptgovaffairs.get(i).getGaid());
            govaffairs.add(this.govaffairsService.queryById(deptgovaffairs.get(i).getGaid()));
        }

        Integer gaNum;   //已评价业务总数
        Double totalRate;    //总评分数
        Double avgRate;    //平均评分分数
        List<JSONObject> gaRates = new ArrayList<>();
        JSONObject jsonObject;

        ret.put("department", this.departmentService.queryById(did).getDname());

        gaNum = 0;
        totalRate = 0.0;

        for(int i = 0; i < gaids.size(); i++)
        {
            int gaNum_1 = 0;
            double totalRate_1 = 0.0;
            double avgRate_1 = 0.0;
            for(int j = 0; j < usergovaffairs.size(); j++)
            {
                if(usergovaffairs.get(j).getGaid() == gaids.get(i) && usergovaffairs.get(j).getRate() != null)
                {
                    gaNum++;    //用户预约订单中此业务已评价数量
                    gaNum_1++;
                    totalRate += usergovaffairs.get(j).getRate();    //用户预约订单中此业务评价总分
                    totalRate_1 += usergovaffairs.get(j).getRate();
                }
            }
            if(gaNum_1 != 0) {
                avgRate_1 = totalRate_1 / gaNum_1;
            }
            else{
                avgRate_1 = 0.0;
            }
            rates[i] = avgRate_1;
        }

        for(int i = 0; i < deptgovaffairs.size(); i++) {
            JSONObject temp = new JSONObject();
            Integer GAid = deptgovaffairs.get(i).getGaid();
            //获取政务详细信息
            Govaffairs govaffairs_1 = this.govaffairsService.queryById(GAid);

            temp.put("name", govaffairs_1.getGaname());
            temp.put("id", GAid);
            DecimalFormat df = new DecimalFormat(".0");
            if(rates[i] != 0) {
                temp.put("rate", df.format(rates[i]));
            }
            else{
                temp.put("rate", rates[i]);
            }

            boolean isArrival = govaffairs_1.getIsarrival() != 0;
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

        DecimalFormat df = new DecimalFormat(".0");
        if(gaNum != 0) {
            avgRate = totalRate / gaNum;
            ret.put("rate", df.format(avgRate));
        }
        else{
            avgRate = 0.0;
            ret.put("rate", avgRate);
        }

        //获取部门信息
        if(department==null)
        {
            ret.put("result", false);
        }
        else
        {
            //存基本信息
            Departmentimg departmentimgs = this.departmentimgService.queryByDid(department.getDid());
            String images;
            if(departmentimgs!=null) {
                images = ImageIOUtils.getUrlFromDBRecord(departmentimgs.getDpic());
            }
            else{
                images = null;
            }

            ret.put("result", true);
            ret.put("headPic", images);
            ret.put("deptName", department.getDname());
            ret.put("desc", department.getDdescription());
            ret.put("phoneNum", department.getDphone());
            ret.put("location", department.getDaddress());
            ret.put("dcode", department.getDcode());

            //存政务
            //获取政务id
//            deptgovaffairs.clear();
//            deptgovaffairs = this.deptgovaffairsService.queryByDid(department.getDid());
        }

        return ResponseEntity.ok(ret);
    }

    //查询某个村下所有的部门信息
    @GetMapping("/country/{cid}")
    public ResponseEntity<List> queryByCid(@PathVariable("cid") Integer cid) {
        List<Department> departments = this.departmentService.queryByCid(cid);
        List<JSONObject> ret = new ArrayList<JSONObject>();
        Creates creates = this.createsService.queryById(cid);
        for(int i = 0; i < departments.size(); i++)
        {
            if(departments.get(i).getDcode().equals(cid + "-" + creates.getUid())){
                departments.remove(i);
                break;
            }
        }

        for(int i = 0; i < departments.size(); i++)
        {
            JSONObject temp = new JSONObject();
            temp.put("address", departments.get(i).getDaddress());
            temp.put("desc", departments.get(i).getDdescription());
            temp.put("did", departments.get(i).getDid());
            temp.put("name", departments.get(i).getDname());
            temp.put("phone", departments.get(i).getDphone());
            temp.put("dCode", departments.get(i).getDcode());

            Departmentimg departmentimgs = this.departmentimgService.queryByDid(departments.get(i).getDid());
            if(departmentimgs!=null) {
                String images = ImageIOUtils.getUrlFromDBRecord(departmentimgs.getDpic());
                temp.put("dImage", images);
            }

            //获取评分
            //获取该部门所有的 未评价&已评价订单
            List<Usergovaffairs> usergovaffairs = new ArrayList<>();
            //获取该部门所有的业务
            List<Deptgovaffairs> deptgovaffairs = new ArrayList<>();
            //获取对应业务的所有信息
            List<Govaffairs> govaffairs = new ArrayList<>();
            //存储GAid
            List<Integer> gaids = new ArrayList<>();

            usergovaffairs = this.usergovaffairsService.queryByDid(departments.get(i).getDid());
            deptgovaffairs = this.deptgovaffairsService.queryByDid(departments.get(i).getDid());

            for (int j = 0; j < deptgovaffairs.size(); j++) {
                gaids.add(deptgovaffairs.get(j).getGaid());
                govaffairs.add(this.govaffairsService.queryById(deptgovaffairs.get(j).getGaid()));
            }

            Integer gaNum;   //已评价业务总数
            Double totalRate;    //总评分数
            Double avgRate;    //平均评分分数
            List<JSONObject> gaRates = new ArrayList<>();
            JSONObject jsonObject;

            gaNum = 0;
            totalRate = 0.0;

            for (int j = 0; j < gaids.size(); j++) {
                jsonObject = new JSONObject();
                for (int k = 0; k < usergovaffairs.size(); k++) {
                    if (usergovaffairs.get(k).getGaid() == gaids.get(j) && usergovaffairs.get(k).getRate() != null) {
                        gaNum++;    //用户预约订单中此业务已评价数量
                        totalRate += usergovaffairs.get(k).getRate();    //用户预约订单中此业务评价总分
                    }
                }
            }
            DecimalFormat df = new DecimalFormat(".0");
            if (gaNum != 0) {
                avgRate = totalRate / gaNum;
                temp.put("rate", df.format(avgRate));
            } else {
                avgRate = 0.0;
                temp.put("rate", avgRate);
            }
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

        String dcode = UUID.randomUUID().toString();
        department.setDcode(dcode);
        this.departmentService.insert(department);

        String images = params.getString("dImage");

        Departmentimg departmentimg = new Departmentimg();
        departmentimg.setDid(department.getDid());
        String url = ImageIOUtils.uploadImg(images);
        departmentimg.setDpic(url);
        this.departmentimgService.insert(departmentimg);

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
        Departmentimg departmentimgs = this.departmentimgService.queryByDid(department.getDid());
        JSONObject ret = new JSONObject();


        this.departmentimgService.deleteById(departmentimgs.getImgId());

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
                ret.put("dImage", ImageIOUtils.getUrlFromDBRecord(url));
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
        Departmentimg departmentimgs = this.departmentimgService.queryByDid(department.getDid());
        JSONObject ret = new JSONObject();

        if(departmentimgs!=null) {
            this.departmentimgService.deleteById(departmentimgs.getImgId());
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

