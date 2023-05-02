package tracker;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Student {
    protected boolean emailValid = false;
    protected boolean lastNameValid = true;
    protected boolean firstNameValid = true;
    private String firstName;
    private String lastName;
    private String email;

    Student(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;

        setBothNamesValid();
        setEmailValid();
    }

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

    public boolean isFirstNameValid() {
        return firstNameValid;
    }

    public void setFirstNameValid(boolean firstNameValid) {
        this.firstNameValid = firstNameValid;
    }

    public boolean isLastNameValid() {
        return lastNameValid;
    }

    public void setBothNamesValid() {
        String firstname = this.firstName;
        String secondName = this.lastName;

        if (nameChecker(firstname) == 0 || firstname.length() < 2) {
            this.firstNameValid = false;
        }

        if (nameChecker(secondName) == 0 || secondName.length() < 2) {
            this.lastNameValid = false;
        }
    }

    public boolean isEmailValid() {
        return emailValid;
    }

    public void setEmailValid() {
        Pattern pattern = Pattern.compile("[\\w.]+@[\\w]+(\\.[\\w]*)+");
        Matcher matches = pattern.matcher(email);

        while (matches.find()) {
            if (matches.group(0).equals(email)) {
                this.emailValid = true;
            }
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
