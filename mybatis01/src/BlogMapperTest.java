import org.apache.ibatis.session.SqlSession;
import org.junit.*;

import com.mybatis.mapper.BlogMapper;
import com.mybatis.pojo.*;
import com.mybatis.util.*;

public class BlogMapperTest {
	@Test
	public void testSelectBlog() {
		SqlSession session = MyBitisUtil.getSqlSession();
		BlogMapper blogMapper = session.getMapper(BlogMapper.class);
		
		Blog blog = blogMapper.selectBlog(1);
		session.close();

		System.out.println("id: " + blog.getId() + " title: " + blog.getTitle() + " author_id: " + blog.getAuthorId() + " state: " + blog.getState() + " featured: " + blog.getFeatured() + " Style: " + blog.getStyle());
	}
}
