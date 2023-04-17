package com.ohgiraffers.hw1.comparator;

import java.util.Comparator;

import com.ohgiraffers.hw1.model.dto.BookDTO;

public class AscBookTitle implements Comparator<BookDTO> {
	
//	1. 바꿔라 0 같다. -1 바꾸지말아라
	@Override
	public int compare(BookDTO o1, BookDTO o2) {
//		문자열은 대소비교가 안된다.
//		compareTo는 인자값이 더 클경우 -1, 인자값이 작을 경우 1, 같을 경우 0을 반환한다.
		return o1.getTitle().compareTo( o2.getTitle());
	}
}
