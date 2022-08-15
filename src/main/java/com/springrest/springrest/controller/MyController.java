package com.springrest.springrest.controller;

import com.springrest.springrest.entities.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.CourseService;
import services.CourseServiceImpl;

import java.util.List;

@RestController
public class MyController {

//    @Autowired
    private CourseService courseService = new CourseServiceImpl();


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

    @PutMapping("/courses")
    public Course updateCourse(@RequestBody Course course){
        return this.courseService.updateCourse(course);
    }

    @DeleteMapping("/courses/{courseId}")
    public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId){
        try{
            this.courseService.deleteCourse(Long.parseLong((courseId)));
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
