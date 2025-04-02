package com.aianalysis.common.model;

public class ComDtlVO {
	private String dtlCd;
	private String mstCd;
	private String dtlNm;
	private String dsctn;
	
	private ComMstVO comMstVO;

	public String getDtlCd() {
		return dtlCd;
	}

	public void setDtlCd(String dtlCd) {
		this.dtlCd = dtlCd;
	}

	public String getMstCd() {
		return mstCd;
	}

	public void setMstCd(String mstCd) {
		this.mstCd = mstCd;
	}

	public String getDtlNm() {
		return dtlNm;
	}

	public void setDtlNm(String dtlNm) {
		this.dtlNm = dtlNm;
	}

	public String getDsctn() {
		return dsctn;
	}

	public void setDsctn(String dsctn) {
		this.dsctn = dsctn;
	}

	public ComMstVO getComMstVO() {
		return comMstVO;
	}

	public void setComMstVO(ComMstVO comMstVO) {
		this.comMstVO = comMstVO;
	}
	
	
}
