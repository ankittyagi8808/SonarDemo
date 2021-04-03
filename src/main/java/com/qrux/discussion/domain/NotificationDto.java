package com.qrux.discussion.domain;

import java.io.Serializable;

public class NotificationDto implements Serializable{

	private static final long serialVersionUID = -1640086261600653990L;

	private Long  transactionCurtureDisplayerId;
	private Long displayerId;
	private Long campaignId;
	private String campaignDispName;
	private Long valueId;
	private String valueDispName;
	private Long behaviourId;
	private String behaviourDispName;
	private Long nanoBehaviourId;
	private String nanoBehaviourDispName;
	private String comment; 
	private Long  contactId;      
	private String contactFirstDispName; 
	private String contactLastDispName;
	private String imageCode;
	private String deptDispName;  
	private String desiDispName; 
	private String branchDispName;
	private Long score;
	private Long rank;
	
	
	
	public Long getScore() {
		return score;
	}
	public void setScore(Long score) {
		this.score = score;
	}
	public Long getRank() {
		return rank;
	}
	public void setRank(Long rank) {
		this.rank = rank;
	}
	public Long getTransactionCurtureDisplayerId() {
		return transactionCurtureDisplayerId;
	}
	public void setTransactionCurtureDisplayerId(Long transactionCurtureDisplayerId) {
		this.transactionCurtureDisplayerId = transactionCurtureDisplayerId;
	}
	public Long getDisplayerId() {
		return displayerId;
	}
	public void setDisplayerId(Long displayerId) {
		this.displayerId = displayerId;
	}
	public Long getCampaignId() {
		return campaignId;
	}
	public void setCampaignId(Long campaignId) {
		this.campaignId = campaignId;
	}
	public String getCampaignDispName() {
		return campaignDispName;
	}
	public void setCampaignDispName(String campaignDispName) {
		this.campaignDispName = campaignDispName;
	}
	public Long getValueId() {
		return valueId;
	}
	public void setValueId(Long valueId) {
		this.valueId = valueId;
	}
	public String getValueDispName() {
		return valueDispName;
	}
	public void setValueDispName(String valueDispName) {
		this.valueDispName = valueDispName;
	}
	public Long getBehaviourId() {
		return behaviourId;
	}
	public void setBehaviourId(Long behaviourId) {
		this.behaviourId = behaviourId;
	}
	public String getBehaviourDispName() {
		return behaviourDispName;
	}
	public void setBehaviourDispName(String behaviourDispName) {
		this.behaviourDispName = behaviourDispName;
	}
	public Long getNanoBehaviourId() {
		return nanoBehaviourId;
	}
	public void setNanoBehaviourId(Long nanoBehaviourId) {
		this.nanoBehaviourId = nanoBehaviourId;
	}
	public String getNanoBehaviourDispName() {
		return nanoBehaviourDispName;
	}
	public void setNanoBehaviourDispName(String nanoBehaviourDispName) {
		this.nanoBehaviourDispName = nanoBehaviourDispName;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Long getContactId() {
		return contactId;
	}
	public void setContactId(Long contactId) {
		this.contactId = contactId;
	}
	public String getContactFirstDispName() {
		return contactFirstDispName;
	}
	public void setContactFirstDispName(String contactFirstDispName) {
		this.contactFirstDispName = contactFirstDispName;
	}
	public String getContactLastDispName() {
		return contactLastDispName;
	}
	public void setContactLastDispName(String contactLastDispName) {
		this.contactLastDispName = contactLastDispName;
	}
	public String getImageCode() {
		return imageCode;
	}
	public void setImageCode(String imageCode) {
		this.imageCode = imageCode;
	}
	public String getDeptDispName() {
		return deptDispName;
	}
	public void setDeptDispName(String deptDispName) {
		this.deptDispName = deptDispName;
	}
	public String getDesiDispName() {
		return desiDispName;
	}
	public void setDesiDispName(String desiDispName) {
		this.desiDispName = desiDispName;
	}
	public String getBranchDispName() {
		return branchDispName;
	}
	public void setBranchDispName(String branchDispName) {
		this.branchDispName = branchDispName;
	}
	
	
}
