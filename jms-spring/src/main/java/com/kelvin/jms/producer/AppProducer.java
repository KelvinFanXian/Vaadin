package com.kelvin.jms.producer;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Kelvin范显
 * @createDate 2017年09月13日
 */
public class AppProducer {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("producer.xml");
        ProducerService service= context.getBean(ProducerService.class);
        for(int i=0;i<100;i++) {
            service.sendMessage("test"+i);
        }
        context.close();
    }
}
