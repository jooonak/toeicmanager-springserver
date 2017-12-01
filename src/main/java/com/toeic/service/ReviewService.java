package com.toeic.service;

import java.util.List;

import com.toeic.dto.ExamDTO;
import com.toeic.dto.MemberDTO;
import com.toeic.dto.WordDTO;

public interface ReviewService {
	public List<WordDTO> getReviewDetail(MemberDTO member);
	
	public void updateMiddleReview(MemberDTO member);

	public String updateFinishedReview(MemberDTO member);
}
