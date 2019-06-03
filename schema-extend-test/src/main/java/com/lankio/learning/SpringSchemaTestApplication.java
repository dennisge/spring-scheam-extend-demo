package com.lankio.learning;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringSchemaTestApplication {

	public static void main(String[] args) throws IOException {

		try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "spring-context.xml" })) {
			context.start();

		}

	}

}
