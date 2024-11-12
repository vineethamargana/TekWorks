package com.bank.sys.entity;

import java.util.List;

import com.bank.sys.enums.UserType;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class User {
	

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;
    
    @Column(nullable = false, unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    private UserType userType; // User type (ADMIN or CUSTOMER)

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Account> accounts;

    

    /**
	 * 
	 */
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int id, String username, String password, UserType userType, String email) 
    {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.userType = userType;
		
	}
    
	public User(int id, String username, String password,  UserType userType,String email, List<Account> accounts) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.userType = userType;
		this.accounts = accounts;
	}



	public User(String username, String password, UserType userType,String useremail) {
        this.username = username;
        this.password = password;
        this.userType = userType;
        this.email = useremail;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }


	@Override
	public String toString() {
		return "User [userid=" + id + ", username=" + username + ", email=" + email + ", password=" + password
				+  ", accounts=" + accounts + "]";
	} 
}
