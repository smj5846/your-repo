package com.aianalysis.common.model;

import java.time.LocalDateTime;

public class MenuVO {
   private int no;
   private int rfrncNo;
   private int rfrncGroup;
   private String menuNm;
   private String menuLnkg;
   private int rlsMbrAuthrt;
   private char useYn;
   private String regId;
   private String uptId;
   private LocalDateTime regDt;  
   private LocalDateTime uptDt;
   private int layer;
   
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getRfrncNo() {
		return rfrncNo;
	}
	public void setRfrncNo(int rfrncNo) {
		this.rfrncNo = rfrncNo;
	}
	public int getRfrncGroup() {
		return rfrncGroup;
	}
	public void setRfrncGroup(int rfrncGroup) {
		this.rfrncGroup = rfrncGroup;
	}
	public String getMenuNm() {
		return menuNm;
	}
	public void setMenuNm(String menuNm) {
		this.menuNm = menuNm;
	}
	public String getMenuLnkg() {
		return menuLnkg;
	}
	public void setMenuLnkg(String menuLnkg) {
		this.menuLnkg = menuLnkg;
	}
	public int getRlsMbrAuthrt() {
		return rlsMbrAuthrt;
	}
	public void setRlsMbrAuthrt(int rlsMbrAuthrt) {
		this.rlsMbrAuthrt = rlsMbrAuthrt;
	}
	public char getUseYn() {
		return useYn;
	}
	public void setUseYn(char useYn) {
		this.useYn = useYn;
	}
	public String getRegId() {
		return regId;
	}
	public void setRegId(String regId) {
		this.regId = regId;
	}
	public String getUptId() {
		return uptId;
	}
	public void setUptId(String uptId) {
		this.uptId = uptId;
	}
	public LocalDateTime getRegDt() {
		return regDt;
	}
	public void setRegDt(LocalDateTime regDt) {
		this.regDt = regDt;
	}
	public LocalDateTime getUptDt() {
		return uptDt;
	}
	public void setUptDt(LocalDateTime uptDt) {
		this.uptDt = uptDt;
	}
	public int getLayer() {
		return layer;
	}
	public void setLayer(int layer) {
		this.layer = layer;
	}
}