package com.aianalysis.common.model;

import java.util.ArrayList;

public class MbrPageResponse {
	private ArrayList<MbrVO> mbrList;
	private int mbrTotal;
	
	public MbrPageResponse(ArrayList<MbrVO> mbrList, int mbrTotal) {
		this.mbrList = mbrList;
		this.mbrTotal = mbrTotal;
	}

	public ArrayList<MbrVO> getMbrList() {
		return mbrList;
	}

	public void setMbrList(ArrayList<MbrVO> mbrList) {
		this.mbrList = mbrList;
	}

	public int getMbrTotal() {
		return mbrTotal;
	}

	public void setMbrTotal(int mbrTotal) {
		this.mbrTotal = mbrTotal;
	}
	
	
}
