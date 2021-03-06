package rabbitmq;
import java.io.IOException;

import org.junit.Test;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConfirmListener;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * 生产者
 * @author yaoxf8888@gmail.com
 * @date 2019.06.01
 */
public class Producer {

	@Test
	public void test() throws Exception {
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

		// 4 指定我们的消息投递模式：消息的确认模式
		channel.confirmSelect();
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

		// 5 发送一条消息
		String msg = "Hello RabbitMQ Send confirm message!";
		channel.basicPublish(exchangeName, routingKey, null, msg.getBytes());

		// 6 添加一个确认监听
		// 说明：deliveryTag表示消息的唯一标签
		channel.addConfirmListener(new ConfirmListener() {
			// 失败的时候 调用
			public void handleNack(long deliveryTag, boolean mutiple) throws IOException {
				System.out.println("---------- no ack! ----------");
			}
			
			// 成功的时候 调用
			public void handleAck(long deliveryTag, boolean multiple) throws IOException {
				System.out.println("---------- ack! ----------");
			}
		});
		
		connection.close();
	}
}



