package com.sm.datastructures;

public class Course {

   private int CourseID;
   private String CourseName;
   private int CourseCreditHrs;
   private float TotalMarks;
   private float ObtainedMarks;
   private float CourseGpa;
   private String CourseGrade;
   
   public String studentName;

   public Course(int courseID, String courseName, int courseCreditHrs, float totalMarks, float obtainedMarks) {
      super();
      CourseID = courseID;
      CourseName = courseName;
      CourseCreditHrs = courseCreditHrs;
      TotalMarks = totalMarks;
      ObtainedMarks = obtainedMarks;
      this.studentName = "";

   }

   public float CalcGpa() {

      CourseGpa = (ObtainedMarks / TotalMarks) * CourseCreditHrs;
      return CourseGpa;

   }

   public String CalcGrade() { // This needs Working!!
                        // Too lazy to implement logic
      if (CourseGpa >= 3.75) {
         CourseGrade = "A";
         return CourseGrade;
      }
      CourseGrade = "B";
      return CourseGrade;
   }

   public int getCourseID() {
      return CourseID;
   }

   public String getCourseName() {
      return CourseName;
   }

   @Override

   public String toString() {
      return " [CourseID=" + CourseID + ", CourseName=" + CourseName + ", CourseCreditHrs=" + CourseCreditHrs
            + ", TotalMarks=" + TotalMarks + ", ObtainedMarks=" + ObtainedMarks + ", CourseGpa="
            + String.format("%,.2f", CalcGpa()) + ", CourseGrade=" + CalcGrade() + "]";
   }

}
