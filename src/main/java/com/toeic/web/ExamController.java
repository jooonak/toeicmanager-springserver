package com.toeic.web;

import java.util.List;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.toeic.dto.CycleDTO;
import com.toeic.dto.MemberDTO;
import com.toeic.dto.WordDTO;
import com.toeic.service.ExamService;

import lombok.extern.java.Log;

@CrossOrigin
@RestController
@RequestMapping("/exam/*")
@Log
public class ExamController {

	@Inject
	ExamService service;

	@GetMapping("/all")
	public List<CycleDTO> getList(String mid) {
		return service.getCycleList(mid);
	}

	@GetMapping("/today")
	public List<WordDTO> getTodayExam(String mid) {
		return service.getTodayExam(mid);
	}

	@PutMapping("/today")
	public void updateTodayExam(@RequestBody MemberDTO member) {
		service.updateTodayExam(member);
	}

}
