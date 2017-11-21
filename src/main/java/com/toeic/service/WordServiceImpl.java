package com.toeic.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.toeic.dto.WordDTO;
import com.toeic.mapper.WordMapper;

@Service
public class WordServiceImpl implements WordService{

	@Inject
	WordMapper mapper;

	@Override
	public List<WordDTO> getList(int vno) {
		// TODO Auto-generated method stub
		return mapper.getList(vno);
	}

	@Override
	public WordDTO getWord(int vno, int wno) {
		// TODO Auto-generated method stub
		return mapper.getWord(vno, wno);
	}
	
	@Override
	public void newWord(int vno, WordDTO word) {
		// TODO Auto-generated method stub
		mapper.newWord(vno, word);
	}

	@Override
	public void updateWord(int vno, WordDTO word) {
		// TODO Auto-generated method stub
		mapper.updateWord(vno, word);
	}

	@Override
	public void delWord(int vno, int wno) {
		// TODO Auto-generated method stub
		mapper.delWord(vno, wno);
	}
	
}
