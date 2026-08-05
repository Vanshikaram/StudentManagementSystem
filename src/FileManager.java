import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileManager {

    private static final String FILE_NAME = "students.txt";

    // Save students to file
    public static void saveStudentsToFile(ArrayList<Student> students) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {

            for (Student student : students) {

                writer.write(
                        student.getId() + "," +
                        student.getName() + "," +
                        student.getAge() + "," +
                        student.getCourse() + "," +
                        student.getMarks()
                );

                writer.newLine();
            }

            System.out.println("Students saved successfully!");

        } catch (IOException e) {

            System.out.println("Error while saving students.");
            System.out.println(e.getMessage());
        }
    }

    // Load students from file
    public static ArrayList<Student> loadStudentsFromFile() {

        ArrayList<Student> students = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                int id = Integer.parseInt(data[0]);
                String name = data[1];
                int age = Integer.parseInt(data[2]);
                String course = data[3];
                double marks = Double.parseDouble(data[4]);

                Student student = new Student(id, name, age, course, marks);

                students.add(student);
            }

        } catch (IOException e) {

            System.out.println("No existing student data found.");
        }

        return students;
    }

    // Export student report
    public static void exportStudentReport(ArrayList<Student> students) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("StudentReport.txt"))) {

            DateTimeFormatter formatter =
                    DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

            writer.write("========== STUDENT REPORT ==========");
            writer.newLine();
            writer.write("Generated On : " + LocalDateTime.now().format(formatter));
            writer.newLine();
            writer.newLine();

            writer.write("Total Students : " + students.size());
            writer.newLine();
            writer.newLine();

            double totalMarks = 0;
            double highestMarks = students.get(0).getMarks();
            double lowestMarks = students.get(0).getMarks();

            for (Student student : students) {

                writer.write("--------------------------------");
                writer.newLine();

                writer.write("ID      : " + student.getId());
                writer.newLine();

                writer.write("Name    : " + student.getName());
                writer.newLine();

                writer.write("Age     : " + student.getAge());
                writer.newLine();

                writer.write("Course  : " + student.getCourse());
                writer.newLine();

                writer.write("Marks   : " + student.getMarks());
                writer.newLine();

                writer.write("Grade   : " + student.getGrade());
                writer.newLine();

                writer.write("--------------------------------");
                writer.newLine();
                writer.newLine();

                totalMarks += student.getMarks();

                if (student.getMarks() > highestMarks) {
                    highestMarks = student.getMarks();
                }

                if (student.getMarks() < lowestMarks) {
                    lowestMarks = student.getMarks();
                }
            }

            double averageMarks = totalMarks / students.size();

            writer.write("========== STATISTICS ==========");
            writer.newLine();
            writer.write("Average Marks : " + String.format("%.2f", averageMarks));
            writer.newLine();
            writer.write("Highest Marks : " + highestMarks);
            writer.newLine();
            writer.write("Lowest Marks  : " + lowestMarks);
            writer.newLine();

            System.out.println("Student report exported successfully!");

        } catch (IOException e) {

            System.out.println("Error exporting student report.");
            System.out.println(e.getMessage());
        }
    }
}
    