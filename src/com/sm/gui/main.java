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
import com.sm.datastructures.Student;

public class main {
	public static void main(String args[]) {
				
		DepartmentDS dep = new DepartmentDS();
		util u = new util(dep);
		
		String depPath = "C:\\Workspace\\Ongoing\\Student-Management-System\\src\\com\\sm\\gui\\departments.txt";
		String studPath = "C:\\Workspace\\Ongoing\\Student-Management-System\\src\\com\\sm\\gui\\students.txt";
		String coursePath = "C:\\Workspace\\Ongoing\\Student-Management-System\\src\\com\\sm\\gui\\courses.txt";
		
		u.ReadDepartment(depPath);
		u.ReadStudents(studPath);
		
		dep.RemoveStudent("BCS","Asaad");
		
		dep.WriteDepartmentToFile(depPath);
		dep.WriteStudentstoFile(studPath);
	}
}
