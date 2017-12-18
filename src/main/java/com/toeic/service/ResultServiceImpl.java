package com.toeic.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.toeic.dto.CycleDTO;
import com.toeic.dto.ExamDTO;
import com.toeic.dto.WiseDTO;
import com.toeic.mapper.CycleMapper;
import com.toeic.mapper.ExamMapper;
import com.toeic.mapper.WiseMapper;

@Service
public class ResultServiceImpl implements ResultService {

	@Inject
	ExamMapper mapper;
	
	@Inject
	CycleMapper cycleMapper;
	
	@Inject
	WiseMapper wiseMapper;
	
	@Override
	public List<ExamDTO> getLearnData(String mid) {
		
		return mapper.getEnoListByMid(mid);
	}

	@Override
	public List<CycleDTO> getExamData(String mid) {
		
		return cycleMapper.getCycleDTOListtoMain(mid);
	}

	@Override
	public Map<String, List<? extends Object>> getGoalData(String mid) {

		Map<String, List<? extends Object>> map = new HashMap<>();
		
		map.put("learn",mapper.getGoalDataById(mid));
		
		map.put("exam",cycleMapper.getGoalDataById(mid));
				
		return map;
	}

	@Override
	public List<CycleDTO> getResult(String mid) {

		return cycleMapper.getGoalDataById(mid);
	}

	@Override
	public List<WiseDTO> getWiseSaying() {
		return wiseMapper.getWiseSaying();
	}

}
