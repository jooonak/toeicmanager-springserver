package com.toeic.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.toeic.dto.ExamDTO;
import com.toeic.dto.MemberDTO;
import com.toeic.dto.WordDTO;


public interface ExamMapper {

	@Select("select * from tbl_exam where mid = #{mid} and type = 'learn' and total > result order by eno")
	public List<ExamDTO> getEnoListByMid(String mid);
	
	public List<WordDTO> getAnmoWordListByMid(ExamDTO exam);
	
	public List<WordDTO> getNormalReviewWordListByMid(String mid);
	
	public List<WordDTO> getReviewWordListByMid(MemberDTO member);
	
	@Update("update tbl_exam set result = #{result} where eno = #{eno}")
	public void updateExam(ExamDTO exam);
	
/*	//eno에 해당하는 exam 데이터의 result 정보를 증가시키는 메서드
	@Update("update tbl_exam set result = #{result} + result where eno = #{eno}")
	public void updateResultByEno(@Param("eno") Integer eno, @Param("result") Integer result);*/
	
	//eno에 해당하는 exam 데이터의 result 정보를 증가시키는 메서드, 시험을 진행한 양(result), 현재 마지막 시험 문제로 제공된 wno(startPoint)
	@Update("update tbl_exam set result = #{result} + result, startpoint = #{startPoint} where eno = #{eno}")
	public void updateResultByEno(@Param("eno") Integer eno, @Param("result") Integer result, @Param("startPoint") Integer startPoint);
	
	@Select("call update_finished_exam(#{mid}, #{examPointer}, @lstatus)")
	public String updateAndCheckMemberStatus(MemberDTO member);
	
}
