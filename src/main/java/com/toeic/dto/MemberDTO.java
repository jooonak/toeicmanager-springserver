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
	//l은 learn의 약자이며, 현재 학습 상태(learn, lock, review)를 나타낸다.
	private String lstatus;
	private String lcnt;
	//시험의 시작 지점(wno)을 체크하기 위해 생성한 변수이다.. 
	//실질적으로는 이전 시험의 마지막 단어에 대한 정보이므로 다음 시험은 해당 wno을 포함하지 않는다.
	private int startPoint;
	//금일 업데이트 된 시험의 문제 개수(단어 개수)를 기록하는 변수이다.
	private String todayAnmoCnt;
	//현재 회원의 eno 지점을 기록하는 변수이다.
	private int examPointer;
}
