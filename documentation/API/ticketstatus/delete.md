# Delete a TicketStatus

Delete a TicketStatus

**URL** : `https://rbmk-ticketguru-backend.herokuapp.com/api/ticketStatuses/{id}`

**Method** : `DELETE`

**Auth required** : Yes

**Permissions required** : None

**Data constraints**

Provide the URL of TicketStatus to be deleted e.g. https://rbmk-ticketguru-backend.herokuapp.com/api/ticketStatuses/1

## Success Response

**Condition** : If everything is OK.

**Code** : `204 No Content`

**Content example**

```json
{}
```
</br>

## Error Responses

**Condition** : ID is missing.

**Code** : `404 Not Found`

**Content example**

```json
{
    "timestamp": "LocalDateTime",
    "status": 404,
    "error": "Not Found",
    "message": "No message available"
    "path": "/api/ticketStatuses/"
}
```
</br>

**Condition** : Invalid ID.

**Code** : `404 Not Found`

**Content example**

```json
{
{}
}
```
</br>

**Condition** : Event is already marked as deleted.

**Code** : `400 Bad Request`

**Content example**

```json
{
    "timestamp": "LocalDateTime",
    "status": 400,
    "error": "Bad Request",
    "message": "Cannot modify Event that is marked as deleted",
    "path": "/api/events/{id}"
}
```
