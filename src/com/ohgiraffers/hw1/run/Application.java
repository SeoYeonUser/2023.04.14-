package com.ohgiraffers.hw1.run;

import com.ohgiraffers.hw1.view.BookMenu;

/**
 * <pre>
 * 자바 프로그램을 실행하기 위한 main()
 * </pre>
 */
public class Application {

	public static void main(String[] args) {
		// TODO 2023.04.14 컬렉션 실습문제 강서연
		
		System.out.println("메인 시작함.");
		
		BookMenu bm = new BookMenu();
		bm.mainMenu();
		
		System.out.println("메인으로 되돌아오고 종료");
	}

}
