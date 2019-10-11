package com.iiht.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="TrainingDtls")
public class TrainingDtls {
	@Id
	private Long id;
	private String status;
	private Integer progress;
	private Float avgRating = 0.0f;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private String startDate;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private String endDate;
	@JsonFormat(pattern = "HH:mm:ss")
	private String startTime;
	@JsonFormat(pattern = "HH:mm:ss")
	private String endTime;
	private Float amountReceived;
	private Long userId;
	private String userName;
	private Long mentorId;
	private String mentorName;
	private Long skillId;
	private String skillName;
	private Float fees;
	private String feedback;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getProgress() {
		return progress;
	}
	public void setProgress(Integer progress) {
		this.progress = progress;
	}
	public Float getAvgRating() {
		return avgRating;
	}
	public void setAvgRating(Float avgRating) {
		this.avgRating = avgRating;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public Float getAmountReceived() {
		return amountReceived;
	}
	public void setAmountReceived(Float amountReceived) {
		this.amountReceived = amountReceived;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Long getMentorId() {
		return mentorId;
	}
	public void setMentorId(Long mentorId) {
		this.mentorId = mentorId;
	}
	public String getMentorName() {
		return mentorName;
	}
	public void setMentorName(String mentorName) {
		this.mentorName = mentorName;
	}
	public Long getSkillId() {
		return skillId;
	}
	public void setSkillId(Long skillId) {
		this.skillId = skillId;
	}
	public String getSkillName() {
		return skillName;
	}
	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}
	public Float getFees() {
		return fees;
	}
	public void setFees(Float fees) {
		this.fees = fees;
	}
	
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	public TrainingDtls(Long id, String status, Integer progress, Float avgRating, String startDate, String endDate,
			String startTime, String endTime, Float amountReceived, Long userId, String userName, Long mentorId,
			String mentorName, Long skillId, String skillName, Float fees, String feedback) {
		super();
		this.id = id;
		this.status = status;
		this.progress = progress;
		this.avgRating = avgRating;
		this.startDate = startDate;
		this.endDate = endDate;
		this.startTime = startTime;
		this.endTime = endTime;
		this.amountReceived = amountReceived;
		this.userId = userId;
		this.userName = userName;
		this.mentorId = mentorId;
		this.mentorName = mentorName;
		this.skillId = skillId;
		this.skillName = skillName;
		this.fees = fees;
		this.feedback = feedback;
	}
	public TrainingDtls() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
