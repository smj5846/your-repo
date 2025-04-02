package com.aianalysis.common.mapper;

import java.util.ArrayList;

import com.aianalysis.common.model.MbrVO;

public interface MbrMapper {
	//MenuVO selectByNo(int no);
	int mbrDelete(String email);
	int mbrUpdate(MbrVO mbrvo);
	MbrVO selectMbrgetList(String email);
	ArrayList<MbrVO> selectMbrList(int grade,String searchkey, String keyword);
	ArrayList<MbrVO> selectMbrPageList(int itemsPerPage,int indexOfFirstItem,int grade,String searchkey, String keyword);
	MbrVO selectMbrByLgn(String email, String password, int grade);
	int insertMbr(MbrVO mbrvo);
	
}