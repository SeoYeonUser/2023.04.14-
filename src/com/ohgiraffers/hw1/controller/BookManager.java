package com.ohgiraffers.hw1.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.ohgiraffers.hw1.comparator.*;
import com.ohgiraffers.hw1.model.dto.BookDTO;

/**
 * 삭제, 검색, 추가 등의 기능, 동작을 담당하고 있는 클래스이다.
 * 정렬과 관련된 클래스들을 호출하여 상호작용하고 있다.
 * 
 */

// 추가하는 도서의 bNo번호의 값 어떻게 할당해야 할지 모르겠음.
// ArrayList의 size를 토대로 +1해서 할당했는데
// 도서 삭제하고 다시 등록하면 번호가 중복되는 문제가 있음.

public class BookManager {
	
	private ArrayList<BookDTO> booklist;
	private Scanner sc;
	
//	기본생성자
	public BookManager() {
		//Arraylist<BookDTO> booklist 인스턴스생성
		 booklist = new ArrayList<>();
	}
	public void addBook(BookDTO book) {
//		전달받은 도서정보를 필드에선언한 List에 담는다.
//		System.out.println("사이즈" + booklist.size());
//		도서번호 bNo를 요소 추가할 때마다 자동으로 1씩 증가시킴
		book.setbNo(booklist.size()+1);
		booklist.add(book);
//		System.out.println("book : " + book);
//		System.out.println("booklist : " + booklist);
	}
	public void deleteBook(int index) {
//		전달받은 도서번호를 이용하여 해당하는 인덱스에 도서를 제거한다.
//		System.out.println("booklist size 값은 " + booklist.size());
//		System.out.println("index입력한 값은 " + index);
		
		if(booklist.size() <= index-1) {
			System.out.print("삭제 불가능. ");
		} else {
			booklist.remove(index-1);
			System.out.print("삭제 되었습니다. ");
		}
		System.out.println("남아있는 도서 리스트는 " + booklist.size() + "개 입니다.");
	}
	
	public String searchBook(String title) {
//		전달받은 도서 제목에 해당하는 도서의 정보를 찾아서 리턴한다. 
		
		String result = "";

		for(BookDTO b : booklist) {
			if(b.getTitle().contains(title)) {
				result += b + "\n";
			}
		}
		
		return result;
	}
	
	public void displayAll() {
//		도서의 전체목록을 출력하고, list의 개수가 0이면 “조회결과가 없습니다” 출력한다.
//		System.out.println("북리스트 사이즈 몇개?" + booklist.size());
		if(booklist.size() == 0) {
			System.out.println("출력할 도서가 없습니다. 등록해주세요.");
		}else {
			
			for(BookDTO b : booklist) {
				System.out.println(b);
			}
		}
	}
	
	public List<BookDTO> sortedBookList(int type) {
//		사용자가 선택한 정렬방식에 따라서 오름차순/내림차순 정렬하여 값을 반환한다.
		
		List<BookDTO> sortList = booklist;
//		도서번호 오름차순 1, 도서번호 내림차순 2, 책 제목 오름차순 3, 책 제목 내림차순 4 :
		
		switch (type) {
			case 1 : // 도서번호 오름차순
				new AscBookNo().compare(sortList, sortList);
				break;
				
			case 2 : // 도서번호 내림차순
				new DescBookNo().compare(sortList, sortList);
				break;
				
			case 3 : // 도서제목 오름차순
				new AscBookTitle().compare(sortList, sortList);
				break;
				
			case 4 : // 도서제목 내림차순
				new DescBookTitle().compare(sortList, sortList);
				
//			default: 넘어오는 값의 범위가 검증을 통해 고정되어 있어서 생략함
		}
		
		return sortList;
	}
	
	public void printBookList(List<BookDTO> printList) {
//	정렬된 list객체의 도서를 출력한다	
	}
	
}
