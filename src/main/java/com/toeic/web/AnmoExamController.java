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
	
	
	//���迡 ���� �������� ����(�Ҵ�� ���蹮�� ��,����� ��ϵ� ��¥ ��)
	@GetMapping("/")
	public List<ExamDTO> getExamInfo () {
		return service.getExam("m1");
		
	}
	
	@GetMapping("/{eno}")
	public List<VocaDTO> getExam (ExamDTO exam) {
		//exam�� ���� ������: mid, eno
		exam.setMid("m1");
		return service.getExamDetail(exam);
	}
	
	@PutMapping("/middle/{eno}")
	public String updateMiddleExamInfo (@RequestBody MemberDTO member) {
		//json�� �迭������ �����͸� ���������� list���·� �������� ���� �۾��� �ؾ��Ѵ�(wapper class�� �����Ѵٴ���..) �׷��� ������ �迭���·� �޴� ���� ���ϴ�.
		service.updateMiddleExam(member.getExamList());
		return "success";
	}
	
	@PutMapping("/finished/{eno}")
	public String updateFinishedExamInfo (@RequestBody MemberDTO member) {
		//update ���� �Է� �� ���� member�� ���¿� eno���� ��, ������ ��� member�� lstatus�� review�� ����
		//���� �� ��� review eno�� ����� ���� ����
		if(member.getLstatus() == "learn") {
			//learn�� ��� exam_detail ���̺� ������Ʈ �� ���� ������ �����ϸ� ���� ���迡 ���� �����͸� ����, ���̻� ���°�� end ��ȯ
		}else if(member.getLstatus() == "lock") {
			
		}
		return null;
	}
}
