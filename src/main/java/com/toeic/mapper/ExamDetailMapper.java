package com.toeic.mapper;

import org.apache.ibatis.annotations.Param;

import com.toeic.dto.ExamDetailDTO;

public interface ExamDetailMapper {
	
	public void updateMiddleExamDetail(ExamDetailDTO[] list);

}
