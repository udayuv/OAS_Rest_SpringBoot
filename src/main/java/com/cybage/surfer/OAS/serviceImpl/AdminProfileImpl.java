package com.cybage.surfer.OAS.serviceImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cybage.surfer.OAS.model.Course;
import com.cybage.surfer.OAS.service.AdminProfileService;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class AdminProfileImpl implements AdminProfileService {

	
	@PersistenceContext
    private EntityManager er;
	
	
	
	@Override
	public void addCourse(Course c) {

		er.persist(c);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Course> showCourse() {
		
		return er.createQuery("select c from Course c").getResultList();
	}

	@Override
	public Course findCourse(int id) {
		return er.find(Course.class,id);
	}

	@Override
	public void updateCourse(Course c) {
		er.merge(c);
	}

	@Override
	public void deleteCourse(int id) {
		Course c=er.find(Course.class, id);
		er.remove(c);
	}

}
