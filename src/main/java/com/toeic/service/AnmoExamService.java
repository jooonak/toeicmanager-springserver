package com.toeic.service;

import java.util.List;
import com.toeic.dto.ExamDTO;
import com.toeic.dto.MemberDTO;
import com.toeic.dto.WordDTO;

public interface AnmoExamService {
	
	public List<ExamDTO> getExam(String mid);

	public List<WordDTO> getExamDetail(ExamDTO exam);
	
	public void updateMiddleExam(MemberDTO member, Integer eno);

	public String updateFinishedExam(MemberDTO member, Integer eno);
}
