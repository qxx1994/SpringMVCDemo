package com.qxx.dao;

import com.qxx.model.BlogEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by 24015 on 2016/11/3.
 */
public interface BlogDao {
    void createBlog(BlogEntity blog);

    void deleteBlogById(long id);

    void updateBlog(BlogEntity blog);

    BlogEntity getBlogById(long id);

    BlogEntity getBlogByTitle(String title);

    List<BlogEntity> getBlogsByTitle(String title);

    List<BlogEntity> getBlogs(@Param("offset") int offset, @Param("limit") int limit);
}
