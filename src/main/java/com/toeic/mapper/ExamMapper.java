package com.toeic.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.toeic.dto.ExamDTO;

public interface ExamMapper {

	@Select("select * from tbl_exam where date(examdate) = date(now())")
	public List<ExamDTO> getTodayExam();
	//추후 examdate를 nextexam으로 변경해야함
	
	@Insert("insert into tbl_exam(wno, result) values(#{wno}, #{result})")
	public void doExam(ExamDTO exam);

	@Update("update tbl_exam set result = #{result} where eno = #{eno}")
	public void updateExam(ExamDTO exam);
	
}
