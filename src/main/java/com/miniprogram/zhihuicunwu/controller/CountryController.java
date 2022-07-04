package com.miniprogram.zhihuicunwu.controller;

import com.alibaba.fastjson.JSONObject;
import com.miniprogram.zhihuicunwu.entity.*;
import com.miniprogram.zhihuicunwu.service.*;
import com.miniprogram.zhihuicunwu.util.ImageIOUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * (Country)表控制层
 *
 * @author makejava
 * @since 2022-06-01 14:39:27
 */
@RestController
@RequestMapping("country")
public class CountryController {
    /**
     * 服务对象
     */
    @Resource
    private CountryService countryService;
    @Resource
    private CountryimgService countryimgService;
    @Resource
    private DepartmentService departmentService;
    @Resource
    private UsergovaffairsService usergovaffairsService;
    @Resource
    private DeptgovaffairsService deptgovaffairsService;
    @Resource
    private GovaffairsService govaffairsService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<JSONObject> queryById(@PathVariable("id") Integer id) {
        JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(this.countryService.queryById(id)));
        Countryimg countryimg = this.countryimgService.queryById(jsonObject.getInteger("cimage"));
        jsonObject.put("cimage", countryimg!=null?ImageIOUtils.getUrlFromDBRecord(countryimg.getCpic()):null);

        //村评分
        //获取村对应的所有部门
        List<Department> departments = this.departmentService.queryByCid(id);
        //获取该部门所有的 未评价&已评价订单
        List<Usergovaffairs> usergovaffairs = new ArrayList<>();
        //获取该部门所有的业务
        List<Deptgovaffairs> deptgovaffairs = new ArrayList<>();
        //获取对应业务的所有信息
        List<Govaffairs> govaffairs = new ArrayList<>();
        //存储GAid
        List<Integer> gaids = new ArrayList<>();

        Integer gaNum;   //已评价业务总数
        Double totalRate;    //总评分数
        Double avgRate;    //平均评分分数

        gaNum = 0;
        totalRate = 0.0;

        for(int k = 0; k < departments.size(); k++) {

            usergovaffairs = this.usergovaffairsService.queryByDid(departments.get(k).getDid());
            deptgovaffairs = this.deptgovaffairsService.queryByDid(departments.get(k).getDid());

            for (int i = 0; i < deptgovaffairs.size(); i++) {
                gaids.add(deptgovaffairs.get(i).getGaid());
                govaffairs.add(this.govaffairsService.queryById(deptgovaffairs.get(i).getGaid()));
            }

            //temp.put("department", this.departmentService.queryById(departments.get(k).getDid()).getDname());

            for (int i = 0; i < gaids.size(); i++) {
                for (int j = 0; j < usergovaffairs.size(); j++) {
                    if (usergovaffairs.get(j).getGaid() == gaids.get(i) && usergovaffairs.get(j).getRate() != null) {
                        gaNum++;    //用户预约订单中此业务已评价数量
                        totalRate += usergovaffairs.get(j).getRate();    //用户预约订单中此业务评价总分
                    }
                }
            }
        }

        DecimalFormat df = new DecimalFormat(".0");
        if (gaNum != 0) {
            avgRate = totalRate / gaNum;
            jsonObject.put("rate", df.format(avgRate));
        } else {
            avgRate = 0.0;
            jsonObject.put("rate", avgRate);
        }

        return ResponseEntity.ok(jsonObject);
    }

    /**
     * 新增数据
     *
     * @param jsonObject 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<JSONObject> add(@RequestBody JSONObject jsonObject) throws IOException {
        Country country = new Country();
        country.setCid(jsonObject.getInteger("cid"));
        country.setScore(jsonObject.getInteger("score"));
        country.setLocation(jsonObject.getString("location"));
        country.setCname(jsonObject.getString("cname"));
        country.setCcode(jsonObject.getString("ccode"));

        Countryimg countryimg = new Countryimg();
        countryimg.setCid(jsonObject.getInteger("cid"));
        String path = ImageIOUtils.uploadImg(jsonObject.getString("cimage"));
        countryimg.setCpic(path);
        this.countryimgService.insert(countryimg);
        jsonObject.replace("cimage", ImageIOUtils.getUrlFromDBRecord(path));
        return ResponseEntity.ok(jsonObject);
    }

    /**
     * 编辑数据
     *
     * @param jsonObject 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<JSONObject> edit(@RequestBody JSONObject jsonObject) throws IOException {
        Country country = JSONObject.parseObject(JSONObject.toJSONString(jsonObject), Country.class);
        country = this.countryService.update(country);
        if(jsonObject.containsKey("cimage")) {
            String path = ImageIOUtils.uploadImg(jsonObject.getString("cimage"));
            Countryimg countryimg = new Countryimg();
            countryimg.setCid(country.getCid());
            List<Countryimg> countryimgs = this.countryimgService.queryAllByAny(countryimg);
            if (countryimgs != null&&!countryimgs.isEmpty()) {
                countryimg = countryimgs.get(0);
                countryimg.setCpic(path);
                jsonObject.replace("cimage", ImageIOUtils.getUrlFromDBRecord(this.countryimgService.update(countryimg).getCpic()));
            }else{
                countryimg.setCpic(path);
                jsonObject.replace("cimage", ImageIOUtils.getUrlFromDBRecord(this.countryimgService.insert(countryimg).getCpic()));
            }
        }
        return ResponseEntity.ok(jsonObject);
    }

    @PutMapping("ccode")
    public ResponseEntity<JSONObject> editCcode(@RequestBody JSONObject jsonObject) {
        JSONObject ret = new JSONObject();
        Country country = this.countryService.queryById(jsonObject.getInteger("cid"));

        if(country == null)
        {
            ret.put("result", false);
        }
        else
        {
            ret.put("result", true);
            if(country.getCcode().equals("waiting")){
                country.setCcode("pass");
                System.out.println(country.getCcode());
            }
            else if(country.getCcode().equals("pass")){
                country.setCcode(UUID.randomUUID().toString());
            }
            this.countryService.update(country);
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
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.countryService.deleteById(id));
    }

}

