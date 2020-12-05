package com.sm.gui;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

import com.sm.datastructures.Department;
import com.sm.datastructures.DepartmentDS;

public class main {
	
	//Check getAllDepartmentData Function when head and tail left
	//Check errorLogs given make them more helpful
	
	public static void main(String args[]) {
				
		DepartmentDS dep = new DepartmentDS();
		util u = new util(dep);
		
		u.ReadDepartment("C:\\Workspace\\Ongoing\\Student-Management-System\\src\\com\\sm\\gui\\departments.txt");
		u.ReadStudents("C:\\Workspace\\Ongoing\\Student-Management-System\\src\\com\\sm\\gui\\students.txt");
		u.ReadCourses("C:\\Workspace\\Ongoing\\Student-Management-System\\src\\com\\sm\\gui\\courses.txt");
		
		
		dep.WriteDepartmentToFile("C:\\Workspace\\Ongoing\\Student-Management-System\\src\\com\\sm\\gui\\departments.txt");
	}
}
