package edu.dio.api.service;

import org.springframework.stereotype.Service;

import edu.dio.api.model.Course;

@Service
public interface CourseService {

    Iterable<Course> getAllCourses();

    Course getCourseById(Long id);

    void addCourse(Course course);

    void updateCourse(Long id, Course course);

    void removeCourse(Long id);

}
