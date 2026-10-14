
import java.util.ArrayList;

public class GradeTracker {

    private ArrayList<Student> students;

    public GradeTracker() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        for (Student existing : students) {
            if (existing.getId().equalsIgnoreCase(
                    student.getId())) {
                throw new IllegalArgumentException(
                        "Student ID already exists."
                );
            }
        }

        students.add(student);
        System.out.println("Student added successfully!");
    }

    public Student findStudent(String id) {
        for (Student student : students) {
            if (student.getId().equalsIgnoreCase(id)) {
                return student;
            }
        }

        return null;
    }

    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        for (Student student : students) {
            student.displayReport();
        }
    }

    public void displayClassSummary() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }

        double totalAverage = 0;
        Student highest = null;
        Student lowest = null;

        for (Student student : students) {
            if (student.getMarks().isEmpty()) {
                continue;
            }

            double average = student.calculateAverage();
            totalAverage += average;

            if (highest == null ||
                    average > highest.calculateAverage()) {
                highest = student;
            }

            if (lowest == null ||
                    average < lowest.calculateAverage()) {
                lowest = student;
            }
        }

        System.out.println("\n===== Class Summary =====");
        System.out.println("Total Students: " + students.size());

        int studentsWithMarks = 0;
        for (Student student : students) {
            if (!student.getMarks().isEmpty()) {
                studentsWithMarks++;
            }
        }

        if (studentsWithMarks == 0) {
            System.out.println("No marks entered yet.");
            return;
        }

        System.out.printf("Class Average: %.2f%n",
                totalAverage / studentsWithMarks);

        System.out.println("Highest Average: " +
                highest.getName() + " (" +
                String.format("%.2f",
                        highest.calculateAverage()) + ")");

        System.out.println("Lowest Average: " +
                lowest.getName() + " (" +
                String.format("%.2f",
                        lowest.calculateAverage()) + ")");
    }
}
