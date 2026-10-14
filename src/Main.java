//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        GradeTracker tracker = new GradeTracker();

        boolean running = true;

        while (running) {

            System.out.println("\n===== Student Grade Tracker =====");
            System.out.println("1. Add Student");
            System.out.println("2. Add Marks");
            System.out.println("3. View Student Report");
            System.out.println("4. View All Students");
            System.out.println("5. View Class Summary");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine().trim();

            try {
                switch (choice) {

                    case "1":
                        System.out.print("Enter Student ID: ");
                        String id = scanner.nextLine().trim();

                        System.out.print("Enter Student Name: ");
                        String name = scanner.nextLine().trim();

                        if (id.isEmpty() || name.isEmpty()) {
                            System.out.println(
                                    "ID and name cannot be empty."
                            );
                            break;
                        }

                        tracker.addStudent(new Student(id, name));
                        break;
                    case "2":
                        System.out.print("Enter Student ID Whose marks you want to enter: ");
                        String studentId = scanner.nextLine().trim();

                        Student student = tracker.findStudent(studentId);

                        if (student == null) {
                            System.out.println("Student not found.");
                            break;
                        }

                        System.out.println("Enter marks one by one.");
                        System.out.println("Type 'done' when you have finished.");

                        int count = 0;

                        while (true) {
                            System.out.print("Enter mark " + (count + 1) + ": ");
                            String input = scanner.nextLine().trim();

                            if (input.equalsIgnoreCase("done")) {
                                break;
                            }

                            try {
                                double mark = Double.parseDouble(input);
                                student.addMark(mark);
                                count++;
                                System.out.println("Mark added successfully!");
                            } catch (NumberFormatException e) {
                                System.out.println("Invalid input! Enter a number or type 'done'.");
                            } catch (IllegalArgumentException e) {
                                System.out.println("Invalid mark: " + e.getMessage());
                            }
                        }

                        System.out.println(count + " mark(s) added.");
                        break;
                    case "3":
                        System.out.print("Enter Student ID: ");
                        String reportId = scanner.nextLine().trim();

                        Student reportStudent =
                                tracker.findStudent(reportId);

                        if (reportStudent == null) {
                            System.out.println(
                                    "Student not found."
                            );
                        } else {
                            reportStudent.displayReport();
                        }
                        break;

                    case "4":
                        tracker.displayAllStudents();
                        break;

                    case "5":
                        tracker.displayClassSummary();
                        break;

                    case "0":
                        running = false;
                        System.out.println("Thank you!");
                        break;

                    default:
                        System.out.println(
                                "Invalid choice. Try again."
                        );
                }

            } catch (NumberFormatException e) {
                System.out.println(
                        "Invalid number. Please try again."
                );

            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        scanner.close();
    }
}
