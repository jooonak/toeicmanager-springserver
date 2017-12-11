package com.toeic.web;

import java.util.List;
import javax.inject.Inject;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.toeic.dto.ExamDTO;
import com.toeic.dto.MemberDTO;

import com.toeic.dto.WordDTO;
import com.toeic.service.LearnService;

import lombok.extern.java.Log;

// �߰� ������ �κ�: 
// 1. update method�� update service�� ȣ���ϱ� ���� member�� lstatus�� Ȯ���Ͽ� ����� ��û�� ������ �Ǵ��ϴ� ���� ����

@Log
@CrossOrigin
@RestController
@RequestMapping("/learn/*")
public class LearnController {
	
	@Inject
	private LearnService service;
	
	//���迡 ���� �������� ����(�Ҵ�� ���蹮�� ��,����� ��ϵ� ��¥ ��)
	@GetMapping("/{mid}")
	public List<ExamDTO> getExamInfo (@PathVariable("mid") String mid) {
		return service.getExam(mid);
		
	}
	
	@GetMapping("/{eno}")
	public List<WordDTO> getExam (ExamDTO exam) {
		//exam�� ���� ������: mid, eno
		return service.getExamDetail(exam);
	}
	
	@PutMapping("/middle/{eno}")
	public void updateMiddleExamInfo (@RequestBody MemberDTO member, @PathVariable("eno") Integer eno) {
		//json�� �迭������ �����͸� ���������� list���·� �������� ���� �۾��� �ؾ��Ѵ�(wapper class�� �����Ѵٴ���..) �׷��� ������ �迭���·� �޴� ���� ���ϴ�.
		service.updateMiddleExam(member, eno);
	}
	
	//������ ���������� ���� �Ǵ��� ����Ʈ������ �ؾ��Ѵ�. ���� ���� ���θ� �������̵忡�� �ϰԵǸ� query�� ������ ������ ���ϵȴ�.
	@PutMapping("/finished/{eno}")
	public String updateFinishedExamInfo (@RequestBody MemberDTO member, @PathVariable("eno") Integer eno) {
		//update ���� �Է� �� ���� member�� ���¿� eno���� ��, ������ ��� member�� lstatus�� review�� ����
		//���� �� ��� review eno�� ����� ���� ����
		return service.updateFinishedExam(member, eno);
	}
}
