package fi.rbmk.ticketguru.domain;

import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import org.hibernate.validator.constraints.Length;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@Table(name="Events")
public class Event {

    @Id // Määritellään kenttä ID:ksi
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Automaattinen juoksenva numerointi. HUOM! Käytetään GenerationType.IDENTITY spring bootin bugin vuoksi
    @Column(name = "event_ID") // Tietokannassa olevan kentän nimi
    private Long id; // Muuttujan nimi, ei välttämättä sama kuin tietokannassa. Tässä tapauksessa id jotta automaattisesti generoidut funktiot toimivat

    @NotEmpty(message = "Event name is required") // Lisätään pakollisiin kenttiin virheilmoituksen kera
    @Length(max = 250) // Määritellään kaikille kentille jotka sen vaativat maksimipituus
    @Column(name = "name")
    private String name;

    //@NotNull(message = "Event type is required")
    @JsonIgnore
    @ManyToOne // Relaatio
    @JoinColumn(name = "eventType_ID") // Mitä kenttää tietokannassa viitataan
    private EventType eventType; // Huomatkaa että FK tyyppiset kentät ovat objektityyppi, ei string, long tai int

    //@NotNull(message = "Event datetime is required")
    @Column(name = "dateTime")
    //@JsonFormat(pattern = "YYYY-MM-dd HH:mm")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime dateTime; // Aikaleimoihin joissa vaaditaan sekä päivä että kellonaika käytetään
                                    // LocalDateTime tyyppiä

    //@NotNull(message = "Event organizer is required")
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "eventOrganizer_ID")
    private EventOrganizer eventOrganizer;

    //@NotNull(message = "Event venue is required")
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "venue_ID")
    private Venue venue;

    @NotNull(message = "Event ticket capacity is required")
    @Column(name = "ticketCapacity")
    private Long ticketCapacity;

    //@NotNull(message = "Age limit must be set")
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "ageLimit_ID")
    private AgeLimit ageLimit; 

    @Length(max = 500)
    @Column(name = "info")
    private String info;

    @JsonIgnore
    @OneToMany(mappedBy = "event")
    private List<EventTicket> eventTickets;

    // Tyhjä construktori
    public Event() {}
    // Kopioidaan olemassaolevasta/ syötetään olemassa oleva constructorille
    public Event(Event event) {}
    // Constuctori vain pakollisille kentille
    public Event(String name, EventType eventType, LocalDateTime eventDateTime, EventOrganizer eventOrganizer, Venue venue, Long ticketCapacity, AgeLimit ageLimit) {
        this.name = name;
        this.eventType = eventType;
        this.dateTime = eventDateTime;
        this.eventOrganizer = eventOrganizer;
        this.venue = venue;
        this.ticketCapacity = ticketCapacity;
        this.ageLimit = ageLimit;
    }
    // Constructori missä mukana vapaaehtoiset kentät
    public Event(String name, EventType eventType, LocalDateTime eventDateTime, EventOrganizer eventOrganizer, Venue venue, Long ticketCapacity, AgeLimit ageLimit, String eventInfo) {
        this.name = name;
        this.eventType = eventType;
        this.dateTime = eventDateTime;
        this.eventOrganizer = eventOrganizer;
        this.venue = venue;
        this.ticketCapacity = ticketCapacity;
        this.ageLimit = ageLimit;
        this.info = eventInfo;
    }

    //Getterit
    public Long getId() { return this.id; }
    public String getName() { return this.name; }
    public EventType getEventType() { return eventType; }
    public LocalDateTime getDateTime() { return dateTime; }
    public EventOrganizer getEventOrganizer() { return eventOrganizer; }
    public Venue getVenue() { return venue; }
    public Long getTicketCapacity() { return ticketCapacity; }
    public AgeLimit getAgeLimit() { return ageLimit; }
    public String getInfo() { return info; }
    public List<EventTicket> getEventTickets() { return eventTickets; }
    //Setterit
    public void setName(String name) { this.name = name; }
    public void setEventType(EventType eventType) { this.eventType = eventType; }
    public void setDateTime(LocalDateTime eventDateTime) { this.dateTime = eventDateTime; }
    public void setEventOrganizer(EventOrganizer eventOrganizer) { this.eventOrganizer = eventOrganizer; }
    public void setVenue(Venue venue) { this.venue = venue; }
    public void setTicketCapacity(Long ticketCapacity) { this.ticketCapacity = ticketCapacity; }
    public void setAgeLimit(AgeLimit ageLimit) { this.ageLimit = ageLimit; }
    public void setInfo(String eventInfo) { this.info = eventInfo;
    }
}