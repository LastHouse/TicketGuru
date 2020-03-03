package fi.rbmk.ticketguru.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import fi.rbmk.ticketguru.userGroup.UserGroup;

@Entity
@Table(name = "Users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_ID", nullable = false, updatable = false)
	private Long id;

	@Column(name = "name", unique = true)
	@NotEmpty(message = "User name is required")
	@Length(max = 50)
	private String name;

	@NotEmpty(message = "Password is required")
	@Column(name = "password", nullable = false, unique = true)
	@Length(max = 100)
	private String passwordHash;

	@NotEmpty(message = "User group is required")
	@ManyToOne
	@JoinColumn(name = "userGroup_ID")
	private UserGroup userGroup;

	@NotEmpty(message = "Active Status is required | unactive = 0 | active = 1")
	@Column(name = "active")
	@Length(max = 1)
	@Min(0)
	@Max(1)
	private Long active;

	public User() {

	}

	public User(User user) {
	}

	public User(String name, String passwordHash, UserGroup userGroup, Long active) {
		this.name = name;
		this.passwordHash = passwordHash;
		this.userGroup = userGroup;
		this.active = active;
	}

	// Getters

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getPasswordHash() {
		return passwordHash;
	}

	public UserGroup getUserGroups() {
		return userGroup;
	}

	public Long getActive() {
		return active;
	}

	// Setters

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	public void setUserGroups(UserGroup userGroup) {
		this.userGroup = userGroup;
	}

	public void setActive(Long active) {
		this.active = active;
	}

}
