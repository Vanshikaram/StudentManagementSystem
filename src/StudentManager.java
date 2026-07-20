import java.util.ArrayList;

public class StudentManager {

    // List to store students
    private ArrayList<Student> students;

    // Constructor
    public StudentManager() {
        students = new ArrayList<>();
    }

    // Add a student
    public void addStudent(Student student) {
        students.add(student);
        System.out.println(student.getName() + " added successfully!");
    }

    // Display all students
    public void displayAllStudents() {

        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        System.out.println("\n========== Student List ==========");

        for (Student student : students) {
            student.displayStudent();
        }

        System.out.println("Total Students: " + students.size());
    }

    // Search student by ID
    public void searchStudentById(int id) {

        for (Student student : students) {

            if (student.getId() == id) {
                System.out.println("\nStudent Found:");
                student.displayStudent();
                return;
            }
        }

        System.out.println("Student with ID " + id + " not found.");
    }
}