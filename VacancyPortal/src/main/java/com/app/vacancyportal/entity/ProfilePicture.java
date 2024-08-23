package com.app.vacancyportal.entity;

import java.io.Serializable;
//Core Java Imports
import java.util.Date;

//JPA Imports
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//Hibernate Validation Imports

//Lombok Imports
import lombok.Builder;

@Entity
@Table(name = "profilepicpath")
public class ProfilePicture implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pic_id")
	private int pictureId;

	@Column(name = "profile_path")
	private String profilePath;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "email_id")
	private User user;

	@Column(name = "created_at")
	private Date createdAt;

	@Column(name = "updated_at")
	private Date updatedAt;

	public String getProfilePath() {
		return profilePath;
	}

	public void setProfilePath(String profilePath) {
		this.profilePath = profilePath;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getPictureId() {
		return pictureId;
	}

	public void setPictureId(int pictureId) {
		this.pictureId = pictureId;
	}

	@Override
	public String toString() {
		return "ProfilePicture [pictureId=" + pictureId + ", profilePath=" + profilePath + ", user=" + user
				+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}
	
	

}
