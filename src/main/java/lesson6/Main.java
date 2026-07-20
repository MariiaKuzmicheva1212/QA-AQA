package lesson6;

import java.util.*;

    public class Main {
        public static void main(String[] args) {

            List<Student> students = new ArrayList<>();

            students.add(new Student("Анна", "Группа-1", 1, Arrays.asList(4, 5, 3, 4)));
            students.add(new Student("Борис", "Группа-1", 1, Arrays.asList(2, 2, 3, 2)));
            students.add(new Student("Вика", "Группа-2", 2, Arrays.asList(5, 5, 5, 4)));
            students.add(new Student("Глеб", "Группа-2", 2, Arrays.asList(3, 3, 3, 3)));
            students.add(new Student("Даша", "Группа-3", 3, Arrays.asList(2, 2, 2, 2)));

            System.out.println("=== ВСЕ СТУДЕНТЫ ===");
            printAllStudents(students);

            removeLowAverageStudents(students);
            System.out.println("\n=== ПОСЛЕ УДАЛЕНИЯ СЛАБЫХ ===");
            printAllStudents(students);

            promoteStudents(students);
            System.out.println("\n=== ПОСЛЕ ПЕРЕВОДА НА СЛЕДУЮЩИЙ КУРС ===");
            printAllStudents(students);

            Set<Student> studentSet = new HashSet<>(students);
            printStudents(studentSet, 2);
            printStudents(studentSet, 3);
        }
        public static void printAllStudents(List<Student> students) {
            for (Student s : students) {
                System.out.println(s.getName() + " | курс: " + s.getCourse() +
                        " | средний балл: " + s.getAverageGrade());
            }
        }

        public static void removeLowAverageStudents(List<Student> students) {
            students.removeIf(s -> s.getAverageGrade() < 3.0);
        }

        public static void promoteStudents(List<Student> students) {
            for (Student s : students) {
                if (s.getAverageGrade() >= 3.0) {
                    s.setCourse(s.getCourse() + 1);
                }
            }
        }

        public static void printStudents(Set<Student> students, int course) {
            System.out.println("\nСтуденты на курсе " + course + ":");
            for (Student s : students) {
                if (s.getCourse() == course) {
                    System.out.println("  - " + s.getName());
                }
            }
        }
    }


