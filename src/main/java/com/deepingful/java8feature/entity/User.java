package com.deepingful.java8feature.entity;

import java.util.Date;

public class User {

	private String firstname;
	private String latestname;
	private int age;
	private Long userid;
	private Date registerTime;
	
	public User(){
		
	}
	
	public User(String firstname, String latestname, int age, Long userid, Date registerTime) {
		super();
		this.firstname = firstname;
		this.latestname = latestname;
		this.age = age;
		this.userid = userid;
		this.registerTime = registerTime;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLatestname() {
		return latestname;
	}
	public void setLatestname(String latestname) {
		this.latestname = latestname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Long getUserid() {
		return userid;
	}
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	public Date getRegisterTime() {
		return registerTime;
	}
	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}
	@Override
	public String toString() {
		return "User [firstname=" + firstname + ", latestname=" + latestname + ", age=" + age + ", userid=" + userid
				+ ", registerTime=" + registerTime + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
		result = prime * result + ((latestname == null) ? 0 : latestname.hashCode());
		result = prime * result + ((registerTime == null) ? 0 : registerTime.hashCode());
		result = prime * result + ((userid == null) ? 0 : userid.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (age != other.age)
			return false;
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!firstname.equals(other.firstname))
			return false;
		if (latestname == null) {
			if (other.latestname != null)
				return false;
		} else if (!latestname.equals(other.latestname))
			return false;
		if (registerTime == null) {
			if (other.registerTime != null)
				return false;
		} else if (!registerTime.equals(other.registerTime))
			return false;
		if (userid == null) {
			if (other.userid != null)
				return false;
		} else if (!userid.equals(other.userid))
			return false;
		return true;
	}
	
}
