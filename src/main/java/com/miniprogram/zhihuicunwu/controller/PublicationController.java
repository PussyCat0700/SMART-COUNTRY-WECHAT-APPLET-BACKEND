package com.miniprogram.zhihuicunwu.controller;

import com.alibaba.fastjson.JSONObject;
import com.miniprogram.zhihuicunwu.entity.Publication;
import com.miniprogram.zhihuicunwu.entity.Publicationattach;
import com.miniprogram.zhihuicunwu.entity.Publicationpic;
import com.miniprogram.zhihuicunwu.service.PublicationService;
import com.miniprogram.zhihuicunwu.service.PublicationattachService;
import com.miniprogram.zhihuicunwu.service.PublicationpicService;
import com.miniprogram.zhihuicunwu.util.ImageIOUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * (Publication)表控制层
 *
 * @author makejava
 * @since 2022-06-06 16:54:43
 */
@RestController
@RequestMapping("publication")
public class PublicationController {
    /**
     * 服务对象
     */
    @Resource
    private PublicationService publicationService;
    @Resource
    private PublicationpicService publicationpicService;
    @Resource
    private PublicationattachService publicationattachService;
    /**
     * 分页查询
     *
     * @return 查询结果
     */
    @GetMapping("/latest/{cid}")
    public ResponseEntity<JSONObject> queryByPage(@PathVariable("cid") Integer cid) {
        JSONObject ret = new JSONObject();
        int pagesize_max = this.publicationService.countAll();
        int size = pagesize_max >= 16 ? 16 : pagesize_max;
        int page = 0;

        Pageable pageable = new PageRequest(page,size);
        Page<Publication> pages = this.publicationService.queryByPage(pageable, cid);

        List<Publication> publications = pages.getContent();
        List<JSONObject> news = new ArrayList<JSONObject>();
        for(int i = 0; i < publications.size(); i++)
        {
            List<Publicationattach> publicationattaches = this.publicationattachService.queryByPid(publications.get(i).getPid());
            List<String> attatches = new ArrayList<>();
            for(int j = 0; j < publicationattaches.size(); j++)
            {
                attatches.add(publicationattaches.get(j).getPattach());
            }

            List<Publicationpic> publicationpics = this.publicationpicService.queryByPid(publications.get(i).getPid());
            List<String> images = new ArrayList<>();
            for(int j = 0; j < publicationpics.size(); j++)
            {
                String url = ImageIOUtils.getUrlFromDBRecord(publicationpics.get(j).getPpic());
                images.add(url);
            }

            JSONObject temp = new JSONObject();
            temp.put("title", publications.get(i).getPtitle());
            temp.put("pid", publications.get(i).getPid());
            temp.put("type", publications.get(i).getPtype());
            temp.put("headPic", images);
            temp.put("abstract", publications.get(i).getPabstract());
            temp.put("create_time", publications.get(i).getPtime());
            news.add(temp);
        }

        ret.put("result", true);
        ret.put("news", news);

        return ResponseEntity.ok(ret);
    }
    /**
     * 通过主键查询单条数据
     *
     * @param pid 主键
     * @return 单条数据
     */
    @GetMapping("{pid}")
    public ResponseEntity<JSONObject> queryById(@PathVariable("pid") Integer pid) {
        Publication publication = this.publicationService.queryById(pid);
        List<Publicationattach> publicationattaches = this.publicationattachService.queryByPid(pid);
        List<Publicationpic> publicationpics = this.publicationpicService.queryByPid(pid);

        List<String> images = new ArrayList<>();
        List<String> attaches = new ArrayList<>();

        for(int i = 0; i < publicationpics.size(); i++)
        {
            String url = ImageIOUtils.getUrlFromDBRecord(publicationpics.get(i).getPpic());
            images.add(url);
        }
        for(int i = 0; i < publicationattaches.size(); i++)
        {
            attaches.add(publicationattaches.get(i).getPattach());
        }

        JSONObject ret = new JSONObject();

        ret.put("result", true);
        ret.put("title", publication.getPtitle());
        ret.put("content", publication.getPcontent());
        ret.put("from", publication.getDid());
        ret.put("create_time", publication.getPtime());
        ret.put("pic", images);
        ret.put("attachment", attaches);

        return ResponseEntity.ok(ret);
    }

    @PostMapping("/fuzzy")
    public ResponseEntity<JSONObject> queryFuzzyByTitle(@RequestBody JSONObject params)
    {
        JSONObject ret = new JSONObject();
        List<JSONObject> news = new ArrayList<JSONObject>();

        String keywords = params.getString("keywords");
        Integer cid = params.getInteger("cid");

        List<Publication> publications = this.publicationService.queryFuzzyByTitle("%" + keywords + "%", cid);
        for(int i = 0; i < publications.size(); i++)
        {
            List<Publicationattach> publicationattaches = this.publicationattachService.queryByPid(publications.get(i).getPid());
            List<String> attatches = new ArrayList<>();
            for(int j = 0; j < publicationattaches.size(); j++)
            {
                attatches.add(publicationattaches.get(j).getPattach());
            }

            List<Publicationpic> publicationpics = this.publicationpicService.queryByPid(publications.get(i).getPid());
            List<String> images = new ArrayList<>();
            for(int j = 0; j < publicationpics.size(); j++)
            {
                String url = ImageIOUtils.getUrlFromDBRecord(publicationpics.get(j).getPpic());
                images.add(url);
            }

            JSONObject temp = new JSONObject();
            temp.put("title", publications.get(i).getPtitle());
            temp.put("pid", publications.get(i).getPid());
            temp.put("type", publications.get(i).getPtype());
            temp.put("headPic", images);
            temp.put("abstract", publications.get(i).getPabstract());
            temp.put("create_time", publications.get(i).getPtime());
            news.add(temp);
        }

        ret.put("result", true);
        ret.put("news", news);

        return ResponseEntity.ok(ret);
    }

    /**
     * 新增数据
     *
     * @param jsonObject 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<JSONObject> add(@RequestBody JSONObject jsonObject) throws IOException {
        Publication publication = new Publication();
        publication.setDid(jsonObject.getInteger("did"));
        publication.setPtype(jsonObject.getString("category"));
        publication.setPabstract(jsonObject.getString("abstract"));
        publication.setPcontent(jsonObject.getString("content"));
        publication.setPtitle("title");
        this.publicationService.insert(publication);
        Publicationpic publicationpic = new Publicationpic();
        publicationpic.setPid(publication.getPid());
        String relativePath = ImageIOUtils.uploadImg(jsonObject.getString("cover"));
        publicationpic.setPpic(relativePath);
        this.publicationpicService.insert(publicationpic);
        jsonObject.put("result", true);
        return ResponseEntity.ok(jsonObject);
    }

    /**
     * 编辑数据
     *
     * @param publication 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Publication> edit(Publication publication) {
        return ResponseEntity.ok(this.publicationService.update(publication));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.publicationService.deleteById(id));
    }

}

