package com.toeic.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.toeic.dto.WiseDTO;

public interface WiseMapper {

	@Select("select * from tbl_wisesaying")
	public List<WiseDTO> getWiseSaying();
}
