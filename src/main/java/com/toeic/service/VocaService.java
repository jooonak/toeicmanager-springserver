package com.toeic.service;

import java.util.List;

import com.toeic.dto.VocaDTO;

public interface VocaService {

	public List<VocaDTO> getList();

	public void newVoca(String vname);

	public void updateVoca(int vno, VocaDTO voca);

	public void delVoca(int vno);
}
