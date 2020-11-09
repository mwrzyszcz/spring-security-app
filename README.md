## Spring Boot - security app

---

### How to use

1. Clone repository
2. Run application
    * OpenJDK 11
    * Maven 3+
    * Spring Boot 2+

3. Send `POST` request to register new user

#### Example
`POST http://localhost:8080/api/auth/signup`
```json
{
	"name": "Jan Testowy",
	"email": "jan@acb.com",
	"password": "password"
}
```

4. Use response to request `POST` and sign in
#### Example
`POST http://localhost:8080/api/auth/signin`

```json
{
	"email": "jan@acb.com",
	"password": "password"
}
```
Response:
```json
{
    "accessToken": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxIiwiaWF0IjoxNjA0OTY1MTQ4LCJleHAiOjE2MDU1Njk5NDh9.OW1eHiNKu2yivFS6NnsXtEtrjMTtu9BfKOwV4mMYWbkvYUVuv1tp2QeUwzgIoJwgopScj1SlvHTVaDeaGj6U_w",
    "tokenType": "Bearer"
}
```

5. Use token in header for `GET` request
#### Example
`GET http://localhost:8080/api/users/me`
`Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxIiwiaWF0IjoxNjA0OTY0NTQyLCJleHAiOjE2MDU1NjkzNDJ9.oB3BrsZT6rDRuQZFHZK7Wsln3IUcfMryV1In_znCBoEHeUHaDQUBeqJrKlcIUD4B1eOwyzl8WDVJ3nNTZai2A`

Response:
```json
{
    "id": 1,
    "name": "Jan Testowy",
    "email": "jan@acb.com"
}
```
---
## Notes
Feel free to use.