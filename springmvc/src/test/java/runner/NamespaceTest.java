/*
 * Copyright  2017. qooco.com All Rights Reserved. 
 * Application : qoocoAPI 
 * Class Name  : NamespaceTest.java
 * Date Created: 2017年08月15日
 * Author      : Kelvin范显
 * 
 */
package runner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import parseXML.EnglishHelloWorld;
import parseXML.FrenchHelloWorld;
import parseXML.HelloWorldInterface;

import static org.junit.Assert.assertTrue;

/**
 * @author Kelvin范显
 * @createDate 2017年08月15日
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:META-INF/wfc.xml"})
public class NamespaceTest {
    @Autowired
    @Qualifier(value = "frenchHello")
    private HelloWorldInterface helloWorldWfc;

    @Autowired
    @Qualifier(value = "englishHelloWorld")
    private HelloWorldInterface helloWorldSpring;

    @Autowired
    private ApplicationContext context;

    @Test
    public void checkWfcBean() {
        assertTrue("helloWorldWfc bean shouldn't be null", helloWorldWfc != null);
        assertTrue("helloWorldSpring bean shouldn't be null", helloWorldSpring != null);
        assertTrue("helloWorldSpring should be an instance of EnglishHelloWorld", helloWorldSpring instanceof EnglishHelloWorld);
        assertTrue("helloWorldWfc should be an instance of FrenchHelloWorld", helloWorldWfc instanceof FrenchHelloWorld);
        assertTrue("englishHelloWorld should be singleton scoped", context.isSingleton("englishHelloWorld"));
    }
}
