package com.sm.datastructures;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

class sNode {
	public Student data;
	public sNode next;
	
	public sNode() {}
	public sNode(Student data , sNode next) {
		this.data = data;
		this.next = next;
	}
	
	public void Print() {
		System.out.println(data.name);
	}
}

public class StudentsDS {
	
	private int studCount = 0;
	private sNode head,curr;
	
	public void Print() {
		curr = head;
		while(curr != null) {
			curr.Print();
			curr = curr.next;
		}
	}
	
	public void Insert(Student data) {
		sNode newNode = new sNode(data,null);
		if(head == null) {
			head = newNode;
		} else {
			curr = head;
			while(curr.next != null) {
				curr = curr.next;
			} curr.next = newNode;
		} studCount++;
	}

	public void Remove(String studentName) {
		curr = head;
		sNode temp = curr;
		while (curr != null && !curr.data.name.equals(studentName)) {
			temp = curr;
			curr = curr.next;
			studCount--;
		} try {
			if (curr.data.name == head.data.name) {
				head = head.next;
			} else if (curr.data.name == studentName) {
				temp.next = curr.next;
			} else { // could not find
				throw new IllegalArgumentException("COULD NOT FIND NODE IN THE LIST");
			}
		} catch (NullPointerException e) {
			System.out.println("Sorry Canoot Delete What not Exists: Student " + studentName);
		}
	}
	
	public sNode FindByName(String studentName) {
		curr = head;
		while(curr != null) {
			if(curr.data.name.equals(studentName)) {
				return curr;
			} curr = curr.next;
		} return null;
	}
	
	public void Edit(String name , Student newData) {
		sNode search = FindByName(name);
		if(search != null) {
			search.data = newData;
		} else {
			System.out.println("Could not find Student " + name + " to edit");
		}
	}

	public int getStudentCount() { return studCount; }
	
	public void AddCourse(String studentName,Course data) {
		sNode search = FindByName(studentName);
		if(search != null) {
			data.studentName = studentName;
			search.data.courses.insertNode(data);
		}
	}
	
	public void RemoveCourse(String studentName , String courseName) {
		sNode search = FindByName(studentName);
		if(search != null) {
			search.data.courses.deleteNodeByCourseName(courseName);
		}
	}
	
	public void EditCourse(String studentName,String courseName,Course newData) {
		sNode search = FindByName(studentName);
		if(search != null) {
			newData.studentName = studentName;
			search.data.courses.EditCourse(courseName, newData);
		}
	}
	
	public void GetCourses(String studentName) {
		sNode search = FindByName(studentName);
		if(search != null) {
			search.data.courses.ViewList();
		}
	}
	
	public void FindByCourse(String courseName) {
		curr = head;
		while(curr != null) {
			if(curr.data.courses.searchByCourseName(courseName) != -1) {
				System.out.println(curr.data.name);
			} curr =curr.next;
		}
	}
	
	public void FindBySection(String section) {
		curr = head;
		while(curr != null) {
			if(curr.data.section.equals(section)) {
				System.out.println(curr.data.name);
			} curr =curr.next;
		}
	}
		
	//Get all the studentDataCount
	public int getStudentDataCount() {
		ArrayList<Student> res  = new ArrayList<>();
		curr = head;
		while(curr != null) {
			Student newData = new Student(curr.data.regID,curr.data.name,curr.data.fatherName,curr.data.section);
			newData.department = curr.data.department;
			res.add(newData);
			curr = curr.next;
		}
		return res.size();
	}
	
	//Get all the studentData
	public ArrayList<Student> getStudentData() {
		ArrayList<Student> res  = new ArrayList<>();
		curr = head;
		while(curr != null) {
			Student newData = new Student(curr.data.regID,curr.data.name,curr.data.fatherName,curr.data.section);
			newData.department = curr.data.department;
			res.add(newData);
			curr = curr.next;
		} return res;
	}
}