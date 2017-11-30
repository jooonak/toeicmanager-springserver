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


// 추가 구현할 부분: 
// 1. update method가 update service를 호출하기 이전 member의 lstatus를 확인하여 제대로 요청한 것인지 판단하는 구문 구현


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
		return service.getExam("m1"); //test용
		
	}
	
	@GetMapping("/{eno}")
	public List<VocaDTO> getExam (ExamDTO exam) {
		//exam에 들어가는 데이터: mid, eno
		exam.setMid("m1");	//test용
		return service.getExamDetail(exam);
	}
	
	
	@PutMapping("/middle/{eno}")
	public void updateMiddleExamInfo (@RequestBody MemberDTO member, @PathVariable("eno") Integer eno) {
		System.out.println(member);
		//json의 배열형태의 데이터를 스프링에서 list형태로 받으려면 여러 작업을 해야한다(wapper class를 생성한다던지..) 그렇기 때문에 배열형태로 받는 것이 편리하다.
		service.updateMiddleExam(member, eno);
	}
	
	//시험이 끝났는지에 대한 판단은 프론트측에서 해야한다. 시험 종료 여부를 서버사이드에서 하게되면 query가 많아져 성능이 저하된다.
	@PutMapping("/finished/{eno}")
	public Integer updateFinishedExamInfo (@RequestBody MemberDTO member, @PathVariable("eno") Integer eno) {
		//update 구문 입력 후 현재 member의 상태와 eno값을 비교, 동일한 경우 member의 lstatus를 review로 변경
		//변경 후 모든 review eno를 만드는 구문 동작	
		if(member.getExamPointer() == eno && member.getLstatus() == "lock") {
			
		}
		//남은 시험 개수를 리턴한다. 0인 경우 더 이상 풀 시험이 없다는 뜻이다.
		return member.getExamPointer() - eno;
	}
}
