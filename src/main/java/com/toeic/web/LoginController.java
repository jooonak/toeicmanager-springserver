package com.toeic.web;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.toeic.dto.MemberDTO;
import com.toeic.service.LoginService;

import lombok.extern.java.Log;

@RestController
@Log
@CrossOrigin
@RequestMapping("/login/*")
public class LoginController {

	@Inject
	LoginService service;

	@PostMapping("/join")
	public void join(@RequestBody MemberDTO dto) {
		
		service.joinMember(dto);
	}

	@PostMapping("/")
	public MemberDTO login(@RequestBody MemberDTO member) {
		
		log.info(""+member);

		return service.checkMember(member);
	}

}
