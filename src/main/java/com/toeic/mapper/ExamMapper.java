package com.toeic.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.toeic.dto.ExamDTO;
import com.toeic.dto.MemberDTO;
import com.toeic.dto.WordDTO;


public interface ExamMapper {

	@Select("select eno, mid, result, total, dayofmonth(examdate) examdate from tbl_exam where mid = #{mid} and type = 'learn' and total > result order by eno")
	public List<ExamDTO> getEnoListByMid(String mid);
	
	public List<WordDTO> getAnmoWordListByMid(ExamDTO exam);
	
	public List<WordDTO> getNormalReviewWordListByMid(String mid);
	
	public List<WordDTO> getReviewWordListByMid(MemberDTO member);
	
	@Update("update tbl_exam set result = #{result} where eno = #{eno}")
	public void updateExam(ExamDTO exam);
	
/*	//eno�� �ش��ϴ� exam �������� result ������ ������Ű�� �޼���
	@Update("update tbl_exam set result = #{result} + result where eno = #{eno}")
	public void updateResultByEno(@Param("eno") Integer eno, @Param("result") Integer result);*/
	
	//eno�� �ش��ϴ� exam �������� result ������ ������Ű�� �޼���, ������ ������ ��(result), ���� ������ ���� ������ ������ wno(startPoint)
	@Update("update tbl_exam set result = #{result} + result, startpoint = #{startPoint} where eno = #{eno}")
	public void updateResultByEno(@Param("eno") Integer eno, @Param("result") Integer result, @Param("startPoint") Integer startPoint);
	
	@Select("call update_finished_exam(#{mid}, #{examPointer}, @lstatus)")
	public String updateAndCheckMemberStatus(MemberDTO member);

	@Select("select * from tbl_exam where mid = #{mid}")
	public List<ExamDTO> getGoalDataById(String mid);
	
}
