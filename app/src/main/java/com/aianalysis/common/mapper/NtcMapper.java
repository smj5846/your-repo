package com.aianalysis.common.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.aianalysis.common.model.NtcVO;

@Mapper
public interface NtcMapper {
	NtcVO selectByNo(int no);
	ArrayList<NtcVO> selectNtcList(int start, int scale, String searchKey, String keyword, int grade);
	ArrayList<NtcVO> selectNtcListToMain(int grade);
	int insertNtc(NtcVO vo);
	int deleteNtc(int no);
	int updateNtc(NtcVO vo);
	ArrayList<NtcVO> selectAllNtcList();
	int getNtcTotal(String searchKey, String keyword, int grade);
}
