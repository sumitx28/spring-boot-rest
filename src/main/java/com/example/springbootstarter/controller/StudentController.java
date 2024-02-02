package com.example.springbootstarter.controller;

import com.example.springbootstarter.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("student")
public class StudentController {

    // GET API - @GetMapping
    @GetMapping
    public ResponseEntity<Student> getStudent() {
        Student student = new Student(1, "s" , "savaliya");
//        return new ResponseEntity<>(student, HttpStatus.OK);
        return ResponseEntity.ok(student);
    }

    @GetMapping("/all-students")
    public ResponseEntity<List<Student>> getStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1 , "sumit", "savaliya"));
        students.add(new Student(2, "het", "savaliya"));

        return ResponseEntity.ok().header("custom-head" , "sumit").body(students);
    }

    // Path Variable
    @GetMapping("{id}")
    public ResponseEntity<Student> studentPathVariable(@PathVariable("id") int id){
        Student student = new Student(id , "Sumit", "Savaliya");
        return ResponseEntity.ok(student);
    }

    // Request Params
    @GetMapping("query")
    public ResponseEntity<Student> studentRequestVariable(@RequestParam("id") int id) {
        Student student = new Student(id , "Ss", "ss");
        return ResponseEntity.ok(student);
    }

    // POST API - @PostMapping and @RequestBody
    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Student> studentPostMapping(@RequestBody Student student) {
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());

        return new ResponseEntity<>(student , HttpStatus.CREATED);
    }

    // PUT API - @PostMapping and @RequestBody
    @PutMapping("update/{id}")
    public ResponseEntity<Student> studentPutMapping(@RequestBody Student student , @PathVariable("id") int id) {
        System.out.println("Student Updated");
        student.setId(100);
        return ResponseEntity.ok(student);
    }

    // DELETE API - @DeleteMapping
    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> studentDeleteMapping(@PathVariable("id") int id) {
        System.out.println("Student deleted!!! id=" + id);
        return ResponseEntity.ok("Student Deleted Successfully");
    }
}
