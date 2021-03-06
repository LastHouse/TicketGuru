package fi.rbmk.ticketguru.ticketType;

import java.net.URI;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import fi.rbmk.ticketguru.constraintViolationParser.ConstraintViolationParser;
import fi.rbmk.ticketguru.eventTicket.*;

@RestController
@RequestMapping(value = "/api/ticketTypes", produces = "application/hal+json")
public class TicketTypeController {

    @Autowired
    TicketTypeRepository ticketTypeRepository;
    @Autowired
    EventTicketRepository eventTicketRepository;

    private static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    @PostMapping(produces = "application/hal+json")
    public ResponseEntity<?> add(@Valid @RequestBody TicketType newTicketType) {
        try {
        	TicketType ticketType = ticketTypeRepository.save(newTicketType);
        	TicketTypeLinks links = new TicketTypeLinks(ticketType);
        	ticketType.add(links.getAll());
        	Resource<TicketType> resource = new Resource<TicketType>(ticketType);
        	return ResponseEntity.created(URI.create(ticketType.getId().getHref())).body(resource);
        } catch (DuplicateKeyException e) {
        	throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Duplicate entry");
        }
    }    

    @PatchMapping(value = "/{id}", produces = "application/hal+json")
    public ResponseEntity<?> edit(@Valid @RequestBody TicketType newTicketType, @PathVariable Long id) {
        TicketType ticketType = ticketTypeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Invalid ID: " + id));
        if (ticketType.getInvalid() != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cannot modify TicketType that is marked as deleted");
        }
        Set<ConstraintViolation<Object>> violations = validator.validate(newTicketType);
        if (!violations.isEmpty()) {
            ConstraintViolationParser constraintViolationParser = new ConstraintViolationParser(violations, HttpStatus.BAD_REQUEST);
            return ResponseEntity.badRequest().body(constraintViolationParser.parse());
        }
        if (newTicketType.getName() != null && newTicketType.getName() != ticketType.getName()) {
            ticketType.setName(newTicketType.getName());
        }
        ticketTypeRepository.save(ticketType);
        Resource<TicketType> resource = new Resource<TicketType>(ticketType);
        return ResponseEntity.ok(resource);
    }
    
    @DeleteMapping(value = "/{id}", produces = "application/hal+json")
    ResponseEntity<?> delete(@PathVariable Long id) {
        TicketType ticketType = ticketTypeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Invalid ID: " + id));
        if (ticketType.getInvalid() != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cannot modify TicketType that is marked as deleted");
        }
    	ticketType.setInvalid();
    	ticketTypeRepository.save(ticketType);
    	return ResponseEntity.noContent().build();
    }

    @GetMapping(produces = "application/hal+json")
    ResponseEntity<Resources<TicketType>> all() {
        List<TicketType> ticketTypes = ticketTypeRepository.findAll();
        Link link = linkTo(TicketTypeController.class).withSelfRel();
        if (ticketTypes.size() != 0) {
            for (TicketType ticketType : ticketTypes) {
            	TicketTypeLinks links = new TicketTypeLinks(ticketType);
            	ticketType.add(links.getAll());
            }
            Resources<TicketType> resources = new Resources<TicketType>(ticketTypes, link);
            return ResponseEntity.ok(resources);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping(value = "/{id}", produces = "application/hal+json")
    public ResponseEntity<Resource<TicketType>> one(@PathVariable Long id) {
        TicketType ticketType = ticketTypeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Invalid ID: " + id));
        TicketTypeLinks links = new TicketTypeLinks(ticketType);
        ticketType.add(links.getAll());
        Resource<TicketType> resource = new Resource<TicketType>(ticketType);
        return ResponseEntity.ok(resource);
    }

    @GetMapping(value = "/{id}/eventtickets", produces = "application/hal+json")
    public ResponseEntity<Resources<EventTicket>> getEventTickets(@PathVariable Long id) {
        TicketType ticketType = ticketTypeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Invalid ID: " + id));
        Link link = linkTo(TicketTypeController.class).withSelfRel();
        List<EventTicket> eventTickets = ticketType.getEventTickets();
        if (eventTickets.size() != 0) {
            for (EventTicket eventTicket : eventTickets) {
                EventTicketLinks links = new EventTicketLinks(eventTicket);
                eventTicket.add(links.getAll());
            }
            Resources<EventTicket> resources = new Resources<EventTicket>(eventTickets, link);
            return ResponseEntity.ok(resources);
        } else {
            return ResponseEntity.noContent().build(); //Pitäisikö olla .notFound?
        }
    }
}