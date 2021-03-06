package com.kelvin.jms.topic;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @author Kelvin范显
 * @createDate 2017年09月13日
 */
public class AppConsumer {
    private static final String url = "tcp://192.168.0.123:61616";
    private static final String queueName = "queue-test";

    public static void main(String[] args) throws JMSException {
        // 1. 创建 ConnectionFactory
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);

        // 2. 创建 Connection
        Connection connection = connectionFactory.createConnection();

        // 3. 启动连接
        connection.start();

        // 4. 创建会话
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        // 5. 创建一个目标
        Destination destination = session.createTopic(queueName);

        // 6. 创建一个消费者
        MessageConsumer consumer = session.createConsumer(destination);

        // 7. 创建一个监听器
        consumer.setMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message) {
                TextMessage textMessage = (TextMessage) message;
                try {
                    System.out.println("接收消息：" + textMessage.getText());
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });

        // 8. 关闭连接
// connection.close();
    }
}
