package util;

public class utilconsole {
    
    public String readString(String prompt) {
        while (true) {
            String input = IO.readln(prompt);
            if (input == null || input.isBlank()) {
                throw new IllegalArgumentException("The input cannot be empty.");
            }
            input = input.trim();
            if (input.isBlank()) {
                throw new IllegalArgumentException("The input cannot be empty");
            }
            return input;
        }
    }

    public int readInt(String prompt) {
        while (true) {
            String input = readString(prompt);
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Error: You must enter a valid integer.");
            }
        }
    }

    public double readDouble(String prompt) {
        while (true) {
            String input = readString(prompt);
            try {
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Error: You must enter a valid decimal number.");
            }
        }
    }
}
