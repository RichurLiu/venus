package com.richur.venus.biz.model.dto;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.richur.venus.biz.model.po.Article;
import com.richur.venus.biz.model.po.User;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author richur
 * @Date 2019/9/11 10:14 AM
 */
@Setter
@Getter
public class ArticleInfoDTO {
    private Article article;
    private List<User> users;


    public static void main(String[] args) {
        ArticleInfoDTO articleInfoDTO = new ArticleInfoDTO();
        Article article = new Article();
        article.setId(1506L);
        article.setAuthor("richur");
        article.setTitle("final");
        article.setContent("blog");
        articleInfoDTO.setArticle(article);
        List<User> users = new ArrayList<>();
        User user = new User();
        user.setId(2233L);
        user.setName("richur");
        user.setGender(1);
        users.add(user);
        users.add(user);
        users.add(user);
        articleInfoDTO.setUsers(users);
        System.out.println(JSON.toJSONString(articleInfoDTO));
        System.out.println(JSON.toJSONString(articleInfoDTO, SerializerFeature.DisableCircularReferenceDetect));
//        System.out.println(JSON.toJSON(articleInfoDTO).toString());


    }
}
