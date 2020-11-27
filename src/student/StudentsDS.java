//Author: Asaad Noman
//Data: 26-11-2020
//File: StudentsDS.java

/*
   
   Functions in the Students BST: 

      1.  Insert(int regID , String name , String fatherName , String department , String section);
      2.  RemoveByID(int regID);
      3.  FindByID(int regID);
      4.  FindBySection(String section);
      5.  FindByCourse(String courseName);
      6.  Edit(int regID , String name , String fatherName , String department , String section)
      7.  AddCourse(int regID , Course course);
      8.  RemoveCourseByID(int regID , courseID);
      9.  RemoveCourseByName(int regID , courseName);
      10. GetCourses(int regID);
      12  GetCoursesTaken(int regID);
      13  EditCourse(int regID , int courseID , String courseName , int CreditHR , float total , float obtained);
      14. Print();
            
*/

package student;

import course.Course;
import course.CourseDS;

class sNode {

   public int regID;
   public String name,fatherName,department,section;

   public sNode left,right;

   public CourseDS courses = new CourseDS(); //courses

   public sNode() {}
   public sNode(int regID , String name , String fatherName , String department , String section) {
      this.name = name;
      this.fatherName = fatherName;
      this.department = department;
      this.section = section;
      this.regID = regID;
   }

   public String toString() {
      return regID + " " + name + " " + fatherName + " " + department + " " + section;
   }

}

public class StudentsDS {

   /* //////////////////   BST FUNCTIONS  ////////////////////*/

   //insert to binary tree
   private sNode b_Insert(sNode root , int regID , String name , String fatherName , String department , String section) {
      if(root == null) {
         root = new sNode(regID,name,fatherName,department,section);
      } else if(regID < root.regID) {
         root.left = b_Insert(root.left,regID,name,fatherName,department,section);
      } else if(regID > root.regID) {
         root.right = b_Insert(root.right,regID,name,fatherName,department,section);
      } return root;
   }

   //find the Minimum node in the bst
   private sNode findMinimum(sNode root) {
      if(root == null) {
         return null;
      } else if(root.left == null) {
         return root;
      } else {
         findMinimum(root.left);
      } return root;
   }

   //remove the given node by ID
   private sNode b_RemoveByID(sNode root , int regID) { 
      sNode temp;
      if(root == null) {
         return null;
      } else if(regID < root.regID) {
         root.left = b_RemoveByID(root.left,regID);
      } else if(regID > root.regID) {
         root.right = b_RemoveByID(root.right,regID);
      } else if(root.right != null && root.left != null) {
         temp = findMinimum(root.right);
         root.regID = temp.regID;
         root.right = b_RemoveByID(root.right,root.regID);
      } else {
         temp = root;
         if(root.left == null) {
            root = root.right;
         } else if(root.right == null) {
            root = root.left;
         }
      } return root;
   }


   //find node using regID
   private sNode b_FindByID(sNode root , int regID) {
      if(root == null) {
         return null;
      } else if(regID < root.regID) {
         return b_FindByID(root.left,regID);
      } else if(regID > root.regID) {
         return b_FindByID(root.right,regID);
      } else {
         return root;
      }
   }

   //find all the students by section
   private void b_FindBySection(sNode root , String section) {
      if(root == null) return;
      if(root.section == section) {
         System.out.println(root.name + " " + root.regID + " " + root.section);
      }

      b_FindBySection(root.left,section);
      b_FindBySection(root.right,section);
   }

   //find all the students by a course they have taken
   private void b_FindByCourse(sNode root , String courseName) {
     if(root == null) return;
     if(root.courses.searchByCourseName(courseName) != -1) {
         System.out.println(root.regID + " " + root.name + " " + root.section + " " + courseName);
     }

     b_FindByCourse(root.left,courseName);
     b_FindByCourse(root.right,courseName);
   }

   
   /* ////////////////  USER FUNCTIONS /////////////////////*/

   private sNode _root;

   public sNode getRoot() {
      return _root;
   }

   //Insert the student into the binary tree
   public void Insert(int regID , String name , String fatherName , String department , String section) {
      _root = b_Insert(_root,regID,name,fatherName,department,section);
   }

   //Remove the Student using REG_ID
   public void RemoveByID(int regID) {
      _root = b_RemoveByID(_root,regID);
   }

   //Edit student info
   public void Edit(int regID,String name,String fatherName,String department,String section) {
      sNode searchNode = b_FindByID(_root,regID);
      if(searchNode != null) {
         searchNode.name = name;
         searchNode.fatherName = fatherName;
         searchNode.department = department;
         searchNode.section = section;
      }
   }

   //Find the student in the binary tree using REG_ID
   public void FindByID(int regID) {
      sNode searchNode = b_FindByID(_root,regID);
      if(searchNode != null) {
         System.out.println("FOUND: " + searchNode);
      } else {
         System.out.println("NOT FOUND");
      }
   }

   //Find all the students by section
   public void FindBySection(String section) {
      b_FindBySection(_root,section);
   }

   //Find All the students from every section taking the same course
   public void FindByCourse(String courseName) {
      b_FindByCourse(_root,courseName);
   }

   //Add Course To the Desired ID
   public void AddCourse(int regID , Course course) {
      sNode searchNode = b_FindByID(_root,regID);
      if(searchNode != null) {
         searchNode.courses.insertNode(course);
      }
   }

   //Remove the course of a student by courseID
   public void RemoveCourseByID(int regID , int courseID) {
      sNode searchNode = b_FindByID(_root,regID);
      if(searchNode != null) {
         searchNode.courses.deleteNodeByCourseID(courseID);
      }
   }

   public void EditCourse(int regID , int courseID , String cn, int ch , float ctm , float com) {
      sNode searchNode = b_FindByID(_root,regID);
      if(searchNode != null) {
         searchNode.courses.EditCourse(courseID,cn,ch,ctm,com);
      }
   }

   //Remove the course of a student by coursename
   public void RemoveCourseByName(int regID , String courseName) {
      sNode searchNode = b_FindByID(_root,regID);
      if(searchNode != null) {
         searchNode.courses.deleteNodeByCourseName(courseName);
      }
   }

   //Retrive All the Courses Of A Student
   public void GetCourses(int regID) {
      sNode searchNode = b_FindByID(_root,regID);
      if(searchNode != null) {
         searchNode.courses.ViewList();
      }
   }

   public int GetCoursesTaken(int regID) {
      sNode searchNode = b_FindByID(_root,regID);
      if(searchNode != null) {
         return searchNode.courses.getSize();
      } return 0;
   }

   //Print the binary tree
   public void Print(sNode root) {
      if(root == null) return;
      Print(root.left);
      System.out.println(root);
      Print(root.right);
   }

   public static void main(String args[]) {
     
      StudentsDS s = new StudentsDS();
     
      s.Insert(1,"Asaad","Noman","CS","F");
      s.Insert(2,"Noman","Asaad","CS","G");
      s.Insert(4,"Shayan","Ali","CS","G");

      s.AddCourse(2,new Course(190,"DLD",100,200,3));
      s.AddCourse(2,new Course(192,"DE",100,200,3));
      s.AddCourse(1,new Course(193,"DE",100,200,3));
      
      //s.FindBySection("G");
      //s.FindByCourse("DE");

      //System.out.println("Courses Taken: " + s.GetCoursesTaken(0));

      s.EditCourse(2,190,"FLD",3,100,90);
      s.GetCourses(2);

      //Important to use this to print the whole LIST
      //s.Print(s.getRoot());
   }
}