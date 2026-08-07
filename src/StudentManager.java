import java.util.Collections;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class StudentManager {

    // List to store students
    private ArrayList<Student> students;

    public StudentManager() {

        students = FileManager.loadStudentsFromFile();

        System.out.println(students.size() + " student(s) loaded from file.");
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
            FileManager.saveStudentsToFile(students);
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
               FileManager.saveStudentsToFile(students);
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

                FileManager.saveStudentsToFile(students);

                System.out.println("Student updated successfully!");
                return;
            }
        }

        System.out.println("Student with ID " + id + " not found.");


    }

    // Display student statistics
    public void displayStatistics() {

        if (students.isEmpty()) {
            System.out.println("No student records available.");
            return;
        }

        int totalStudents = students.size();

        double totalMarks = 0;
        double highestMarks = students.get(0).getMarks();
        double lowestMarks = students.get(0).getMarks();

        for (Student student : students) {

            totalMarks += student.getMarks();

            if (student.getMarks() > highestMarks) {
                highestMarks = student.getMarks();
            }

            if (student.getMarks() < lowestMarks) {
                lowestMarks = student.getMarks();
            }
        }

        double averageMarks = totalMarks / totalStudents;

        System.out.println("\n========== Student Statistics ==========");
        System.out.println("Total Students : " + totalStudents);
        System.out.printf("Average Marks  : %.2f%n", averageMarks);
        System.out.println("Highest Marks  : " + highestMarks);
        System.out.println("Lowest Marks   : " + lowestMarks);
    }

    // Display the top performer
    public void displayTopPerformer() {

        if (students.isEmpty()) {
            System.out.println("No student records available.");
            return;
        }

        Student topStudent = students.get(0);

        for (Student student : students) {

            if (student.getMarks() > topStudent.getMarks()) {
                topStudent = student;
            }
        }

        System.out.println("\n========== Top Performer ==========");
        topStudent.displayStudent();
    }  

    // Display students by course
    public void displayStudentsByCourse(String course) {

        if (students.isEmpty()) {
            System.out.println("No student records available.");
            return;
        }

        boolean found = false;

        System.out.println("\n========== Students in " + course + " ==========");

        for (Student student : students) {

            if (student.getCourse().equalsIgnoreCase(course)) {

                student.displayStudent();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No students found in course: " + course);
        }
    }

    // Search students by marks range
    public void searchStudentsByMarksRange(double minMarks, double maxMarks) {

        if (students.isEmpty()) {
            System.out.println("No student records available.");
            return;
        }

        boolean found = false;

        System.out.println("\n========== Students with Marks Between "
                + minMarks + " and " + maxMarks + " ==========");

        for (Student student : students) {

            double marks = student.getMarks();

            if (marks >= minMarks && marks <= maxMarks) {

                student.displayStudent();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No students found in this marks range.");
        }
    }

    // Count students by course
    public void countStudentsByCourse() {

     if (students.isEmpty()) {
            System.out.println("No student records available.");
           return;
        }

        HashMap<String, Integer> courseCount = new HashMap<>();

        for (Student student : students) {

            String course = student.getCourse();

            if (courseCount.containsKey(course)) {

                courseCount.put(course, courseCount.get(course) + 1);

            } else {

                courseCount.put(course, 1);
            }
        }

        System.out.println("\n========== Student Count by Course ==========");

        for (Map.Entry<String, Integer> entry : courseCount.entrySet()) {

            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
    public void exportReport() {

        if (students.isEmpty()) {

            System.out.println("No student records available.");
            return;
        }

        FileManager.exportStudentReport(students);
    }
    public void backupData() {

        FileManager.backupStudentData();
    }
    public void restoreData() {

        FileManager.restoreStudentData();

        students = FileManager.loadStudentsFromFile();

        System.out.println("Student list refreshed.");
    }
}