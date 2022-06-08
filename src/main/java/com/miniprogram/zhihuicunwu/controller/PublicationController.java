package com.miniprogram.zhihuicunwu.controller;

import com.alibaba.fastjson.JSONObject;
import com.miniprogram.zhihuicunwu.entity.Publication;
import com.miniprogram.zhihuicunwu.entity.Publicationattach;
import com.miniprogram.zhihuicunwu.entity.Publicationpic;
import com.miniprogram.zhihuicunwu.service.PublicationService;
import com.miniprogram.zhihuicunwu.service.PublicationattachService;
import com.miniprogram.zhihuicunwu.service.PublicationpicService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
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
     * @param publication 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Publication>> queryByPage(Publication publication, PageRequest pageRequest) {
        return ResponseEntity.ok(this.publicationService.queryByPage(publication, pageRequest));
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
            images.add(publicationpics.get(i).getPpic());
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

    @GetMapping("/fuzzy/{keywords}")
    public ResponseEntity<JSONObject> queryFuzzyByTitle(@PathVariable("keywords") String keywords)
    {
        JSONObject ret = new JSONObject();
        List<JSONObject> news = new ArrayList<JSONObject>();
        List<Publication> publications = this.publicationService.queryFuzzyByTitle("%" + keywords + "%");
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
                images.add(publicationpics.get(j).getPpic());
            }

            JSONObject temp = new JSONObject();
            temp.put("title", publications.get(i).getPtitle());
            temp.put("pid", publications.get(i).getPid());
            temp.put("type", publications.get(i).getPtype());
            temp.put("headPic", images);
            news.add(temp);
        }

        ret.put("result", true);
        ret.put("news", news);

        return ResponseEntity.ok(ret);
    }

    /**
     * 新增数据
     *
     * @param publication 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Publication> add(Publication publication) {
        return ResponseEntity.ok(this.publicationService.insert(publication));
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

