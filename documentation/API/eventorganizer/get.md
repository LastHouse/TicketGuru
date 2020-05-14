# Get all EventOrganizers

Get all EventOrganizers the active User can access with current permission level.

**URL** : `https://rbmk-ticketguru-backend.herokuapp.com/api/eventOrganizers`

**Method** : `GET`

**Auth required** : Yes

**Permissions required** : None

**Data constraints** : `{[]}`

## Success Response

**Condition** : EventOrganizers found.

**Code** : `200 OK`

**Content** :

```json
{
  "_embedded": {
    "eventOrganizers": [
      {
        "name": "String",
        "streetAddress": "String",
        "tel": "String",
        "email": "String",
        "www": "String",
        "contactPerson": "String",
        "created": "LocalDateTime",
        "invalid": "LocalDateTime",
        "_links": {
          "self": {
            "href": "https://rbmk-ticketguru-backend.herokuapp.com/api/eventOrganizers/{id}"
          },
          "postcode": {
            "href": "https://rbmk-ticketguru-backend.herokuapp.com/api/eventOrganizers/{id}/postcode"
          },
          "events": {
            "href": "https://rbmk-ticketguru-backend.herokuapp.com/api/eventOrganizers/{id}/events"
          }
        }
      }
    ]
  },
  "_links": {
    "self": {
      "href": "https://rbmk-ticketguru-backend.herokuapp.com/api/eventOrganizers"
    }
  }
}
```
</br>

**Condition** : No EventOrganizers.

**Code** : `404 Not Found`

**Content** :

```json
{ }
```
</br>

# Get an EventOrganizer

Get a single EventOrganizer the active User can access with current permission level.

**URL** : `https://rbmk-ticketguru-backend.herokuapp.com/api/eventOrganizers/{id}`

**Method** : `GET`

**Auth required** : Yes

**Permissions required** : None

**Data constraints** : `{}`

## Success Response

**Condition** : EventOrganizer found.

**Code** : `200 OK`

**Content** :

```json
{
  "name": "String",
  "streetAddress": "String",
  "tel": "String",
  "email": "String",
  "www": "String",
  "contactPerson": "String",
  "created": "LocalDateTime",
  "invalid": "LocalDateTime",
  "_links": {
    "self": {
      "href": "https://rbmk-ticketguru-backend.herokuapp.com/api/eventOrganizers/{id}"
    },
    "postcode": {
      "href": "https://rbmk-ticketguru-backend.herokuapp.com/api/eventOrganizers/{id}/postcode"
    },
    "events": {
      "href": "https://rbmk-ticketguru-backend.herokuapp.com/api/eventOrganizers/{id}/events"
    }
  }
}
```
</br>

## Failure Response

**Condition** : EventOrganizer not found or invalid ID.

**Code** : `404 NOT FOUND`

**Content** :

```json
{
    "timestamp": "2020-05-06T16:48:28.706+0000",
    "status": 404,
    "error": "Not Found",
    "message": "Invalid ID: {id}",
    "path": "/api/eventOrganizers/{id}"
}
```
</br>

# Get Postcode

Get Postcode for given EventOrganizer id.

**URL** : `https://rbmk-ticketguru-backend.herokuapp.com/api/eventOrganizers/{id}/postcode`

**Method** : `GET`

**Auth required** : Yes

**Permissions required** : None

**Data constraints** : `{}`

## Success Response

**Condition** : Postcode found.

**Code** : `200 OK`

**Content** : 

```json
{
  "city": "String",
  "country": "String",
  "created": "LocalDateTime",
  "invalid": "LocalDateTime",
  "_links": {
    "self": {
      "href": "https://rbmk-ticketguru-backend.herokuapp.com/api/postcodes/{id}"
    },
    "eventOrganizers": {
      "href": "https://rbmk-ticketguru-backend.herokuapp.com/api/postcodes/{id}/eventOrganizers"
    },
    "venues": {
      "href": "https://rbmk-ticketguru-backend.herokuapp.com/api/postcodes/{id}/venues"
    }
  },
  "_links": {
    "self": {
      "href": "https://rbmk-ticketguru-backend.herokuapp.com/api/eventOrganizers"
    }
  }
}
```
</br>
