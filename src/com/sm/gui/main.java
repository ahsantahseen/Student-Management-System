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
		int selectedOption=-1;
		Scanner sc=new Scanner(System.in);
		DepartmentDS dep = new DepartmentDS();
		util u = new util(dep);
		
		String depPath = "C:\\Users\\Home\\Downloads\\Student-Management-System-main\\Student-Management-System-main\\src\\com\\sm\\gui\\departments.txt";
		String studPath = "C:\\Users\\Home\\Downloads\\Student-Management-System-main\\Student-Management-System-main\\src\\com\\sm\\gui\\students.txt";
		
		
		
		
	      u.ReadDepartment(depPath);
		  u.ReadStudents(studPath);
		
		
	
		
		
		
		
		while(selectedOption!=15) {
		System.out.println("============================");
	    System.out.println("|Student Management System |");
	    System.out.println("============================");
	    System.out.println("|                          |");
	    System.out.println("|  1. View Departments     |");
	    System.out.println("|  2. Insert Departments   |");
	    System.out.println("|  3. Remove Departments   |");
	    System.out.println("|  4. Edit Departments     |");
	    System.out.println("|  5. Search Departments   |");
	    System.out.println("|  6. View Students        |");
	    System.out.println("|  7. Insert Students      |");
	    System.out.println("|  8. Remove Students      |");
	    System.out.println("|  9. Edit Students        |");
	    System.out.println("|  10. Search Student      |");
	    System.out.println("|  11. Insert Course       |");
	    System.out.println("|  12. Edit Course         |");
	    System.out.println("|  13. Remove Course       |");
	    System.out.println("|  14. Search Courses      |");
	    System.out.println("|      of Student          |");
	    System.out.println("|  15. Exit                |");
	    System.out.println("============================");
	    System.out.println(" Select main option : ");
		selectedOption = sc.nextInt(); //takes number input for option selection
	    System.out.println("============================");
		if(selectedOption==1) {
			dep.Print();
		}
		else if(selectedOption==2) {
			 System.out.println("Enter Department ID:");
	         int id=sc.nextInt();
	         System.out.println("Enter Department Name:");
	         String name=sc.nextLine()+sc.next();
	         System.out.println("Enter Department HOD:");
	         String hod=sc.nextLine()+sc.next();
	         dep.Insert(new Department(id, name, hod));
	         
		}
		else if(selectedOption==3) {
			System.out.println("Enter Department Name:");
			String name=sc.nextLine()+sc.next();
			dep.Remove(name);
	        
		}
		else if(selectedOption==4) {
			System.out.println("Enter Department Name (for edit):");
			String name=sc.nextLine()+sc.next();
			System.out.println("Enter Department New Name:");
	         String newName=sc.nextLine()+sc.next();
	         System.out.println("Enter Department New HOD:");
	         String newHod=sc.nextLine()+sc.next();
			dep.Edit(name, newName, newHod);
		}
		else if(selectedOption==5) {
			System.out.println("Enter Department Name (for search):");
			String name=sc.nextLine()+sc.next();
			dep.PrintDepartmentInfo(name);
		}
		else if(selectedOption==6) {
			System.out.println("Enter Department Name (for search):");
			String name=sc.nextLine()+sc.next();
			dep.PrintDepartmentStudentsInfo(name);
		}
		else if(selectedOption==7) {
			System.out.println("Enter Department Name (for insertion):");
			String name=sc.nextLine()+sc.next();
			System.out.println("Enter Student ID:");
	         int id=sc.nextInt();
	         System.out.println("Enter Student Name:");
	         String Stdname=sc.nextLine()+sc.next();
	         System.out.println("Enter Student Father Name:");
	         String StdFname=sc.nextLine()+sc.next();
	         System.out.println("Enter Student Section:");
	         String StdSect=sc.nextLine()+sc.next();
			dep.AddStudent(name, new Student(id, Stdname, StdFname, StdSect));
		}
		else if(selectedOption==8) {
			System.out.println("Enter Department Name (for deletion):");
			String DepName=sc.nextLine()+sc.next();
			System.out.println("Enter Student Name (for deletion):");
			String Stdname=sc.nextLine()+sc.next();
			dep.RemoveStudent(DepName, Stdname);
		}
		else if(selectedOption==9) {
			System.out.println("Enter Department Name (for edit):");
			String DepName=sc.nextLine()+sc.next();
			System.out.println("Enter Student Name (for edit):");
			String Stdname=sc.nextLine()+sc.next();
			System.out.println("Enter Student New ID:");
	         int Newid=sc.nextInt();
	         System.out.println("Enter Student New Name:");
	         String NewStdname=sc.nextLine()+sc.next();
	         System.out.println("Enter Student Father New Name:");
	         String NewStdFname=sc.nextLine()+sc.next();
	         System.out.println("Enter Student New Section:");
	         String NewStdSect=sc.nextLine()+sc.next();
			dep.EditStudent(DepName, Stdname,new Student(Newid, NewStdname,NewStdFname, NewStdSect));
			
		}
		else if(selectedOption==10) {
			System.out.println("Enter Department Name (for search):");
			String DepName=sc.nextLine()+sc.next();
			System.out.println("Enter Student Name (for search):");
			String Stdname=sc.nextLine()+sc.next();
			dep.FindStudentInDepartment(DepName, Stdname);
		}
		else if(selectedOption==11) {
			System.out.println("Enter Department Name (for insertion):");
			String DepName=sc.nextLine()+sc.next();
			System.out.println("Enter Student Name (for insertion):");
			String name=sc.nextLine()+sc.next();
			System.out.println("Enter Course ID:");
	         int CRSid=sc.nextInt();
	         System.out.println("Enter Course Name:");
	         String CRSname=sc.nextLine()+sc.next();
	         System.out.println("Enter Course Credit Hrs:");
	         int CRSCreditHrs=sc.nextInt();
	         System.out.println("Enter Obtained Marks in Course:");
	         float obtainedMarks=sc.nextFloat();
	         float totalMarks=100f; // By default
	         dep.AddCourse(DepName, name, new Course(CRSid, CRSname, CRSCreditHrs, totalMarks, obtainedMarks));
		}
		else if(selectedOption==12) {
			System.out.println("Enter Department Name (for edit):");
			String DepName=sc.nextLine()+sc.next();
			System.out.println("Enter Student Name (for edit):");
			String name=sc.nextLine()+sc.next();
			System.out.println("Enter Course Name:");
	        String OldCRSname=sc.nextLine()+sc.next();
	        System.out.println("Enter New Course ID:");
	        int CRSid=sc.nextInt();
	        System.out.println("Enter New Course Name:");
	        String CRSname=sc.nextLine()+sc.next();
	        System.out.println("Enter New Course Credit Hrs:");
	        int CRSCreditHrs=sc.nextInt();
	        System.out.println("Enter New Obtained Marks in Course:");
	        float obtainedMarks=sc.nextFloat();
	        float totalMarks=100f; // By default
	        dep.EditCourse(DepName, name, OldCRSname, new Course(CRSid, CRSname, CRSCreditHrs, totalMarks, obtainedMarks));
			
		}
		else if(selectedOption==13) {
			System.out.println("Enter Department Name (for remove):");
			String DepName=sc.nextLine()+sc.next();
			System.out.println("Enter Student Name (for remove):");
			String name=sc.nextLine()+sc.next();
			System.out.println("Enter Course Name (for remove):");
	        String CRSname=sc.nextLine()+sc.next();
	        dep.RemoveCourse(DepName, name, CRSname);
		}
		else if(selectedOption==14) {
			System.out.println("Enter Department Name (for search):");
			String DepName=sc.nextLine()+sc.next();
			System.out.println("Enter Student Name (for search):");
			String name=sc.nextLine()+sc.next();
			dep.FindStudentCoursesByID(DepName, name);
		}
		
	}
		dep.WriteDepartmentToFile(depPath);
		dep.WriteStudentstoFile(studPath);

	}
}
