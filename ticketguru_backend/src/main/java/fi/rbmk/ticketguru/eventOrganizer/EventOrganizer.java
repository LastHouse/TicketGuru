package fi.rbmk.ticketguru.eventOrganizer;

import fi.rbmk.ticketguru.event.Event;
import fi.rbmk.ticketguru.postcode.Postcode;

import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.hateoas.ResourceSupport;

import javax.persistence.JoinColumn;

@Entity
@Table(name = "EventOrganizers")
public class EventOrganizer extends ResourceSupport {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "eventOrganizer_ID")
	private Long eventOrganizer_ID;

	@NotEmpty(message = "Event organizer name is required")
	@Column(name = "name")
	private String name;
	
	@Column(name = "streetAddress")
	private String streetAddress;
	
	@Column(name = "tel")
	private String tel;

	@Column(name = "email")
	private String email;

	@Column(name = "www")
	private String www;

	@Column(name = "contactPerson")
	private String contactPerson;

	@NotEmpty(message = "Postcode is required")
	@ManyToOne
	@JoinColumn(name = "postcode_ID")
	private Postcode postcode;

	@CreationTimestamp
	@Column(name = "created")
	private LocalDateTime created;

	@Column(name = "invalid")
	private LocalDateTime invalid;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "eventOrganizer")
	private List<Event> events;

	public EventOrganizer() {
	}

	public EventOrganizer(EventOrganizer eventOrganizer) {
	}

	public EventOrganizer(Long id, Postcode postcode, String name, String streetAddress, String tel, String email,
			String www, String contactPerson) {
		super();
		this.eventOrganizer_ID = id;
		this.postcode = postcode;
		this.name = name;
		this.streetAddress = streetAddress;
		this.tel = tel;
		this.email = email;
		this.www = www;
		this.contactPerson = contactPerson;
	}

	// Getters
	public Long getEventOrganizer_ID() { return eventOrganizer_ID; }
	public String getName() { return name; }
	public String getStreetAddress() { return streetAddress; }
	public String getTel() { return tel; }
	public String getEmail() { return email; }
	public String getWWW() { return www; }
	public String getContactPerson() { return contactPerson; }
	public Postcode getPostcode() { return postcode; }
	public LocalDateTime getCreated() { return created; }
	public LocalDateTime getInvalid() { return invalid; }
	public List<Event> getEvents() { return events; }

	// Setters
	public void setName(String name) { this.name = name; }
	public void setStreetAddress(String streetAddress) { this.streetAddress = streetAddress; }
	public void setTel(String tel) { this.tel = tel; }
	public void setEmail(String email) { this.email = email; }
	public void setWWW(String www) { this.www = www; }
	public void setContactPerson(String contactPerson) { this.contactPerson = contactPerson; }
	public void setPostcode(Postcode postcode) { this.postcode = postcode; }
	public void setInvalid() { this.invalid = LocalDateTime.now(); }

	@Override
	public String toString() {
		return "EventOrganizer[id=" + eventOrganizer_ID + ", name=" + name + ", streetAddress=" + streetAddress
				+ ", tel=" + tel + ", email=" + email + ", www=" + www + ", contactPerson=" + contactPerson
				+ ", postcode=" + postcode + "]";
	}
}