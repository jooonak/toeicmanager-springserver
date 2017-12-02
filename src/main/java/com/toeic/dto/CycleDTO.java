package com.toeic.dto;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CycleDTO {

	private int dno;
	private int wno;
	private int vno;
	private String word;
	private String meaning;
	private String mid;
	private String t1; //첫번째 시험
	private String t2; //...
	private String t3;
	private String t4;
	private String t5;
	private int score; //해당 단어에 대한 암기 점수
	private Date nextCycle; //다음 시험날짜
	private Date lastExamDate; //마지막으로 시험 친 날짜
	private Date regdate; //등록된 날짜
}
