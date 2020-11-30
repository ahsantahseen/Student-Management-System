//Author: Asaad Noman
//Data: 27-11-2020
//File: Department.java

package department;

import student.StudentsDS;

public class Department {

	public int depID;
	public String name;
		
	public StudentsDS students;
	
	public Department() {}
	public Department(int depID , String name) {
		this.name = name;
		this.depID = depID;
		
		students = new StudentsDS();
	}
	
	public void PrintDepartment() {
		System.out.println("---------------------------------------");
		System.out.println("Printing " + name + " Department Info..");
		System.out.println("---------------------------------------");
		System.out.println("DepName: " + name);
		System.out.println("DepID: " + depID);
		System.out.println("Number of Students: " + students.getStudentCount());
	}
	
	public void PrintDepartmentStudents() {
		System.out.println("---------------------------------------");
		System.out.println("Printing " + name + " Department Students Info..");
		System.out.println("---------------------------------------");
		students.Print(students.getRoot());
	}
}
