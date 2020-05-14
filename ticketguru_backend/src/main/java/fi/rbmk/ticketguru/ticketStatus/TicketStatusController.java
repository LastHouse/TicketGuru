package fi.rbmk.ticketguru.ticketStatus;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import java.net.URI;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

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
import fi.rbmk.ticketguru.ticket.*;

@RestController
@RequestMapping(value = "/api/ticketStatuses", produces = "application/hal+json")
public class TicketStatusController {

    @Autowired
    TicketStatusRepository tSRepository;
    @Autowired
    TicketRepository tRepository;

    private static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    @PostMapping(produces = "application/hal+json")
    public ResponseEntity<?> add(@RequestBody TicketStatus newTicketStatus) {
        try {
            Set<ConstraintViolation<Object>> violations = validator.validate(newTicketStatus);
            if (!violations.isEmpty()) {
                ConstraintViolationParser constraintViolationParser = new ConstraintViolationParser(violations, HttpStatus.BAD_REQUEST);
                return ResponseEntity.badRequest().body(constraintViolationParser.parse());
            }
            TicketStatus ticketStatus = tSRepository.save(newTicketStatus);
            TicketStatusLinks links = new TicketStatusLinks(ticketStatus);
            ticketStatus.add(links.getAll());
            Resource<TicketStatus> resource = new Resource<TicketStatus>(ticketStatus);
            return ResponseEntity.created(URI.create(ticketStatus.getId().getHref())).body(resource);
        } catch (DuplicateKeyException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Duplicate entry");
        }
    }

    @PatchMapping(value = "/{id}", produces = "application/hal+json")
    public ResponseEntity<?> edit(@RequestBody TicketStatus newTicketStatus, @PathVariable Long id) {
        TicketStatus ticketStatus = tSRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Invalid ID: + id"));
        if (ticketStatus.getInvalid() != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cannot modify TicketStatus that is marked as deleted");
        }
        Set<ConstraintViolation<Object>> violations = validator.validate(newTicketStatus);
        if (!violations.isEmpty()) {
            ConstraintViolationParser constraintViolationParser = new ConstraintViolationParser(violations, HttpStatus.BAD_REQUEST);
            return ResponseEntity.badRequest().body(constraintViolationParser.parse());
        }
        if (newTicketStatus.getName() != null && newTicketStatus.getName() != ticketStatus.getName()) {
            ticketStatus.setName(newTicketStatus.getName());
        }
        tSRepository.save(ticketStatus);
        TicketStatusLinks links = new TicketStatusLinks(ticketStatus);
        ticketStatus.add(links.getAll());
        Resource<TicketStatus> resource = new Resource<TicketStatus>(ticketStatus);
        return ResponseEntity.ok(resource);
    }
    
    @DeleteMapping(value = "/{id}", produces = "application/hal+json")
    ResponseEntity<?> delete(@PathVariable Long id) {
        TicketStatus ticketStatus = tSRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Invalid ID: " + id));
        if (ticketStatus.getInvalid() != null) {
            /*return ResponseEntity.badRequest().body("Cannot modify TicketStatus that is marked as deleted");*/
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cannot modify TicketStatus that is marked as deleted");
        }
    	ticketStatus.setInvalid();
    	tSRepository.save(ticketStatus);
    	return ResponseEntity.noContent().build();
    }

    @GetMapping(produces = "application/hal+json")
    ResponseEntity<Resources<TicketStatus>> all() {
        List<TicketStatus> ticketStatuses = tSRepository.findAll();
        Link link = linkTo(TicketStatusController.class).withSelfRel();
        if (ticketStatuses.size() != 0) {
            for (TicketStatus ticketStatus : ticketStatuses) {
                TicketStatusLinks links = new TicketStatusLinks(ticketStatus);
                ticketStatus.add(links.getAll());
            }
            Resources<TicketStatus> resources = new Resources<TicketStatus>(ticketStatuses, link);
            return ResponseEntity.ok(resources);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping(value = "/{id}", produces = "application/hal+json")
    public ResponseEntity<Resource<TicketStatus>> one(@PathVariable Long id) {
        TicketStatus ticketStatus = tSRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Invalid ID: " + id));
        TicketStatusLinks links = new TicketStatusLinks(ticketStatus);
        ticketStatus.add(links.getAll());
        Resource<TicketStatus> resource = new Resource<TicketStatus>(ticketStatus);
        return ResponseEntity.ok(resource);
    }

    @GetMapping(value = "/{id}/tickets", produces = "application/hal+json")
    public ResponseEntity<Resources<Ticket>> getTickets(@PathVariable Long id) {
        TicketStatus ticketStatus = tSRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Invalid ID: " + id));
        Link link = linkTo(TicketStatusController.class).withSelfRel();
        List<Ticket> tickets = ticketStatus.getTickets();
        if (tickets.size() != 0) {
            for (Ticket ticket : tickets) {
                TicketLinks links = new TicketLinks(ticket);
                ticket.add(links.getAll());
            }
            Resources<Ticket> resources = new Resources<Ticket>(tickets, link);
            return ResponseEntity.ok(resources);
        } else {
            return ResponseEntity.noContent().build();
        }
    }
}