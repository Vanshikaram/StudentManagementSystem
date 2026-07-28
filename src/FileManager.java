import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

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
}