package com.toeic.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.toeic.dto.MemberDTO;
import com.toeic.dto.WordDTO;
import com.toeic.mapper.ExamDetailMapper;
import com.toeic.mapper.ExamMapper;
import com.toeic.mapper.MemberMapper;

@Transactional
@Service
public class ReviewServiceImpl implements ReviewService {

	@Inject
	private ExamMapper examMapper;
	
	@Inject
	private ExamDetailMapper examDetailMapper;
	
	@Inject
	private MemberMapper memberMapper;
	
	@Override
	public List<WordDTO> getReviewDetail(MemberDTO member) {
		if(member.getLstatus().equals("review")) {
			//review�� ���� memberDTO�� ����ִ� eno(examPointer)�� �����ͼ� �����ش�. review ���¿� �ִ� ��� ������ examPointer�� review�̴�.
			return examMapper.getReviewWordListByMid(member);
		} else {
			//lock, learn�� ��쿡�� exam_detail���� 'x'�� ���� ����Ʈ���� �����´�.
			return examMapper.getNormalReviewWordListByMid(member.getMid());
		}
	}

	@Override
	public void updateMiddleReview(MemberDTO member) {
		examDetailMapper.updateMiddleReviewExamDetail(member);
		if(member.getLstatus().equals("review")) {
			examMapper.updateResultByEno(member.getExamPointer(), member.getExamList().length, member.getExamList()[member.getExamList().length-1].getWno());
		} 
	}

	@Override
	public String updateFinishedReview(MemberDTO member) {
		updateMiddleReview(member);
		memberMapper.ChangeLstatusFromReviewToLearn(member.getMid());
		// TODO Auto-generated method stub
		return "learn";
	}

}
