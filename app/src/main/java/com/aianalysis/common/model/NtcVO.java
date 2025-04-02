package com.aianalysis.common.model;

import java.time.LocalDateTime;

public class NtcVO {
   private int no;
   private char ntcYn;
   private String title;
   private String content;
   private String regId;
   private String uptId;
   private LocalDateTime regDt;
   private LocalDateTime uptDt;
   private char useYn;
   private int total;
   
   private MbrVO mbrVo;
   
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public char getNtcYn() {
		return ntcYn;
	}
	public void setNtcYn(char ntcYn) {
		this.ntcYn = ntcYn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
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
	public char getUseYn() {
		return useYn;
	}
	public void setUseYn(char useYn) {
		this.useYn = useYn;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public MbrVO getMbrVo() {
		return mbrVo;
	}
	public void setMbrVo(MbrVO mbrVo) {
		this.mbrVo = mbrVo;
	}
	
}