package com.sm.datastructures;

class sNode {

   public Student data;
   public sNode left,right;

   public sNode() {}
   public sNode(Student data) {
      this.data = data;
   }
   
   public void Print() {
	   System.out.println(data);
   }

}

public class StudentsDS {

	private int count = 0;
	
   //insert to binary tree
   private sNode b_Insert(sNode root , Student data) {
      if(root == null) {
         root = new sNode(data);
      } else if(data.regID < root.data.regID) {
         root.left = b_Insert(root.left,data);
      } else if(data.regID > root.data.regID) {
         root.right = b_Insert(root.right,data);
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
      } else if(regID < root.data.regID) {
         root.left = b_RemoveByID(root.left,regID);
      } else if(regID > root.data.regID) {
         root.right = b_RemoveByID(root.right,regID);
      } else if(root.right != null && root.left != null) {
         temp = findMinimum(root.right);
         root.data.regID = temp.data.regID;
         root.right = b_RemoveByID(root.right,root.data.regID);
      } else {
         temp = root;
         count--;
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
      } else if(regID < root.data.regID) {
         return b_FindByID(root.left,regID);
      } else if(regID > root.data.regID) {
         return b_FindByID(root.right,regID);
      } else {
         return root;
      }
   }

   //find all the students by section
   private void b_FindBySection(sNode root , String section) {
      if(root == null) return;
      if(root.data.section.equals(section)) { //import
         System.out.println(root.data.name + " " + root.data.regID + " " + root.data.section);
      }

      b_FindBySection(root.left,section);
      b_FindBySection(root.right,section);
   }

   //find all the students by a course they have taken
   private void b_FindByCourse(sNode root , String courseName) {
     if(root == null) return;
     if(root.data.courses.searchByCourseName(courseName) != -1) {
         System.out.println(root.data.regID + " " + root.data.name + " " + root.data.section + " " + courseName);
     }

     b_FindByCourse(root.left,courseName);
     b_FindByCourse(root.right,courseName);
   }

   private sNode _root;

   public sNode getRoot() {
      return _root;
   }

   //Insert the student into the binary tree
   public void Insert(Student data) {
      _root = b_Insert(_root,data);
      count++;
   }

   //Remove the Student using REG_ID
   public void RemoveByID(int regID) {
      _root = b_RemoveByID(_root,regID);
   }
   
   public int getStudentCount() { return count; }

   //Edit student info
   public void Edit(int regID,Student data) {
      sNode searchNode = b_FindByID(_root,regID);
      if(searchNode != null) {
         searchNode.data.name = data.name;
         searchNode.data.fatherName = data.fatherName;
         searchNode.data.department = data.department;
         searchNode.data.section = data.section;
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
    	 course.studentID = regID; //
         searchNode.data.courses.insertNode(course);
      }
   }

   //Remove the course of a student by courseID
   public void RemoveCourseByID(int regID , int courseID) {
      sNode searchNode = b_FindByID(_root,regID);
      if(searchNode != null) {
         searchNode.data.courses.deleteNodeByCourseID(courseID);
      }
   }

   public void EditCourse(int regID , int courseID , Course newData) {
      sNode searchNode = b_FindByID(_root,regID);
      if(searchNode != null) {
     	 newData.studentID = regID; //
         searchNode.data.courses.EditCourse(courseID,newData);
      }
   }

   //Remove the course of a student by coursename
   public void RemoveCourseByName(int regID , String courseName) {
      sNode searchNode = b_FindByID(_root,regID);
      if(searchNode != null) {
         searchNode.data.courses.deleteNodeByCourseName(courseName);
      }
   }

   //Retrive All the Courses Of A Student
   public void GetCourses(int regID) {
      sNode searchNode = b_FindByID(_root,regID);
      if(searchNode != null) {
         searchNode.data.courses.ViewList();
      }
   }

   public int GetCoursesTaken(int regID) {
      sNode searchNode = b_FindByID(_root,regID);
      if(searchNode != null) {
         return searchNode.data.courses.getSize();
      } return 0;
   }

   //Print the binary tree
   public void Print(sNode root) {
      if(root == null) return;
      Print(root.left);
      root.Print();
      Print(root.right);
   }
   

   public static void main(String args[]) {
     
      StudentsDS s = new StudentsDS();
     
      s.Insert(new Student(1,"Asaad","Noman","F"));
      s.Insert(new Student(2,"Noman","Asaad","G"));
      s.Insert(new Student(4,"Shayan","Ali","G"));

      s.AddCourse(2,new Course(190,"DLD",100,200,3));
      s.AddCourse(2,new Course(192,"DE",100,200,3));
      s.AddCourse(1,new Course(193,"DE",100,200,3));
      
      //s.FindBySection("G");
      //s.FindByCourse("DE");

      //System.out.println("Courses Taken: " + s.GetCoursesTaken(0));

      //s.EditCourse(2,190,"FLD",3,100,90);
      //s.RemoveCourseByName(2, "FLD");
      s.GetCourses(0);

      s.Print(s.getRoot());
   } 
}