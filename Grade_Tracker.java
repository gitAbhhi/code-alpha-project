
import java.util.*;

class Student {

    private String name;
    private HashMap<String, Integer> subjects = new HashMap<>();

    public Student(String name) {
        this.name = name;
    }

    public void addSubject(String subject, int marks) {
        subjects.put(subject, marks);
    }

    public String getGrade(int marks) {
        if (marks >= 90) {
            return "A";
        } else if (marks >= 80) {
            return "B";
        } else if (marks >= 70) {
            return "C";
        } else if (marks >= 60) {
            return "D";
        } else {
            return "F";
        }
    }

    public void displayResults() {
        int totalMarks = 0;
        int maxMarks = Integer.MIN_VALUE;
        int minMarks = Integer.MAX_VALUE;

        System.out.println("Results for " + name + ":");
        for (String subject : subjects.keySet()) {
            int marks = subjects.get(subject);
            totalMarks += marks;
            maxMarks = Math.max(maxMarks, marks);
            minMarks = Math.min(minMarks, marks);
            System.out.println("-> " + subject + ": " + marks + " (" + getGrade(marks) + ")");
        }

        double averageMarks = totalMarks / (double) subjects.size();
        System.out.printf("* Average Marks: %.2f\n", averageMarks);
        System.out.println("* Highest Marks: " + maxMarks);
        System.out.println("* Lowest Marks: " + minMarks);
    }
}

public class Grade_Tracker {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Student Name");
        String name = sc.nextLine();
        Student s1 = new Student(name);
        System.out.println("Enter no of subject with marks ");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String subject = sc.next();
            int marks = sc.nextInt();
            s1.addSubject(subject, marks);
        }
        System.out.println();
        s1.displayResults();
    }
}
