package com.toeic.web;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.toeic.service.AnmoExamService;

import lombok.extern.java.Log;

@Log
@CrossOrigin
@RestController
@RequestMapping("/anmoexams/*")
public class AnmoExamController {
	
	@Inject
	private AnmoExamService serivce;
	
	
	//���迡 ���� �������� ����(�Ҵ�� ���蹮�� ��,����� ��ϵ� ��¥ ��)
	@GetMapping("/")
	public void getExamInfo () {
		
	}
	
	@GetMapping("/{eno}")
	public void getExam () {
		
	}
	
	@PutMapping("/middle/{eno}")
	public String updateMiddleExamInfo () {
		return null;
	}
	
	@PutMapping("/finished/{eno}")
	public String updateFinishedExamInfo () {
		return null;
	}
}
