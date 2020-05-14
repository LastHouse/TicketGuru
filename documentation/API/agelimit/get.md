# Get all AgeLimits

Get all AgeLimits the active User can access with current permission level.

**URL** : `https://rbmk-ticketguru-backend.herokuapp.com/api/ageLimits`

**Method** : `GET`

**Auth required** : Yes

**Permissions required** : None

**Data constraints** : `{[]}`

## Success Response

**Condition** : AgeLimits found.

**Code** : `200 OK`

**Content** :

```json
{
  "_embedded": {
    "ageLimits": [
      {
        "name": "String",
        "info": "String",
        "created": "LocalDateTime",
        "invalid": "LocalDateTime",
        "_links": {
          "self": {
            "href": "https://rbmk-ticketguru-backend.herokuapp.com/api/ageLimits/{id}"
          },
          "events": {
            "href": "https://rbmk-ticketguru-backend.herokuapp.com/api/ageLimits/{id}/events"
          }
        }
      }
    ]
  },
  "_links": {
    "self": {
      "href": "https://rbmk-ticketguru-backend.herokuapp.com/api/ageLimits"
    }
  }
}
```
</br>

**Condition** : No AgeLimits.

**Code** : `404 Not Found`

**Content** :

```json
{ }
```
</br>

# Get an AgeLimit

Get a single AgeLimit the active User can access with current permission level.

**URL** : `https://rbmk-ticketguru-backend.herokuapp.com/api/ageLimits/{id}`

**Method** : `GET`

**Auth required** : Yes

**Permissions required** : None

**Data constraints** : `{}`

## Success Response

**Condition** : AgeLimit found.

**Code** : `200 OK`

**Content** :

```json
{
  "name": "String",
  "info": "String",
  "created": "LocalDateTime",
  "invalid": "LocalDateTime",
  "_links": {
    "self": {
      "href": "https://rbmk-ticketguru-backend.herokuapp.com/api/ageLimits/{id}"
    },
    "events": {
      "href": "https://rbmk-ticketguru-backend.herokuapp.com/api/ageLimits/{id}/events"
    }
  }
}
```
</br>

## Failure Response

**Condition** : AgeLimit not found or invalid ID.

**Code** : `404 NOT FOUND`

**Content** :

```json
{
    "timestamp": "LocalDateTime",
    "status": 404,
    "error": "Not Found",
    "message": "Invalid ID: {id}",
    "path": "/api/ageLimits/{id}"
}
```
</br>
