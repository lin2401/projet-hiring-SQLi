package com.hiring.entities;
// Generated 10 oct. 2018 14:34:30 by Hibernate Tools 5.1.10.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * CandidateAnswerProvided generated by hbm2java
 */
@Entity
@Table(name = "candidate_answer_provided", catalog = "hiring")
public class CandidateAnswerProvided implements java.io.Serializable {

	private int idcandidateAnswerProvided;
	private Candidate candidate;
	private Question question;
	private String value;

	public CandidateAnswerProvided() {
	}

	public CandidateAnswerProvided(int idcandidateAnswerProvided, Candidate candidate, Question question) {
		this.idcandidateAnswerProvided = idcandidateAnswerProvided;
		this.candidate = candidate;
		this.question = question;
	}

	public CandidateAnswerProvided(int idcandidateAnswerProvided, Candidate candidate, Question question,
			String value) {
		this.idcandidateAnswerProvided = idcandidateAnswerProvided;
		this.candidate = candidate;
		this.question = question;
		this.value = value;
	}

	@Id

	@Column(name = "idcandidate_answer_provided", unique = true, nullable = false)
	public int getIdcandidateAnswerProvided() {
		return this.idcandidateAnswerProvided;
	}

	public void setIdcandidateAnswerProvided(int idcandidateAnswerProvided) {
		this.idcandidateAnswerProvided = idcandidateAnswerProvided;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "candidate_idcandidate", nullable = false)
	public Candidate getCandidate() {
		return this.candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "question_idquestion", nullable = false)
	public Question getQuestion() {
		return this.question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	@Column(name = "value", length = 45)
	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}