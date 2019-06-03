package com.lankio.learning;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lankio.learning.model.SimpleDateContainer;

public class SpringSchemaTestApplication {

	public static void main(String[] args) throws IOException {

		try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "spring-context.xml" })) {
			context.start();

			SimpleDateFormat sdf = (SimpleDateFormat) context.getBean("defaultDateFormat");

			System.out.println("=======SimpleDateFormat Demo: " + sdf.format(new Date()));

			SimpleDateContainer sdfContainer = (SimpleDateContainer) context.getBean("simpleDateContainer");

			System.out.println("========SimpleDateContainer Demo: " + sdfContainer.getDateFormat().format(new Date()));

		}

	}

}
