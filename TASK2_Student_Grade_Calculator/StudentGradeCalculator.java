import java.util.Scanner;

public class StudentGradeCalculator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("==================================");
        System.out.println("   STUDENT GRADE CALCULATOR");
        System.out.println("==================================");

        System.out.print("Enter Number of Subjects: ");
        int n = sc.nextInt();

        int total = 0;

        for (int i = 1; i <= n; i++) {

            int marks;

            while (true) {

                System.out.print("Enter Marks of Subject " + i + " (0-100): ");
                marks = sc.nextInt();

                if (marks >= 0 && marks <= 100)
                    break;

                System.out.println("Invalid Marks! Please enter between 0 and 100.");
            }

            total += marks;
        }

        double average = (double) total / n;

        char grade;

        if (average >= 90)
            grade = 'A';
        else if (average >= 80)
            grade = 'B';
        else if (average >= 70)
            grade = 'C';
        else if (average >= 60)
            grade = 'D';
        else if (average >= 50)
            grade = 'E';
        else
            grade = 'F';

        System.out.println("\n========== RESULT ==========");
        System.out.println("Total Marks      : " + total);
        System.out.println("Average Percentage : " + average + "%");
        System.out.println("Grade            : " + grade);

        if (grade == 'F')
            System.out.println("Result           : FAIL");
        else
            System.out.println("Result           : PASS");

        sc.close();
    }
}