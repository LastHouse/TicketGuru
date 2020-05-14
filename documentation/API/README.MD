# TicketGuru REST API

Here's documentation for TicketGuru REST API.

## Base-URL

`https://rbmk-ticketguru-backend.herokuapp.com`

## Endpoints require Authentication

Closed endpoints require a valid Token to be included in the header of the
request.

* [Authentication](authentication.md) : `POST /api/login/`

### Endpoint listing

Each endpoint manipulates or displays information::

* [Events](event/get.md) : `GET /api/events/`
* [Events](event/post.md) : `POST /api/events/`
* [Events](event/patch.md) : `PATCH /api/events/{id}`
* [Events](event/delete.md) : `DELETE /api/events/{id}`
* [SaleEvents](saleEvents/get.md) : `GET /api/saleEvents/`
* [saleEvents](saleEvents/post.md) : `POST /api/saleEvents/`
* [saleEvents](saleEvents/patch.md) : `PATCH /api/saleEvents/{id}`
* [saleEvents](saleEvents/delete.md) : `DELETE /api/saleEvents/{id}`
* [SaleRows](salerow/get.md) : `GET /api/saleRows/`
* [SaleRows](salerow/post.md) : `POST /api/saleRows/`
* [SaleRows](salerow/patch.md) : `PATCH /api/saleRows/{id}`
* [SaleRows](salerow/delete.md) : `DELETE /api/saleRows/{id}`
* [Tickets](ticket/get.md) : `GET /api/tickets/`
* [Tickets](ticket/patch.md) : `PATCH /api/tickets/{id}`
* [Tickets](ticket/delete.md) : `DELETE /api/tickets/{id}`
* [Users](user/get.md) : `GET /api/users/`
* [Users](user/post.md) : `POST /api/users/`
* [Users](user/patch.md) : `PATCH /api/users/{id}`
* [Users](user/delete.md) : `DELETE /api/users/{id}`
* [Usergroups](usergroup/get.md) : `GET /api/userGroups/`
* [Usergroups](usergroup/post.md) : `POST /api/userGroups/`
* [Usergroups](usergroup/patch.md) : `PATCH /api/userGroups/{id}`
* [Usergroups](usergroup/delete.md) : `DELETE /api/userGroups/{id}`
* [EventOrganizers](eventorganizer/get.md) : `GET /api/eventOrganizers/`
* [EventOrganizers](eventorganizer/post.md) : `POST /api/eventOrganizers/`
* [EventOrganizers](eventorganizer/patch.md) : `PATCH /api/eventOrganizers/{id}`
* [EventOrganizers](eventorganizer/delete.md) : `DELETE /api/eventOrganizers/{id}`
* [EventTickets](eventTicket/get.md) : `GET /api/EventTicket/`
* [EventTickets](eventTicket/post.md) : `POST /api/eventTickets/`
* [EventTickets](eventTicket/patch.md) : `PATCH /api/eventTickets/{id}`
* [EventTickets](eventTicket/delete.md) : `DELETE /api/eventTickets/{id}`
* [Postcodes](postcode/get.md) : `GET /api/postcodes/`
* [Postcodes](postcode/post.md) : `POST /api/postcodes/`
* [Postcodes](postcode/patch.md) : `PATCH /api/postcodes/{id}`
* [Postcodes](postcode/delete.md) : `DELETE /api/postcodes/{id}`
* [AgeLimits](agelimit/get.md) : `GET /api/ageLimits/`
* [AgeLimits](agelimit/post.md) : `POST /api/ageLimits/`
* [AgeLimits](agelimit/patch.md) : `PATCH /api/ageLimits/{id}`
* [AgeLimits](agelimit/delete.md) : `DELETE /api/ageLimits/{id}`
* [TicketTypes](tickettype/get.md) : `GET /api/ticketTypes/`
* [TicketTypes](tickettype/post.md) : `POST /api/ticketTypes/`
* [TicketTypes](tickettype/patch.md) : `PATCH /api/ticketTypes/{id}`
* [TicketTypes](tickettype/delete.md) : `DELETE /api/ticketTypes/{id}`
* [TicketStatuses](ticketstatus/get.md) : `GET /api/ticketStatuses/`
* [TicketStatuses](ticketstatus/post.md) : `POST /api/ticketStatuses/`
* [TicketStatuses](ticketstatus/patch.md) : `PATCH /api/ticketStatuses/{id}`
* [TicketStatuses](ticketstatus/delete.md) : `DELETE /api/ticketStatuses/{id}`
* [Venues](venue/get.md) : `GET /api/venues/`
* [Venues](venue/post.md) : `POST /api/venues/`
* [Venues](venue/patch.md) : `PATCH /api/venues/{id}`
* [Venues](venue/delete.md) : `DELETE /api/venues/{id}`
