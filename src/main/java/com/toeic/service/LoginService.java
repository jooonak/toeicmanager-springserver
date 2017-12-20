package com.toeic.service;

import com.toeic.dto.MemberDTO;

public interface LoginService {

	public void joinMember(MemberDTO dto);

	public MemberDTO checkMember(MemberDTO member);

	public void updateMemberToken(MemberDTO member);
	

}
