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
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine(); // Clear buffer

            switch (choice) {

                case 1:

                    System.out.print("Enter Student ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    int age;

                    do {
                        System.out.print("Enter Age (greater than 0): ");
                        age = sc.nextInt();

                        if (age <= 0) {
                            System.out.println("Invalid age! Please try again.");
                        }

                    } while (age <= 0);

                    sc.nextLine();

                    System.out.print("Enter Course: ");
                    String course = sc.nextLine();

                    double marks;

                    do {
                        System.out.print("Enter Marks (0-100): ");
                        marks = sc.nextDouble();

                        if (marks < 0 || marks > 100) {
                            System.out.println("Invalid marks! Please enter between 0 and 100.");
                        }

                    } while (marks < 0 || marks > 100);

                    sc.nextLine();   // ⭐ IMPORTANT

                    Student student = new Student(id, name, age, course, marks);
                    manager.addStudent(student);

                    break;

                case 2:

                    manager.displayAllStudents();

                    break;

                case 3:

                    System.out.print("Enter Student ID to search: ");
                    int searchId = sc.nextInt();
                    sc.nextLine();   // ⭐ IMPORTANT

                    manager.searchStudentById(searchId);

                    break;

                case 4:

                    System.out.print("Enter Student Name: ");
                    String searchName = sc.nextLine();

                    manager.searchStudentByName(searchName);

                break;

                case 5:

                    System.out.print("Enter Student ID to delete: ");
                    int deleteId = sc.nextInt();
                    sc.nextLine();   // ⭐ IMPORTANT

                    manager.deleteStudentById(deleteId);

                    break;

                case 6:

                    System.out.print("Enter Student ID to update: ");
                    int updateId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter New Name: ");
                    String newName = sc.nextLine();

                    int newAge;

                    do {
                        System.out.print("Enter New Age (greater than 0): ");
                        newAge = sc.nextInt();

                        if (newAge <= 0) {
                            System.out.println("Invalid age! Please try again.");
                        }

                    } while (newAge <= 0);

                    sc.nextLine();

                    System.out.print("Enter New Course: ");
                    String newCourse = sc.nextLine();

                    double newMarks;

                    do {
                        System.out.print("Enter New Marks (0-100): ");
                        newMarks = sc.nextDouble();

                        if (newMarks < 0 || newMarks > 100) {
                            System.out.println("Invalid marks! Please enter between 0 and 100.");
                        }

                    } while (newMarks < 0 || newMarks > 100);

                    sc.nextLine();   // ⭐ IMPORTANT

                    manager.updateStudentById(updateId, newName, newAge, newCourse, newMarks);

                    break;

                case 7:

                    System.out.println("Thank you for using Student Management System!");
                    break;

                default:

                    System.out.println("Invalid choice!");
            }

        } while (choice != 7);

        sc.close();
    }
}