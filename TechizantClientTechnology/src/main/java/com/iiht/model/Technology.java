package com.iiht.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "technology")
public class Technology {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long techid;
	private String name;
	private String toc;
	private String prerequisites;
	private int fees;
	public Long getTechid() {
		return techid;
	}
	public void setTechid(Long techid) {
		this.techid = techid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public Technology(Long techid, String name, String toc, String prerequisites,int fees) {
		super();
		this.techid = techid;
		this.name = name;
		this.toc = toc;
		this.prerequisites = prerequisites;
		this.fees=fees;
	}
	public Technology() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
