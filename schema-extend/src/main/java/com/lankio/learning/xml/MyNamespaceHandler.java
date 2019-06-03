
package com.lankio.learning.xml;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * A simple date format handler
 *
 *
 */
public class MyNamespaceHandler extends NamespaceHandlerSupport {

	public void init() {
		registerBeanDefinitionParser("dateformat", new SimpleDateFormatBeanDefinitionParser());
	}

}
