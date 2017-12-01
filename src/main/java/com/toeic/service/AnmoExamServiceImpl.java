package com.toeic.service;

import java.util.List;
import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.toeic.dto.ExamDTO;
import com.toeic.dto.MemberDTO;

import com.toeic.dto.WordDTO;
import com.toeic.mapper.ExamDetailMapper;
import com.toeic.mapper.ExamMapper;

@Transactional
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
	public List<WordDTO> getExamDetail(ExamDTO exam) {
		return examMapper.getAnmoWordListByMid(exam);
	}

	@Override
	public void updateMiddleExam(MemberDTO member, Integer eno) {
		examDetailMapper.updateMiddleExamDetail(member, eno);
		examMapper.updateResultByEno(eno, member.getExamList().length);
	}

	@Override
	public String updateFinishedExam(MemberDTO member, Integer eno) {
		String status = (member.getExamPointer() - eno > 0)?"next": "end"; 
		updateMiddleExam(member, eno);
		if(member.getExamPointer() == eno && member.getLstatus().equals("lock")) {
			status = examMapper.updateAndCheckMemberStatus(member);
		}
		return status;
	}

}
