package com.toeic.service;

import java.util.List;

import com.toeic.dto.WordDTO;

public interface WordService {

	public List<WordDTO> getList(int vno);

	public WordDTO getWord(int vno, int wno);

	public void newWord(int vno, WordDTO word);
	
	public void updateWord(int vno, WordDTO word);

	public void delWord(int vno, int wno);

}
