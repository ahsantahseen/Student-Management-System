package com.sm.datastructures;

public class Department {

	public int depID = 0;
	public String name = " ";
	public String hod = " ";
	
	public StudentsDS students;
	
	public Department() {}
	public Department(int depID , String name,String hod) {
		this.name = name;
		this.depID = depID;
		this.hod = hod;
		
		students = new StudentsDS();
	}
	
	public void PrintDepartment() {
		System.out.println("---------------------------------------");
		System.out.println("Printing " + name + " Department Info..");
		System.out.println("---------------------------------------");
		System.out.println("DepName: " + name);
		System.out.println("DepID: " + depID);
		System.out.println("Dep HOD: " + hod);
		System.out.println("Number of Students: " + students.getStudentCount());
	}
	
	public void PrintDepartmentStudents() {
		System.out.println("---------------------------------------");
		System.out.println("Printing " + name + " Department Students Info..");
		System.out.println("---------------------------------------");
		students.Print(students.getRoot());
	}
}
