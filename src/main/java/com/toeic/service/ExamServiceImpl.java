package com.toeic.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.toeic.dto.CycleDTO;
import com.toeic.dto.MemberDTO;
import com.toeic.dto.WordDTO;
import com.toeic.mapper.CycleMapper;
import com.toeic.mapper.TimecheckMapper;

@Service
public class ExamServiceImpl implements ExamService {

	@Inject
	CycleMapper cycleMapper;

	@Inject
	TimecheckMapper timeMapper;

	@Override
	public List<CycleDTO> getCycleList(String mid) {
		return cycleMapper.getCycleDTOListByMid(mid);
	}

	@Override
	public List<WordDTO> getTodayExam(String mid) {
		return cycleMapper.getTodayExamListByMid(mid);
	}

	@Override
	public void updateTodayExam(MemberDTO member) {
		cycleMapper.updateTodayExam(member);
	}

	@Override
	public void newExamTime(String mid) {
		timeMapper.newExamTime(mid);

	}

}
