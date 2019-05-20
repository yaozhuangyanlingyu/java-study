package com.mybatis.mapper;

import com.mybatis.pojo.Blog;
import java.util.List;;

public interface BlogMapper {
	Blog selectBlog(Integer id);
	
	List<Blog> selectBlogByTitle(String title);
}
