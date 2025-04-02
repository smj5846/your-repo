package com.aianalysis.common.model;

import java.util.ArrayList;

public class MenuPageResponse {
	private ArrayList<MenuVO> menuList;
	private int menuTotal;
	
	public MenuPageResponse(ArrayList<MenuVO> menuList, int menuTotal) {
		this.menuList = menuList;
		this.menuTotal = menuTotal;
	}

	public ArrayList<MenuVO> getMenuList() {
		return menuList;
	}

	public void setMenuList(ArrayList<MenuVO> menuList) {
		this.menuList = menuList;
	}

	public int getMenuTotal() {
		return menuTotal;
	}

	public void setMenuTotal(int menuTotal) {
		this.menuTotal = menuTotal;
	}
	
	
}
