package com.sm.gui;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.sm.datastructures.Course;
import com.sm.datastructures.Department;
import com.sm.datastructures.DepartmentDS;
import com.sm.datastructures.Student;

public class main {

	public void DeptMenu() {
		int selectedOption = -1;
		Scanner sc = new Scanner(System.in);
		DepartmentDS dep = new DepartmentDS();
		util u = new util(dep);

		String depPath = "C:\\Users\\Ahsan Tahseen\\Downloads\\Student-Management-System-main (2)\\Student-Management-System-main\\src\\com\\sm\\gui\\departments.txt";

		u.ReadDepartment(depPath);

		while (selectedOption != 7) {
			System.out.println("============================");
			System.out.println("|     Department Menu      |");
			System.out.println("============================");
			System.out.println("|                          |");
			System.out.println("|  1. View Departments     |");
			System.out.println("|  2. Insert Departments   |");
			System.out.println("|  3. Remove Departments   |");
			System.out.println("|  4. Edit Departments     |");
			System.out.println("|  5. Search Departments   |");
			System.out.println("|  6. View Department from |");
			System.out.println("| Strength wise(low->high) |");
			System.out.println("|  7. Exit                 |");
			System.out.println("|                          |");
			System.out.println("============================");
			System.out.println(" Select main option : ");
			try {
				selectedOption = sc.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("============================");
				System.out.println("|  System Error Detected   |");
				System.out.println("============================");
				System.out.println("|                          |");
				System.out.println("|Error: Invalid Input      |");
				System.out.println("|Program Status:Terminated |");
				System.out.println("|                          |");
				System.out.println("============================");
				break;
			}
			// takes number input for option selection
			System.out.println("============================");
			if (selectedOption == 1) {
				dep.Print();
			} else if (selectedOption == 2) {
				int id;
				System.out.println("Enter Department ID:");
				try {
					id = sc.nextInt();
				} catch (InputMismatchException e) {
					System.out.println("============================");
					System.out.println("|  System Error Detected   |");
					System.out.println("============================");
					System.out.println("|                          |");
					System.out.println("|Error: Invalid Input      |");
					System.out.println("|Program Status:Terminated |");
					System.out.println("|                          |");
					System.out.println("============================");
					break;
				}
				System.out.println("Enter Department Name:");
				String name = sc.next() + sc.nextLine();
				System.out.println("Enter Department HOD:");
				String hod = sc.next() + sc.nextLine();
				dep.Insert(new Department(id, name, hod));

			} else if (selectedOption == 3) {
				System.out.println("Enter Department Name:");
				String name = sc.next() + sc.nextLine();
				dep.Remove(name);

			} else if (selectedOption == 4) {
				System.out.println("Enter Department Name (for edit):");
				String name = sc.next() + sc.nextLine();
				System.out.println("Enter Department New Name:");
				String newName = sc.next() + sc.nextLine();
				System.out.println("Enter Department New HOD:");
				String newHod = sc.next() + sc.nextLine();
				dep.Edit(name, newName, newHod);

			} else if (selectedOption == 5) {
				System.out.println("Enter Department Name (for search):");
				String name = sc.next() + sc.nextLine();
				dep.PrintDepartmentInfo(name);
			} else if (selectedOption == 6) {
				dep.SortDepartmentsAscending();

			}
		}
		dep.WriteDepartmentToFile(depPath);
	}

	public void StudentMenu() {
		int selectedOption = -1;
		Scanner sc = new Scanner(System.in);
		DepartmentDS dep = new DepartmentDS();
		util u = new util(dep);

		String studPath = "C:\\Users\\Ahsan Tahseen\\Downloads\\Student-Management-System-main (2)\\Student-Management-System-main\\src\\com\\sm\\gui\\students.txt";

		String depPath = "C:\\Users\\Ahsan Tahseen\\Downloads\\Student-Management-System-main (2)\\Student-Management-System-main\\src\\com\\sm\\gui\\departments.txt";

		u.ReadDepartment(depPath);
		u.ReadStudents(studPath);

		while (selectedOption != 6) {
			System.out.println("============================");
			System.out.println("|       Student Menu       |");
			System.out.println("============================");
			System.out.println("|                          |");
			System.out.println("|  1. View Student         |");
			System.out.println("|  2. Insert Student       |");
			System.out.println("|  3. Remove Student       |");
			System.out.println("|  4. Edit Student         |");
			System.out.println("|  5. Search Student       |");
			System.out.println("|  6. Exit                 |");
			System.out.println("|                          |");
			System.out.println("============================");
			System.out.println(" Select main option : ");
			try {
				selectedOption = sc.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("============================");
				System.out.println("|  System Error Detected   |");
				System.out.println("============================");
				System.out.println("|                          |");
				System.out.println("|Error: Invalid Input      |");
				System.out.println("|Program Status:Terminated |");
				System.out.println("|                          |");
				System.out.println("============================");
				break;
			}
			; // takes number input for option selection
			System.out.println("============================");
			if (selectedOption == 1) {
				System.out.println("Enter Department Name (for search):");
				String name = sc.next() + sc.nextLine();
				dep.PrintDepartmentStudentsInfo(name);
			} else if (selectedOption == 2) {
				System.out.println("Enter Department Name (for insertion):");
				String name = sc.next() + sc.nextLine();
				System.out.println("Enter Student ID:");
				int id;

				try {
					id = sc.nextInt();
				} catch (InputMismatchException e) {
					System.out.println("============================");
					System.out.println("|  System Error Detected   |");
					System.out.println("============================");
					System.out.println("|                          |");
					System.out.println("|Error: Invalid Input      |");
					System.out.println("|Program Status:Terminated |");
					System.out.println("|                          |");
					System.out.println("============================");
					break;
				}
				System.out.println("Enter Student Name:");
				String Stdname = sc.next() + sc.nextLine();
				System.out.println("Enter Student Father Name:");
				String StdFname = sc.next() + sc.nextLine();
				System.out.println("Enter Student Section:");
				String StdSect = sc.next() + sc.nextLine();
				dep.AddStudent(name, new Student(id, Stdname, StdFname, StdSect));
			} else if (selectedOption == 3) {
				System.out.println("Enter Department Name (for deletion):");
				String DepName = sc.next() + sc.nextLine();
				System.out.println("Enter Student Name (for deletion):");
				String Stdname = sc.next() + sc.nextLine();
				dep.RemoveStudent(DepName, Stdname);
			} else if (selectedOption == 4) {
				System.out.println("Enter Department Name (for edit):");
				String DepName = sc.next() + sc.nextLine();
				System.out.println("Enter Student Name (for edit):");
				String Stdname = sc.next() + sc.nextLine();
				int Newid;
				System.out.println("Enter Student New ID:");
				try {
					Newid = sc.nextInt();
				} catch (InputMismatchException e) {
					System.out.println("============================");
					System.out.println("|  System Error Detected   |");
					System.out.println("============================");
					System.out.println("|                          |");
					System.out.println("|Error: Invalid Input      |");
					System.out.println("|Program Status:Terminated |");
					System.out.println("|                          |");
					System.out.println("============================");
					break;
				}
				System.out.println("Enter Student New Name:");
				String NewStdname = sc.next() + sc.nextLine();
				System.out.println("Enter Student Father New Name:");
				String NewStdFname = sc.next() + sc.nextLine();
				System.out.println("Enter Student New Section:");
				String NewStdSect = sc.next() + sc.nextLine();
				dep.EditStudent(DepName, Stdname, new Student(Newid, NewStdname, NewStdFname, NewStdSect));

			} else if (selectedOption == 5) {
				System.out.println("Enter Department Name (for search):");
				String DepName = sc.next() + sc.nextLine();
				System.out.println("Enter Student Name (for search):");
				String Stdname = sc.next() + sc.nextLine();
				dep.FindStudentInDepartment(DepName, Stdname);
			}
		}
		dep.WriteStudentstoFile(studPath);
		dep.WriteDepartmentToFile(depPath);

	}

	public void CourseMenu() {
		int selectedOption = -1;
		Scanner sc = new Scanner(System.in);
		DepartmentDS dep = new DepartmentDS();
		while (selectedOption != 5) {
			System.out.println("============================");
			System.out.println("|     Course Menu          |");
			System.out.println("============================");
			System.out.println("|                          |");
			System.out.println("|  1. Insert Course        |");
			System.out.println("|  2. Remove Course        |");
			System.out.println("|  3. Edit Course          |");
			System.out.println("|  4. Search Courses       |");
			System.out.println("|      of Student          |");
			System.out.println("|  5. Exit                 |");
			System.out.println("|                          |");
			System.out.println("============================");
			System.out.println(" Select main option : ");
			try {
				selectedOption = sc.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("============================");
				System.out.println("|  System Error Detected   |");
				System.out.println("============================");
				System.out.println("|                          |");
				System.out.println("|Error: Invalid Input      |");
				System.out.println("|Program Status:Terminated |");
				System.out.println("|                          |");
				System.out.println("============================");
				break;
			} // takes number input for option selection
			System.out.println("============================");
			if (selectedOption == 1) {
				System.out.println("Enter Department Name (for insertion):");
				String DepName = sc.next() + sc.nextLine();
				System.out.println("Enter Student Name (for insertion):");
				String name = sc.next() + sc.nextLine();
				int CRSid;
				System.out.println("Enter Course ID:");
				try {
					CRSid = sc.nextInt();
				} catch (InputMismatchException e) {
					System.out.println("============================");
					System.out.println("|  System Error Detected   |");
					System.out.println("============================");
					System.out.println("|                          |");
					System.out.println("|Error: Invalid Input      |");
					System.out.println("|Program Status:Terminated |");
					System.out.println("|                          |");
					System.out.println("============================");
					break;
				}
				System.out.println("Enter Course Name:");
				String CRSname = sc.next() + sc.nextLine();
				int CRSCreditHrs;
				System.out.println("Enter Course Credit Hours:");
				try {
					CRSCreditHrs = sc.nextInt();
				} catch (InputMismatchException e) {
					System.out.println("============================");
					System.out.println("|  System Error Detected   |");
					System.out.println("============================");
					System.out.println("|                          |");
					System.out.println("|Error: Invalid Input      |");
					;
					System.out.println("|Program Status:Terminated |");
					System.out.println("|                          |");
					System.out.println("============================");
					break;
				}
				float obtainedMarks;
				System.out.println("Enter New Course Obatained Marks:");
				try {
					obtainedMarks = sc.nextFloat();
				} catch (InputMismatchException e) {
					System.out.println("============================");
					System.out.println("|  System Error Detected   |");
					System.out.println("============================");
					System.out.println("|                          |");
					System.out.println("|Error: Invalid Input      |");
					System.out.println("|Program Status:Terminated |");
					System.out.println("|                          |");
					System.out.println("============================");
					break;
				}
				float totalMarks = 100f; // By default
				dep.AddCourse(DepName, name, new Course(CRSid, CRSname, CRSCreditHrs, totalMarks, obtainedMarks));
			} else if (selectedOption == 2) {
				System.out.println("Enter Department Name (for edit):");
				String DepName = sc.next() + sc.nextLine();
				System.out.println("Enter Student Name (for edit):");
				String name = sc.next() + sc.nextLine();
				System.out.println("Enter Course Name:");
				String OldCRSname = sc.next() + sc.nextLine();
				int CRSid;
				System.out.println("Enter New Course ID:");
				try {
					CRSid = sc.nextInt();
				} catch (InputMismatchException e) {
					System.out.println("============================");
					System.out.println("|  System Error Detected   |");
					System.out.println("============================");
					System.out.println("|                          |");
					System.out.println("|Error: Invalid Input      |");
					System.out.println("|Program Status:Terminated |");
					System.out.println("|                          |");
					System.out.println("============================");
					break;
				}
				System.out.println("Enter New Course Name:");
				String CRSname = sc.next() + sc.nextLine();
				int CRSCreditHrs;
				System.out.println("Enter New Course Credit Hours:");
				try {
					CRSCreditHrs = sc.nextInt();
				} catch (InputMismatchException e) {
					System.out.println("============================");
					System.out.println("|  System Error Detected   |");
					System.out.println("============================");
					System.out.println("|                          |");
					System.out.println("|Error: Invalid Input      |");
					System.out.println("|Program Status:Terminated |");
					System.out.println("|                          |");
					System.out.println("============================");
					break;
				}
				float obtainedMarks;
				System.out.println("Enter New Course Obatained Marks:");
				try {
					obtainedMarks = sc.nextFloat();
				} catch (InputMismatchException e) {
					System.out.println("============================");
					System.out.println("|  System Error Detected   |");
					System.out.println("============================");
					System.out.println("|                          |");
					System.out.println("|Error: Invalid Input      |");
					System.out.println("|Program Status:Terminated |");
					System.out.println("|                          |");
					System.out.println("============================");
					break;
				}
				float totalMarks = 100f; // By default
				dep.EditCourse(DepName, name, OldCRSname,
						new Course(CRSid, CRSname, CRSCreditHrs, totalMarks, obtainedMarks));

			} else if (selectedOption == 3) {
				System.out.println("Enter Department Name (for remove):");
				String DepName = sc.next() + sc.nextLine();
				System.out.println("Enter Student Name (for remove):");
				String name = sc.next() + sc.nextLine();
				System.out.println("Enter Course Name (for remove):");
				String CRSname = sc.next() + sc.nextLine();
				dep.RemoveCourse(DepName, name, CRSname);
			} else if (selectedOption == 4) {
				System.out.println("Enter Department Name (for search):");
				String DepName = sc.next() + sc.nextLine();
				System.out.println("Enter Student Name (for search):");
				String name = sc.next() + sc.nextLine();
				dep.FindStudentCoursesByName(DepName, name);
			}

		}
	}

	public static void main(String args[]) {
		int selectedOption = -1;
		Scanner sc = new Scanner(System.in);
		DepartmentDS dep = new DepartmentDS();
		main mainmenu = new main();

		while (selectedOption != 4) {
			System.out.println("============================");
			System.out.println("|Student Management System |");
			System.out.println("============================");
			System.out.println("|                          |");
			System.out.println("|  1. Department           |");
			System.out.println("|  2. Students             |");
			System.out.println("|  3. Courses              |");
			System.out.println("|  4. Exit                 |");
			System.out.println("|                          |");
			System.out.println("============================");
			System.out.println(" Select main option : ");
			try {
				selectedOption = sc.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("============================");
				System.out.println("|  System Error Detected   |");
				System.out.println("============================");
				System.out.println("|                          |");
				System.out.println("|Error: Invalid Input      |");
				System.out.println("|Program Status:Terminated |");
				System.out.println("|                          |");
				System.out.println("============================");
				break;
			} // takes number input for option selection
			System.out.println("============================");
			if (selectedOption == 1) {
				mainmenu.DeptMenu();
			} else if (selectedOption == 2) {
				mainmenu.StudentMenu();
			} else if (selectedOption == 3) {
				mainmenu.CourseMenu();
			}

		}

	}
}
