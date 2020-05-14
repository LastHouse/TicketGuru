package fi.rbmk.ticketguru.user;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;
import org.springframework.hateoas.ResourceSupport;

import fi.rbmk.ticketguru.saleEvent.SaleEvent;
import fi.rbmk.ticketguru.userGroup.UserGroup;

@Entity
@Table(name = "users")
public class User extends ResourceSupport {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id", nullable = false, updatable = false)
	private Long user_id;

	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@NotEmpty(message = "Password is required")
	@Length(max = 250)
	@Column(name = "password", nullable = false)
	private String password;

	@NotEmpty(message = "Username is required")
	@Length(max = 50)
	@Column(name = "username", unique = true, nullable = false, updatable = false)
	private String username;

	@Length(max = 100)
	@Column(name = "name")
	private String name;

	@CreationTimestamp
	@Column(name = "created")
	private LocalDateTime created;

	@Column(name = "invalid")
	private LocalDateTime invalid;

	@Column(name = "active")
	private Boolean active = false;

	@ManyToOne
	@NotNull(message = "User Group is required")
	@JoinColumn(name = "user_group_id")
	private UserGroup userGroup;

	@OneToMany(mappedBy = "user")
	private List<SaleEvent> saleEvents;

	public User() {
	}

	public User(User user) {
	}

	public User(String username, String password, UserGroup userGroup) {
		this.username = username;
		this.password = password;
		this.userGroup = userGroup;
		this.active = true;
	}

	public User(String name, String username, String password, UserGroup userGroup, Boolean active) {
		super();
		this.name = name;
		this.username = username;
		this.password = password;
		this.userGroup = userGroup;
		this.active = active;
	}

	// Getters
	public Long getUser_id() { return user_id; }
	public String getName() { return name; }
	public String getUsername() { return username; }
	public String getPassword() { return password; }
	public LocalDateTime getCreated() { return created; }
	public LocalDateTime getInvalid() { return invalid; }
	public Boolean getActive() { return active; }
	public UserGroup getUserGroup() { return userGroup; }
	public List<SaleEvent> getSaleEvents() { return saleEvents; }

	// Setters
	public void setName(String name) { this.name = name; }
	public void setUsername(String username) { this.username = username; }
	public void setPassword(String password) { this.password = password; }
	public void setUserGroup(UserGroup userGroup) { this.userGroup = userGroup; }
	public void setActive(Boolean active) { this.active = active; }
	public void setInvalid() { this.invalid = LocalDateTime.now(); }
}