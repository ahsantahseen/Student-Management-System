package com.sm.datastructures;

public class Student {
	public int regID;
	public String name,fatherName,department,section;
	
	public CourseDS courses = new CourseDS();
	
	public Student(int regID,String name,String fatherName,String section) {
		this.name = name;
		this.fatherName = fatherName;
		this.department = "";
		this.section = section;
		this.regID = regID;
	}
	
	public String toString() {
		return regID + " " + name + " " + fatherName + " " + department + " " + section;
	}
}