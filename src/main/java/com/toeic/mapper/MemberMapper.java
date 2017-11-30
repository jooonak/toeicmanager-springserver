package com.toeic.mapper;

import org.apache.ibatis.annotations.Insert;

import com.toeic.dto.MemberDTO;

public interface MemberMapper {

	@Insert("insert into tbl_member (mid,mpw,name) values(#{mid},#{mpw},#{name})")
	public void regMember(MemberDTO dto);

}
