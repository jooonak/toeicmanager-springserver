package com.toeic.dto;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class VocaDTO {

	private int vno;
	private String vname;
	private String owner;
	private int gubun; //시스템 단어장의 목표점수 확인을 위한 컬럼 -> 사용자는 1000으로 기본 설정
	private int wcnt; //word count
	private Date regdate;
	
}
