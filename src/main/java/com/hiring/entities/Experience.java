package com.hiring.entities;
// Generated 10 oct. 2018 14:34:30 by Hibernate Tools 5.1.10.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Experience generated by hbm2java
 */
@Entity
@Table(name = "experience", catalog = "hiring")
public class Experience implements java.io.Serializable {

	private ExperienceId id;
	private Candidate candidate;
	private Company company;
	private String position;
	private String startDate;
	private String endDate;

	public Experience() {
	}

	public Experience(ExperienceId id, Candidate candidate, Company company) {
		this.id = id;
		this.candidate = candidate;
		this.company = company;
	}

	public Experience(ExperienceId id, Candidate candidate, Company company, String position, String startDate,
			String endDate) {
		this.id = id;
		this.candidate = candidate;
		this.company = company;
		this.position = position;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "idexperience", column = @Column(name = "idexperience", nullable = false)),
			@AttributeOverride(name = "candidateIdcandidate", column = @Column(name = "candidate_idcandidate", nullable = false)),
			@AttributeOverride(name = "employerIdemployer", column = @Column(name = "employer_idemployer", nullable = false)) })
	public ExperienceId getId() {
		return this.id;
	}

	public void setId(ExperienceId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "candidate_idcandidate", nullable = false, insertable = false, updatable = false)
	public Candidate getCandidate() {
		return this.candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "company_idcompany", nullable = false)
	public Company getCompany() {
		return this.company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	@Column(name = "position", length = 45)
	public String getPosition() {
		return this.position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	@Column(name = "start_date", length = 45)
	public String getStartDate() {
		return this.startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	@Column(name = "end_date", length = 45)
	public String getEndDate() {
		return this.endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

}
