package com.toeic.service;

import java.util.List;

import com.toeic.dto.ExamDTO;
import com.toeic.dto.ExamDetailDTO;
import com.toeic.dto.VocaDTO;
import com.toeic.dto.WordDTO;

public interface AnmoExamService {
	
	public List<ExamDTO> getExam(String mid);

	public List<VocaDTO> getExamDetail(ExamDTO exam);
	
	public void updateMiddleExam(ExamDetailDTO[] examList);

	public void updateFinishedExam(List<ExamDetailDTO> list, ExamDTO exam);
}
