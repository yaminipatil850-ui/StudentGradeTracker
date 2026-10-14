import java.util.ArrayList;
import java.util.List;

    public class Student {

        private String id;
        private String name;
        private ArrayList<Double> marks;

        public Student(String id, String name) {
            this.id = id;
            this.name = name;
            this.marks = new ArrayList<>();
        }

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public List<Double> getMarks() {
            return List.copyOf(marks);
        }

        public void addMark(double mark) {
            if (mark < 0 || mark > 100) {
                throw new IllegalArgumentException(
                        "Marks must be between 0 and 100."
                );
            }

            marks.add(mark);
        }

        public double calculateAverage() {
            if (marks.isEmpty()) {
                return 0.0;
            }

            double total = 0;

            for (double mark : marks) {
                total += mark;
            }

            return total / marks.size();
        }

        public double getHighestMark() {
            if (marks.isEmpty()) {
                return 0.0;
            }

            double highest = marks.get(0);

            for (double mark : marks) {
                if (mark > highest) {
                    highest = mark;
                }
            }

            return highest;
        }

        public double getLowestMark() {
            if (marks.isEmpty()) {
                return 0.0;
            }

            double lowest = marks.get(0);

            for (double mark : marks) {
                if (mark < lowest) {
                    lowest = mark;
                }
            }

            return lowest;
        }

        public String calculateGrade() {
            if (marks.isEmpty()) {
                return "N/A";
            }

            double average = calculateAverage();

            if (average >= 90) {
                return "O";
            } else if (average >= 80) {
                return "A";
            } else if (average >= 70) {
                return "B";
            } else if (average >= 60) {
                return "C";
            } else {
                return "D";
            }
        }

        public void displayReport() {
            System.out.println("\n----- Student Report -----");
            System.out.println("Student ID: " + id);
            System.out.println("Name: " + name);
            System.out.println("Marks: " + marks);
            System.out.printf("Average: %.2f%n", calculateAverage());
            System.out.printf("Highest Mark: %.2f%n", getHighestMark());
            System.out.printf("Lowest Mark: %.2f%n", getLowestMark());
            System.out.println("Grade: " + calculateGrade());
        }


}
