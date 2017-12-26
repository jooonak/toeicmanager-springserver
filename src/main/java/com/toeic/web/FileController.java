package com.toeic.web;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.java.Log;

@CrossOrigin
@RestController
@RequestMapping("/file/*")
@Log
public class FileController {

	@GetMapping("/{fileName:.+}")
	public byte[] showImg(@PathVariable("fileName") String fileName) {
		try {
			File file = new File("D:\\ToeicManager_repo\\" + fileName);
			
			return FileUtils.readFileToByteArray(file);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@GetMapping("/newdata")
	public List<String> getNewData() {
		
		File file = new File("D:\\ToeicManager_repo\\academy\\admy_data.txt");
		List<String> list = new ArrayList<String>();
				
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			
			while (br.read() != -1) {
				list.add(br.readLine());
			}
			
			log.info("LIST: "+list);
			
			br.close();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			
			return null;
		}
	}
}
