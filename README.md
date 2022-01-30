## Simple API - get/create/delete users, users can edit their work statuses.

Back-end: Spring Boot<br>
Database: PostgreSQL

***WORKING FUNCTIONALITY***

Endpoints:

- GET /api/v1/users // Get all users - for admin
- GET /api/v1/users/{username} // Get single user by username
- POST /api/v1/users // Create new user - for admin
- DELETE /api/v1/users/{id] // Delete user by user Id - for admin
- GET /api/v1/workers // Get all works - for admin dashboard
- GET /api/v1/workers/{username} // Get single work - for users
- PUT /api/v1/workers/{username} // Edit work by sending username - for users 


New work line is created at the same time when user is created.<br>
New work line is also deleted, when user is deleted.

"Get all workers" endpoint should have live data possibility, so admin
dashboard is updated live. <br>
One possibility is to use Websocket. Must search for more information


To be continued...