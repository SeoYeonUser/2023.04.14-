package com.ohgiraffers.hw1.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.ohgiraffers.hw1.controller.BookManager;
import com.ohgiraffers.hw1.model.dto.BookDTO;

/**
 * <pre>
 * BookMenu 클래스는 사용자에게 메뉴를 보여주고 사용자에게 입력을 받는다.
 * 그리고 입력받은 값을 토대로 하여 BookDTO, BookManager 와 상호작용한다.
 * 
 * BookDTO는 추가할 도서의 값을 객체단위로 그룹화 한다. 그렇게 그룹화된 값을 BookManager에게 전달한다.
 * 만약, DTO를 사용하지 않는다면 사용자가 입력한 도서정보를 담을 다양한 타입의 변수나 배열을 여러개 만들게 될것이고
 * 이 값들은 서로간의 타입이 상이하기 때문에 다른 클래스에 데이터값을 넘겨줄 때 
 * 데이터를 받는 클래스에서는 각각의 타입별로 메서드의 매개변수가 여러개 있을 것이다.
 * 하지만 DTO를 거쳐감으로서 상이한 타입들의 변수나 배열이 객체 타입으로서 그룹화 되고
 * 데이터를 받는 클래스에서도 매개변수의 타입을 BookDTO하나만 써서 받을 수 있게 되어 효율적이다.
 * 도서를 추가할 때마다 BookDTO의 인스턴스들이 생기게 되고 그럴때마다 인스턴스의 주소값이 BookManager로 전달된다. 
 * 
 * BookManager는 사용자가 선택한 기능에 따라 실제로 작업을 수행하게 된다. 
 * BookManager로 넘어간 BookDTO의 인스턴스의 주소들이 ArrayList에 순서대로 저장된다.
 * ArrayList는 배열의 단점을 보완한 클래스이며, 대표적으로 List, Collection 등을 상속받고 구현하고 있는 클래스이다.
 * 그래서 다양한 부모 타입으로 ArrayList의 인스턴스 생성할 수 있다.
 * </pre>
 *
 */
public class BookMenu {
	
	Scanner sc = new Scanner(System.in);
	BookManager bm = new BookManager();
	
//	기본생성자
	public BookMenu() {}
	
	public void mainMenu() {
//		도서관리 프로그램에 해당하는 메인 메뉴 출력, 각 메뉴에 해당 하는
//		BookManager 클래스의 메소드 실행 반복 출력되게 한다.
		
		while(true) {
			System.out.println("메인메뉴 호출");
			System.out.println("*** 도서 관리 프로그램 ***");
			System.out.println("1. 새 도서 추가");
			System.out.println("2. 도서정보 정렬 후 출력");
			System.out.println("3. 도서 삭제");
			System.out.println("4. 도서 검색출력");
			System.out.println("5. 전체 출력");
			System.out.println("6. 끝내기");
			
			System.out.print("메뉴 번호 선택 : ");
			int menu = sc.nextInt();
			sc.nextLine(); //버퍼비움
			System.out.println();
			switch (menu) {
				case 1: // 새 도서 추가
					System.out.println(">>>>>>>>>>>>> 1. 새 도서 추가");
					bm.addBook(inputBook());
					System.out.println(">>>>>>>>>>>>> 도서가 추가되었습니다.");
					System.out.println();
					break;
				case 2 : //도서정보 정렬 후 출력
					bm.printBookList(selectSortedBook());
					break;
				case 3 : //도서 삭제
					System.out.println(">>>>>>>>>>>>> 3. 도서 삭제");
					System.out.println("-------- 도서 리스트");
					bm.displayAll();
					int num = inputBookNo();
					if (num == 0) {
						System.out.println("삭제를 취소하였습니다.");
					} else {
						bm.deleteBook(num);
					}
					System.out.println();
					break;
				case 4 : //도서 검색출력
					//if 결과가 있을 경우 해당 도서 출력
					//else 결과 없으면 조회한 도서가 목록에 없습니다.
					System.out.println(">>>>>>>>>>>>> 4. 도서 검색 출력");
					String result = bm.searchBook(inputBookTitle());
					if(result == "") {
						System.out.println("조회한 도서가 목록에 없습니다.");
					} else {
						System.out.println(result);
					}
					System.out.println();
					break;
				case 5 : //전체 출력
					System.out.println(">>>>>>>>>>>>> 5. 도서 전체 출력");
					bm.displayAll();
					//if 비어있을 경우 출력결과가 없습니다.
					//else 전체출력
					System.out.println();
					break;
				case 6 : //끝내기 main()으로 돌아가기
					return;
				default:
					System.out.println("잘못된 메뉴입니다. 다시 입력하세요.");
					System.out.println();
					break;
			}
		}		
		
	}
	
	public BookDTO inputBook() {
		int category = 0; //장르 분류 번호
		String title = ""; //도서 제목
		String author = ""; //도서 저자
		
		System.out.print("도서 제목 입력 : ");
		title = sc.nextLine();
		
		while(category < 1 || category > 4) {
			System.out.print("도서 장르 입력 (1.인문/2.자연과학/3.의료/4.기타) : ");
			category = sc.nextInt();
			sc.nextLine(); //버퍼비움
		}
		
		System.out.print("도서 저자 입력 : ");
		author = sc.nextLine();
		
//		매개변수 생성자 호출해서 객체 만들고 리턴
		BookDTO book = new BookDTO(category, title, author);
		return book;
	}
	
	public int inputBookNo() {
//		삭제할 도서번호를 키보드로 입력 받아 리턴
		int num = 0;
		
		System.out.print("삭제할 도서 번호 입력(번호는 1부터 시작하며 취소는 0입니다) : ");
		num = sc.nextInt();
		sc.nextLine(); //버퍼비움
		
		return num;
	}
	
	public String inputBookTitle() {
//		검색할 도서제목을 키보드로 입력 받아 리턴
		String searchTitle = "";
		System.out.print("검색할 도서제목 입력 : ");
		searchTitle = sc.nextLine();
		return searchTitle;
	}
	
	public List<BookDTO> selectSortedBook() {
//		도서출력시 정렬방식을 선택
		int num = 0;
		
		while (num < 1 || num > 4) {
			System.out.print("도서번호 오름차순 1, 도서번호 내림차순 2, 책 제목 오름차순 3, 책 제목 내림차순 4 : ");
			num = sc.nextInt();
			sc.nextLine();//버퍼비움
		}

		List<BookDTO> printList = bm.sortedBookList(num); 
		return printList;
	}
}
