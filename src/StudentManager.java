import java.util.Collections;
import java.util.Comparator;
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

        // Check for duplicate ID
         for (Student s : students) {
            if (s.getId() == student.getId()) {
                System.out.println("Error: Student ID already exists!");
                return;
            }
        }

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

    // Search student by Name
    public void searchStudentByName(String name) {

        boolean found = false;

        for (Student student : students) {

            if (student.getName().equalsIgnoreCase(name)) {

                System.out.println("\nStudent Found:");
                student.displayStudent();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No student found with name: " + name);
        }
    }

    // Sort students by name
    public void sortStudentsByName() {

        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return s1.getName().compareToIgnoreCase(s2.getName());
            }
        });

        System.out.println("Students sorted by name successfully!");
    }

    // Sort students by marks in descending order
    public void sortStudentsByMarks() {

        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        Collections.sort(students, new Comparator<Student>() {

            @Override
            public int compare(Student s1, Student s2) {
                return Double.compare(s2.getMarks(), s1.getMarks());
            }
        });

        System.out.println("Students sorted by marks successfully!");
    }

    // Delete student by ID
    public void deleteStudentById(int id) {

       for (int i = 0; i < students.size(); i++) {

           if (students.get(i).getId() == id) {

               System.out.println(students.get(i).getName() + " deleted successfully!");

               students.remove(i);
               return;
            }
        }

        System.out.println("Student with ID " + id + " not found.");
    }

    // Update student by ID
    public void updateStudentById(int id, String name, int age, String course, double marks) {

        for (Student student : students) {

            if (student.getId() == id) {

                student.setName(name);
                student.setAge(age);
                student.setCourse(course);
                student.setMarks(marks);

                System.out.println("Student updated successfully!");
                return;
            }
        }

        System.out.println("Student with ID " + id + " not found.");


    }
    // Save students to file
    public void saveStudents() {
        FileManager.saveStudentsToFile(students);
    }
}