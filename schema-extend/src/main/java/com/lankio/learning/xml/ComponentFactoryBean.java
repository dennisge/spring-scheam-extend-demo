
package com.lankio.learning.xml;

import java.util.List;

import org.springframework.beans.factory.FactoryBean;

import com.lankio.learning.model.Component;

/**
 * 
 *
 * Date: 2019年5月28日
 *
 * @author: dennis
 **/
public class ComponentFactoryBean implements FactoryBean<Component> {

	private Component parent;
	private List<Component> children;

	public void setParent(Component parent) {
		this.parent = parent;
	}

	public void setChildren(List<Component> children) {
		this.children = children;
	}

	@Override
	public Component getObject() throws Exception {
		if (this.children != null && this.children.size() > 0) {
			children.forEach(childComponent -> this.parent.addComponent(childComponent));
		}
		return this.parent;
	}

	@Override
	public Class<Component> getObjectType() {
		return Component.class;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}
}
