package com.hiring.entities;
// Generated 10 oct. 2018 14:34:30 by Hibernate Tools 5.1.10.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * TrainingId generated by hbm2java
 */
@Embeddable
public class TrainingId implements java.io.Serializable {

	private int idtraining;
	private int candidateIdcandidate;
	private int schoolIdschool;

	public TrainingId() {
	}

	public TrainingId(int idtraining, int candidateIdcandidate, int schoolIdschool) {
		this.idtraining = idtraining;
		this.candidateIdcandidate = candidateIdcandidate;
		this.schoolIdschool = schoolIdschool;
	}

	@Column(name = "idtraining", nullable = false)
	public int getIdtraining() {
		return this.idtraining;
	}

	public void setIdtraining(int idtraining) {
		this.idtraining = idtraining;
	}

	@Column(name = "candidate_idcandidate", nullable = false)
	public int getCandidateIdcandidate() {
		return this.candidateIdcandidate;
	}

	public void setCandidateIdcandidate(int candidateIdcandidate) {
		this.candidateIdcandidate = candidateIdcandidate;
	}

	@Column(name = "school_idschool", nullable = false)
	public int getSchoolIdschool() {
		return this.schoolIdschool;
	}

	public void setSchoolIdschool(int schoolIdschool) {
		this.schoolIdschool = schoolIdschool;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TrainingId))
			return false;
		TrainingId castOther = (TrainingId) other;

		return (this.getIdtraining() == castOther.getIdtraining())
				&& (this.getCandidateIdcandidate() == castOther.getCandidateIdcandidate())
				&& (this.getSchoolIdschool() == castOther.getSchoolIdschool());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getIdtraining();
		result = 37 * result + this.getCandidateIdcandidate();
		result = 37 * result + this.getSchoolIdschool();
		return result;
	}

}
