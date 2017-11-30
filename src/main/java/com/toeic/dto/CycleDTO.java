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
	private int t1; //ù��° ����
	private int t2; //...
	private int t3;
	private int t4;
	private int t5;
	private int score; //�ش� �ܾ ���� �ϱ� ����
	private Date nextCycle; //���� ���賯¥
	
}
