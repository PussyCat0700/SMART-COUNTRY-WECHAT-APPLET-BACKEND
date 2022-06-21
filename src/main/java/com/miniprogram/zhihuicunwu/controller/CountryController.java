package com.miniprogram.zhihuicunwu.controller;

import com.alibaba.fastjson.JSONObject;
import com.miniprogram.zhihuicunwu.entity.Country;
import com.miniprogram.zhihuicunwu.entity.Countryimg;
import com.miniprogram.zhihuicunwu.service.CountryService;
import com.miniprogram.zhihuicunwu.service.CountryimgService;
import com.miniprogram.zhihuicunwu.util.ImageIOUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;
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
        jsonObject.replace("cimage", ImageIOUtils.getUrlFromDBRecord(countryimg!=null?countryimg.getCpic():null));
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
            if(jsonObject.getString("ccode") != "error") {
                country.setCcode(UUID.randomUUID().toString());
            }
            else{
                country.setCcode("error");
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

