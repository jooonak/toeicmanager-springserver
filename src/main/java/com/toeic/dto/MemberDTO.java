package com.toeic.dto;

import java.sql.Date;

public class MemberDTO {
	private String mid;
	private String mpw;
	private String name;
	private int goal;
	private int extra;
	private Date toeic;
	private Date pushAm;
	private Date pushPm;
	//l�� learn�� �����̸�, ���� �н� ����(learn, lock, review)�� ��Ÿ����.
	private String lstatus;
	private String lcnt;
	//������ ���� ����(wno)�� üũ�ϱ� ���� ������ �����̴�.. 
	//���������δ� ���� ������ ������ �ܾ ���� �����̹Ƿ� ���� ������ �ش� wno�� �������� �ʴ´�.
	private int startPoint;
	//���� ������Ʈ �� ������ ���� ����(�ܾ� ����)�� ����ϴ� �����̴�.
	private String todayAnmoCnt;
	//���� ȸ���� eno ������ ����ϴ� �����̴�.
	private int examPointer;
}
