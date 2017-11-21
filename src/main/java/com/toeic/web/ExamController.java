package com.toeic.web;

import java.util.List;


import javax.inject.Inject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.toeic.dto.ExamDTO;
import com.toeic.dto.WordDTO;
import com.toeic.service.ExamService;

@RestController
@RequestMapping("/exam/*")
public class ExamController {

	@Inject
	ExamService service;
	
	@GetMapping("/")
	public List<WordDTO> getList(){
		return service.getList();
	}
	
	@GetMapping("/today")
	public List<ExamDTO> getTodayExam(){
		return service.getTodayExam();
	}
	
	@PostMapping("/")
	public void doExam(@RequestBody ExamDTO exam) {
		service.doExam(exam);
	}
	
	@PutMapping("/")
	public void updateExam(@RequestBody ExamDTO exam) {
		service.updateExam(exam);
	}
	
}
