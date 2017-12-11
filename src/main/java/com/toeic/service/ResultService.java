package com.toeic.service;

import java.util.List;
import java.util.Map;

import com.toeic.dto.CycleDTO;
import com.toeic.dto.ExamDTO;

public interface ResultService {

	public List<ExamDTO> getLearnData(String mid);

	public List<CycleDTO> getExamData(String mid);

	public Map<String, List<? extends Object>> getGoalData(String mid);

	public List<CycleDTO> getResult(String mid);

	

	

}
