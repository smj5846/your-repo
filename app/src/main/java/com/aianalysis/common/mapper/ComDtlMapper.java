package com.aianalysis.common.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.aianalysis.common.model.ComDtlVO;

@Mapper
public interface ComDtlMapper {
	int insertDtl(ComDtlVO dtlVo);
	ArrayList<ComDtlVO> selectDtlListByMstCd(int start, int scale, String searchKey, String keyword, String mstCd);
	ArrayList<ComDtlVO> selectByMstCd(String mstCd);
	int deleteDtl(String dtlCd);
	int updateDtl(ComDtlVO dtlVo);
	ComDtlVO selectByDtlCd(String dtlCd);
}
