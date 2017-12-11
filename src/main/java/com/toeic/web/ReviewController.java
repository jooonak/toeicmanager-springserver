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
	
	//review�� ��� ���ٸ� eno url���̵� ���� ���� ����Ʈ�� ������ �� �ֵ��� �Ͽ���. ���� ȸ���� 'review'������ ��� exam ���̺� ��ϵ� review eno�� �������� ���� ����Ʈ�� �������� �ƴ� ���
	//exam_detail���� ���°� 'x'�� wno�� ���������� �Ͽ���.
	
	//�ʿ��� parameter: mid, Lstatus, examPointer
	@GetMapping("/")
	public List<WordDTO> getReview (MemberDTO member) {
		System.out.println("get==========="+member);
		//mid ��� ��ȣȭ�Ǽ� ���� ����
//		member.setMid("m3");
		return service.getReviewDetail(member);
	}
	
	
	@PutMapping("/middle")
	public void updateMiddleReviewInfo (@RequestBody MemberDTO member) {
		//json�� �迭������ �����͸� ���������� list���·� �������� ���� �۾��� �ؾ��Ѵ�(wapper class�� �����Ѵٴ���..) �׷��� ������ �迭���·� �޴� ���� ���ϴ�.
		System.out.println(member.getExamList()[member.getExamList().length-1].getWno());
		service.updateMiddleReview(member);
	}
	
	//������ ���������� ���� �Ǵ��� ����Ʈ������ �ؾ��Ѵ�. ���� ���� ���θ� �������̵忡�� �ϰԵǸ� query�� ������ ������ ���ϵȴ�.
	@PutMapping("/finished")
	public String updateFinishedReviewInfo (@RequestBody MemberDTO member) {
		//update ���� �Է� �� ���� member�� ���¿� eno���� ��, ������ ��� member�� lstatus�� review�� ����
		//���� �� ��� review eno�� ����� ���� ����
		System.out.println(member);
		if(!member.getLstatus().equals("review")) {
			return "reject: no review status";
		}
		//learn ����
		return service.updateFinishedReview(member);
	}

}
