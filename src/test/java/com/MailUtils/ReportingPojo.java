package com.MailUtils;

public class ReportingPojo {
	
	private String featureName;
	private String tag;
	private String status;
	
	public String getFeatureName() {
		return featureName;
	}
	public void setFeatureName(String featureName) {
		this.featureName = featureName;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return getFeatureName() + ":" + getTag() + ":"+ getStatus();
	}
	
	

}
