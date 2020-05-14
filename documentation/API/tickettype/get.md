# Get all TicketTypes

Get all TicketTypes the active User can access with current permission level.

**URL** : `https://rbmk-ticketguru-backend.herokuapp.com/api/ticketTypes`

**Method** : `GET`

**Auth required** : Yes

**Permissions required** : None

**Data constraints** : `{[]}`

## Success Response

**Condition** : TicketTypes found.

**Code** : `200 OK`

**Content** :

```json
{
  "_embedded": {
    "ticketTypes": [
      {
        "name": "String",
        "created": "LocalDateTime",
        "invalid": "LocalDateTime",
        "_links": {
          "self": {
            "href": "https://rbmk-ticketguru-backend.herokuapp.com/api/ticketTypes/{id}"
          },
          "eventTickets": {
            "href": "https://rbmk-ticketguru-backend.herokuapp.com/api/ticketTypes/{id}/eventtickets"
          }
        }
      }
    ]
  },
  "_links": {
    "self": {
      "href": "https://rbmk-ticketguru-backend.herokuapp.com/api/ticketTypes"
    }
  }
}
```
</br>

**Condition** : No TicketTypes.

**Code** : `404 Not Found`

**Content** :

```json
{ }
```
</br>

# Get a TicketType

Get a single TicketType the active User can access with current permission level.

**URL** : `https://rbmk-ticketguru-backend.herokuapp.com/api/ticketTypes/{id}`

**Method** : `GET`

**Auth required** : Yes

**Permissions required** : None

**Data constraints** : `{}`

## Success Response

**Condition** : TicketType found.

**Code** : `200 OK`

**Content** :

```json
{
  "name": "String",
  "created": "LocalDateTime",
  "invalid": "LocalDateTime",
  "_links": {
    "self": {
      "href": "https://rbmk-ticketguru-backend.herokuapp.com/api/ticketTypes/{id}"
    },
    "eventTickets": {
      "href": "https://rbmk-ticketguru-backend.herokuapp.com/api/ticketTypes/{id}/eventtickets"
    }
  }
}
```
</br>

## Failure Response

**Condition** : TicketType not found or invalid ID.

**Code** : `404 NOT FOUND`

**Content** :

```json
{
    "timestamp": "LocalDateTime",
    "status": 404,
    "error": "Not Found",
    "message": "Invalid ID: {id}",
    "path": "/api/ticketTypes/{id}"
}
```
</br>
