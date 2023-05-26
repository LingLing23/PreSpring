package com.itwillbs.ex;

public class PersonImpl implements Person {

	// 멤버변수
	private String name;
	
	// 추상메서드 오버라이딩
	@Override
	public void sayMyInfo() {
		System.out.println("내 이름 : " + name + "입니다.");
	}
	
	// Getter & Setter
	// Setter를 통한 객체 주입
	// -> 이름을 받아서 저장하기 때문.
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
