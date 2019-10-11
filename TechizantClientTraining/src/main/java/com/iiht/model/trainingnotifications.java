package com.iiht.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="trainingnotifications")
public class trainingnotifications {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long userId;
	private String userName;
	private Long mentorId;
	private String mentorName;
	private Long skillId;
	private String skillName;
//	@JsonFormat(pattern = "yyyy-MM-dd")
	private String RequestDate;
	private String status;
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
	public String getRequestDate() {
		return RequestDate;
	}
	public void setRequestDate(String requestDate) {
		RequestDate = requestDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public trainingnotifications(Long userId, String userName, Long mentorId, String mentorName, Long skillId,
			String skillName, String requestDate, String status) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.mentorId = mentorId;
		this.mentorName = mentorName;
		this.skillId = skillId;
		this.skillName = skillName;
		RequestDate = requestDate;
		this.status = status;
	}
	public trainingnotifications() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "trainingnotifications [userId=" + userId + ", userName=" + userName + ", mentorId=" + mentorId
				+ ", mentorName=" + mentorName + ", skillId=" + skillId + ", skillName=" + skillName + ", RequestDate="
				+ RequestDate + ", status=" + status + "]";
	}
	
	
}
