package com.sm.gui;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

import com.sm.datastructures.Course;
import com.sm.datastructures.Department;
import com.sm.datastructures.DepartmentDS;
import com.sm.datastructures.Student;

public class main {
	public static void main(String args[]) {	
		DepartmentDS dep = new DepartmentDS();
		util u = new util(dep);
		
		String depPath = "C:\\Workspace\\Ongoing\\Student-Management-System\\src\\com\\sm\\gui\\departments.txt";
		String studPath = "C:\\Workspace\\Ongoing\\Student-Management-System\\src\\com\\sm\\gui\\students.txt";
		String coursePath = "C:\\Workspace\\Ongoing\\Student-Management-System\\src\\com\\sm\\gui\\courses.txt";
		
		//FIRST READ FROM ALL THE FILES
		
		u.ReadDepartment(depPath);
		u.ReadStudents(studPath);
		
		//SECOND MANUPLATE DATA
		
		//dep.Insert(new Department(1,"BCS","Asif Khalid"));
		//dep.Insert(new Department(2,"LLB","Farhan"));
		//dep.Insert(new Department(3,"Mech","Shayan Ali"));
		
		//dep.AddStudent("BCS", new Student(1,"Asaad","Noman","F"));
		//dep.AddStudent("BCS", new Student(2,"Ahsan","Tahseen","F"));
		//dep.AddStudent("LLB", new Student(3,"Muhammad","Zeehan","F"));

		dep.RemoveStudent("BCS", "Ahsan");
		
		//THIRD WRITE TO THE FILES
		
		dep.WriteDepartmentToFile(depPath);
		dep.WriteStudentstoFile(studPath);
	}
}
