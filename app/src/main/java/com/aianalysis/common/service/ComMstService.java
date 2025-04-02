package com.aianalysis.common.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aianalysis.common.mapper.ComMstMapper;
import com.aianalysis.common.model.ComMstVO;

@Service
public class ComMstService {
	@Autowired
	private ComMstMapper cmm;
	
	public ComMstVO getComMst(String mstCd) {
		return cmm.selectByMstCd(mstCd);
	}
	
	public ArrayList<ComMstVO> getAllComMst() {
		return cmm.selectAllMstCd();
	}
	
	public ArrayList<ComMstVO> getMstIndex(int start, int scale, String searchKey, String keyword) {
		return cmm.selectMstList(start, scale, searchKey, keyword);
	}
	
	public int addMst(ComMstVO mstVo) {
		return cmm.insertMst(mstVo);
	}
	
	public int modifyMst(ComMstVO mstVo) {
		return cmm.updateMst(mstVo);
	}
	
	public int removeMst(String mstCd) {
		return cmm.deleteMst(mstCd);
	}
}
