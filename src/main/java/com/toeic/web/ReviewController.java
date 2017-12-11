package com.toeic.web;

import java.util.List;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.toeic.dto.ExamDTO;
import com.toeic.dto.MemberDTO;
import com.toeic.dto.WordDTO;
import com.toeic.service.LearnService;
import com.toeic.service.ReviewService;

@CrossOrigin
@RestController
@RequestMapping("/review/*")
public class ReviewController {
	
	@Inject
	private ReviewService service;
	
	//review의 경우 별다른 eno url없이도 현재 시험 리스트를 가져올 수 있도록 하였다. 현재 회원이 'review'상태인 경우 exam 테이블에 등록된 review eno를 기준으로 문제 리스트를 가져오고 아닌 경우
	//exam_detail에서 상태가 'x'인 wno만 가져오도록 하였다.
	
	//필요한 parameter: mid, Lstatus, examPointer
	@GetMapping("/")
	public List<WordDTO> getReview (MemberDTO member) {
		System.out.println("get==========="+member);
		//mid 계속 암호화되서 따로 넣음
//		member.setMid("m3");
		return service.getReviewDetail(member);
	}
	
	
	@PutMapping("/middle")
	public void updateMiddleReviewInfo (@RequestBody MemberDTO member) {
		//json의 배열형태의 데이터를 스프링에서 list형태로 받으려면 여러 작업을 해야한다(wapper class를 생성한다던지..) 그렇기 때문에 배열형태로 받는 것이 편리하다.
		System.out.println(member.getExamList()[member.getExamList().length-1].getWno());
		service.updateMiddleReview(member);
	}
	
	//시험이 끝났는지에 대한 판단은 프론트측에서 해야한다. 시험 종료 여부를 서버사이드에서 하게되면 query가 많아져 성능이 저하된다.
	@PutMapping("/finished")
	public String updateFinishedReviewInfo (@RequestBody MemberDTO member) {
		//update 구문 입력 후 현재 member의 상태와 eno값을 비교, 동일한 경우 member의 lstatus를 review로 변경
		//변경 후 모든 review eno를 만드는 구문 동작
		System.out.println(member);
		if(!member.getLstatus().equals("review")) {
			return "reject: no review status";
		}
		//learn 리턴
		return service.updateFinishedReview(member);
	}

}
