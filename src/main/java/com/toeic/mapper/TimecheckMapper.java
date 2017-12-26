package com.toeic.mapper;

import org.apache.ibatis.annotations.Insert;

public interface TimecheckMapper {

	@Insert("insert into tbl_timecheck ( mid, timecheck) values(#{mid} ,curtime())")
	public void newExamTime(String mid);

}
