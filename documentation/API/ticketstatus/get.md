# Get all TicketStatuses

Get all TicketStatuses the active User can access with current permission level.

**URL** : `https://rbmk-ticketguru-backend.herokuapp.com/api/TicketStatuses`

**Method** : `GET`

**Auth required** : Yes

**Permissions required** : None

**Data constraints** : `{[]}`

## Success Response

**Condition** : TicketStatuses found.

**Code** : `200 OK`

**Content** :

```json
{
  "_embedded": {
    "ticketStatuses": [
      {
        "name": "String",
        "created": "2020-04-11T00:55:20.885919",
        "invalid": "LocalDateTime",
        "_links": {
          "self": {
            "href": "https://rbmk-ticketguru-backend.herokuapp.com/api/ticketStatuses/1"
          },
          "ticketStatus": {
            "href": "https://rbmk-ticketguru-backend.herokuapp.com/api/ticketStatuses/1"
          },
          "tickets": {
            "href": "https://rbmk-ticketguru-backend.herokuapp.com/api/ticketStatuses/1/tickets"
          }
        }
      }
    ]
  },
  "_links": {
    "self": {
      "href": "https://rbmk-ticketguru-backend.herokuapp.com/api/ticketStatuses/"
    },
    "profile": {
      "href": "https://rbmk-ticketguru-backend.herokuapp.com/api/profile/ticketStatuses"
    },
    "search": {
      "href": "https://rbmk-ticketguru-backend.herokuapp.com/api/ticketStatuses/search"
    }
  }
}
```
</br>

**Condition** : No TicketStatuses.

**Code** : `404 Not Found`

**Content** :

```json
{ }
```
</br>

# Get a TicketStatus

Get a single TicketStatus the active User can access with current permission level.

**URL** : `https://rbmk-ticketguru-backend.herokuapp.com/api/ticketStatuses/{id}`

**Method** : `GET`

**Auth required** : Yes

**Permissions required** : None

**Data constraints** : `{}`

## Success Response

**Condition** : TicketStatus found.

**Code** : `200 OK`

**Content** :

```json
{
  "name": "String",
  "created": "LocalDateTime",
  "invalid": "LocalDateTime",
  "_links": {
    "self": {
      "href": "https://rbmk-ticketguru-backend.herokuapp.com/api/ticketStatuses/1"
    },
    "ticketStatus": {
      "href": "https://rbmk-ticketguru-backend.herokuapp.com/api/ticketStatuses/1"
    },
    "tickets": {
      "href": "https://rbmk-ticketguru-backend.herokuapp.com/api/ticketStatuses/1/tickets"
    }
  }
}
```
</br>

## Failure Response

**Condition** : TicketStatus not found or invalid ID.

**Code** : `404 NOT FOUND`

**Content** :

```json
{
{}
}
```
</br>
