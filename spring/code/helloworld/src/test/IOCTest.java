package test;

import org.junit.Test;
import com.hello.spring.pojo.Persion;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IOCTest {

	@Test
	public void testCreatePersion() {
		// ��������
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// ���Ҷ���
		Persion p = (Persion)context.getBean("p");
		
		// �������
		System.out.println(p);
	}
}
