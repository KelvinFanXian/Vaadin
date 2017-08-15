/*
 * Copyright  2017. qooco.com All Rights Reserved. 
 * Application : qoocoAPI 
 * Class Name  : WfcBeanNamespaceHandler.java
 * Date Created: 2017年08月15日
 * Author      : Kelvin范显
 * 
 */
package parseXML;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.xml.NamespaceHandlerSupport;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;

/**
 * @author Kelvin范显
 * @createDate 2017年08月15日
 */
public class WfcBeanNamespaceHandler  extends NamespaceHandlerSupport {

    // attributes available for bean definition
    public enum ATTRS {
        objectClass;
    }

    public void init() {
        registerBeanDefinitionDecoratorForAttribute("scope", new WfcBeanDefinitionDecorator());
        registerBeanDefinitionParser("beanWfc", new WfcBeanDefinitionParser());
    }

    @Override
    public BeanDefinition parse(Element element, ParserContext parserContext) {
        return super.parse(element, parserContext);
    }
}
