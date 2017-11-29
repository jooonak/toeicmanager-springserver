package com.toeic.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.toeic.dto.ExamDTO;
import com.toeic.dto.ExamDetailDTO;
import com.toeic.dto.VocaDTO;
import com.toeic.mapper.ExamDetailMapper;
import com.toeic.mapper.ExamMapper;

@Service
public class AnmoExamServiceImpl implements AnmoExamService {
	
	@Inject
	private ExamMapper examMapper;
	
	@Inject
	private ExamDetailMapper examDetailMapper;

	@Override
	public List<ExamDTO> getExam(String mid) {
		return examMapper.getEnoListByMid(mid);
	}

	@Override
	public List<VocaDTO> getExamDetail(ExamDTO exam) {
		return examMapper.getWordListByMid(exam);
	}

	@Override
	public void updateMiddleExam(ExamDetailDTO[] examList) {
		examDetailMapper.updateMiddleExamDetail(examList);
	}

	@Override
	public void updateFinishedExam(List<ExamDetailDTO> list, ExamDTO exam) {
		// TODO Auto-generated method stub

	}

}
