package com.sm.datastructures;

public class Course {
    
   // Declaring Data Variables for the records

   private int CourseID;
   private String CourseName;
   private int CourseCreditHrs;
   private float TotalMarks;
   private float ObtainedMarks;
   private float CourseGpa;
   private String CourseGrade;

   public String studentName;

   // Defining Custom constructor
   public Course(int courseID, String courseName, int courseCreditHrs, float totalMarks, float obtainedMarks) {
      super();
      CourseID = courseID;
      CourseName = courseName;
      CourseCreditHrs = courseCreditHrs;
      TotalMarks = totalMarks;
      ObtainedMarks = obtainedMarks;
      this.studentName = "";

   }

   // Function for calculating the Gpa based on total and obatained marks
   public float CalcGpa() {

      CourseGpa = (ObtainedMarks / TotalMarks) * CourseCreditHrs;
      return CourseGpa;

   }

   // Function for calculating the Grade based on Gpa
   public String CalcGrade() {

      if (CourseGpa >= 3.75) {
         CourseGrade = "A";
         return CourseGrade;
      } else if (CourseGpa >= 3.5) {
         CourseGrade = "B";
         return CourseGrade;
      } else if (CourseGpa >= 3) {
         CourseGrade = "B-";
         return CourseGrade;
      } else if (CourseGpa >= 2.75) {
         CourseGrade = "C+";
         return CourseGrade;
      } else if (CourseGpa >= 2.5) {
         CourseGrade = "C";
         return CourseGrade;
      } else if (CourseGpa >= 2) {
         CourseGrade = "C-";
         return CourseGrade;
      }

      else if (CourseGpa >= 1.75) {
         CourseGrade = "D";
         return CourseGrade;
      } else if (CourseGpa < 1.75) {
         CourseGrade = "F";
         return CourseGrade;
      }

      CourseGrade = "NaN";
      return CourseGrade;

   }

   // Getters for CouseID and Name
   public int getCourseID() {
      return CourseID;
   }

   public String getCourseName() {
      return CourseName;
   }

   @Override

   // Method for returing a formatted string for output
   public String toString() {
      return " [CourseID=" + CourseID + ", CourseName=" + CourseName + ", CourseCreditHrs=" + CourseCreditHrs
            + ", TotalMarks=" + TotalMarks + ", ObtainedMarks=" + ObtainedMarks + ", CourseGpa="
            + String.format("%,.2f", CalcGpa()) + ", CourseGrade=" + CalcGrade() + "]";
   }

}
