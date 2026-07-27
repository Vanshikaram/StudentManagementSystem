import java.util.Scanner;

public class InputHelper {

    // Read an integer safely
    public static int readInt(Scanner sc, String message) {

        while (true) {

            System.out.print(message);

            try {
                return Integer.parseInt(sc.nextLine().trim());

            } catch (NumberFormatException e) {

                System.out.println("Invalid input! Please enter a valid integer.");
            }
        }
    }

    // Read a double safely
    public static double readDouble(Scanner sc, String message) {

        while (true) {

            System.out.print(message);

            try {
                return Double.parseDouble(sc.nextLine().trim());

            } catch (NumberFormatException e) {

                System.out.println("Invalid input! Please enter a valid number.");
            }
        }
    }

    // Read a non-empty string
    public static String readString(Scanner sc, String message) {

        while (true) {

            System.out.print(message);

            String input = sc.nextLine().trim();

            if (!input.isEmpty()) {
                return input;
            }

            System.out.println("Input cannot be empty. Please try again.");
        }
    }
}
