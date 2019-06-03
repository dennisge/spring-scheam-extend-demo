
package com.lankio.learning.xml;

import java.util.List;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.ManagedList;
import org.springframework.beans.factory.xml.AbstractBeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.springframework.util.xml.DomUtils;
import org.w3c.dom.Element;

import com.lankio.learning.model.Component;
import com.lankio.learning.xml.ComponentFactoryBean;

/**
 * 
 *
 * Date: 2019年5月28日
 *
 * @author: dennis
 **/
public class ComponentBeanDefinitionParser extends AbstractBeanDefinitionParser {

	@Override
	protected AbstractBeanDefinition parseInternal(Element element, ParserContext parserContext) {
		BeanDefinitionBuilder factory = BeanDefinitionBuilder.rootBeanDefinition(ComponentFactoryBean.class);
		BeanDefinitionBuilder parent = parseComponent(element);
		factory.addPropertyValue("parent", parent.getBeanDefinition());

		List<Element> childElements = DomUtils.getChildElementsByTagName(element, "component");
		if (childElements != null && childElements.size() > 0) {
			parseChildComponents(childElements, factory);
		}
		return factory.getBeanDefinition();
	}

	private static BeanDefinitionBuilder parseComponent(Element element) {
		BeanDefinitionBuilder component = BeanDefinitionBuilder.rootBeanDefinition(Component.class);
		component.addPropertyValue("name", element.getAttribute("name"));
		return component;
	}

	private static void parseChildComponents(List<Element> childElements, BeanDefinitionBuilder factory) {
		ManagedList<BeanDefinition> children = new ManagedList<>(childElements.size());
		for (int i = 0; i < childElements.size(); ++i) {
			Element childElement = (Element) childElements.get(i);
			BeanDefinitionBuilder child = parseComponent(childElement);
			children.add(child.getBeanDefinition());
		}
		factory.addPropertyValue("children", children);
	}
}
