import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentManager manager = new StudentManager();

        int choice;

        do {

            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Search Student by Name");
            System.out.println("5. Delete Student");
            System.out.println("6. Update Student");
            System.out.println("7. Sort Students by Name");
            System.out.println("8. Sort Students by Marks");
            System.out.println("9. View Statistics");
            System.out.println("10. View Top Performer");
            System.out.println("11. Exit");

            choice = InputHelper.readInt(sc, "Enter your choice: ");

            switch (choice) {

                case 1:

                    int id = InputHelper.readInt(
                            sc,
                            "Enter Student ID: "
                    );

                    String name = InputHelper.readString(
                            sc,
                            "Enter Name: "
                    );

                    int age;

                    do {

                        age = InputHelper.readInt(
                                sc,
                                "Enter Age (greater than 0): "
                        );

                        if (age <= 0) {
                            System.out.println(
                                    "Invalid age! Please enter a positive number."
                            );
                        }

                    } while (age <= 0);

                    String course = InputHelper.readString(
                            sc,
                            "Enter Course: "
                    );

                    double marks;

                    do {

                        marks = InputHelper.readDouble(
                                sc,
                                "Enter Marks (0-100): "
                        );

                        if (marks < 0 || marks > 100) {
                            System.out.println(
                                    "Invalid marks! Please enter between 0 and 100."
                            );
                        }

                    } while (marks < 0 || marks > 100);

                    Student student = new Student(
                            id,
                            name,
                            age,
                            course,
                            marks
                    );

                    manager.addStudent(student);

                    break;

                case 2:

                    manager.displayAllStudents();

                    break;

                case 3:

                    int searchId = InputHelper.readInt(
                            sc,
                            "Enter Student ID to search: "
                    );

                    manager.searchStudentById(searchId);

                    break;

                case 4:

                    String searchName = InputHelper.readString(
                            sc,
                            "Enter Student Name to search: "
                    );

                    manager.searchStudentByName(searchName);

                    break;

                case 5:

                    int deleteId = InputHelper.readInt(
                            sc,
                            "Enter Student ID to delete: "
                    );

                    manager.deleteStudentById(deleteId);

                    break;

                case 6:

                    int updateId = InputHelper.readInt(
                            sc,
                            "Enter Student ID to update: "
                    );

                    String newName = InputHelper.readString(
                            sc,
                            "Enter New Name: "
                    );

                    int newAge;

                    do {

                        newAge = InputHelper.readInt(
                                sc,
                                "Enter New Age (greater than 0): "
                        );

                        if (newAge <= 0) {
                            System.out.println(
                                    "Invalid age! Please enter a positive number."
                            );
                        }

                    } while (newAge <= 0);

                    String newCourse = InputHelper.readString(
                            sc,
                            "Enter New Course: "
                    );

                    double newMarks;

                    do {

                        newMarks = InputHelper.readDouble(
                                sc,
                                "Enter New Marks (0-100): "
                        );

                        if (newMarks < 0 || newMarks > 100) {
                            System.out.println(
                                    "Invalid marks! Please enter between 0 and 100."
                            );
                        }

                    } while (newMarks < 0 || newMarks > 100);

                    manager.updateStudentById(
                            updateId,
                            newName,
                            newAge,
                            newCourse,
                            newMarks
                    );

                    break;

                case 7:

                    manager.sortStudentsByName();

                    break;

                case 8:

                    manager.sortStudentsByMarks();

                    break;

                
                case 9:

                    manager.displayStatistics();

                    break;

                case 10:

                    manager.displayTopPerformer();

                    break;

                case 11:

                    System.out.println(
                            "Thank you for using Student Management System!"
                    );

                    break;

                default:

                    System.out.println(
                            "Invalid choice! Please select between 1 and 9."
                    );
            }

        } while (choice != 11);

        sc.close();
    }
}