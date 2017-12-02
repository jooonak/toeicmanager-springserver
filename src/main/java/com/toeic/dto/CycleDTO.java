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
	private String t1; //ù��° ����
	private String t2; //...
	private String t3;
	private String t4;
	private String t5;
	private int score; //�ش� �ܾ ���� �ϱ� ����
	private Date nextCycle; //���� ���賯¥
	private Date lastExamDate; //���������� ���� ģ ��¥
	private Date regdate; //��ϵ� ��¥
}
