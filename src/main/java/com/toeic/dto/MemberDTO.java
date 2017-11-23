package com.toeic.dto;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MemberDTO {

	private String mid;
	private String mpw;
	private String name;
	private int goal; //��ǥ����
	private int extra; //�߰� �����Ǵ� �ܾ��� ���� (���� �ʿ�)
	private Date toeic; //���� ��¥
	private Date pushAM; //���� Ǫ���˸� ��¥
	private Date pushPM; //���� Ǫ���˸� ��¥
	private String lstatus; //���� ȸ���� �н����� - learn -> �н�, lock (?) -> �н��� �и�, review -> ����
	private int lcnt; //�н� ������ Ƚ��
	
}
