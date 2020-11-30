//Author: Asaad Noman
//Data: 30-11-2020
//File: Student.java

package student;

import course.CourseDS;

public class Student {

	public int regID;
	public String name,fatherName,department,section;
	
	public CourseDS courses;
	
	public Student(int regID , String name , String fatherName , String section) {
		this.name = name;
		this.fatherName = fatherName;
		this.department = " ";
		this.section = section;
		this.regID = regID;
		courses = new CourseDS();
	}

	public String toString() {
		return regID + " " + name + " " + fatherName + " " + department + " " + section;
	 }
}
