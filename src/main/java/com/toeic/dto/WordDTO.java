package com.toeic.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class WordDTO {

	private int vno;
	private int wno;
	private String word;
	private String meaning;
	private String img;
	private String sentence;
	
}
