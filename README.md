
## API Reference

#### For Login

```http
  POST localhost:8080/login
```

| Parameter | Value     | password               |roles     |
| :-------- | :------- | :---------------------- |:---------------------- |
| `username` | `gshahrza` | `qweR1234*` |  `ADMIN`            |
| `username` | `ex_user` | `qweR1234*` | `USER`      |
| `username` | `ex_publisher` | `qwR1234*` |       `PUBLISHER`       |
| `username` | `ex_publishe2r` | `qwR1234*` |       `PUBLISHER`       |
| `username` | `ex_publisher3` | `qwR1234*` |       `PUBLISHER`       |
| `username` | `ex_publisher4` | `qwR1234*` |       `PUBLISHER`       |

`Example for requestBody`:
{
    "username" : "gshahrza", 
    "password" : "qweR1234*" 
}
`Response Body`: { "jwt" : "body"}

#### Get list books

```http
  GET localhost:8080/books
```

| Header |  Description          | allowed|
| :-------- | :--------------------- |:------|
| `Authorization`| **Required**. Bearer tokenBody | `all users`|

##### Get list book with author details :
```http
  GET localhost:8080/users/details
```
| Header |  Description          | allowed|
| :-------- | :--------------------- |:------|
| `Authorization`| **Required**. Bearer tokenBody | `all users`|

##### Get list book by rating with pagination:
```http
  GET localhost:8080/books/rating
```
| RequestParam | Type     | allowed   |
| :-------- | :------- |:---------- |
| `rating` | `double` |  `All users`   |
| `pageNo` | `Integer` |  `All users`   |
| `pageSize` | `Integer` |  `All users`   |

Example: localhost:8080/books/rating?rating=7.5&?pageSize=2
#### Get list book by author:
```http
  GET localhost:8080/books/authors
```
| RequestParam | Type     | allowed   |
| :-------- | :------- |:---------- |
| `firstName` | `String` |  `All users`   |
| `lastName` | `String` |  `All users`   |

Example: localhost:8080/books/authors?firstName=X&?lastName=Y

##### Book add to Publisher :
```http
  POST localhost:8080/users/{id}
```
| Parameter | Type     | allowed   |
| :-------- | :------- |:---------- |
| `AddBookRequest` | `body` |  `Only PUBLISHER`   |

|Header | Description          | allowed|
| :----- |:--------------------- |:------|
|`Authorization`|**Required**. Bearer tokenBody | `Only admin`|

`Example : ` `RequestBody : ` {"isbn" : Long,"tittle" : "value","totalPages":Integer,"rating":double,"categories":[{"id":Long,"categoryName":"value"}]}
##### Book update from publisher :
```http
  PUT localhost:8080/users/{id}
```
| Parameter | Type     | allowed   |
| :-------- | :------- |:---------- |
| `UpdateBookRequest` | `body` |  `Only PUBLISHER`   |

|Header | Description          | allowed|
| :----- |:--------------------- |:------|
|`Authorization`|**Required**. Bearer tokenBody | `Only admin`|
