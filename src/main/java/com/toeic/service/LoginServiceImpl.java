package com.toeic.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.toeic.dto.MemberDTO;
import com.toeic.mapper.MemberMapper;

@Service
public class LoginServiceImpl implements LoginService{

	@Inject
	MemberMapper mapper;
	
	@Override
	public void joinMember(MemberDTO dto) {
		mapper.regMember(dto);
		
	}

	@Override
	public MemberDTO checkMember(MemberDTO member) {
		return mapper.getMemberByIDAndPW(member);
	}

	@Override
	public void updateMemberToken(MemberDTO member) {
		mapper.updateMemberToken(member);
	}

}
