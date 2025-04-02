package com.aianalysis.common.model;

import java.util.List;

public class NtcPageVO {
	private List<NtcVO> ntcList;
	private int total;
	
	public NtcPageVO(List<NtcVO> ntcList, int total) {
		this.ntcList = ntcList;
		this.total = total;
	}
	
	public List<NtcVO> getNtcList() {
		return ntcList;
	}
	public void setNtcList(List<NtcVO> ntcList) {
		this.ntcList = ntcList;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
}
