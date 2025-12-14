package es.ulpgc.hpi.p3.projectimplementation.model;

import java.util.Objects;
import java.util.regex.Pattern;

public class Email {

    private static final Pattern emailPattern = Pattern.compile(
            "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$");

    private final String email;

    public Email(String email) {

        String trimmedEmail = email.trim();

        if (!isValid(trimmedEmail)) {
            throw new IllegalArgumentException("Invalid email format.");
        }
        this.email = trimmedEmail;
    }

    private static boolean isValid(String email) {
        if (email == null || email.trim().isEmpty()) {
            return false;
        }
        return emailPattern.matcher(email).matches();
    }

    public String getEmail() {
        return email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Email email1 = (Email) o;
        return Objects.equals(email, email1.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }

    @Override
    public String toString() {
        return email;
    }
}
