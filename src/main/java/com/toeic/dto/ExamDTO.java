package com.toeic.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ExamDTO {

	private int eno;
	private String mid;
	private int result;
	private int total;
	private int startPoint;
	private String type; //lean -> 학습, exam -> 시험, review -> 복습
	private int examDate; //시험 볼 날짜
	
}
