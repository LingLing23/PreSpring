package com.itwillbs.ex;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class HelloApp {

	
	public static void sayHello(String name) {
		System.out.println(name + "님 안녕하세요!");
	}
	
	
	public static void main(String[] args) {

		// 1. "홍길동"님 안녕하세요! 메세지 출력을 위해 필요한 기능 직접 구현
		System.out.println("홍길동님 안녕하세요!");
		
		// 2. 필요한 기능을 수행하는 메서드 호출
		sayHello("홍길동2");
		
		// 3. 별도의 객체를 사용하여 기능 수행
		// HelloApp -> MessageBean-sayMSG() 메서드 호출.
		// HelloApp은 MessageBean 객체를 필요로 함. (HelloApp <---의존관계---> MessageBean)
		// => 즉, 객체를 생성하는 것은 의존 관계를 구현하는 것 (강한 결합(tightly coupled))
		MessageBean mb = new MessageBean();
		mb.sayMSG("홍길동3");
		
		
		
		// ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
		
		
		
		// 약한결합(loosely coupled)
		// 인터페이스를 구현하여 사용하는 것.
		MSGBean msgBean = new MsgBeanImpl();	// 업캐스팅
		msgBean.sayMSG("홍길동4");
		
		
		MsgBeanImpl msgImpl = new MsgBeanImpl();
		msgImpl.sayMSG("홍길동5");
		// -> 객체를 직접 생성하였으므로 '강한 결합'
		
		
		
		// ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
		
		
		
		// 약한 결합 -> 의존성 주입을 통해 동작 구현
		// 쇼핑몰 접속 (== XML 파일 접근)
		BeanFactory fac = new XmlBeanFactory(new FileSystemResource("spring_bean.xml"));
		// BeanFactory가 인터페이스이므로 XmlBeanFactory 클래스 생성으로 업캐스팅.
		// 위의 코드를 통해 아까 만들어 놓은 XML파일에 접근 하는 것.
		
		// 이제 원래라면 객체를 생성해서 코드를 실행하는데, 이제는 객체생성이 아닌 주입!
		MSGBean msgBean2 = fac.getBean("msgBean",MSGBean.class);
		msgBean2.sayMSG("의존 주입");
		
	}

}
