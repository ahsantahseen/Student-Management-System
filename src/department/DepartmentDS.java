//Author: Asaad Noman
//Data: 27-11-2020
//File: DepartmentDS.java

package department;

import course.Course;
import student.Student;

class dNode {
	public Department data;
	public dNode next,prev;
	
	public dNode(Department data , dNode next , dNode prev) {
		this.data = data;
		this.next = next;
		this.prev = prev;
	}
	
	//( PREV ID || CURR ID || NEXT ID) ->
	public void Print() {
		if(prev == null && next == null) 
			System.out.print("( null " + " || " + data.name + " || " + "null ) ");
		else if(prev == null)
			System.out.print("( null " + " || " + data.name + " || " + next.data.name + " ) -> ");
		else if(next == null)
			System.out.print("( " + prev.data.name + " || " + data.name + " || null " + " )");
		else
			System.out.print("( " + prev.data.name + " || " + data.name + " || " + next.data.name + " ) -> ");
	}
}

public class DepartmentDS {
	
	private int depCount = 0;
	private dNode head , curr;
	
	//Insert department
	public void Insert(Department data) {
		dNode newNode = new dNode(data,null,null);
		if(head == null) {
			head = newNode;
			head.prev = null;
		} else {
			curr = head;
			while(curr.next != null) {
				curr = curr.next;
			} 
			newNode.prev = curr;
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
	
	//Find A Department Node by ID
	public dNode FindByName(String depName) { 
		curr = head;
		while(curr != null && curr.data.name != depName) curr = curr.next;
		if(curr.data.name == depName) return curr;
		return null;
	}
		
	//Remove the department
	public void Remove(int depID) {
		curr = head;
		dNode temp = curr;
		while(curr != null && curr.data.depID != depID) {
			temp = curr;
			curr = curr.next; depCount--;
		} if(curr.prev == null && curr.next == null) { //last node in the list
			curr = null; depCount--;
		} else if(curr.prev == null) {	//head 
			head = head.next;
			head.prev = null; depCount--;
		}  else if(curr.next == null) {  //tail
			temp.next = null;
		} else if(curr != null && curr.data.depID == depID) {  //any node in middle
			temp.next = curr.next;
			curr.next.prev = curr.prev; depCount--;
		} else { //could not find
			throw new IllegalArgumentException("COULD NOT FIND NODE IN THE LIST");
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
			throw new IllegalArgumentException("Could not find the department");
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
		else throw new IllegalArgumentException("Could not find department"); 
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
		curr = head.next;
		head.Print();
		while(curr.next != null) {
			curr.Print();
			curr = curr.next;
		} curr.Print();
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
		else throw new IllegalArgumentException("Could not find the department");
	}
	
	//Find A Department's Student By ID 
	public void FindStudentByID(String depName , int studentID) {
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
	
	public static void main(String args[]) {
		DepartmentDS dep = new DepartmentDS();
		
		dep.Insert(new Department(1,"CS"));
		dep.Insert(new Department(2,"BBA"));
		dep.Insert(new Department(3,"LLB"));
		
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
		
	}	
}
