package com.toeic.service;

import java.util.List;

import com.toeic.dto.CycleDTO;
import com.toeic.dto.MemberDTO;
import com.toeic.dto.WordDTO;

public interface ExamService {

	public List<CycleDTO> getCycleList(String mid);

	public List<WordDTO> getTodayExam(String mid);
	
	public void updateTodayExam(MemberDTO member);

	public void newExamTime(String mid);

}
