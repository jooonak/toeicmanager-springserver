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
	private String mid;
	private int t1; //첫번째 시험
	private int t2; //...
	private int t3;
	private int t4;
	private int t5;
	private int score; //해당 단어에 대한 암기 점수
	private Date nextCycle; //다음 시험날짜
	
}
