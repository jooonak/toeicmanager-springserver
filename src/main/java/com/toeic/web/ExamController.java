package com.toeic.web;

import java.util.List;


import javax.inject.Inject;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.toeic.dto.CycleDTO;
import com.toeic.dto.ExamDTO;
import com.toeic.dto.MemberDTO;
import com.toeic.dto.WordDTO;
import com.toeic.service.ExamService;

import lombok.extern.java.Log;

@CrossOrigin
@RestController
@RequestMapping("/exams/*")
@Log
public class ExamController {

	@Inject
	ExamService service;
	
	@GetMapping("/all")
	public List<CycleDTO> getList(String mid){
		return service.getCycleList("m1");
	}
	
	@GetMapping("/today")
	public List<WordDTO> getTodayExam(String mid){
		return service.getTodayExam("m3");		
	}
	
	
	@PutMapping("/today")
	public void updateTodayExam(@RequestBody MemberDTO member) {
		service.updateTodayExam(member);
	}
	
	@PostMapping("/timecheck")
	public void newExamTime(String mid) {
		service.newExamTime(mid);
	
	}
	
}
