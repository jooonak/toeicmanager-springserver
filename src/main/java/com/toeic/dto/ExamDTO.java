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
	private int startPoint;
	private String type; //lean -> �н�, exam -> ����, review -> ����
	private int examDate; //���� �� ��¥
	
}
