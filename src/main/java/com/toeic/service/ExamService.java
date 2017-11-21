package com.toeic.service;

import java.util.List;

import com.toeic.dto.ExamDTO;
import com.toeic.dto.WordDTO;

public interface ExamService {

	public List<WordDTO> getList();

	public List<ExamDTO> getTodayExam();
	
	public void doExam(ExamDTO exam);

	public void updateExam(ExamDTO exam);

}
