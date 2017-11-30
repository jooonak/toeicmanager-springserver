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
		log.info("" + dto);
		log.info("join@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");

		service.joinMember(dto);
	}

	@PostMapping("/")
	public void login() {

		log.info("guest@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
	}

}
