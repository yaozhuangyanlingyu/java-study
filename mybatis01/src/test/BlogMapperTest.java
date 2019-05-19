package test;
import org.apache.ibatis.session.SqlSession;
import org.junit.*;

import com.mybatis.mapper.BlogMapper;
import com.mybatis.pojo.*;
import com.mybatis.util.*;

public class BlogMapperTest {
	@Test
	public void testSelectBlogNoInterface() {
		SqlSession session = MyBatisUtil.getSqlSession();
		Blog blog = (Blog)session.selectOne("com.mybatis.mapper.BlogMapper.selectBlog", 1);
		session.close();

		System.out.println(blog);
		//System.out.println("id: " + blog.getId() + " title: " + blog.getTitle() + " author_id: " + blog.getAuthorId() + " state: " + blog.getState() + " featured: " + blog.getFeatured() + " Style: " + blog.getStyle());
	}
	
	//@Test
	public void testSelectBlog() {
		SqlSession session = MyBatisUtil.getSqlSession();
		BlogMapper blogMapper = session.getMapper(BlogMapper.class);
		Blog blog = blogMapper.selectBlog(2);
		session.close();

		System.out.println("id: " + blog.getId() + " title: " + blog.getTitle() + " author_id: " + blog.getAuthorId() + " state: " + blog.getState() + " featured: " + blog.getFeatured() + " Style: " + blog.getStyle());
	}
}
