package test;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hello.spring.pojo.Person;

public class InjectionTest {

	//@Test
	public void testCreatePerson1() {
		// 创建容器
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("applicationInjectionContext.xml");

		// 输出对象
		Person p1 = (Person)context.getBean("p1");
		System.out.println(p1);

		// 关闭销毁容器
		context.close();
	}
	
	@Test
	public void testCreatePerson3() {
		// 创建容器
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("applicationInjectionContext.xml");
		
		// 输出对象
		Person p3 = (Person)context.getBean("person3");
		System.out.println(p3);
		
		// 关闭销毁容器
		context.close();
	}
}
