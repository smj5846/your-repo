package com.aianalysis.common.model;

import java.util.List;

public class ComMstPageVO {
	private List<ComMstVO> mstList;
	private int total;
	
	public ComMstPageVO(List<ComMstVO> mstList, int total) {
		this.mstList = mstList;
		this.total = total;
	}
	
	public List<ComMstVO> getMstList() {
		return mstList;
	}
	public void setMstList(List<ComMstVO> mstList) {
		this.mstList = mstList;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	
	
}
