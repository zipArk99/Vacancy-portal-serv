package com.app.vacancyportal.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.ManyToAny;

import com.app.vacancyportal.dto.ProfilePicResponse;

@Entity
@Table(name = "userdetail")
public class UserDetail implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@OneToOne(cascade =CascadeType.REMOVE)
	@Id
	@JoinColumn(name = "registration_email")
	private User user;

	@NotEmpty
	@Column(name = "first_name")
	private String firstName;

	@NotEmpty
	@Column(name = "last_name")
	private String lastName;

	@ManyToOne(cascade = CascadeType.REMOVE, fetch =  FetchType.EAGER)
	@JoinColumn(name ="selected_profile_pic_id")
	private ProfilePicture profilePicture;
	
	@Transient
	private List<ProfilePicResponse> profilePictureList;
	
	@Column(name = "created_at")
	private Date createdAt;
	@Column(name = "updated_at")
	private Date updatedAt;

	public UserDetail() {

	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	
	public ProfilePicture getProfilePicture() {
		return profilePicture;
	}

	public void setProfilePicture(ProfilePicture profilePicture) {
		this.profilePicture = profilePicture;
	}
	
	

	public List<ProfilePicResponse> getProfilePictureList() {
		return profilePictureList;
	}

	public void setProfilePictureList(List<ProfilePicResponse> profilePictureList) {
		this.profilePictureList = profilePictureList;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	

	
	@Override
	public String toString() {
		return "UserDetail [user=" + user + ", firstName=" + firstName + ", lastName=" + lastName + ", profilePicture="
				+ profilePicture + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}

}
