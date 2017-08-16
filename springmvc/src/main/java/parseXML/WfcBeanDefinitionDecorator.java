/*
 * Copyright  2017. qooco.com All Rights Reserved. 
 * Application : qoocoAPI 
 * Class Name  : WfcBeanDefinitionDecorator.java
 * Date Created: 2017年08月15日
 * Author      : Kelvin范显
 * 
 */
package parseXML;

import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.xml.BeanDefinitionDecorator;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Attr;
import org.w3c.dom.Node;

/**
 * @author Kelvin范显
 * @createDate 2017年08月15日
 */
public class WfcBeanDefinitionDecorator implements BeanDefinitionDecorator {
    public BeanDefinitionHolder decorate(Node node, BeanDefinitionHolder beanDefinitionHolder, ParserContext parserContext) {
        if (node instanceof Attr) {
            Attr attr = (Attr) node;
            if (attr.getName().equals("wfc:scope")) {
                System.out.println("Scope before change: "+beanDefinitionHolder.getBeanDefinition().getScope());
                beanDefinitionHolder.getBeanDefinition().setScope(attr.getValue());
                System.out.println("Scope after change: "+beanDefinitionHolder.getBeanDefinition().getScope());
            }
        }
        return beanDefinitionHolder;
    }
}
