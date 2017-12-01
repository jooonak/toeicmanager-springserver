package com.toeic.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.toeic.dto.ExamDTO;
import com.toeic.dto.WordDTO;

public interface ExamMapper {

	@Select("select * from tbl_exam where mid = #{mid} and type = 'learn' and total >= result order by eno;")
	public List<ExamDTO> getEnoListByMid(String mid);
	
	public List<WordDTO> getWordListByMid(ExamDTO exam);
	
	@Update("update tbl_exam set result = #{result} where eno = #{eno}")
	public void updateExam(ExamDTO exam);
	
	//eno�� �ش��ϴ� exam �������� result ������ ������Ű�� �޼���
	
	@Update("update tbl_exam set result = #{result} + result where eno = #{eno}")
	public void updateResultByEno(@Param("eno") Integer eno, @Param("result") Integer result);
	
}
