package test;

import org.junit.Test;
import com.hello.spring.pojo.Persion;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class IOCTest {

	@Test
	// ͨ��������ȡ����ʵ��
	// ˵����ͨ��������Կ����������췽��ֻ��������1�Σ�˵����ȡ�����ķ�ʽ�ǵ�����
	public void testCreatePersion1() {
		// ��������
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// ���Ҷ���
		Persion p1 = (Persion)context.getBean("p1");
		Persion p2 = (Persion)context.getBean("p2");

		// �������
		System.out.println(p1);
		System.out.println(p2);
	}
	
	@Test
	// ͨ����һ�ֶ�������������
	// ˵����1�����������ļ�ʹ�þ���·����ȡ 2��ʹ�ø÷�����������������������ʼ����ʱ�򣬾��Ѿ������ö����ˣ������ǵ����ģ�����Ĭ������
	public void testCreatePersion2() {
		ApplicationContext context = new FileSystemXmlApplicationContext("D:\\java-study\\spring\\code\\helloworld\\src\\applicationContext.xml");
	}
	
	
}
