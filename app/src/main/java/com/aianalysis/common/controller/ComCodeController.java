package com.aianalysis.common.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aianalysis.common.model.ComDtlPageVO;
import com.aianalysis.common.model.ComDtlVO;
import com.aianalysis.common.model.ComMstPageVO;
import com.aianalysis.common.model.ComMstVO;
import com.aianalysis.common.model.RequestComVO;
import com.aianalysis.common.service.ComDtlService;
import com.aianalysis.common.service.ComMstService;

import jakarta.servlet.http.HttpSession;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/code")
public class ComCodeController {
	@Autowired
	private ComMstService cms;
	@Autowired
	private ComDtlService cds;

	//코드 등록 시 MST 코드 전체 출력
	@GetMapping("/getMstCode")
	public ArrayList<ComMstVO> getAllComMst() {
		return cms.getAllComMst();
	}
	
	@PostMapping("/mstIndex")
	public ComMstPageVO ntcIndex(@RequestParam(required = false, defaultValue = "0") int start, 
			@RequestParam(required = false, defaultValue = "5") int scale, 
			@RequestParam(required = false) String searchKey, 
			@RequestParam(required = false, defaultValue = "") String keyword) {
		
		List<ComMstVO> list = cms.getMstIndex(start, scale, searchKey, keyword);
		int total = cms.getAllComMst().size();
		
		ComMstPageVO pageVO = new ComMstPageVO(list, total);
		
		return pageVO;
	}
	
	@PostMapping("/dtlIndex")
	public ComDtlPageVO ntcIndex(@RequestParam(required = false, defaultValue = "0") int start, 
			@RequestParam(required = false, defaultValue = "5") int scale, 
			@RequestParam(required = false) String searchKey, 
			@RequestParam(required = false, defaultValue = "") String keyword,
			@RequestParam String mstCd) {
		
		List<ComDtlVO> list = cds.getDtlIndex(start, scale, searchKey, keyword, mstCd);
		int total = cds.getDtlByMst(mstCd).size();
		
		ComDtlPageVO pageVO = new ComDtlPageVO(list, total);
		
		return pageVO;
	}
	
	//MST 코드 등록
	@PostMapping("/reg")
	public ResponseEntity<?> reg(@RequestBody RequestComVO reqComVo) {
		String type = reqComVo.getType();
		int result = 0;
		
		if(type.equals("mst")) { //마스터 코드 등록
			ComMstVO mstVo = new ComMstVO();
			mstVo.setMstCd(reqComVo.getDtlVO().getDtlCd());
			mstVo.setMstNm(reqComVo.getDtlVO().getDtlNm());
			mstVo.setDsctn(reqComVo.getDtlVO().getDsctn());
			
			result = cms.addMst(mstVo);
		} else { //상세 코드 등록
			ComDtlVO dtlVo = new ComDtlVO();
			dtlVo.setMstCd(reqComVo.getDtlVO().getMstCd());
			dtlVo.setDtlCd(reqComVo.getDtlVO().getDtlCd());
			dtlVo.setDtlNm(reqComVo.getDtlVO().getDtlNm());
			dtlVo.setDsctn(reqComVo.getDtlVO().getDsctn());
			
			result = cds.addDtl(dtlVo);
		}
		
		if(result > 0) {
			return ResponseEntity.ok().body("등록 완료");
		} else {
			return ResponseEntity.ok().body("등록 실패");
		}
	}
	
	//MST 코드 수정
	@PostMapping("/modify")
	public ResponseEntity<?> modify(@RequestBody RequestComVO reqComVo) {
		String type = reqComVo.getType();
		int result = 0;
		
		if(type.equals("mst")) { //마스터 코드 수정
			ComMstVO mstVo = new ComMstVO();
			mstVo.setMstCd(reqComVo.getDtlVO().getDtlCd());
			mstVo.setMstNm(reqComVo.getDtlVO().getDtlNm());
			mstVo.setDsctn(reqComVo.getDtlVO().getDsctn());
			
			result = cms.modifyMst(mstVo);
		} else { //상세 코드 수정
			ComDtlVO dtlVo = new ComDtlVO();
			dtlVo.setMstCd(reqComVo.getDtlVO().getMstCd());
			dtlVo.setDtlCd(reqComVo.getDtlVO().getDtlCd());
			dtlVo.setDtlNm(reqComVo.getDtlVO().getDtlNm());
			dtlVo.setDsctn(reqComVo.getDtlVO().getDsctn());
			
			result = cds.modifyDtl(dtlVo);
		}
		
		if(result > 0) {
			return ResponseEntity.ok().body("수정 완료");
		} else {
			return ResponseEntity.ok().body("수정 실패");
		}
	}
	
	@PostMapping("/mstDelete")
	public ResponseEntity<?> mstDelete(@RequestBody String mstCd) {
		int result = cms.removeMst(mstCd);
		
		if(result > 0) {
			return ResponseEntity.ok().body("삭제 완료");
		} else {
			return ResponseEntity.ok().body("삭제 실패");
		} 
	}
	
	@PostMapping("/dtlDelete")
	public ResponseEntity<?> dtlDelete(@RequestBody String dtlCd) {
		int result = cds.removeDtl(dtlCd);
		
		if(result > 0) {
			return ResponseEntity.ok().body("삭제 완료");
		} else {
			return ResponseEntity.ok().body("삭제 실패");
		} 
	}
	
	@PostMapping("/getDtlByCode")
	public ComDtlVO getDtlByCode(@RequestBody String dtlCd) {
		return cds.getDtlByDtlCd(dtlCd);
	}
	
	@PostMapping("/getMstByCode")
	public ComMstVO getMstByCode(@RequestBody String mstCd) {
		return cms.getComMst(mstCd);
	} 
}
