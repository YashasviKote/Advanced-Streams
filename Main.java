import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List<Student> students = Arrays.asList(
                new Student("Ravi", "CS"),
                new Student("Anita", "IT"),
                new Student("Kiran", "CS"),
                new Student("Meena", "ECE"),
                new Student("Arjun", "IT")
        );

        // Group students by department
        Map<String, List<Student>> grouped =
                students.stream()
                        .collect(Collectors.groupingBy(Student::getDepartment));

        System.out.println("Students grouped by department:");

        grouped.forEach((dept, list) -> {
            System.out.println(dept + " -> " + list);
        });

        // Count students in each department
        Map<String, Long> count =
                students.stream()
                        .collect(Collectors.groupingBy(
                                Student::getDepartment,
                                Collectors.counting()
                        ));

        System.out.println("\nStudent count by department:");

        count.forEach((dept, c) ->
                System.out.println(dept + " : " + c));
    }
}