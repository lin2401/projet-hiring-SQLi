package com.hiring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hiring.dao.ICandidateDao;
import com.hiring.entities.Candidate;

@Service
// @Transactionnal permet à Spring de faire un Rollback en cas de problème lors
// de la transaction
@Transactional
public class CandidateService implements ICandidateService {

	@Autowired
	private ICandidateDao candidateDao;

	public void insertCandidate(Candidate candidat) {
		this.candidateDao.addCandidate(candidat);
	}

}
