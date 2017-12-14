package com.toeic.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.toeic.dto.MemberDTO;
import com.toeic.dto.VocaDTO;
import com.toeic.mapper.VocaMapper;

import lombok.extern.java.Log;

@Service
public class VocaServiceImpl implements VocaService{

	@Inject
	VocaMapper mapper;
	
	@Override
	public List<VocaDTO> getList(MemberDTO member) {
		// TODO Auto-generated method stub
		return mapper.getList(member);
	}

	@Override
	public void newVoca(VocaDTO dto) {
		// TODO Auto-generated method stub
		mapper.newVoca(dto);
	}

	@Override
	public void updateVoca(int vno, VocaDTO voca) {
		// TODO Auto-generated method stub
		mapper.updateVoca(vno, voca);
	}

	@Override
	public void delVoca(int vno) {
		// TODO Auto-generated method stub
		mapper.delVoca(vno);
	}

}
