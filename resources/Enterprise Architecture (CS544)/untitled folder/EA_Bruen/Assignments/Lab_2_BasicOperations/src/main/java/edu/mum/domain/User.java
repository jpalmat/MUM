package edu.mum.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

@Entity()
@Table(name="Users")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "USER_ID", nullable = false, unique = true, length = 20)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id = null;

	@Column(name="FIRSTNAME")
	private String firstName;

	@Column(name="LASTNAME")
	private String lastName;

	@Column(name="EMAIL")
	private String email;

	@Column(name="RANKING" , length=11)
	private int ranking = 0;
	
	@Column(name="IS_ADMIN")
	private boolean admin = false;

	@Version
	private int version = 0;

	@Column(name="lastLogin")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastLogin;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstname) {
		this.firstName = firstname;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastname) {
		this.lastName = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getRanking() {
		return ranking;
	}

	public void setRanking(int ranking) {
		this.ranking = ranking;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

}