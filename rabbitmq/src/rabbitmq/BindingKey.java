package rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class BindingKey {
	
	public static void main(String[] args) throws Exception {
		// 1 创建ConnectionFactory
		ConnectionFactory connectionFactory = new ConnectionFactory();
		connectionFactory.setHost("192.168.107.102");
		connectionFactory.setPort(5672);
		connectionFactory.setVirtualHost("shop");
		connectionFactory.setUsername("yaoxf");
		connectionFactory.setPassword("123456");
	
		// 2 获取connection
		Connection connection = connectionFactory.newConnection();
		
		// 3 通过Connection创建一个channel
		Channel channel = connection.createChannel();
		
		// 交换机与队列绑定
		String exchangeName = "test_confirm_exchange";
		String routingKey = "confirm.save";
		String queueName = "test_confirm_queue";		// 队列名
		String routerType = "topic";					// 路由类型
		boolean isPersistence = true;					// 是否持久化
		boolean isExclusive = false;					// 是否独占模式
		boolean autoDelete = false;						// 是否自动删除，queue会清理自己。但是是在最后一个connection断开的时候

		// -- 交换器声明
		channel.exchangeDeclare(exchangeName, routerType, isPersistence);

		// -- 队列声明 
		channel.queueDeclare(queueName, isPersistence, isExclusive, autoDelete, null);

		// -- 队列绑定
		channel.queueBind(queueName, exchangeName, routingKey);

		// 管理资源
		System.out.println("BindingKey");
		connection.close();
	}
}
