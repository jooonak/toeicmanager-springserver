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
	//�ش� �ܾ����� �����ָ� ��Ÿ����. �⺻ ���� �ܾ����� ��� 'system'���� ǥ��ȴ�.
	private String owner;
	//�ش� �ܾ����� toeic level�� ��Ÿ����. �Ϲ� ����ڴ� 1000���� ǥ��ȴ�.  
	private int gubun;
	private int wcnt;
	private Date regdate;
	
}
