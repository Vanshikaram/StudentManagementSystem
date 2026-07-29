import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;


public class FileManager {

    private static final String FILE_NAME = "students.txt";

    // Save students to file
    public static void saveStudentsToFile(ArrayList<Student> students) {

        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter(FILE_NAME))) {

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
}