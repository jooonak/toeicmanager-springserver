package com.toeic.dto;

import java.sql.Date;

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
	private String type; //lean -> 학습, exam -> 시험
	private Date examDate; //시험 볼 날짜
	
}
