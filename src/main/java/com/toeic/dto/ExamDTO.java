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
	private int wno;
	private String result;
	private Date examDate;
	
}
