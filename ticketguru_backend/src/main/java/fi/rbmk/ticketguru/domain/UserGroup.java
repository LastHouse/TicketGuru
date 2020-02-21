package fi.rbmk.ticketguru.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "UserGroups")
public class UserGroup {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userGroup_ID")
	private Long id;

	@NotEmpty(message = "User group name is required")
	@Length(max = 100)
	@Column(name = "name")
	private String name;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "id")
	private List<User> users;

	public UserGroup() {
	}

	public UserGroup(UserGroup userGroup) {
	}

	public UserGroup(String name, List<User> users) {
		this.name = name;
		this.users = users;
	}

	// Getters

	public Long getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	// Setters

	public void setName(String name) {
		this.name = name;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

}
