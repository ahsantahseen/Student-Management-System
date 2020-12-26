package com.sm.datastructures;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

class dNode {
	public Department data = new Department();
	public dNode next;

	public dNode() {}

	public dNode(Department data, dNode next) {
		this.data = data;
		this.next = next;
	}

	public void Print() {
		System.out.println(data.name + " | Students: " + data.students.getStudentCount());
	}
}

public class DepartmentDS {

	private int depCount = 0;
	private dNode head, curr;

	// Insert department
	public void Insert(Department data) {
		dNode newNode = new dNode(data, null);
		if (head == null) {
			head = newNode;
		} else {
			curr = head;
			while (curr.next != null) {
				curr = curr.next;
			}
			curr.next = newNode;
		}
		depCount++;
	}

	// Find A Department Node by ID
	public dNode FindByID(int depID) {
		curr = head;
		while (curr != null && curr.data.depID != depID)
			curr = curr.next;
		if (curr.data.depID == depID)
			return curr;
		return null;
	}

	// Find A Department Node by Name
	public dNode FindByName(String depName) {
		curr = head;
		while (curr != null) {
			if (curr.data.name.equals(depName)) { // important
				return curr;
			}
			curr = curr.next;
		}
		return null;
	}

	// DO THIS BY NAME
	// Remove the department
	public void Remove(String depName) {
		curr = head;
		dNode temp = curr;
		while (curr != null && !curr.data.name.equals(depName)) {
			temp = curr;
			curr = curr.next;
			depCount--;
		}
		try {
			if (curr.data.name.equals(head.data.name)) {
				head = head.next;
			} else if (curr.data.name.equals(depName)) {
				temp.next = curr.next;
			} else { // could not find
				System.out.println("Could not find Node @ Remove Function");
			}
		} catch (NullPointerException e) {
			System.out.println("Sorry Canoot Delete What not Exists: DepName " + depName);
		}
	}

	// Edit the department
	public void Edit(String depName, String newName, String newHod) {
		dNode search = FindByName(depName);
		if (search != null) {
			search.data.name = newName;
			search.data.hod = newHod;
		} else {
			System.out.println("Could not find Dep to Edit: " + depName);
		}
	}

	// Returns the total number of departments under the uni
	public int getDepartmentCount() {
		return depCount;
	}

	// Add Student to a department .. DepName and student data
	public void AddStudent(String depName, Student data) {
		dNode search = FindByName(depName);
		if (search != null) {
			data.department = depName;
			search.data.students.Insert(data);
		} else {
			System.out.println("Could not find the departmen to addStudent " + data.name + " " + depName);
		}
	}

	// Remove Student from department
	public void RemoveStudent(String depName, String studentName) {
		dNode search = FindByName(depName);
		if (search != null)
			search.data.students.Remove(studentName);
		else
			System.out.println("Could not find the departmen " + depName + "to Remove " + studentName);
	}

	// Insert Course of student
	public void AddCourse(String depName, String studentName, Course data) {
		dNode searchNode = FindByName(depName);
		if (searchNode != null)
			searchNode.data.students.AddCourse(studentName, data);
		else
			System.out.println("Could not find the department " + depName + " To add course of student: " + studentName
					+ " " + data.getCourseName());
	}

	// Remove course of student
	public void RemoveCourse(String depName, String StudentName, String courseName) {
		dNode searchNode = FindByName(depName);
		if (searchNode != null)
			searchNode.data.students.RemoveCourse(StudentName, courseName);
		else
			System.out.println("Could not find Department @ Remove Course");
	}

	// Edit student
	public void EditStudent(String depName, String studentName, Student newData) {
		dNode searchNode = FindByName(depName);
		if (searchNode != null) {
			newData.department = depName;
			searchNode.data.students.Edit(studentName, newData);
		} else
			System.out.println("Could not find Department @ Edit Student Function");
	}

	// Edit course of student
	public void EditCourse(String depName, String studentName, String courseName, Course newData) {
		dNode searchNode = FindByName(depName);
		if (searchNode != null)
			searchNode.data.students.EditCourse(studentName, courseName, newData);
	}

	// Print all the departments in doubly linked list form
	// @NOTE: this does not work when a single node is left .. need to handle that
	// case [ NOT IMPORTANT ]
	public void Print() {
		curr = head;
		while (curr != null) {
			curr.Print();
			curr = curr.next;
		}
	}

	// Print a Certain departments Info
	public void PrintDepartmentInfo(String depName) {
		dNode search = FindByName(depName);
		if (search != null)
			search.data.PrintDepartment();
		else
			System.out.println("Could not Find Department " + depName + " to Print Info About");
	}

	// Print a Certain Departments Whole Student Info
	public void PrintDepartmentStudentsInfo(String depName) {
		dNode search = FindByName(depName);
		if (search != null)
			search.data.PrintDepartmentStudents();
		else
			System.out.println("Could not find Department @ Print Departments Studenent Info Function");
	}

	// Find A Department's Student Courses By Name
	public void FindStudentCoursesByName(String depName, String studentName) {
		dNode search = FindByName(depName);
		if (search != null)
			search.data.students.GetCourses(studentName);
		else
			System.out.println("Could not find Department @ FindStudentsCoursesByName");

	}

	// Find Student in Department

	public void FindStudentInDepartment(String depName, String studentName) {
		dNode search = FindByName(depName);
		if (search != null)
			search.data.students.FindStudentByName(studentName);
		else
			System.out.println("Department not found!");
	}

	// Find Students By Section
	public void FindBySection(String depName, String section) {
		dNode searchNode = FindByName(depName);
		if (searchNode != null) {
			searchNode.data.students.FindBySection(section);
		}
	}

	// Find Students Taking a Certain course in a department
	public void FindByCourseName(String depName, String courseName) {
		dNode searchNode = FindByName(depName);
		if (searchNode != null) {
			searchNode.data.students.FindByCourse(courseName);
		}
	}

	private ArrayList<Department> getAllDepartmentData() {
		ArrayList<Department> result = new ArrayList<>();
		curr = head;
		while (curr != null) {
			result.add(new Department(curr.data.depID, curr.data.name, curr.data.hod));
			curr = curr.next;
		}
		return result;
	}

	public void WriteDepartmentToFile(String path) {
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(path, "UTF-8");
			ArrayList<Department> data = getAllDepartmentData();
			for (int i = 0; i <= data.size() - 1; i++) {
				String f = data.get(i).depID + "," + data.get(i).name + "," + data.get(i).hod;
				writer.println(f);
			}
			writer.close();
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	// this should give an array list of students from every department
	public ArrayList<Student> GetAllStudentData() {
		ArrayList<Student> result = new ArrayList<>();
		curr = head;
		while (curr != null) {
			ArrayList<Student> theData = curr.data.students.getStudentData();
			for (int i = 0; i <= curr.data.students.getStudentDataCount() - 1; i++) {
				result.add(theData.get(i));
			}
			curr = curr.next;
		}
		return result;
	}

	// This writes the student data to the file
	public void WriteStudentstoFile(String path) {
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(path, "UTF-8");
			ArrayList<Student> data = GetAllStudentData();
			for (int i = 0; i <= data.size() - 1; i++) {
				String f = data.get(i).regID + "," + data.get(i).name + "," + data.get(i).fatherName + ","
						+ data.get(i).section + "," + data.get(i).department;
				writer.println(f);
			}
			writer.close();
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	// This returns the current student count in a department
	public int getDepartmentStudentCount(String depName) {
		dNode searchNode = FindByName(depName);
		if (searchNode != null)
			return searchNode.data.students.getStudentCount();
		else
			System.out.println("Could not find dep on getDepartmentStudentCount(): " + depName);
		return 0;
	}

	// This basically bubble sorts the linked list according to the student count
	// (Low -> High)
	// This swaps the data not the nodes in memory
	public void SortDepartmentsAscending() {
		curr = head;
		while (curr.next != null) {
			if (curr.data.students.getStudentCount() > curr.next.data.students.getStudentCount()) {
				Department tempData = curr.data;
				curr.data = curr.next.data;
				curr.next.data = tempData;
			} curr = curr.next;
		}
	}

}
