package edu.dio.api.service.implementation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.dio.api.model.Course;
import edu.dio.api.model.CourseRepository;
import edu.dio.api.service.CourseService;

@Service
public class CourseServiceImplementation implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public Iterable<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Course getCourseById(Long id) {
        Optional<Course> course = courseRepository.findById(id);
        return course.get();
    }

    @Override
    public void addCourse(Course course) {
        this.saveOrUpdateCourse(course);
    }

    @Override
    public void updateCourse(Long id, Course course) {
        Optional<Course> courseDB = courseRepository.findById(id);

        if (courseDB.isPresent()) {
            this.saveOrUpdateCourse(course);
        }
    }

    @Override
    public void removeCourse(Long id) {
        courseRepository.deleteById(id);
    }

    private void saveOrUpdateCourse(Course course) {
        courseRepository.save(course);
    }
}
