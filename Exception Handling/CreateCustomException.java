package exceptionHandling;

import java.util.Scanner;


import java.util.Scanner;

public class CreateCustomException {
    public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Enter age:");
            int age = scanner.nextInt();
            validateAge(age);
            System.out.println("Age: " + age);
        } catch (NotAnAgeException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("An unexpected error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void validateAge(int age) throws NotAnAgeException {
        if (age < 0) {
            throw new NotAnAgeException("Age cannot be negative.");
        }
    }
}

class NotAnAgeException extends Exception {
    public NotAnAgeException(String message) {
        super(message);
    }
}

