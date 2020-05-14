package fi.rbmk.ticketguru.ticketStatus;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;
import org.springframework.hateoas.ResourceSupport;

import fi.rbmk.ticketguru.ticket.Ticket;

@Entity
@Table(name = "ticket_statuses")
public class TicketStatus extends ResourceSupport {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ticket_status_id")
	private Long ticketStatus_id;

	@NotEmpty(message = "Ticket status name is required")
	@Length(max = 50)
	@Column(name = "name")
	private String name;
	
	@CreationTimestamp
	@Column(name = "created")
	private LocalDateTime created;

	@Column(name = "invalid")
	private LocalDateTime invalid;

	@OneToMany(mappedBy = "ticketStatus")
	private List<Ticket> tickets;

	public TicketStatus() {
	}

	public TicketStatus(TicketStatus ticketStatus) {
	}

	public TicketStatus(String name) {
		this.name = name;
	}

	// Getters
	public Long getTicketStatus_id() { return this.ticketStatus_id; }
	public String getName() { return this.name; }
	public LocalDateTime getCreated() { return created; }
	public LocalDateTime getInvalid() { return invalid; }
	public List<Ticket> getTickets() { return tickets; }

	// Setters
	public void setName(String name) { this.name = name; }
	public void setInvalid() {  this.invalid = LocalDateTime.now(); }

}