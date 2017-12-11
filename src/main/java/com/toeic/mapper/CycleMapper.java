package com.toeic.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.toeic.dto.CycleDTO;
import com.toeic.dto.MemberDTO;
import com.toeic.dto.WordDTO;

public interface CycleMapper {

	public List<CycleDTO> getCycleDTOListByMid(String mid);

	public List<WordDTO> getTodayExamListByMid(String mid);

	public void updateTodayExam(@Param("member") MemberDTO member);

	@Select("select * from tbl_cycle where mid = #{mid} and  nextcycle < now()")
	public List<CycleDTO> getCycleDTOListtoMain(String mid);

	@Select("select * from tbl_cycle where mid = #{mid}")
	public List<CycleDTO> getGoalDataById(String mid);
}
