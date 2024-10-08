package com.app.vacancywebservice.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;




@Entity
@Table(name = "vacancies")
public class Vacancy implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "vac_id")
	private int vacancyId;

	@Column(name = "vac_title")
	private String vacancyTitle;

	@Column(name = "vac_experience")
	private String vacancyExperience;
	@Column(name = "vac_salary")
	private int vacancySalary;

	@Column(name = "vac_number_opening")
	private int vacancyNumberOfOpening;

	@Column(name = "created_at")
	private Date createdAt;

	@Column(name = "updated_at")
	private Date updatedAt;
	
	

	
	public Vacancy() {
		
	}

	public int getVacancyId() {
		return vacancyId;
	}

	public void setVacancyId(int vacancyId) {
		this.vacancyId = vacancyId;
	}

	public String getVacancyTitle() {
		return vacancyTitle;
	}

	public void setVacancyTitle(String vacancyTitle) {
		this.vacancyTitle = vacancyTitle;
	}

	public String getVacancyExperience() {
		return vacancyExperience;
	}

	public void setVacancyExperience(String vacancyExperience) {
		this.vacancyExperience = vacancyExperience;
	}

	public int getVacancySalary() {
		return vacancySalary;
	}

	public void setVacancySalary(int vacancySalary) {
		this.vacancySalary = vacancySalary;
	}

	public int getVacancyNumberOfOpening() {
		return vacancyNumberOfOpening;
	}

	public void setVacancyNumberOfOpening(int vacancyNumberOfOpening) {
		this.vacancyNumberOfOpening = vacancyNumberOfOpening;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return "Vacancy [vacancyId=" + vacancyId + ", vacancyTitle=" + vacancyTitle + ", vacancyExperience="
				+ vacancyExperience + ", vacancySalary=" + vacancySalary + ", vacancyNumberOfOpening="
				+ vacancyNumberOfOpening + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}

}
