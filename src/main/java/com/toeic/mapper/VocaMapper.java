package com.toeic.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.toeic.dto.VocaDTO;

public interface VocaMapper {

	@Select("select * from tbl_voca")
	public List<VocaDTO> getList();

	@Insert("insert into tbl_voca(vname) values (#{vname})")
	public void newVoca(String vname);

	@Update("update tbl_voca set vname = #{voca.vname} where vno = #{vno}")
	public void updateVoca(@Param("vno") int vno, @Param("voca") VocaDTO voca);

	@Delete("delete from tbl_voca where vno = #{vno}")
	public void delVoca(int vno);
	
}
