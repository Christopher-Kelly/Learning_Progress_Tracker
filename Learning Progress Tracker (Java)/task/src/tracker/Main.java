package tracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static int student_handler(Scanner scanner) {
        int student_tracker = 0;
        boolean input_validator = true;

        System.out.println("Enter student credentials or 'back' to return:");

        while (input_validator) {
            String input = scanner.nextLine();
            List<String> input_split = new ArrayList<String>(List.of(input.split(" ")));
            if (input_split.get(0).equals("back")) {
                return student_tracker;
            }
            if (input_split.size() < 3) {
                System.out.println("Incorrect Credentials");
            } else {
                String email = input_split.get(input_split.size() - 1);
                input_split.remove(input_split.size() - 1);
                String firstname = input_split.get(0);
                input_split.remove(0);
                String lastname = ""+ String.join(" ",input_split);

                Student student = new Student(firstname,lastname,email);

                if (student.isEmailValid() == false) {
                    System.out.println("Incorrect email");
                } else {
                    if (student.isFirstNameValid() == false) {
                        System.out.println("Incorrect first name.");
                    } else {
                        if (student.isLastNameValid() == false) {
                            System.out.println("Incorrect last name");
                        } else {
                            student_tracker++;
                            System.out.println("The student has been added.");
                        }
                    }
                }
            }
        }
        return student_tracker;
    }


    public static void main(String[] args) {
        Boolean done = false;
        System.out.println("Learning Progress Tracker\n");

        Scanner scanner = new Scanner(System.in);
        while (!done) {
            String input = scanner.nextLine();
            if (input.isBlank() || input.isEmpty()) {
                System.out.println("No input.");
            } else {
                switch (input) {
                    case "back":
                        System.out.println("Enter 'exit' to exit the program");
                        break;
                    case "add students":
                        int student_number = student_handler(scanner);
                        System.out.printf("Total %d students have been added.", student_number);
                        break;
                    case "exit":
                        done = true;
                        System.out.println("Bye!");
                        break;
                    default:
                        System.out.println("Error: unknown command!");
                }
            }
        }
    }
}
