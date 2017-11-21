package com.toeic.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.toeic.dto.ExamDTO;
import com.toeic.dto.WordDTO;
import com.toeic.mapper.ExamMapper;
import com.toeic.mapper.WordMapper;

@Service
public class ExamServiceImpl implements ExamService {

	@Inject
	WordMapper wMapper;
	
	@Inject
	ExamMapper eMapper;
	
	@Override
	public List<WordDTO> getList() {
		// TODO Auto-generated method stub
		return wMapper.getExamList();
	}

	@Override
	public List<ExamDTO> getTodayExam() {
		// TODO Auto-generated method stub
		return eMapper.getTodayExam();
	}
	
	@Override
	public void doExam(ExamDTO exam) {
		// TODO Auto-generated method stub
		eMapper.doExam(exam);
	}

	@Override
	public void updateExam(ExamDTO exam) {
		// TODO Auto-generated method stub
		eMapper.updateExam(exam);
	}

}
