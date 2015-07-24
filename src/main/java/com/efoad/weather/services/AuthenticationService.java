package com.efoad.weather.services;

import org.springframework.stereotype.Service;

import com.efoad.weather.models.User;
@Service
public class AuthenticationService {
	private User currentUser;

	public User getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}
	
}
