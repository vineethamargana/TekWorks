package com.bank.sys.dto;

import com.bank.sys.enums.UserType;

public class UserDto {

	    private int id;
	    private String email;
	 //   private String password;
	    private UserType userType;
	    private String username;
	    
		public UserDto() {
			super();
			// TODO Auto-generated constructor stub
		}

//		public UserDto(int id, String email, String password, UserType userType, String username) {
//			super();
//			this.id = id;
//			this.email = email;
//			this.password = password;
//			this.userType = userType;
//			this.username = username;
//		}

		public UserDto(int id, String username, String email, UserType userType) {
			this.id = id;
			this.email = email;
			this.userType = userType;
			this.username = username;
			
		}

		public int getId() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }

	    
	    public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

//	    public String getPassword() {
//	        return password;
//	    }
//
//	    public void setPassword(String password) {
//	        this.password = password;
//	    }

	    public UserType getUserType() {
	        return userType;
	    }

	    public void setUserType(UserType userType) {
	        this.userType = userType;
	    }
	    
	    
	
}
