package com.example.Student.controller;

import com.example.Student.StudentApplication;
import com.example.Student.entity.Student;
import com.example.Student.repo.Studentrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/hsj")
public class Studentcontroller {
    @Autowired
    private Studentrepo studentrepo;
    @PostMapping("/bs")
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        Student student1= studentrepo.save(student);
        return ResponseEntity.ok().body(student1);
    }
    @GetMapping("/gdh")
    public ResponseEntity<List<Student>> getAllStudent(){
        List<Student> studentList=studentrepo.findAll();
        return ResponseEntity.ok().body(studentList);
    }
    @GetMapping("/chxj")
    public ResponseEntity<Student> getById(@PathVariable Long id){
       Optional<Student> student=studentrepo.findById(id);
        return ResponseEntity.ok(student.get());
    }
    @PutMapping("/j")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student){
        studentrepo.save(student);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/h")
    public ResponseEntity<Boolean> deletStudent(@PathVariable Long id){
         studentrepo.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
