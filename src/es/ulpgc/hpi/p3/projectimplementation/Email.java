package es.ulpgc.hpi.p3.projectimplementation;

import java.util.regex.Pattern;

public class Email {
    // 1. Changed Object to String and removed 'static'
    private String address;

    // 2. Added type 'String' to the constructor argument
    public Email(String address) {
        this.address = address;
    }

    // 3. Implemented logic to check the format
    boolean isValid() {
        // First check if it is null to avoid a NullPointerException
        if (address == null) {
            return false;
        }

        // Simple Regex pattern for email validation
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

        return address.matches(emailRegex);
    }

    // Getter to retrieve the address later
    public String getAddress() {
        return address;
    }
}
