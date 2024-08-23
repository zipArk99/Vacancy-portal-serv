package com.app.vacancyportal.dto;

import java.io.Serializable;


public class ProfilePicResponse  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String profilePath;
	private int pictureId;
	
	
	public ProfilePicResponse() {
		
	}
	
	
	
	public ProfilePicResponse(String profilePath, int pictureId) {
		super();
		this.profilePath = profilePath;
		this.pictureId = pictureId;
	}



	public String getProfilePath() {
		return profilePath;
	}
	public void setProfilePath(String profilePath) {
		this.profilePath = profilePath;
	}
	public int getPictureId() {
		return pictureId;
	}
	public void setPictureId(int pictureId) {
		this.pictureId = pictureId;
	}
	@Override
	public String toString() {
		return "ProfilePicResponse [profilePath=" + profilePath + ", pictureId=" + pictureId + "]";
	}
	
	

}
