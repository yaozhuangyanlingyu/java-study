package com.mybatis.mapper;

import com.mybatis.pojo.Blog;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;;

public interface BlogMapper {
	// 根据ID查询
	Blog selectBlog(Integer id);
	
	// 模糊查询
	List<Blog> selectBlogByTitle(String title);

	// 多参数传递1
	List<Blog> selectBlogByPage1(int page, int pageSize);
	
	// 多参数传递2
	List<Blog> selectBlogByPage2(
			@Param(value="offset")int page,
			@Param(value="pageSize")int pageSize);
	
	// 多参数传递3
	List<Blog> selectBlogByPage3(Map<String, Object> map);
}
