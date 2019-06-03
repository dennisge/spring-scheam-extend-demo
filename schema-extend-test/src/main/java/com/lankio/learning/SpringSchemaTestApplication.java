package com.lankio.learning;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lankio.learning.model.Component;

public class SpringSchemaTestApplication {

	public static void main(String[] args) throws IOException {

		try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "spring-context.xml" })) {
			context.start();

			Component component = context.getBean(Component.class);

			System.out.println(component);

		}

	}

}
