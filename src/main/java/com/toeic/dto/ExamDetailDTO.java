package com.toeic.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ExamDetailDTO {

	private int dno;
	private int eno;
	private int wno;
	private String result; // o -> 정답 , x -> 오답
	private int ncnt; // 틀린 횟수
	
}
