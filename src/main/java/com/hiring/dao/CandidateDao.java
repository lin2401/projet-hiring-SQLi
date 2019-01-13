package com.hiring.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.hiring.entities.Candidate;

@Repository
public class CandidateDao implements ICandidateDao {

	@Autowired
	private HibernateTemplate template;

	public void addCandidate(Candidate candidat) {
		this.template.save(candidat);
	}

}
