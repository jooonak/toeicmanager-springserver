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
import org.springframework.web.bind.annotation.RestController;

import com.toeic.dto.WordDTO;
import com.toeic.service.WordService;

@CrossOrigin
@RestController
public class WordController {

	@Inject
	WordService service;
	
	@GetMapping("/vocabulary/{vno}/words")
	public List<WordDTO> getList(@PathVariable("vno") int vno){
		return service.getList(vno);
	}
	
	@GetMapping("/vocabulary/{vno}/words/{wno}")
	public WordDTO getWord(@PathVariable("vno") int vno, @PathVariable("wno") int wno){
		return service.getWord(vno, wno);
	}
	
	@PostMapping("/vocabulary/{vno}/words")
	public void newWord(@PathVariable("vno") int vno, @RequestBody WordDTO word) {
		System.out.println(word);
		service.newWord(vno, word);
	}
	
	@PutMapping("/vocabulary/{vno}/words")
	public void updateWord(@PathVariable("vno") int vno, @RequestBody WordDTO word) {
		//기본 단어장에 대한 수정은 프론트에서 막아야 함
		service.updateWord(vno, word);
	}
	
	@DeleteMapping("/vocabulary/{vno}/words/{wno}")
	public void delWord(@PathVariable("vno") int vno, @PathVariable("wno") int wno) {
		service.delWord(vno, wno);
	}
	
}
