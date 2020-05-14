package fi.rbmk.ticketguru.eventTicket;

import fi.rbmk.ticketguru.event.Event;
import fi.rbmk.ticketguru.ticket.Ticket;
import fi.rbmk.ticketguru.ticketType.TicketType;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.hateoas.ResourceSupport;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "event_tickets")
public class EventTicket extends ResourceSupport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_ticket_id")
    private Long eventTicket_id;

    @Column(name = "ticket_count")
    private Long ticketCount;

    @Column(name = "price")
    private Double price;

    @CreationTimestamp
    @Column(name = "created")
    private LocalDateTime created;

    @Column(name = "invalid")
    private LocalDateTime invalid;

    @NotNull(message = "Event must be set")
    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    @NotNull(message = "Ticket type must be set")
    @ManyToOne
    @JoinColumn(name = "ticket_type_id")
    private TicketType ticketType;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "eventTicket")
	private List<Ticket> tickets;

    public EventTicket() {
        super();
    }

    public EventTicket(EventTicket eventTicket) {
    }

    // Getters
    public Long getEventTicket_id() { return eventTicket_id; }
    public Long getTicketCount() { return ticketCount; }
    public Double getPrice() { return price; }
    public LocalDateTime getCreated() { return created; }
    public LocalDateTime getInvalid() { return invalid; }
    public Event getEvent() { return event; }
    public TicketType getTicketType() { return ticketType; }
    public List<Ticket> getTickets() { return tickets; }

    // Setters
    public void setEventTicket_ID(Long id) { this.eventTicket_id = id; }
    public void setTicketCount(Long ticketCount) { this.ticketCount = ticketCount; }
    public void setPrice(Double price) { this.price = price; }
    public void setEvent(Event event) { this.event = event; }
    public void setTicketType(TicketType ticketType) { this.ticketType = ticketType; }
    public void setInvalid() { this.invalid = LocalDateTime.now(); }
}