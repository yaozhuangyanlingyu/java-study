package test;

import org.junit.Test;
import com.hello.spring.pojo.Persion;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IOCTest {

	@Test
	public void testCreatePersion() {
		// 创建容器
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// 查找对象
		Persion p = (Persion)context.getBean("p");
		
		// 输出对象
		System.out.println(p);
	}
}
