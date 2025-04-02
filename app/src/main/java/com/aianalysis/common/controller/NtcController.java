package com.aianalysis.common.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.aianalysis.common.model.NtcPageVO;
import com.aianalysis.common.model.NtcVO;
import com.aianalysis.common.service.NtcService;

import jakarta.servlet.http.HttpSession;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class NtcController {
	@Autowired
	public NtcService ntcService;
	
	@PostMapping("/api/ntc/reg")
	public ResponseEntity<?> ntcInsert(@RequestBody NtcVO vo, HttpSession session) {
		int result = 0;
		int grade = 1;
		if(session.getAttribute("grade") != null) {
			grade = (int)session.getAttribute("grade");
			vo.setRegId((String)session.getAttribute("email"));
			vo.setUptId((String)session.getAttribute("email"));
		}
		
		
		
		//관리자만 작성 가능
		if(grade == 3) result = ntcService.addNtc(vo);
		
		if(result > 0) {
			return ResponseEntity.ok().body("등록 완료");
		} else {
			return ResponseEntity.ok().body("등록 실패");
		}
	}
	
	@GetMapping("/api/ntc/index")
	public NtcPageVO ntcIndex(@RequestParam(required = false, value = "start", defaultValue = "0") int start
			, @RequestParam(value = "scale", required = false, defaultValue = "5") int scale
			, @RequestParam(value = "searchKey", required = false, defaultValue = "") String searchKey
			, @RequestParam(value = "keyword", required = false, defaultValue = "") String keyword
			, HttpSession session) {
		
		int grade = 1;
		if(session.getAttribute("grade") != null) {
			grade = (int)session.getAttribute("grade");
		}
		
		List<NtcVO> list = ntcService.getNtcIndex(start, scale, searchKey, keyword, grade);
		int total = ntcService.getNtcTotal(searchKey, keyword, grade);
		
		NtcPageVO pageVO = new NtcPageVO(list, total);
		
		return pageVO;
	}
	
	@GetMapping("/api/ntc/main")
	@ResponseBody
	public List<NtcVO> ntcIndexToMain(HttpSession session) {
		int grade = 1;
		if(session.getAttribute("grade") != null) {
			grade = (int)session.getAttribute("grade");
		}
		
		List<NtcVO> list = ntcService.getNtcIndexToMain(grade);
		
		return list;
	}
	
	@GetMapping("/api/ntc/get")
	public NtcVO ntcGet(@RequestParam int no) {
		NtcVO vo = new NtcVO();
		if(no != 0) vo = ntcService.getNtc(no);
		
		return vo;
	}
	
	@PostMapping("/api/ntc/update")
	public ResponseEntity<?> ntcUpdate(@RequestBody NtcVO vo, HttpSession session) {		
		int result = 0;
		int grade = 1;
		if(session.getAttribute("grade") != null) {
			grade = (int)session.getAttribute("grade");
			vo.setUptId((String)session.getAttribute("email"));
		}
		
		//관리자만 작성 가능
		if(grade == 3) result = ntcService.updateNtc(vo);
		
		if(result > 0) {
			return ResponseEntity.ok().body("수정 완료");
		} else {
			return ResponseEntity.ok().body("수정 실패");
		}
	}
	
	@PostMapping("/api/ntc/delete")
	public int ntcDelete(@RequestBody int no) {		
		return ntcService.deleteNtc(no);
	}
}
