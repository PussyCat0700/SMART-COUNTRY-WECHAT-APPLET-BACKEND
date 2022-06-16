package com.miniprogram.zhihuicunwu.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.miniprogram.zhihuicunwu.entity.PublicationComment;
import com.miniprogram.zhihuicunwu.entity.User;
import com.miniprogram.zhihuicunwu.service.PublicationCommentService;
import com.miniprogram.zhihuicunwu.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.*;

/**
 * (PublicationComment)表控制层
 *
 * @author makejava
 * @since 2022-06-16 14:50:07
 */
@RestController
@RequestMapping("publicationComment")
public class PublicationCommentController {
    /**
     * 服务对象
     */
    @Resource
    private PublicationCommentService publicationCommentService;
    @Resource
    private UserService userService;

    /**
     * 通过主键查询单条数据
     *
     * @param pid publicationID
     * @return 对应publication的许多条评论
     */
    @GetMapping("{pid}")
    public ResponseEntity<JSONArray> queryById(@PathVariable("pid") Integer pid) {
        PublicationComment c1 = new PublicationComment();
        c1.setPid(pid);
        List<PublicationComment> comments = this.publicationCommentService.queryAllByAny(c1);
        JSONArray roots = new JSONArray();
        List<JSONObject> subRoots = new ArrayList<>();
        HashMap<Integer, Integer> rootID2Idx = new HashMap<>();
        for(PublicationComment comment:comments){
            JSONObject item = new JSONObject();
            item.put("replyContent", comment.getContent());
            item.put("commentID", comment.getCommentId());
            User u = userService.queryById(comment.getUid());
            if(u!=null) {
                item.put("userInfo", u.getBriefInfo());
            }
            if(comment.getReplyUid() !=null){
                User u2 = userService.queryById(comment.getReplyUid());
                item.put("replyUserInfo", u2.getBriefInfo());
            }
            Integer rootID = comment.getRootCommentId();
            if(rootID==null){
                roots.add(new JSONArray(new ArrayList<>(Collections.singletonList(item))));
                rootID2Idx.put(comment.getCommentId(), roots.size()-1);
            }else{
                item.put("rootCommentID", rootID);
                subRoots.add(item);
            }
        }
        for(JSONObject comment: subRoots){
            Integer rootCommentID = comment.getInteger("rootCommentID");
            Integer index = rootID2Idx.get(rootCommentID);
            JSONArray jsonArray = roots.getJSONArray(index);
            jsonArray.add(comment);
        }
        return ResponseEntity.ok(roots);
    }

    /**
     * 新增数据
     *
     * @param jsonObject 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<PublicationComment> add(@RequestBody JSONObject jsonObject) {
        PublicationComment comment = new PublicationComment();
        comment.setContent(jsonObject.getString("replyContent"));
        comment.setUid(jsonObject.getInteger("userID"));
        comment.setReplyUid(jsonObject.getInteger("replyUserID"));
        comment.setPid(jsonObject.getInteger("pid"));
        comment.setRootCommentId(jsonObject.getInteger("rootCommentID"));
        return ResponseEntity.ok(this.publicationCommentService.insert(comment));
    }

    /**
     * 编辑数据
     *
     * @param publicationComment 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<PublicationComment> edit(@RequestBody PublicationComment publicationComment) {
        return ResponseEntity.ok(this.publicationCommentService.update(publicationComment));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.publicationCommentService.deleteById(id));
    }

}

