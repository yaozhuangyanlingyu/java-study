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
public class producer {

	@Test
	public void test() throws Exception {
		// 1 创建ConnectionFactory
		ConnectionFactory connectionFactory = new ConnectionFactory();
		connectionFactory.setHost("192.168.107.102");
		connectionFactory.setPort(5672);
		connectionFactory.setVirtualHost("/");
		
		// 2 获取connection
		Connection connection = connectionFactory.newConnection();
		
		// 3 通过Connection创建一个channel
		Channel channel = connection.createChannel();
		
		// 4 指定我们的消息投递模式：消息的确认模式
		channel.confirmSelect();
		String exchangeName = "test_confirm_exchange";
		String routingKey = "confirm.save";
		
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
	}
}
