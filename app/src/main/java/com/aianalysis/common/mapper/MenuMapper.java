package com.aianalysis.common.mapper;

import java.util.ArrayList;

import com.aianalysis.common.model.MenuVO;

public interface MenuMapper {
	MenuVO selectByNo(int no);
	ArrayList<MenuVO> selectMenuList();
	ArrayList<MenuVO> selectMenuPageList(int itemsPerPage,int indexOfFirstItem);
	int insertMenu(MenuVO mv,String emlAddr);
	int deleteMenu(int no);
	int updateMenu(MenuVO mv,String emlAddr);
	ArrayList<MenuVO> selectMenuGrdList(int grade);
}