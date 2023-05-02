package tracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static int nameChecker(String name) {
        Pattern pattern = Pattern.compile("([^-'][\\w ]*([-'][^-'])*[\\w]*)");
        Matcher matches = pattern.matcher(name);

        while (matches.find()) {
            if (matches.group(0).equals(name)) {
                return 1;
            }
        }
        return 0;
    }

    public static int nameHandler(List<String> name_array) {
        String firstname = name_array.get(0);
        String secondName = name_array.get(1);

        if (nameChecker(firstname) == 0 || firstname.length() < 2) {
            return 2;
        } else if (nameChecker(secondName) == 0 || secondName.length() < 2) {
            return 3;
        } else {
            return 1;
        }
    }

    public static int emailChecker(String email) {
        Pattern pattern = Pattern.compile("[\\w.]+@[\\w]+(\\.[\\w]*)+");
        Matcher matches = pattern.matcher(email);

        while (matches.find()) {
            if (matches.group(0).equals(email)) {
                return 1;
            }
        }
        return 0;
    }

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
                int email_checker = emailChecker(input_split.get(input_split.size() - 1));
                input_split.remove(input_split.size() - 1);
                int name_valid = nameHandler(input_split);

                if (email_checker == 0) {
                    System.out.println("Incorrect email");
                } else {
                    if (name_valid == 2) {
                        System.out.println("Incorrect first name.");
                    } else {
                        if (name_valid == 3) {
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
