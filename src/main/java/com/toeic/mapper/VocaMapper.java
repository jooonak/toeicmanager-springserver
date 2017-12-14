package com.toeic.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.toeic.dto.MemberDTO;
import com.toeic.dto.VocaDTO;

public interface VocaMapper {

	@Select("select * from (select * from tbl_voca where owner = 'SYSTEM' or owner = #{member.mid}) tbl_voca  where gubun =1000 or gubun <=#{member.goal}")
	public List<VocaDTO> getList(@Param("member") MemberDTO member);

	@Insert("insert into tbl_voca(vname, owner) values (#{dto.vname}, #{dto.owner})")
	public void newVoca(@Param("dto") VocaDTO dto);

	@Update("update tbl_voca set vname = #{voca.vname} where vno = #{vno}")
	public void updateVoca(@Param("vno") int vno, @Param("voca") VocaDTO voca);

	@Delete("delete from tbl_voca where vno = #{vno}")
	public void delVoca(int vno);
	
}
