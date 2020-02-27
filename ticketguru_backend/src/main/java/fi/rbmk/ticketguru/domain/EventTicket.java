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
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

@Entity
public class EventTicket {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "eventTicket_ID")
  private Long id;
  private Long ticketCount, price;

  @NotEmpty(message = "Event must be set")
  @ManyToOne
  @JoinColumn(name = "event_ID")
  private Event event; 

  @NotEmpty(message = "Ticket type must be set")
  @ManyToOne
  @JoinColumn(name = "ticketType_ID")
  private TicketType ticketType; 

  public EventTicket() {
	  super();
  }

  public EventTicket(EventTicket eventTicket) {
  }

  public Long getId() {
	  return id;
  }
  
  public void setId(Long id) {
	  this.id = id;
  }

  public Long getTicketCount() {
	  return ticketCount;
  }
  
  public void setTicketCount(Long ticketCount) {
	  this.ticketCount = ticketCount;
  }

  public Long getPrice() {
	  return price;
  }

  public void setPrice(Long price) {
	  this.price = price;
  }

  public Event getEvent() {
	  return event;
  }
  
  public void setEvent(Event event) {
    this.event = event;
  }

  public TicketType getTicketType() {
    return ticketType;
  }
  
  public void setTicketTypeD(TicketType ticketType) {
	  this.ticketType = ticketType;
  }

  @Override
  public String toString() {
	  return "EventTicket [eventTickets_ID=" + id + ", event=" + event + ", ticketType="
			+ ticketType + ", ticketCount=" + ticketCount + ", price=" + price + "]";
  }