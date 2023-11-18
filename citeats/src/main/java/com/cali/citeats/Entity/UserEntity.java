package com.cali.citeats.Entity;


import javax.persistence.*;

@Entity
@Table(name = "tbluser")
public class UserEntity {

	@Id
    @Column(name = "UserID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

	@Column(name = "Username", nullable = false)
    private String username;

    @Column(name = "Password", nullable = false)
    private String password;

    @Column(name = "Email")
    private String email;

    @Column(name = "UserType", nullable = false)
    @Enumerated(EnumType.STRING)
    private UserType userType;
    
    public UserEntity() {
		super();
	}
    
    public UserEntity(int userId, String username, String password, String email, UserType userType) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.email = email;
		this.userType = userType;
	}
    
 // Getters
    public Integer getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public UserType getUserType() {
        return userType;
    }

    // Setters
    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public enum UserType {
        Student,
        RestaurantOwner,
        Admin
    }
}