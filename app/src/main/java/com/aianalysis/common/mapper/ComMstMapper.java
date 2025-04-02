package com.aianalysis.common.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.aianalysis.common.model.ComMstVO;

@Mapper
public interface ComMstMapper {
	ComMstVO selectByMstCd(String mstCd);
	ArrayList<ComMstVO> selectAllMstCd();
	int insertMst(ComMstVO mstVo);
	int updateMst(ComMstVO mstVo);
	ArrayList<ComMstVO> selectMstList(int start, int scale, String searchKey, String keyword);
	int deleteMst(String mstCd);
}
