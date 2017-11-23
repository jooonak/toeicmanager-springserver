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
	private int goal; //목표점수
	private int extra; //추가 제공되는 단어장 점수 (수정 필요)
	private Date toeic; //시험 날짜
	private Date pushAM; //오전 푸쉬알림 날짜
	private Date pushPM; //오후 푸쉬알림 날짜
	private String lstatus; //현재 회원의 학습상태 - learn -> 학습, lock (?) -> 학습이 밀림, review -> 복습
	private int lcnt; //학습 진행한 횟수
	
}
