# Get all tickets

Get all Tickets the active User can access with current permission level.

**URL** : `https://rbmk-ticketguru-backend.herokuapp.com/api/tickets`

**Method** : `GET`

**Auth required** : Yes

**Permissions required** : None

**Data constraints** : `{[]}`

## Success Response

**Condition** : Events found.

**Code** : `200 OK`

**Content** :

```json
{
  "_embedded": {
    "tickets": [
      {
        "cheksum": "String",
        "created": "LocalDateTime",
        "invalid": "LocalDateTime",
        "_links": {
          "self": {
            "href": "https://rbmk-ticketguru-backend.herokuapp.com/api/tickets/{id}"
          },
          "eventTicket": {
            "href": "https://rbmk-ticketguru-backend.herokuapp.com/api/tickets/{id}/eventTicket"
          },
          "ticketStatus": {
            "href": "https://rbmk-ticketguru-backend.herokuapp.com/api/tickets/{id}/ticketStatus"
          }
        }
      }
    ]
  },
  "_links": {
    "self": {
      "href": "https://rbmk-ticketguru-backend.herokuapp.com/api/tickets"
    }
  }
}
```
</br>

**Condition** : No tickets found.

**Code** : `404 NOT FOUND`

**Content** : `{ }`

</br>

# Get a single Ticket

Get a single Ticket the active User can access with current permission level.

**URL** : `https://rbmk-ticketguru-backend.herokuapp.com/api/tickets/{id}`
**OR**
**URL** : `https://rbmk-ticketguru-backend.herokuapp.com/api/tickets/{checksum}`

**Method** : `GET`

**Auth required** : Yes

**Permissions required** : None

**Data constraints** : `{}`

## Success Response

**Condition** : Ticket found.

**Code** : `200 OK`

**Content** :

```json
{
  "checksum": "String",
  "created": "LocalDateTime",
  "invalid": "LocalDateTime",
  "_links": {
    "self": {
      "href": "https://rbmk-ticketguru-backend.herokuapp.com/api/tickets/{id}"
    },
    "eventTicket": {
      "href": "https://rbmk-ticketguru-backend.herokuapp.com/api/tickets/{id}/eventTicket"
    },
    "ticketStatus": {
      "href": "https://rbmk-ticketguru-backend.herokuapp.com/api/tickets/{id}/ticketStatus"
    }
  }
}
```
</br>

## Failure Response

**Condition** : Ticket not found or invalid ID/ checksum.

**Code** : `404 NOT FOUND`

**Content** :

```json
{
    "timestamp": "LocalDateTime",
    "status": 404,
    "error": "Not Found",
    "message": "Invalid ID: {id}",
    "path": "/api/tickets/{id}"
}
```
</br>

# Validate a Ticket

Validate a ticket.

**URL** : `https://rbmk-ticketguru-backend.herokuapp.com/api/tickets/validate/{checksum}`

**Method** : `GET`

**Auth required** : Yes

**Permissions required** : None

**Data constraints** : `{}`

## Success Response

**Condition** : Ticket found.

**Code** : `200 OK`

**Content** :

```json
{
  "checksum": "String",
  "created": "LocalDateTime",
  "invalid": "LocalDateTime",
  "_links": {
    "self": {
      "href": "https://rbmk-ticketguru-backend.herokuapp.com/api/tickets/{id}"
    },
    "eventTicket": {
      "href": "https://rbmk-ticketguru-backend.herokuapp.com/api/tickets/{id}/eventTicket"
    },
    "ticketStatus": {
      "href": "https://rbmk-ticketguru-backend.herokuapp.com/api/tickets/{id}/ticketStatus"
    }
  }
}
```
</br>

## Failure Response

**Condition** : Ticket not found or checksum.

**Code** : `404 NOT FOUND`

**Content** :

```json
{
    "timestamp": "LocalDateTime",
    "status": 404,
    "error": "Not Found",
    "message": "Invalid Checksum",
    "path": "/api/tickets/validate/{checksum}"
}
```
</br>

# Get ticket type

Get event ticket for given ticket id.

**URL** : `https://rbmk-ticketguru-backend.herokuapp.com/api/tickets/{id}/eventTicket`

**Method** : `GET`

**Auth required** : Yes

**Permissions required** : None

**Data constraints** : `{}`

## Success Response

**Condition** : Event ticket found.

**Code** : `200 OK`

**Content** : 

```json
{
  "ticketCount": "Long",
  "price": "Double",
  "created": "LocalDateTime",
  "invalid": "LocalDateTime",
  "_links": {
    "self": {
      "href": "https://rbmk-ticketguru-backend.herokuapp.com/api/eventTickets/{id}"
    },
    "event": {
      "href": "https://rbmk-ticketguru-backend.herokuapp.com/api/eventTickets/{id}/event"
    },
    "ticketType": {
      "href": "https://rbmk-ticketguru-backend.herokuapp.com/api/eventTickets/{id}/ticketType"
    }
  }
}
```
</br>

## Failure Response

**Condition** : Invalid ticket ID.

**Code** : `404 NOT FOUND`

**Content** : 

```json
{
    "timestamp": "LocalDateTime",
    "status": 404,
    "error": "Not Found",
    "message": "Invalid ID: {id}",
    "path": "/api/tickets/{id}/eventTicket"
}
```
</br>

# Get ticket status

Get ticket status for given ticket id.

**URL** : `https://rbmk-ticketguru-backend.herokuapp.com/api/tickets/{id}/ticketStatus`

**Method** : `GET`

**Auth required** : Yes

**Permissions required** : None

**Data constraints** : `{}`

## Success Response

**Condition** : Ticket status found.

**Code** : `200 OK`

**Content** : 

```json
{
  "name": "String",
  "created": "LocalDateTime",
  "invalid": "LocalDateTime",
  "_links": {
    "self": {
      "href": "https://rbmk-ticketguru-backend.herokuapp.com/api/ticketStatuses/{id}"
    },
    "tickets": {
      "href": "https://rbmk-ticketguru-backend.herokuapp.com/api/ticketStatuses/{id}/tickets"
    }
  }
}
```
</br>

## Failure Response

**Condition** : Invalid ticket ID.

**Code** : `404 NOT FOUND`

**Content** : 

```json
{
    "timestamp": "LocalDateTime",
    "status": 404,
    "error": "Not Found",
    "message": "Invalid ID: {id}",
    "path": "/api/tickets/{id}/ticketStatus"
}
```
