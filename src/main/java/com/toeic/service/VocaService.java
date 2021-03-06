package com.toeic.service;

import java.util.List;

import com.toeic.dto.MemberDTO;
import com.toeic.dto.VocaDTO;

public interface VocaService {

	public List<VocaDTO> getList(MemberDTO member);

	public void newVoca(VocaDTO dto);

	public void updateVoca(int vno, VocaDTO voca);

	public void delVoca(int vno);
}
