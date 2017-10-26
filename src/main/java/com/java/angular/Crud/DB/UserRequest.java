package com.java.angular.Crud.DB;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserRequest {
	@JsonProperty
	private String name;
	
	@JsonProperty
	private String role;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
