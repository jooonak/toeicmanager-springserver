package com.toeic.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.toeic.dto.WordDTO;

public interface WordMapper {

	@Select("select * from tbl_word where vno = #{vno}")
	public List<WordDTO> getList(int vno);

	@Select("select * from tbl_word where wno = #{wno} and vno = #{vno}")
	public WordDTO getWord(@Param("vno") int vno, @Param("wno") int wno);

	@Insert("insert into tbl_word(vno, word, meaning) values(#{vno}, #{word.word}, #{word.meaning})")
	public void newWord(@Param("vno") int vno, @Param("word") WordDTO word);
	
	@Update("update tbl_word set meaning = #{word.meaning} where vno = #{vno} and wno = #{word.wno}")
	public void updateWord(@Param("vno") int vno, @Param("word") WordDTO word);

	@Delete("delete from tbl_word where wno = #{wno} and vno = #{vno}")
	public void delWord(@Param("vno") int vno, @Param("wno") int wno);
	
	@Select("select word.vno, wno, word, meaning from tbl_voca voca, tbl_word word where voca.vno = word.vno order by wno limit 0,20")
	public List<WordDTO> getExamList();
	//시험조건에 맞는 단어 리스트를 불러오는 메서드 -> word.vno를 파라미터로 받아야 하고, voca.owner와 user정보를 비교하는 구문과 user의 마지막 시험 정보로 가져올 단어의 시작 번호 지정하는 구문 추가필요
	
}
