package auca.ac.rw.question2_student_api.controller;

import auca.ac.rw.question2_student_api.model.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private List<Student> students = new ArrayList<>();

    public StudentController() {
        students.add(new Student(1L, "Mireille", "Ishimwe",
                "mireille@gmail.com", "Software Engineering", 3.8));

        students.add(new Student(2L, "Eric", "Ndayisenga",
                "eric@gmail.com", "Information Management Systems", 3.2));

        students.add(new Student(3L, "Grace", "Mukamana",
                "grace@gmail.com", "Networking", 3.6));

        students.add(new Student(4L, "Patrick", "Habimana",
                "patrick@gmail.com", "Software Engineering", 2.9));

        students.add(new Student(5L, "Claudine", "Umutoni",
                "claudine@gmail.com", "Information Management Systems", 3.9));
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        return ResponseEntity.ok(students);
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long studentId) {

        for (Student student : students) {
            if (student.getStudentId().equals(studentId)) {
                return ResponseEntity.ok(student);
            }
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/major/{major}")
    public ResponseEntity<List<Student>> getStudentsByMajor(@PathVariable String major) {

        List<Student> result = new ArrayList<>();

        for (Student student : students) {
            if (student.getMajor().equalsIgnoreCase(major)) {
                result.add(student);
            }
        }

        return ResponseEntity.ok(result);
    }

    @GetMapping("/filter")
    public ResponseEntity<List<Student>> filterByGpa(@RequestParam Double gpa) {

        List<Student> result = new ArrayList<>();

        for (Student student : students) {
            if (student.getGpa() >= gpa) {
                result.add(student);
            }
        }

        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        students.add(student);
        return ResponseEntity.status(201).body(student);
    }

    @PutMapping("/{studentId}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long studentId,
                                                 @RequestBody Student updatedStudent) {

        for (Student student : students) {
            if (student.getStudentId().equals(studentId)) {

                student.setFirstName(updatedStudent.getFirstName());
                student.setLastName(updatedStudent.getLastName());
                student.setEmail(updatedStudent.getEmail());
                student.setMajor(updatedStudent.getMajor());
                student.setGpa(updatedStudent.getGpa());

                return ResponseEntity.ok(student);
            }
        }

        return ResponseEntity.notFound().build();
    }
}
