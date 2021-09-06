package com.kardex.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(schema = "kardex", name = "users")
public class Users {
	
	private static final long serialVersionUID = 1L;
	@Id
	@SequenceGenerator(name = "USERID_GENERATOR", sequenceName = "sec_user", initialValue = 1, allocationSize = 1 )
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "USERID_GENERATOR")
    @Basic(optional = false)
    @NotNull
    @Column(name = "user_id")
	private Long userId;

    @Column(name = "user_name")
	private String userName;
    
    @Column(name = "user_email")
	private String userEmail;
    
    @Column(name = "user_password")
	private String userPassword;
    
	public Users() {
		super();
	}

	public Users(Long userId, String userName, String userEmail, String userPassword) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

    

}
