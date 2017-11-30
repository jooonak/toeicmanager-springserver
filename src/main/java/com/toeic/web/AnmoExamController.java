package com.toeic.web;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.toeic.dto.ExamDTO;
import com.toeic.dto.ExamDetailDTO;
import com.toeic.dto.MemberDTO;
import com.toeic.dto.VocaDTO;
import com.toeic.service.AnmoExamService;

import lombok.extern.java.Log;

@Log
@CrossOrigin
@RestController
@RequestMapping("/anmoexams/*")
public class AnmoExamController {
	
	@Inject
	private AnmoExamService service;
	
	
	//시험에 대한 전반적인 정보(할당된 시험문제 량,시험당 등록된 날짜 등)
	@GetMapping("/")
	public List<ExamDTO> getExamInfo () {
		return service.getExam("m1");
		
	}
	
	@GetMapping("/{eno}")
	public List<VocaDTO> getExam (ExamDTO exam) {
		//exam에 들어가는 데이터: mid, eno
		exam.setMid("m1");
		return service.getExamDetail(exam);
	}
	
	@PutMapping("/middle/{eno}")
	public String updateMiddleExamInfo (@RequestBody MemberDTO member) {
		//json의 배열형태의 데이터를 스프링에서 list형태로 받으려면 여러 작업을 해야한다(wapper class를 생성한다던지..) 그렇기 때문에 배열형태로 받는 것이 편리하다.
		service.updateMiddleExam(member.getExamList());
		return "success";
	}
	
	@PutMapping("/finished/{eno}")
	public String updateFinishedExamInfo (@RequestBody MemberDTO member) {
		//update 구문 입력 후 현재 member의 상태와 eno값을 비교, 동일한 경우 member의 lstatus를 review로 변경
		//변경 후 모든 review eno를 만드는 구문 동작
		if(member.getLstatus() == "learn") {
			//learn인 경우 exam_detail 테이블 업데이트 후 다음 시험이 존재하면 다음 시험에 대한 데이터를 전달, 더이상 없는경우 end 반환
		}else if(member.getLstatus() == "lock") {
			
		}
		return null;
	}
}
