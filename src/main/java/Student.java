import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Student {
    private String name;
    private List<Course> courses;

    public Student(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }

    public void addCourse(Course course) {
        if (!this.courses.contains(course)) {
            this.courses.add(course);
        }
    }

    public String getName() {
        return name;
    }

    public List<Course> getAllCourses() {
        return this.courses;
    }


    public String toString() {
        return this.getName() + " курсы (" + getAllCourses().size() + "): " + courses.stream().map(Course::getName).collect(Collectors.joining(", "));
    }
}