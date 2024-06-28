import java.util.Scanner;

public class StudentGradeCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfSubjects;
        double totalMarks = 0;
        
        System.out.print("Enter the number of subjects: ");
        numberOfSubjects = scanner.nextInt();
        
        if (numberOfSubjects <= 0) {
            System.out.println("Number of subjects should be greater than 0.");
            return;
        }

        
        double[] marks = new double[numberOfSubjects];

        for (int i = 0; i < numberOfSubjects; i++) {
            System.out.print("Enter marks for subject " + (i + 1) + ": ");
            marks[i] = scanner.nextDouble();
            if (marks[i] < 0 || marks[i] > 100) {
                System.out.println("Invalid marks entered. Please enter marks between 0 and 100.");
                return;
            }
            totalMarks += marks[i];
        }

        double averageMarks = totalMarks / numberOfSubjects;

        double percentage = (totalMarks / (numberOfSubjects * 100)) * 100;

        char grade;
        if (percentage >= 90) {
            grade = 'A';
        } else if (percentage >= 80) {
            grade = 'B';
        } else if (percentage >= 70) {
            grade = 'C';
        } else if (percentage >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }

        System.out.println("\nTotal Marks: " + totalMarks);
        System.out.println("Average Marks: " + averageMarks);
        System.out.println("Percentage: " + percentage + "%");
        System.out.println("Grade: " + grade);
    }
}
