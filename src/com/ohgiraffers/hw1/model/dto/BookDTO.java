package com.ohgiraffers.hw1.model.dto;

/**
 * 
 * 서로 다른 타입들의 데이터(정보) 값을 BookDTO 객체 단위로서 그룹화하는 용도의 클래스이다.
 * getter, setter 캡슐화가 되어 있으며 toString()이 오버라이딩되어 있다.
 */
public class BookDTO {
	
	private int bNo; //도서번호
	private int category; //장르 분류 번호
	private String title; //도서 제목
	private String author; //도서 저자
	
//	기본 생성자
	public BookDTO() {}
	
//	매개변수 생성자 bNo 포함
//	public BookDTO(int bNo, int category, String title, String author) {
//		this.bNo = bNo;
//		this.category = category;
//		this.title = title;
//		this.author = author;
//	}


	@Override
	public String toString() {
		return "도서번호 : " + bNo + ", 장르 분류 번호 : " + category
			  + ", 도서제목 : " + title + ", 도서저자 : " + author;
	}

	//	getter, setter
	public int getbNo() {
		return bNo;
	}

	public void setbNo(int bNo) {
		this.bNo = bNo;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	};
	
}
