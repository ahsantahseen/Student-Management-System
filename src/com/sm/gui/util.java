package com.sm.gui;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import com.sm.datastructures.*;

public class util {
	
	private Scanner fileScanner;
	private File file;
	
	private DepartmentDS dep;
	
	public util(DepartmentDS dep) {
		this.dep = dep;
	}
	
	public int str2Int(String str) {
		return Integer.parseInt(str);
	}
	
	public float str2Float(String str) {
		return Float.parseFloat(str);
	}
	
	//FILE FORMAT: depID,depName,depHOD
	public void ReadDepartment(String path) {
		
		//@TODO: Check if file empty
		
		file = new File(path);
		try {
			fileScanner = new Scanner(file);
			while(fileScanner.hasNextLine()) {
				String line = fileScanner.nextLine();
				String p[] = line.split(",");
				this.dep.Insert(new Department(str2Int(p[0]),p[1],p[2]));
			}
		} catch (IOException e) {
			System.out.println(e);
		} fileScanner.close();
	}
	
	//FILE FORMAT: id,name,fathername,section,department
	public void ReadStudents(String path) {
		
		//@TODO: Check if file empty
		
		file = new File(path);
		try {
			fileScanner = new Scanner(file);
			while(fileScanner.hasNextLine()) {
				String line = fileScanner.nextLine();
				String p[] = line.split(",");
				this.dep.AddStudent(p[4],new Student(str2Int(p[0]),p[1],p[2],p[3]));
			}
		} catch (IOException e) {
			System.out.println(e);
		} fileScanner.close();
	}
}
