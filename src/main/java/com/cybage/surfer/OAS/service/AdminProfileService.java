package com.cybage.surfer.OAS.service;

import java.util.List;

import com.cybage.surfer.OAS.model.Course;

public interface AdminProfileService {
	
	public	void addCourse(Course c);
	public List<Course> showCourse();
	public Course findCourse(int id);
	public void updateCourse(Course c);
    public void deleteCourse(int id);
}
