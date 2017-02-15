package me.shellj.example.mybatis.mapper;

import me.shellj.example.mybatis.model.Blog;

/**
 * @author : shellj
 * @date : 2017-02-15
 */
public interface BlogMapper {
    int insert(Blog blog);

    Blog selectById(Long id);
}
