package me.shellj.example.mybatis;

import me.shellj.example.mybatis.mapper.BlogMapper;
import me.shellj.example.mybatis.model.Blog;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author : shellj
 * @date : 2017-02-15
 */
public class BlogTest {
    private static final Logger logger = LoggerFactory.getLogger(BlogTest.class);

    SqlSessionFactory sqlSessionFactory;

    @Before
    public void init() throws IOException {
        String resource = "mybatis/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void insertTest() throws Exception {
        Blog blog = new Blog("标题", "shellj", "很多内容");
        try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
            int insert = sqlSession.insert("Blog.insert", blog);
            logger.info("id:" + blog.getId());
            assertEquals(1, insert);
        }
    }

    @Test
    public void selectTest() throws Exception {
        try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
            BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
            Blog blog = mapper.selectById(1L);
            assertNotNull(blog);
            logger.info(blog.toString());
        }
    }
}
