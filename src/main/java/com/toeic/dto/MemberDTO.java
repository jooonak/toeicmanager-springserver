package com.toeic.dto;

import java.sql.Date;

import lombok.Data;
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
	private int extra; //�߰� �����Ǵ� �ܾ��� ����
	private Date toeic; //���� ��¥
	private Date pushAm; //���� Ǫ���˸� ��¥
	private Date pushPm; //���� Ǫ���˸� ��¥
	
	/* �Ʒ��� �������� ȸ���� ���� ���¸� ����ϴ� �������̸�, �̴� ȸ�� ������ �и��Ͽ� ������ �ʿ䰡 �ִ� �����͵��̴�.
	 * ���� �ý����� ��������� ���� member���̺��� �и�(����ȭ)�Ͽ� ������ �����̴�.
	*/
	
	//l�� learn�� �����̸�, ���� �н� ����(learn, lock, review)�� ��Ÿ����.
	private String lstatus;
	private String lcnt;
	//������ ���� ����(wno)�� üũ�ϱ� ���� ������ �����̴�.. 
	//���������δ� ���� ������ ������ �ܾ ���� �����̹Ƿ� ���� ������ �ش� wno�� �������� �ʴ´�.
	private int startPoint;
	//���� ������Ʈ �� ������ ���� ����(�ܾ� ����)�� ����ϴ� �����̴�.
	private int todayAnmoCnt;
	//���� ȸ���� eno ������ ����ϴ� �����̴�.
	private int examPointer;
	
	//mysql�󿡴� ������ ����Ͻ� ���� �� �ʿ��� ��ü�̴� �� spring �����󿡼� �ʿ��� ��ü�̴�.
	private ExamDetailDTO[] examList;
	
}
