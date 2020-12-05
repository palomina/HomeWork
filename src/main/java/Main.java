import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        String[] courseTitles = {
                "Математика",
                "Физика",
                "Основы С++",
                "Основы Java",
                "Основы Python",
                "Основы PHP",
                "Основы Golang",
                "Основы HTML",
                "Основы CSS",
        };

        HashMap<String, Course> allCourses = new HashMap<>();
        for (String courseTitle : courseTitles) {
            allCourses.put(courseTitle, new Course(courseTitle));
        }

        List<Student> students = new ArrayList<>();

        for (int j=1; j<=20; j++ ) {
            students.add(new Student("Студент " + j));
            for (int i = 0; i < rand.nextInt(allCourses.size()) + 1; i++) {
                students.get(students.size() - 1)
                        .addCourse(allCourses.get(courseTitles[rand.nextInt(courseTitles.length)]));
            }
        }

        students.forEach(System.out::println);

        System.out.println("Список уникальных курсов, на которые подписаны студенты:");
        List<Course> task1 = getUniqueCourses(students);
        task1.forEach(s -> System.out.println(s.getName()));

        System.out.println("Список из трех самых любознательных (любознательность определяется количеством курсов):");
        List<Student> task2 = getThree(students);
        task2.forEach(s -> System.out.println(s.getName()));

        Course testCourse = allCourses.get(courseTitles[0]);
        System.out.println("Список студентов, которые посещают курс " + testCourse.getName() + ":");
        List<Student> task3 = getStudentsOnCourse(students, testCourse);
        task3.forEach(s -> System.out.println(s.getName()));

    }

    public static List<Course> getUniqueCourses(List<Student> students) {
        return students.stream()
                .flatMap(listContainer -> listContainer.getAllCourses().stream())
                .distinct()
                .collect(Collectors.toList());
    }

    public static List<Student> getThree(List<Student> students) {
        return students.stream()
                .sorted((s1, s2) -> s2.getAllCourses().size() - s1.getAllCourses().size())
                .limit(3)
                .collect(Collectors.toList());
    }

    public static List<Student> getStudentsOnCourse(List<Student> students, Course course) {
        return students.stream()
                .filter((s) -> s.getAllCourses().contains(course))
                .collect(Collectors.toList());
    }


}