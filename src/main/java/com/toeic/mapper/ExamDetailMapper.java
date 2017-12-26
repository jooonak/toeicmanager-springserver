package com.toeic.mapper;

import org.apache.ibatis.annotations.Param;

import com.toeic.dto.MemberDTO;

public interface ExamDetailMapper {
	
	public void updateMiddleExamDetail(@Param("member") MemberDTO member, @Param("eno") Integer eno);

	public void updateMiddleReviewExamDetail(@Param("member") MemberDTO member);
}
