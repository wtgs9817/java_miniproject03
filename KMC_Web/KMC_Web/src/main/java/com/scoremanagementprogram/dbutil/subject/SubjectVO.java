package com.scoremanagementprogram.dbutil.subject;

import lombok.Data;

@Data
public class SubjectVO {
	
	String id;
	String year;
	String semester;
	String course;
	String subjectName;
	String credit;
	String professor;
	String score;
	String searchCondition;
	String searchKeyword;
	
	
	
	public String getSearchCondition() {
		return searchCondition;
	}
	
	public void setSearchCondition(String con) {
		this.searchCondition = con;
	}
	
	public String getSearchKeyword() {
		return searchKeyword;
	}
	
	public void setSearchKeyword(String key) {
		this.searchKeyword = key;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getSemester() {
		return semester;
	}
	public void setSemester(String semester) {
		this.semester = semester;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public String getCredit() {
		return credit;
	}
	public void setCredit(String credit) {
		this.credit = credit;
	}
	public String getProfessor() {
		return professor;
	}
	public void setProfessor(String professor) {
		this.professor = professor;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	

}
