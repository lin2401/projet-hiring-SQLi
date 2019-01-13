package com.hiring.entities;
// Generated 10 oct. 2018 14:34:30 by Hibernate Tools 5.1.10.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Assessment generated by hbm2java
 */
@Entity
@Table(name = "assessment", catalog = "hiring")
public class Assessment implements java.io.Serializable {

	private int idassessment;
	private String name;
	private Set candidateHasAssessments = new HashSet(0);
	private Set questions = new HashSet(0);

	public Assessment() {
	}

	public Assessment(int idassessment) {
		this.idassessment = idassessment;
	}

	public Assessment(int idassessment, String name, Set candidateHasAssessments, Set questions) {
		this.idassessment = idassessment;
		this.name = name;
		this.candidateHasAssessments = candidateHasAssessments;
		this.questions = questions;
	}

	@Id

	@Column(name = "idassessment", unique = true, nullable = false)
	public int getIdassessment() {
		return this.idassessment;
	}

	public void setIdassessment(int idassessment) {
		this.idassessment = idassessment;
	}

	@Column(name = "name", length = 45)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "assessment")
	public Set getCandidateHasAssessments() {
		return this.candidateHasAssessments;
	}

	public void setCandidateHasAssessments(Set candidateHasAssessments) {
		this.candidateHasAssessments = candidateHasAssessments;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "assessment_has_question", catalog = "hiring", joinColumns = {
			@JoinColumn(name = "assessment_idassessment", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "question_idquestion", nullable = false, updatable = false) })
	public Set getQuestions() {
		return this.questions;
	}

	public void setQuestions(Set questions) {
		this.questions = questions;
	}

}