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
	private Date regdate;
	
}
