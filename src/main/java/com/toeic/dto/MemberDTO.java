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
	private int goal; //목표점수
	private int extra; //추가 제공되는 단어장 점수
	private Date toeic; //시험 날짜
	private Date pushAm; //오전 푸쉬알림 날짜
	private Date pushPm; //오후 푸쉬알림 날짜
	private String pushToken;
	
	/* 아래의 정보들은 회원의 시험 상태를 기록하는 변수들이며, 이는 회원 정보와 분리하여 관리할 필요가 있는 데이터들이다.
	 * 추후 시스템의 성능향상을 위해 member테이블에서 분리(정규화)하여 관리할 예정이다.
	*/
	
	//l은 learn의 약자이며, 현재 학습 상태(learn, lock, review)를 나타낸다.
	private String lstatus;
	private String lcnt;
	//시험의 시작 지점(wno)을 체크하기 위해 생성한 변수이다.. 
	//실질적으로는 이전 시험의 마지막 단어에 대한 정보이므로 다음 시험은 해당 wno을 포함하지 않는다.
	private int startPoint;
	//금일 업데이트 된 시험의 문제 개수(단어 개수)를 기록하는 변수이다.
	private int todayAnmoCnt;
	//현재 회원의 eno 지점을 기록하는 변수이다.
	private int examPointer;
	
	//mysql상에는 없지만 비즈니스 로직 상 필요한 객체이다 즉 spring 로직상에서 필요한 객체이다.
	private ExamDetailDTO[] examList;
	
}
