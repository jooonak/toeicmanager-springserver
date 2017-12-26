package com.toeic.web;

import java.util.List;

import javax.inject.Inject;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.toeic.dto.MemberDTO;
import com.toeic.dto.VocaDTO;
import com.toeic.service.VocaService;

@CrossOrigin
@RestController
@RequestMapping("/vocabulary/*")
public class VocaController {

	@Inject
	VocaService service;
	
	@GetMapping("/")
	public List<VocaDTO> getList(MemberDTO member){
		return service.getList(member);
	}
	
	@PostMapping("/")
	public void newVoca( VocaDTO dto) {
		service.newVoca(dto);
	}
	
	@PutMapping("/{vno}")
	public void updateVoca(@PathVariable("vno") int vno, @RequestBody VocaDTO voca) {
		service.updateVoca(vno, voca);
	}
	
	@DeleteMapping("/{vno}")
	public void delVoca(@PathVariable("vno") int vno) {
		service.delVoca(vno);
	}
	
}
