
package com.lankio.learning.xml;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

public class MyComponentNamespaceHandler extends NamespaceHandlerSupport {

	public void init() {
		registerBeanDefinitionParser("component", new ComponentBeanDefinitionParser());
	}

}
