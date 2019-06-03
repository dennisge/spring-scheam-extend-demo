
package com.lankio.learning.xml;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;


public class JCacheNamespaceHandler extends NamespaceHandlerSupport {

	public void init() {
		super.registerBeanDefinitionDecoratorForAttribute("cache-name",
				new JCacheInitializingBeanDefinitionDecorator());
	}
}
