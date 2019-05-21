package test;
import org.apache.ibatis.session.SqlSession;
import org.junit.*;

import com.mybatis.mapper.BlogMapper;
import com.mybatis.pojo.*;
import com.mybatis.util.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BlogMapperTest {
	//@Test
	// 查询不适用接口
	public void testSelectBlogNoInterface() {
		SqlSession session = MyBatisUtil.getSqlSession();
		Blog blog = (Blog)session.selectOne("com.mybatis.mapper.BlogMapper.selectBlog", 1);
		session.close();

		System.out.println(blog);
		//System.out.println("id: " + blog.getId() + " title: " + blog.getTitle() + " author_id: " + blog.getAuthorId() + " state: " + blog.getState() + " featured: " + blog.getFeatured() + " Style: " + blog.getStyle());
	}
	
	//@Test
	// 查询数据
	public void testSelectBlog() {
		SqlSession session = MyBatisUtil.getSqlSession();
		BlogMapper blogMapper = session.getMapper(BlogMapper.class);
		Blog blog = blogMapper.selectBlog(2);
		session.close();

		System.out.println("id: " + blog.getId() + " title: " + blog.getTitle() + " author_id: " + blog.getAuthorId() + " state: " + blog.getState() + " featured: " + blog.getFeatured() + " Style: " + blog.getStyle());
	}
	
	//@Test
	// like查询
	public void testSelectLike() {
		SqlSession session = MyBatisUtil.getSqlSession();
		BlogMapper blogMapper = session.getMapper(BlogMapper.class);
		List<Blog> blogs = blogMapper.selectBlogByTitle("%分库%");
		session.close();
		
		for(int i = 0; i < blogs.size(); i++) {
			Blog blog = blogs.get(i);
			System.out.println("id: " + blog.getId() + " title: " + blog.getTitle() + " author_id: " + blog.getAuthorId() + " state: " + blog.getState() + " featured: " + blog.getFeatured() + " Style: " + blog.getStyle());
		}
	}

	//@Test
	// 多参数方法1
	public void testSelectByPage1() {
		SqlSession session = MyBatisUtil.getSqlSession();
		BlogMapper blogMapper = session.getMapper(BlogMapper.class);
		
		// 根据mapper查询
		List<Blog> blogs = blogMapper.selectBlogByPage1(2, 2);

		// 输出结果
		for(int i = 0; i < blogs.size(); i++) {
			Blog blog = blogs.get(i);
			System.out.println("id: " + blog.getId() + " title: " + blog.getTitle() + " author_id: " + blog.getAuthorId() + " state: " + blog.getState() + " featured: " + blog.getFeatured() + " Style: " + blog.getStyle());
		}
		
		session.close();
	}
	
	//@Test
	// 多参数方法2
	public void testSelectByPage2() {
		SqlSession session = MyBatisUtil.getSqlSession();
		BlogMapper blogMapper = session.getMapper(BlogMapper.class);
		
		// 根据mapper查询
		List<Blog> blogs = blogMapper.selectBlogByPage2(2, 2);

		// 输出结果
		for(int i = 0; i < blogs.size(); i++) {
			Blog blog = blogs.get(i);
			System.out.println("id: " + blog.getId() + " title: " + blog.getTitle() + " author_id: " + blog.getAuthorId() + " state: " + blog.getState() + " featured: " + blog.getFeatured() + " Style: " + blog.getStyle());
		}
		
		session.close();
	}
	
	//@Test
	// 多参数方法3
	public void testSelectByPage3() {
		SqlSession session = MyBatisUtil.getSqlSession();
		BlogMapper blogMapper = session.getMapper(BlogMapper.class);
		
		// 根据mapper查询
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("offset", 2);
		map.put("pageSize", 2);
		List<Blog> blogs = blogMapper.selectBlogByPage3(map);
		
		// 输出结果
		for(int i = 0; i < blogs.size(); i++) {
			Blog blog = blogs.get(i);
			System.out.println("id: " + blog.getId() + " title: " + blog.getTitle() + " author_id: " + blog.getAuthorId() + " state: " + blog.getState() + " featured: " + blog.getFeatured() + " Style: " + blog.getStyle());
		}
		
		session.close();
	}
	
	@Test
	// 插入数据方法1
	public void testInsertBlog() {
		SqlSession session = MyBatisUtil.getSqlSession();
		BlogMapper blogMapper = session.getMapper(BlogMapper.class);
		
		// 获得数据对象
		Blog blog = new Blog();
		blog.setTitle("JAVA从入门到精通");
		blog.setAuthorId(1004);
		blog.setState("编辑中");
		blog.setFeatured(true);
		blog.setStyle("green");
		int count = blogMapper.insertBlog1(blog);
		System.out.println("影响行数：" + count + " 插入ID为：" + blog.getId());

		session.close();
	}
}
