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

	@Insert("insert into tbl_word(vno, word, meaning, img, sentence) values(#{vno}, #{word.word}, #{word.meaning}, #{word.img}, #{word.sentence})")
	public void newWord(@Param("vno") int vno, @Param("word") WordDTO word);
	
	@Update("update tbl_word set meaning = #{word.meaning} where vno = #{vno} and wno = #{word.wno}")
	public void updateWord(@Param("vno") int vno, @Param("word") WordDTO word);

	@Delete("delete from tbl_word where wno = #{wno} and vno = #{vno}")
	public void delWord(@Param("vno") int vno, @Param("wno") int wno);
	
	@Select("select word.* from tbl_voca voca, tbl_word word where voca.vno = word.vno order by wno limit 0,20")
	public List<WordDTO> getExamList();

}
