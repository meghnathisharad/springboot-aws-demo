package com.example.demo;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController("/")
public class SpringbootApiOnAwsDemo {
    private static List<Student> studentList;
    @GetMapping(value = "/find/{name}")
    public String getStudentByName(@PathVariable String name ){
        initiateStudentList();
        return studentList.stream().filter(s -> s.getName().equals(name))
                .findFirst().get().toString();
    }

    @GetMapping("/")
    public String greetings(){
        return "Hello user! you can find student by name.";
    }

    public static void initiateStudentList(){
        studentList = new ArrayList<>();
        studentList.add(new Student(1, "Jaini","Nursery"));
        studentList.add(new Student(2, "Het","Seven"));
        studentList.add(new Student(3, "Rudra","LKG"));
        studentList.add(new Student(4, "Jeet","Fourth"));
    }
}

class Student{
    int id;
    String name;
    String standard;

    public Student(int id, String name, String standard) {
        this.id = id;
        this.name = name;
        this.standard = standard;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", standard='" + standard + '\'' +
                '}';
    }
}
