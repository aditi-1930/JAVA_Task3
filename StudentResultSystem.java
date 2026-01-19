import java.util.Scanner;

public class StudentResultSystem {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n--- Student Result Processing System ---");

            int[] marks = new int[5];
            String[] subjects = {"Maths", "Physics", "Chemistry", "English", "Computer"};

            for (int i = 0; i < marks.length; i++) {
                marks[i] = getValidMarks(subjects[i]);
            }

            int total = calculateTotal(marks);
            double percentage = calculatePercentage(total, marks.length);
            char grade = assignGrade(percentage);

            displayResult(total, percentage, grade);

            System.out.print("\nDo you want to enter another student? (yes/no): ");
            String choice = sc.next();

            if (choice.equalsIgnoreCase("no")) {
                break;
            }
        }

        System.out.println("\nProgram Ended. Thank You!");
    }

    // Method to validate marks
    static int getValidMarks(String subject) {
        int marks;

        while (true) {
            System.out.print("Enter marks for " + subject + " (0-100): ");
            marks = sc.nextInt();

            if (marks < 0 || marks > 100) {
                System.out.println("Invalid marks! Try again.");
                continue;
            }
            break;
        }
        return marks;
    }

    // Method to calculate total
    static int calculateTotal(int[] marks) {
        int sum = 0;
        for (int m : marks) {
            sum += m;
        }
        return sum;
    }

    // Method to calculate percentage
    static double calculatePercentage(int total, int subjectsCount) {
        return (double) total / subjectsCount;
    }

    // Method to assign grade using if-else + switch
    static char assignGrade(double percentage) {
        char grade;

        if (percentage >= 90) grade = 'A';
        else if (percentage >= 75) grade = 'B';
        else if (percentage >= 60) grade = 'C';
        else if (percentage >= 40) grade = 'D';
        else grade = 'F';

        switch (grade) {
            case 'A':
            case 'B':
            case 'C':
            case 'D':
                return grade;
            default:
                return 'F';
        }
    }

    // Method to display result
    static void displayResult(int total, double percentage, char grade) {
        System.out.println("\n--- Final Result ---");
        System.out.println("Total Marks: " + total);
        System.out.printf("Percentage: %.2f%%\n", percentage);
        System.out.println("Grade: " + grade);
    }
}
