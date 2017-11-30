package com.toeic.dto;

import java.sql.Date;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ExamDetailDTO {
	
	private int dto;
	private int eno;
	private int wno;
	private String result;
	private int ncnt;
	private String mid;
	private Date regdate;
}
