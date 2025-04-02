package com.aianalysis.common.service;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aianalysis.common.mapper.MenuMapper;
import com.aianalysis.common.model.MenuVO;

@Service
public class MenuService {

	@Autowired
	public MenuMapper menumapper;
	
	public ArrayList<MenuVO> getMenuList(){
		return menumapper.selectMenuList();
	}
	
	public ArrayList<MenuVO> getMenuPageList(Map<String, Integer> params){
		int itemsPerPage = params.get("itemsPerPage");
		int indexOfFirstItem = params.get("indexOfFirstItem");
		return menumapper.selectMenuPageList(itemsPerPage,indexOfFirstItem);
	}
	
	public MenuVO getMenu(int no) {
		return menumapper.selectByNo(no);
	}
	
	public int saveMenu(MenuVO mv,String emlAddr) {
		mv.setRfrncNo(1);
		mv.setRfrncGroup(1);
		mv.setLayer(1);
		
		return menumapper.insertMenu(mv,emlAddr);
	}
	
	public int deleteMenu(int no) {
		return menumapper.deleteMenu(no);
	}
	
	public int updateMenu(MenuVO mv,String emlAddr) {
		return menumapper.updateMenu(mv,emlAddr);
	}
	
	public ArrayList<MenuVO> getMenuGrdList(int grade){
		return menumapper.selectMenuGrdList(grade);
	}
	
}
