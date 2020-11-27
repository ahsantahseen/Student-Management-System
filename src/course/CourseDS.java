//Author: Muhammad Ahsan
//Data: 26-11-2020
//File: CourseDS.java

package course;

//Node Class
class Node {
    private Course Data;
    private Node next;

    public Node() {
        Data = null;
        next = null;

    }

    // Sets a course class object as a data for the node for e.g name id etc..
    public void setData(Course Data) {
        this.Data = Data;
    }

    // Returns a course class object as a data from the node for e.g name id etc..
    public Course getData() {
        return Data;
    }

    // Sets the next pointer of the node
    public void setNext(Node next) {
        this.next = next;
    }

    // Returns the pointer which is pointing to the next node
    public Node getNext() {
        return next;
    }

}
/*
 * 
 * Functions in the CourseDS linked list:
 * 
 * 1.isEmpty() 2.getSize() 3.insertNode(Course Data) 4.searchByCourseId(int
 * courseID) 5.searchByCourseName(String name) 6.delete first,last functions
 * (small functions) 7.deleteAtPos(int pos) 8.deleteNodeByCourseID(int courseID)
 * 9.deleteNodeByCourseName(String courseName) 10.SearchAndPrintByCourseID(int
 * CourseID) 11.EditCourse(int CourseID,String CourseName,int
 * CourseCreditHrs,float CourseTotalMarks,float CourseObtainedMarks)
 * 12.ViewList()
 */

public class CourseDS {

    private int size;
    private Node start;

    public CourseDS() {
        size = 0;
        start = null;
    }

    // Checks if Course Linked List is empty or not
    private boolean isEmpty() {
        if (getSize() == 0) {
            return true;
        } else {
            return false;
        }
    }

    // Returns the size of the Linked List
    public int getSize() {
        return size;
    }

    // Inserts a course node in the linked list
    public void insertNode(Course Data) {
        Node node;
        node = new Node();
        node.setData(Data);
        node.setNext(start);
        start = node;
        size++;

    }

    // Searches a course by its id and returns its position in the list
    private int searchByCourseId(int courseID) {
        Node current = start;
        int i = 0; // Initialize current
        while (current != null) {
            i++;
            if (current.getData().getCourseID() == courseID) {
                return i;
            } // data found

            current = current.getNext();

        }
        return -1; // data not found
    }

    // Searches a course by its name and returns its position in the list
    public int searchByCourseName(String name) {
        Node current = start;
        int i = 0; // Initialize current
        while (current != null) {
            i++;
            if (current.getData().getCourseName() == name) {
                return i;
            } // data found

            current = current.getNext();

        }
        return -1; // data not found
    }

    // Deletes a course node at the first position
    private void deleteFirst() {
        if (start == null) {
            System.out.println("List is empty");
        } else {
            start = start.getNext();
            size--;

        }
    }

    // Deletes a course node at the last position
    private void deleteLast() {
        if (start == null) {
            System.out.println("List is empty");
        }
        if (size == 1) {
            start = null;
            size--;
        } else {
            Node pointerNode;
            pointerNode = start;
            for (int i = 1; i < size - 1; i++) {
                pointerNode = pointerNode.getNext();
            }
            pointerNode.setNext(null);
            size--;
        }

    }

    // Deletes a course node at the given position
    public void deleteAtPos(int pos) {
        if (start == null) {
            System.out.println("List is empty");
        } else if (pos < 1 || pos > size) {
            System.out.println("Invalid Pos Cannot delete");
        } else if (pos == 1) {
            deleteFirst();
        } else if (pos == size) {
            deleteLast();
        } else {
            Node pointerNode, secondaryPointerNode; // for example if given 3 pointerNode will point to 2 and
            // secondaryPointer will target to 4
            pointerNode = start;
            for (int i = 1; i < pos - 1; i++) {
                pointerNode = pointerNode.getNext();
            }
            secondaryPointerNode = pointerNode.getNext();
            pointerNode.setNext(secondaryPointerNode.getNext());
            size--;
        }

    }

    // Deletes a course's records by its ID
    public void deleteNodeByCourseID(int courseID) {
        int pos = searchByCourseId(courseID);
        if (pos == -1) {
            System.out.println("Course Does not exists");
        } else {
            if (isEmpty()) {
                System.out.println("LIST IS EMPTY");
            } else {
                deleteAtPos(pos);
            }
        }
    }

    // Deletes a course's records by its Name
    public void deleteNodeByCourseName(String courseName) {
        int pos = searchByCourseName(courseName);
        if (pos == -1) {
            System.out.println("Course Does not exists");
        } else {
            if (isEmpty()) {
                System.out.println("LIST IS EMPTY");
            } else {
                deleteAtPos(pos);
            }
        }
    }

    // Searches a course by its name and prints its details
    public void SearchAndPrintByCourseName(String CourseName) {
        int pos = searchByCourseName(CourseName);
        if (pos == -1) {
            System.out.println("Course does not exist");
        } else {
            Node node;
            if (isEmpty()) {
                System.out.println("LIST IS EMPTY");
            } else {
                node = start;
                for (int i = 1; i <= pos; i++) {
                    if (i == pos) {
                        System.out.print(node.getData());
                        System.out.println();
                    }
                    node = node.getNext();
                }
            }
        }
    }

    // Searches a course by its id and prints its details
    public void SearchAndPrintByCourseID(int CourseID) {
        int pos = searchByCourseId(CourseID);
        if (pos == -1) {
            System.out.println("Course does not exist");
        } else {
            Node node;
            if (isEmpty()) {
                System.out.println("LIST IS EMPTY");
            } else {
                node = start;
                for (int i = 1; i <= pos; i++) {
                    if (i == pos) {
                        System.out.print(node.getData());
                        System.out.println();
                    }
                    node = node.getNext();
                }
            }
        }
    }

    // Edits a course by it's id
    public void EditCourse(int CourseID, String CourseName, int CourseCreditHrs, float CourseTotalMarks,
            float CourseObtainedMarks) {
        int pos = searchByCourseId(CourseID);
        if (pos == -1) {
            System.out.println("Course does not exist");
        } else {
            Node node;
            if (isEmpty()) {
                System.out.println("LIST IS EMPTY");
            } else {
                node = start;
                for (int i = 1; i <= pos; i++) {
                    if (i == pos) {
                        Course crs = new Course(CourseID, CourseName, CourseCreditHrs, CourseTotalMarks,
                                CourseObtainedMarks);
                        node.setData(crs);
                    }
                    node = node.getNext();
                }
            }
        }
    }

    // Prints the whole linked list of courses
    public void ViewList() {
        Node node;
        if (isEmpty()) {
            System.out.println("LIST IS EMPTY");
        } else {
            node = start;
            for (int i = 1; i <= size; i++) {
                System.out.print(node.getData());
                System.out.println();
                node = node.getNext();
            }
        }
    }
}