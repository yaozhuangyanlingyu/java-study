package test;

import org.junit.Test;
import com.hello.spring.pojo.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class IOCTest {

	//@Test
	// 通过容器获取对象实例
	// 说明：通过输出可以看出来，构造方法只被调用了1次，说明获取方法的方式是单例的
	public void testCreatePerson1() {
		// 创建容器
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// 创建对象
		Person p1 = (Person)context.getBean("p1");
		Person p2 = (Person)context.getBean("p2");

		// 输出对象
		System.out.println(p1);
		System.out.println(p2);
	}

	//@Test
	// 通过另一种对象来构建容器
	// 说明：1、加载配置文件使用绝对路径获取 2、使用该方法创建容器，发现容器初始化的时候，就已经创建好对象了，并且是单例的，这是默认特性
	public void testCreatePerson2() {
		ApplicationContext context = new FileSystemXmlApplicationContext("D:\\java-study\\spring\\code\\helloworld\\src\\applicationContext.xml");
	}
	
	@Test
	// 单利测试
	public void testSimpleInterest() {
		// 创建容器
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		/*
		// 创建对象
		Person p1 = (Person)context.getBean("p1");
		Person p2 = (Person)context.getBean("p2");

		// 判断测试
		System.out.println(p1 == p2);
		*/

		/*
		示例：
		<bean name="p1" id="p2" class="com.hello.spring.pojo.Person" scope="singleton"></bean>

		说明：
		scope="prototype"	多实例时，在容器启动时不创建对象，当获取对象时才创建对象
		scope="singleton	单利时，在容器启动时创建对象，而且只创建一个

		lazy-init="true"	延迟创建，针对单利时，获取对象时才会创建。默认值为false
		*/
		
		// 销毁需要手动调用，或者执行对象.close，没测试成功
		//Person p1 = (Person)context.getBean("p1");
		// p1.destroy();
	}
}
