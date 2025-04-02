package com.aianalysis.common.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aianalysis.common.mapper.NtcMapper;
import com.aianalysis.common.model.NtcVO;

@Service
public class NtcService {
	@Autowired
	public NtcMapper ntcMapper;
	
	public NtcVO getNtc(int no) {
		return ntcMapper.selectByNo(no);
	}
	
	public int addNtc(NtcVO vo) {
		return ntcMapper.insertNtc(vo);
	}
	
	public ArrayList<NtcVO> getNtcIndex(int stat, int scl, String searchKey, String keyword, int grade) {        
		return ntcMapper.selectNtcList(stat, scl, searchKey, keyword, grade);
	}
	
	public ArrayList<NtcVO> getAllNtcIndex() {
		return ntcMapper.selectAllNtcList();
	}
	
	public int updateNtc(NtcVO vo) {
		return ntcMapper.updateNtc(vo);
	}
	
	public int deleteNtc(int no) {
		return ntcMapper.deleteNtc(no);
	}
	
	public int getNtcTotal(String searchKey, String keyword, int grade) {
		return ntcMapper.getNtcTotal(searchKey, keyword, grade);
	}
	public ArrayList<NtcVO> getNtcIndexToMain(int grade) {
		return ntcMapper.selectNtcListToMain(grade);
	} 
}
