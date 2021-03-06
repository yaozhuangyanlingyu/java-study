package rabbitmq;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.BasicProperties;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

/**
 * 消费者
 * @author yaoxf8888@gmail.com
 * @date 2019.06.01
 */
public class Consumer {

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
		
		// 4 声明交换机和队列，然后通过路由key绑定
		String exchangeName = "test_confirm_exchange";	// 交换器
		String routingKey = "confirm.#";				// 路由key，说明：*匹配一个单词，#匹配多个单词，写单词是精准匹配
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

		// 5 创建消费者
        DefaultConsumer consumer  = new DefaultConsumer(channel) {
            public void handleDelivery(String consumerTag, Envelope envelope, BasicProperties properties, byte[] body) throws IOException {
                System.out.println("接收消息 :   "+new String(body));
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
 
                //消息确认
                channel.basicAck(envelope.getDeliveryTag(), false);
            }
        };
        channel.basicConsume(queueName, false, "ConsumerTag", consumer);
        System.out.println("Consumer end");
        connection.close();
	}
}
