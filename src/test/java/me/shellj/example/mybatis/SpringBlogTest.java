package me.shellj.example.mybatis;

import me.shellj.example.spring.mapper.BlogMapper;
import me.shellj.example.spring.model.Blog;
import me.shellj.example.spring.model.BlogExample;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author : shellj
 * @date : 2017-02-15
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(locations = "classpath:spring/mybatis-spring.xml")
public class SpringBlogTest {
    private static final Logger logger = LoggerFactory.getLogger(SpringBlogTest.class);

    @Autowired
    private BlogMapper blogMapper;

    @Test
    public void insert() throws Exception {
        Blog blog = new Blog();
        blog.setAuthor("名字spring");
        blog.setTitle("title");
        blog.setContent("content");
        int insert = blogMapper.insert(blog);
        assertEquals(1, insert);
        logger.info(blog.toString());
    }

    @Test
    public void select() throws Exception {
        BlogExample example = new BlogExample();
        example.createCriteria().andAuthorEqualTo("名字spring");
        List<Blog> blogs = blogMapper.selectByExample(example);
        assertNotNull(blogs);
        assertEquals(1, blogs.size());
        logger.info(blogs.get(0).toString());
    }
}
