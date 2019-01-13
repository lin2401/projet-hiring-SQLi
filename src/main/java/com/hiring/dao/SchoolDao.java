package com.hiring.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.hiring.entities.School;

@Repository
public class SchoolDao implements ISchoolDao {

	@Autowired
	private HibernateTemplate template;

	public void addSchool(School school) {
		this.template.save(school);
	}

}
