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


// �߰� ������ �κ�: 
// 1. update method�� update service�� ȣ���ϱ� ���� member�� lstatus�� Ȯ���Ͽ� ����� ��û�� ������ �Ǵ��ϴ� ���� ����


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
		return service.getExam("m1"); //test��
		
	}
	
	@GetMapping("/{eno}")
	public List<VocaDTO> getExam (ExamDTO exam) {
		//exam�� ���� ������: mid, eno
		exam.setMid("m1");	//test��
		return service.getExamDetail(exam);
	}
	
	
	@PutMapping("/middle/{eno}")
	public void updateMiddleExamInfo (@RequestBody MemberDTO member, @PathVariable("eno") Integer eno) {
		System.out.println(member);
		//json�� �迭������ �����͸� ���������� list���·� �������� ���� �۾��� �ؾ��Ѵ�(wapper class�� �����Ѵٴ���..) �׷��� ������ �迭���·� �޴� ���� ���ϴ�.
		service.updateMiddleExam(member, eno);
	}
	
	//������ ���������� ���� �Ǵ��� ����Ʈ������ �ؾ��Ѵ�. ���� ���� ���θ� �������̵忡�� �ϰԵǸ� query�� ������ ������ ���ϵȴ�.
	@PutMapping("/finished/{eno}")
	public Integer updateFinishedExamInfo (@RequestBody MemberDTO member, @PathVariable("eno") Integer eno) {
		//update ���� �Է� �� ���� member�� ���¿� eno���� ��, ������ ��� member�� lstatus�� review�� ����
		//���� �� ��� review eno�� ����� ���� ����	
		if(member.getExamPointer() == eno && member.getLstatus() == "lock") {
			
		}
		//���� ���� ������ �����Ѵ�. 0�� ��� �� �̻� Ǯ ������ ���ٴ� ���̴�.
		return member.getExamPointer() - eno;
	}
}
