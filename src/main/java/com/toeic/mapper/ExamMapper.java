package com.toeic.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.toeic.dto.ExamDTO;
import com.toeic.dto.VocaDTO;

public interface ExamMapper {

	@Select("select * from tbl_exam where mid = #{mid}")
	public List<ExamDTO> getEnoListByMid(String mid);
	
	public List<VocaDTO> getWordListByMid(ExamDTO exam);

	@Update("update tbl_exam set result = #{result} where eno = #{eno}")
	public void updateExam(ExamDTO exam);
	
}
