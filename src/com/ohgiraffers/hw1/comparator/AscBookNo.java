package com.ohgiraffers.hw1.comparator;

import java.util.Comparator;

import com.ohgiraffers.hw1.model.dto.BookDTO;

public class AscBookNo implements Comparator<BookDTO> {

//	1 바꿔라. -1 바꾸지 마라. 0 같다.
	@Override
	public int compare(BookDTO o1, BookDTO o2) {
//		o1이 앞에 있는데 숫자가 더 크다면 바꾼다. 결과적으로 오름차순이 됨
		
		if(o1.getbNo() > o2.getbNo()) {
			return 1;
		} else {
			return -1;
		}
	}
}
