package com.toeic.web;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.toeic.dto.CycleDTO;
import com.toeic.dto.ExamDTO;
import com.toeic.dto.WiseDTO;
import com.toeic.service.ResultService;

import lombok.extern.java.Log;

@CrossOrigin
@RestController
@RequestMapping("/result/*")
@Log
public class ResultController {

	@Inject
	private ResultService service;
	
	@GetMapping("/mainlearn")
	public List<ExamDTO> getLearnData(String mid) {
		return service.getLearnData("m1");
	}
	
	@GetMapping("/mainexam")
	public List<CycleDTO> getExamData(String mid){
		return service.getExamData("m1");
	}
	
	@GetMapping("/mainbar")
	public Map<String, List<? extends Object>> getGoalData(String mid){
		return service.getGoalData("m1");
	}
	
	@GetMapping("/")
	public List<CycleDTO> getResult(String mid){
		return service.getResult("m1");
	}
	
	@GetMapping("/wise")
	public List<WiseDTO> getWiseSaying(){
		return service.getWiseSaying();
	}
}

