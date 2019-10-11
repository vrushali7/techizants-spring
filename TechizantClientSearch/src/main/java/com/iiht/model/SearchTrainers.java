package com.iiht.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "search")
public class SearchTrainers {

	@Id
	private Long id;
	private Long mentor_id;
	
	private String mentor_name;
	private float mentor_rating;
	private int technology_id;

	private String technologyname;
	private String toc;
	private String prerequisites;
	private int fees;
	private String startTime;
	private String endTime;
	
	private String availFrom;
	private String availTill;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getMentor_id() {
		return mentor_id;
	}
	public void setMentor_id(Long mentor_id) {
		this.mentor_id = mentor_id;
	}
	public String getMentor_name() {
		return mentor_name;
	}
	public void setMentor_name(String mentor_name) {
		this.mentor_name = mentor_name;
	}
	public float getMentor_rating() {
		return mentor_rating;
	}
	public void setMentor_rating(float mentor_rating) {
		this.mentor_rating = mentor_rating;
	}
	public int getTechnology_id() {
		return technology_id;
	}
	public void setTechnology_id(int technology_id) {
		this.technology_id = technology_id;
	}
	public String getTechnologyname() {
		return technologyname;
	}
	public void setTechnologyname(String technologyname) {
		this.technologyname = technologyname;
	}
	public String getToc() {
		return toc;
	}
	public void setToc(String toc) {
		this.toc = toc;
	}
	public String getPrerequisites() {
		return prerequisites;
	}
	public void setPrerequisites(String prerequisites) {
		this.prerequisites = prerequisites;
	}
	public int getFees() {
		return fees;
	}
	public void setFees(int fees) {
		this.fees = fees;
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
	public String getAvailFrom() {
		return availFrom;
	}
	public void setAvailFrom(String availFrom) {
		this.availFrom = availFrom;
	}
	public String getAvailTill() {
		return availTill;
	}
	public void setAvailTill(String availTill) {
		this.availTill = availTill;
	}
	
	
	public SearchTrainers(Long id, Long mentor_id, String mentor_name, float mentor_rating, int technology_id,
			String technologyname, String toc, String prerequisites, int fees, String startTime, String endTime,
			String availFrom, String availTill) {
		super();
		this.id=id;
		this.mentor_id = mentor_id;
		this.mentor_name = mentor_name;
		this.mentor_rating = mentor_rating;
		this.technology_id = technology_id;
		this.technologyname = technologyname;
		this.toc = toc;
		this.prerequisites = prerequisites;
		this.fees = fees;
		this.startTime = startTime;
		this.endTime = endTime;
		this.availFrom = availFrom;
		this.availTill = availTill;
	}
	public SearchTrainers() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
