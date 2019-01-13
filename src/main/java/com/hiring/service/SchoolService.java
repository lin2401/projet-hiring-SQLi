package com.hiring.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hiring.dao.SchoolDao;
import com.hiring.entities.School;

@Service
@Transactional
public class SchoolService implements ISchoolService {

	private SchoolDao schoolDao;

	public void insertSchool(School school) {
		this.schoolDao.addSchool(school);
	}

}
