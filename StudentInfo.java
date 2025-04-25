import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class StudentInfo {
    public static void removeUnderperformingStudents(Set<Student> students) {
        students.removeIf(student -> student.getAverageGrade() < 3.0);
    }

    public static void promoteEligibleStudents(Set<Student> students) {
        students.stream()
                .filter(student -> student.getAverageGrade() >= 3.0)
                .forEach(Student::promoteToNextCourse);
    }

    public static void printStudentsByCourse(Set<Student> students, int course) {
        System.out.println("\nСтуденты " + course + " курса:");
        students.stream()
                .filter(student -> student.getCourse() == course)
                .forEach(System.out::println);
    }

    public static void demo() {
        Set<Student> students = new HashSet<>();

        students.add(new Student("Антон Сонич", 2011, 1,
                Map.of("Мат.анализ", 2, "Теор.мех", 3, "Физика", 2)));

        students.add(new Student("Кабак Олег", 2012, 2,
                Map.of("Начертательная геометрия", 5, "История Беларуси", 3, "Алкалоидная химия", 5)));

        students.add(new Student("Третьяков Андрей", 2013, 3,
                Map.of("Теория машин и механизмов", 3, "Двигатели внутреннего сгорания", 5, "Сапротивление материалов", 4)));

        System.out.println("\nИсходный список студентов:");
        students.forEach(System.out::println);

        removeUnderperformingStudents(students);
        System.out.println("\nКроме студентов с баллом < 3:");
        students.forEach(System.out::println);

        promoteEligibleStudents(students);
        System.out.println("\nПереведены на следующий курс:");
        students.forEach(System.out::println);

        printStudentsByCourse(students, 3);
    }
}