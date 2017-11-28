package com.shard.session.app;

public class SSOInfo {

	public String getBackUrl() {
		return backUrl;
	}

	public void setBackUrl(String backUrl) {
		this.backUrl = backUrl;
	}

	/**
	 * 
	 */
	String backUrl;

	public SSOInfo(String backUrl) {
		super();
		this.backUrl = backUrl;
	}
}
