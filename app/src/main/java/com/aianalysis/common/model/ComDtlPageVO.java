package com.aianalysis.common.model;

import java.util.List;

public class ComDtlPageVO {
	private List<ComDtlVO> dtlList;
	private int total;
	
	public ComDtlPageVO(List<ComDtlVO> dtlList, int total) {
		this.dtlList = dtlList;
		this.total = total;
	}

	public List<ComDtlVO> getDtlList() {
		return dtlList;
	}
	public void setDtlList(List<ComDtlVO> dtlList) {
		this.dtlList = dtlList;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	
}
