package fi.rbmk.ticketguru.saleEvent;

import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.hateoas.ResourceSupport;

import fi.rbmk.ticketguru.saleRow.SaleRow;
import fi.rbmk.ticketguru.user.User;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@Table(name = "sale_events")
public class SaleEvent extends ResourceSupport {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sale_event_id")
	private Long saleEvent_id;

	@CreationTimestamp
	@Column(name = "created")
	private LocalDateTime created;

	@Column(name = "invalid")
	private LocalDateTime invalid;

	@NotNull(message = "User is required")
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "saleEvent")
	private List<SaleRow> saleRows;

	public SaleEvent() {
		super();
	}

	public SaleEvent(User user) {
		super();
		this.user = user;
	}

	// Getterit
	public Long getSaleEvent_id() { return this.saleEvent_id; }
	public LocalDateTime getCreated() { return created; }
	public LocalDateTime getInvalid() { return invalid; }
	public List<SaleRow> getSaleRows() { return this.saleRows; }
	public User getUser() { return this.user; }

	// Setterit
	public void setInvalid() { this.invalid = LocalDateTime.now(); }
	public void setUser(User user) { this.user = user; }
}
