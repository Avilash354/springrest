package com.springrest.springrest.controller;

import com.springrest.springrest.entities.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.web.bind.annotation.*;
import services.CourseService;
import services.CourseServiceImpl;

import java.util.List;

@RestController
public class MyController {

//    @Autowired
    private CourseService courseService = new CourseServiceImpl();

    @GetMapping("/home")
    public String home(){
        return "Welcome to courses application";
    }
    //Get the courses
    @GetMapping("/courses")
    public List<Course> getCourses(){
        return this.courseService.getCourses();
    }

    @GetMapping("/courses/{courseId}")
    public Course getCourse(@PathVariable String  courseId){
        return this.courseService.getCourse(Long.parseLong(courseId));
    }

    @PostMapping("/courses")
    public Course addCourses(@RequestBody Course course){
        return this.courseService.addCourse(course);
    }
}
