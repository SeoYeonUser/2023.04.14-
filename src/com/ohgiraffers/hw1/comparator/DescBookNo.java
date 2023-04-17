package com.ohgiraffers.hw1.comparator;

import java.util.Comparator;

import com.ohgiraffers.hw1.model.dto.BookDTO;

public class DescBookNo implements Comparator<BookDTO> {
	
	@Override
	public int compare(BookDTO o1, BookDTO o2) {
//		o1이 앞에 있는데 숫자가 더 작다면 바꾼다. 결과적으로 내림차순이 됨
		
		if(o1.getbNo() < o2.getbNo()) {
			return 1;
		} else {
			return -1;
		}
	}
}