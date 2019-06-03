
package com.lankio.learning.model;

import java.util.ArrayList;
import java.util.List;

public class Component {

	private String name;

	private List<Component> components = new ArrayList<>();

	// mmm, there is no setter method for the 'components'
	public void addComponent(Component component) {
		this.components.add(component);
	}

	public List<Component> getComponents() {
		return components;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		if (components.size() == 0) {
			return "Component [name=" + name + "]";
		}
		return "Component [name=" + name + ", components=" + components + "]";
	}

}
