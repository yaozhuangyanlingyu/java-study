package test;
import org.apache.ibatis.session.SqlSession;
import org.junit.*;

import com.mybatis.mapper.BlogMapper;
import com.mybatis.pojo.*;
import com.mybatis.util.*;
import java.util.List;

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
	
	@Test
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
}
