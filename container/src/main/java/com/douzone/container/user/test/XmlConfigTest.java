package com.douzone.container.user.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import com.douzone.container.user.User;
import com.douzone.container.user.User1;

public class XmlConfigTest {

	public static void main(String[] args) {
		//xml auto configuration(Annotation Scanning)
		//testBeanFactory01();

		//XML Bean Configuration(Explicit Configuration)
		//testBeanFactory02();
		
		//xml auto configuration(Annotation Scanning)
		//testApplicationContext01();
		
		testApplicationContext02();
	}
	
	//XML Bean Configuration(Explicit Configuration)
	private static void testApplicationContext02() {
		ApplicationContext  ac =new ClassPathXmlApplicationContext("com/douzone/container/config/user/applicationContext02.xml");
		
		User user =null;
		
		
		// Id로 빈 가져오기
		user = (User)ac.getBean("user");
		System.out.println(user);
		
		// name으로 빈 가져오기
		user = (User)ac.getBean("usr");
		System.out.println(user);
		
		// Type으로 빈 가져오기
		// 같은 타입의 빈이 두개 이상 있으면 type으로 가져올 수 없다
		//1. id + type 
		//2. name + type 
		user = ac.getBean("user2",User.class);
		System.out.println(user);
		
		// 2개 파라미터로 생성된 Bean 가져오기1
		user = ac.getBean("user3",User.class);
		System.out.println(user);
		
		// 2개 파라미터로 생성된 Bean 가져오기2
		user = ac.getBean("user4",User.class);
		System.out.println(user);
		
		// setter를 사용한 빈 가져오기
		user = ac.getBean("user5",User.class);
		System.out.println(user);
	}
	
	//xml auto configuration(Annotation Scanning)
	private static void testApplicationContext01() {
		ApplicationContext  ac =new ClassPathXmlApplicationContext("com/douzone/container/config/user/applicationContext01.xml");
		User1 user1 = ac.getBean(User1.class);
		System.out.println(user1.getName());
		
		// Bean Id가 자동으로 설정됨
		user1 = (User1)ac.getBean("user1");
		System.out.println(user1.getName());
	}
	
	//xml auto configuration(Annotation Scanning)
	private static void testBeanFactory01() {
		BeanFactory bf =new XmlBeanFactory(new ClassPathResource("com/douzone/container/config/user/applicationContext01.xml"));
		User1 user1 = bf.getBean(User1.class);
		System.out.println(user1.getName());
		
		// Bean Id가 자동으로 설정됨
		user1 = (User1)bf.getBean("user1");
		System.out.println(user1.getName());
	}
	
	//XML Bean Configuration(Explicit Configuration)
	private static void testBeanFactory02() {
		BeanFactory bf =new XmlBeanFactory(new ClassPathResource("com/douzone/container/config/user/applicationContext02.xml"));
		User1 user1 = bf.getBean(User1.class);
		System.out.println(user1.getName());
		
		// Bean Id가 자동으로 생성되지 않음
		// 명시적으로 설정해야 함
		user1 = (User1)bf.getBean("user1");
		System.out.println(user1.getName());
	}

}
