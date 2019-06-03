
package com.lankio.learning.xml;

public class JCacheInitializer {

	private String name;

	public JCacheInitializer(String name) {
		this.name = name;

		System.out.println("========JCacheInitializer=========: " + name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
