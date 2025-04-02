package com.aianalysis.common.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aianalysis.common.mapper.ComDtlMapper;
import com.aianalysis.common.model.ComDtlVO;

@Service
public class ComDtlService {
	@Autowired
	private ComDtlMapper cdm;
	
	public int addDtl(ComDtlVO dtlVo) {
		return cdm.insertDtl(dtlVo);
	}
	
	public ArrayList<ComDtlVO> getDtlByMst(String mstCd) {
		return cdm.selectByMstCd(mstCd);
	}
	
	public ArrayList<ComDtlVO> getDtlIndex(int start, int scale, String searchKey, String keyword, String mstCd) {
		return cdm.selectDtlListByMstCd(start, scale, searchKey, keyword, mstCd);
	}
	
	public int removeDtl(String dtlCd) {
		return cdm.deleteDtl(dtlCd);
	}
	
	public int modifyDtl(ComDtlVO dtlVo) {
		return cdm.updateDtl(dtlVo);
	}
	
	public ComDtlVO getDtlByDtlCd(String dtlCd) {
		return cdm.selectByDtlCd(dtlCd);
	}
}
