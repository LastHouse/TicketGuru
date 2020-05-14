package fi.rbmk.ticketguru.saleEvent;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import org.springframework.hateoas.Link;

import java.util.Arrays;
import java.util.List;

public class SaleEventLinks {

    private Link selfLink, userLink, saleRowsLink, ticketsLink;
    private List<Link> linkList;

    public SaleEventLinks(SaleEvent saleEvent) {
        Long id = saleEvent.getSaleEvent_id();
        this.selfLink = linkTo(SaleEventController.class).slash(id).withSelfRel();
        this.userLink = linkTo(methodOn(SaleEventController.class).getUser(id)).withRel("user");
        this.saleRowsLink = linkTo(methodOn(SaleEventController.class).getSaleRows(id)).withRel("saleRows");
        this.ticketsLink = linkTo(methodOn(SaleEventController.class).getTickets(id)).withRel("tickets");
        // events
        this.linkList = Arrays.asList(
            selfLink,
            userLink,
            saleRowsLink,
            ticketsLink
        );
    }

    // Getters
    public Link getSelfLink() { return selfLink; }
    public Link getUserLink() { return userLink; }
    public Link getSaleRowsLink() { return saleRowsLink; }
    public Link getTicketsLink() { return ticketsLink; }
    public List<Link> getAll() { return linkList; }
}