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
	//해당 단어장의 소유주를 나타낸다. 기본 제공 단어장의 경우 'system'으로 표기된다.
	private String owner;
	//해당 단어장의 toeic level을 나타낸다. 일반 사용자는 1000으로 표기된다.  
	private int gubun;
	private int wcnt;
	private Date regdate;
	
}
