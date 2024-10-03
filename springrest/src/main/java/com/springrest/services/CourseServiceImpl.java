package com.springrest.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.dao.CourseDao;
import com.springrest.entities.Course;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseDao courseDao;

    

  

    // private List<Course> list;

    // public CourseServiceImpl(){
    //     list = new ArrayList<>();
    //     list.add(new Course(911,"Java","Basic to core java"));
    //     list.add(new Course(428,"React","React framwork"));
    // }
    @Override
    public List<Course> getCourses() {
        return courseDao.findAll();
    }

    @Override
    public Course getCourse(long courseId){
        // for(Course obj:list){
        //     if(obj.getId() == courseId){
        //         return obj;
        //     }
        // }
        // return null;
        return courseDao.getReferenceById(courseId);

    }

    @Override
    public Course addCourse(Course course){
        courseDao.save(course);
        return course;
    }


}
