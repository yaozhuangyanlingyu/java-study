package test;

import org.junit.Test;
import com.hello.spring.pojo.Persion;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class IOCTest {

	@Test
	// 通过容器获取对象实例
	// 说明：通过输出可以看出来，构造方法只被调用了1次，说明获取方法的方式是单例的
	public void testCreatePersion1() {
		// 创建容器
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// 查找对象
		Persion p1 = (Persion)context.getBean("p1");
		Persion p2 = (Persion)context.getBean("p2");

		// 输出对象
		System.out.println(p1);
		System.out.println(p2);
	}
	
	@Test
	// 通过另一种对象来构建容器
	// 说明：1、加载配置文件使用绝对路径获取 2、使用该方法创建容器，发现容器初始化的时候，就已经创建好对象了，并且是单例的，这是默认特性
	public void testCreatePersion2() {
		ApplicationContext context = new FileSystemXmlApplicationContext("D:\\java-study\\spring\\code\\helloworld\\src\\applicationContext.xml");
	}
	
	
}
