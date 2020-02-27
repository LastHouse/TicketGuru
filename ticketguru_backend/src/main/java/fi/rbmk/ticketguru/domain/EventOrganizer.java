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

import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "EventOrganizers")
public class EventOrganizer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "eventOrganizer_ID")
	private Long id;
	private String name, streetAddress, tel, email, www, contactPerson;

	@NotEmpty(message = "Postcode is required")
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "postcode_ID")
    private Postcode postcode;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "eventOrganizer")
	private List<Event> events;
	
	public EventOrganizer() {
	}

	public EventOrganizer(EventOrganizer eventOrganizer) {
	}
  
	public Long getID() {
		return id;
	}

	public Postcode getPostcode() {
		return postcode;
	}

	public void setPostcode(Postcode postcode) {
		this.postcode = postcode;
	}

	public String getEmail() {
		return email;
	}

	public String getWWW() {
		return www;
	}

	public String getContactPerson() {
		return contactPerson;
	}

	public Postcode getPostcode() {
		return postcode;
	}
	
	public List<Event> getEvents() {
		return events;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	
	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}	
	
	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}	
	
	public String getEmail() {
		return companyEmail;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setWWW(String www) {
		this.www = www;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}
	
	@Override
	public String toString() {
		return "EventOrganizer[id=" + id + ", name=" + name + ", streetAddress="
				+ streetAddress + ", tel=" + tel + ", email=" + email
				+ ", www=" + www+ ", contactPerson=" + contactPerson + ", postcode=" + postcode + "]";
	}

	public EventOrganizer(Long id, Postcode postcode, String name, String streetAddress,
			String tel, String email, String www, String contactPerson) {

		super();
		this.id = id;
		this.postcode = postcode;
		this.name = name;
		this.streetAddress = streetAddress;
		this.tel = tel;
		this.email = email;
		this.www = www;
		this.contactPerson = contactPerson;
	}
}