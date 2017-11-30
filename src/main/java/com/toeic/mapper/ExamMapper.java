package com.toeic.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.toeic.dto.ExamDTO;
import com.toeic.dto.MemberDTO;
import com.toeic.dto.VocaDTO;
import com.toeic.dto.WordDTO;

public interface ExamMapper {

	@Select("select * from tbl_exam where mid = #{mid}")
	public List<ExamDTO> getEnoListByMid(String mid);
	
	public List<WordDTO> getWordListByMid(ExamDTO exam);
	
	@Update("update tbl_exam set result = #{result} where eno = #{eno}")
	public void updateExam(ExamDTO exam);
	
	//eno에 해당하는 exam 데이터의 result 정보를 증가시키는 메서드
	
	@Update("update tbl_exam set result = #{result} + result where eno = #{eno}")
	public void updateResultByEno(@Param("eno") Integer eno, @Param("result") Integer result);
	
}
