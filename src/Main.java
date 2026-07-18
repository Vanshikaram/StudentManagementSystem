public class Main {

    public static void main(String[] args) {

        StudentManager manager = new StudentManager();

        Student student1 = new Student(
                101,
                "Rahul Sharma",
                20,
                "Computer Science",
                92.5
        );

        Student student2 = new Student(
                102,
                "Priya Singh",
                19,
                "Information Technology",
                89.8
        );

        manager.addStudent(student1);
        manager.addStudent(student2);

        manager.displayAllStudents();
    }
}