package com.toeic.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.mysql.fabric.xmlrpc.base.Member;
import com.toeic.dto.MemberDTO;

public interface MemberMapper {

	@Select("select * from tbl_member where mid = #{mid} and mpw = #{mpw}")
	public MemberDTO getMemberByIDAndPW(MemberDTO member);
	
	@Select("select * from tbl_member where mid = #{mid}")
	public MemberDTO getMemberByID(String mid);
	
	@Insert("insert into tbl_member (mid,mpw,name) values(#{mid},#{mpw},#{name})")
	public void regMember(MemberDTO dto);
	
	@Update("update tbl_member set lstatus = 'learn' where mid = #{mid}")
	public void ChangeLstatusFromReviewToLearn(String mid);

}
