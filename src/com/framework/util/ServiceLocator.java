package com.framework.util;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.javamail.JavaMailSender;
import freemarker.template.Configuration;

public class ServiceLocator {

	private static ServiceLocator locator = null;

	private static BeanFactory factory = null;

	public BeanFactory getFactory() {
		if (factory == null) {
			factory = new ClassPathXmlApplicationContext(
					"applicationContext.xml");
		}
		return factory;
	}

	private ServiceLocator() {
	}

	public void setFactory(BeanFactory factory) {
		ServiceLocator.factory = factory;
	}

	public static ServiceLocator getInstance() {
		if (locator == null) {
			locator = new ServiceLocator();
		}
		return locator;
	}

	public Object getBean(String beanName) {
		return getFactory().getBean(beanName);
	}

	public JavaMailSender getJavaMailSender() {
		return (JavaMailSender) getBean("mailSender");
	}

	public Configuration getFreeMarkerConfig() {
		return (Configuration) getBean("freeMarkerConfigurer");
	}

}
