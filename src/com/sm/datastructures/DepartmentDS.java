package com.sm.datastructures;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

class dNode {
	public Department data = new Department();
	public dNode next;
	
	public dNode(Department data , dNode next) {
		this.data = data;
		this.next = next;
	}
	
	public void Print() {
		System.out.println(data.name);
	}
}

public class DepartmentDS {
	
	private int depCount = 0;
	private dNode head , curr;
	
	//Insert department
	public void Insert(Department data) {
		dNode newNode = new dNode(data,null);
		if(head == null) {
			head = newNode;
		} else {
			curr = head;
			while(curr.next != null) {
				curr = curr.next;
			} 
			curr.next = newNode;
		} depCount++;
	}
	
	//Find A Department Node by ID
	public dNode FindByID(int depID) { 
		curr = head;
		while(curr != null && curr.data.depID != depID) curr = curr.next;
		if(curr.data.depID == depID) return curr;
		return null;
	}
	
	//Find A Department Node by Name
	public dNode FindByName(String depName) { 
		curr = head;
		while(curr != null) {
			if(curr.data.name.equals(depName)) { //important
				return curr;
			} curr = curr.next;
		} return null;
	}
		
	//Remove the department
	public void Remove(int depID) {
		curr = head;
		dNode temp = curr;
		while(curr != null && curr.data.depID != depID) {
			temp = curr;
			curr = curr.next; depCount--;
		} try {if(curr.data.depID == head.data.depID) {
			head = head.next;
		} else if(curr.data.depID == depID) {
			temp.next = curr.next;
		} else { //could not find
			throw new IllegalArgumentException("COULD NOT FIND NODE IN THE LIST");
		} } catch(NullPointerException e) {
			System.out.println("Sorry Canoot Delete What not Exists: DepID " + depID);
		}
	}
	
	//Edit the department
	public void Edit(String depName , String newName , String newHod) {
		dNode search = FindByName(depName);
		if(search != null) {
			search.data.name = newName;
			search.data.hod = newHod;
		} else {
			System.out.println("Could not find Dep to Edit: " + depName);
		}
	}
	
	//Returns the total number of departments under the uni
	public int getDepartmentCount() { return depCount; }
	
	//Add Student to a department .. DepName and student data
	public void AddStudent(String depName,Student data) {
		dNode search = FindByName(depName);
		if(search != null) {
			data.department = depName;
			search.data.students.Insert(data);	
		} else {
			System.out.println("Could not find the departmen to addStudent " + data.name + " " + depName);
		}
	}
	
	//Remove Student from department
	public void RemoveStudent(String depName , int studentID) {
		dNode search = FindByName(depName);
		if(search != null) search.data.students.RemoveByID(studentID);
		else throw new IllegalArgumentException("Could not find department");
	}
	
	//Insert Course of student
	public void AddCourse(String depName , int studentID , Course data) {
		dNode searchNode = FindByName(depName);
		if(searchNode != null) searchNode.data.students.AddCourse(studentID, data);
		else System.out.println("Could not find the department " + depName + " To add course of studentID: " + studentID + " " + data.getCourseName());
	}
	
	//Remove course of student
	public void RemoveCourse(String depName , int StudentID , String courseName) {
		dNode searchNode = FindByName(depName);
		if(searchNode != null) searchNode.data.students.RemoveCourseByName(StudentID, courseName);
		else throw new IllegalArgumentException("Could not find department"); 
	}
	
	//Edit student
	public void EditStudent(String depName , int studentID , Student newData) {
		dNode searchNode = FindByName(depName);
		if(searchNode != null) searchNode.data.students.Edit(studentID, newData);
		else throw new IllegalArgumentException("Could not find department"); 
	}
	
	//Edit course of student
	public void EditCourse(String depName , int studentID , int courseID , Course newData) {
		dNode searchNode = FindByName(depName);
		if(searchNode != null) searchNode.data.students.EditCourse(studentID, courseID, newData);
	}
	
	//Print all the departments in doubly linked list form
	//@NOTE: this does not work when a single node is left .. need to handle that case [ NOT IMPORTANT ]
	public void Print() {
		curr = head;
		while(curr != null) {
			curr.Print();
			curr = curr.next;
		}
	}
		
	//Print a Certain departments Info
	public void PrintDepartmentInfo(String depName) {
		dNode search = FindByName(depName);
		if(search != null) search.data.PrintDepartment();
		else throw new IllegalArgumentException("Could not find the department");
	}
	
	//Print a Certain Departments Whole Student Info
	public void PrintDepartmentStudentsInfo(String depName) {
		dNode search = FindByName(depName);
		if(search != null) search.data.PrintDepartmentStudents();
		else throw new IllegalArgumentException("Could not find the department " + depName);
	}
	
	//Find A Department's Student Courses By ID 
	public void FindStudentCoursesByID(String depName , int studentID) {
		dNode search = FindByName(depName);
		if(search != null) search.data.students.GetCourses(studentID);
		else throw new IllegalArgumentException("Could not find the department");
	}
	
	//Find Students By Section
	public void FindBySection(String depName , String section) {
		dNode searchNode = FindByName(depName);
		if(searchNode != null) {
			searchNode.data.students.FindBySection(section);
		}
	}
	
	//Find Students Taking a Certain course in a department
	public void FindByCourseName(String depName , String courseName) {
		dNode searchNode = FindByName(depName);
		if(searchNode != null) {
			searchNode.data.students.FindByCourse(courseName);
		}
	}
	
	//@NOTE: CHECK THIS FUNCTION OUT WHEN HEAD AND TAIL ARE ONLY LEFT
	private ArrayList<Department> getAllDepartmentData() {
		ArrayList<Department> result = new ArrayList<>();		
		curr = head;
		while(curr != null) {
			result.add(new Department(curr.data.depID,curr.data.name,curr.data.hod));
			curr = curr.next;
		}  return result;
	}
	
	
	public void WriteDepartmentToFile(String path) {
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(path, "UTF-8");
			ArrayList<Department> data = getAllDepartmentData();
			for (int i = 0; i <= data.size() - 1; i++) {
				String f = data.get(i).depID + "," + data.get(i).name + "," + data.get(i).hod;
				writer.println(f);
			} writer.close();
		} catch (IOException e) {
			System.out.println(e);
		}
	}
		
	
	/*
	public static void main(String args[]) {
		DepartmentDS dep = new DepartmentDS();
		
	//	dep.Insert(new Department(1,"CS"));
	//	dep.Insert(new Department(2,"BBA"));
	//	dep.Insert(new Department(3,"LLB"));
		
		dep.AddStudent("CS", new Student(1912297, "Asaad", "Noman", "F"));
		dep.AddStudent("CS", new Student(1912298, "Ahsan", "Khan", "G"));
		dep.AddStudent("CS", new Student(56656, "Ali", "Noman", "F"));

		dep.AddStudent("BBA", new Student(191284, "Shayan", "Ali", "F"));
		dep.AddStudent("LLB", new Student(195555, "Moiz", "Khan", "G"));
		
		dep.AddCourse("CS", 1912297, new Course(1, "DLD", 3, 300, 100));
		//dep.RemoveCourse("CS", 1912297, "DLD");
		dep.AddCourse("CS", 1912298, new Course(1,"DLD",3,300,240));
		
		dep.EditStudent("CS", 1912297, new Student(1912297,"Ahmed","Noman","F"));
		//dep.EditCourse("CS", 1912297, 1, new Course(1,"FLD",2,100,90));
		
		//dep.PrintDepartmentInfo("CS");
		//dep.PrintDepartmentStudentsInfo("CS");
		//dep.FindStudentByID("CS", 1912297);
		
		//dep.FindBySection("CS", "#");
		
		//dep.Print();
		
		dep.FindByCourseName("CS", "FLD");
		
	}*/	
}
