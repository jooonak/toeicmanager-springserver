package com.toeic.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import com.toeic.dto.MemberDTO;

public interface TimecheckMapper {

	@Insert("insert into tbl_timecheck ( mid, timecheck) values(#{mid} ,curtime())")
	public void newExamTime(String mid);

}
