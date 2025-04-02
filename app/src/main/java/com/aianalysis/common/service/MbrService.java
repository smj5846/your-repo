package com.aianalysis.common.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aianalysis.common.mapper.MbrMapper;
import com.aianalysis.common.model.MbrVO;
import com.aianalysis.common.model.PasswordUtil;

@Service
public class MbrService {
	@Autowired
	public MbrMapper mbrMapper;
	
	LocalDateTime now = LocalDateTime.now(); // 현재 날짜 및 시간 가져오기
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    String nowDate = now.format(formatter);
    
//    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
    public int mbrDelete(String email){
		return mbrMapper.mbrDelete(email);
	}
    
	public int mbrUpdate(MbrVO mbrvo){
		if(mbrvo.getPassword() != null) {
			mbrvo.setPassword(PasswordUtil.encryptSHA256(mbrvo.getPassword()));
		}
		mbrvo.setUptDt(nowDate);
		return mbrMapper.mbrUpdate(mbrvo);
	}

	public MbrVO getMbr(String email){
		
		return mbrMapper.selectMbrgetList(email);
	}
	
	public ArrayList<MbrVO> getMbrPageIndex(Map<String, ?> params){
		int itemsPerPage = (int) params.get("itemsPerPage");
		int indexOfFirstItem = (int) params.get("indexOfFirstItem");
		int grade = (int) params.get("grade");
		String searchkey = (String) params.get("searchkey");
		String keyword = (String) params.get("keyword");

		return mbrMapper.selectMbrPageList(itemsPerPage,indexOfFirstItem,grade,searchkey,keyword);
	}
	
	public ArrayList<MbrVO> getMbrIndex(Map<String, ?> params){
		int grade = (int) params.get("grade");
		String searchkey = (String) params.get("searchkey");
		String keyword = (String) params.get("keyword");
		
		return mbrMapper.selectMbrList(grade,searchkey,keyword);
	}
	
	public MbrVO getMbrByLgn(String email, String password, int grade){
		return mbrMapper.selectMbrByLgn(email, password, grade);
	}
	
	public int saveMbr(MbrVO mbrvo) {
		mbrvo.setPassword(PasswordUtil.encryptSHA256(mbrvo.getPassword()));
		mbrvo.setGrade(1);
		mbrvo.setRegDt(nowDate);
		mbrvo.setUptDt(nowDate);
		
		return mbrMapper.insertMbr(mbrvo);
	}
	
	
}
