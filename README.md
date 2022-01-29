## Simple API - get/create/delete users, users can edit their work statuses.

***TODO***:

Endpoints:

- GET /api/v1/users // Get all users - for admin
- GET /api/v1/users/{id} // Get single user by id
- POST /api/v1/users // Create new user - for admin
- DELETE /api/v1/users/{id] // Delete user by userId - for admin


- GET /api/v1/works // Get all works - for admin dashboard
- PUT /api/v1/works/{id} // Edit work by sending userId - for users 

New work line is created at the same time when user is created.<br>
New work line is also delete for the user, when user is deleted.

Get all works endpoint should have live data possibility, so admin
dashboard is updated live. One possibility is to use Websocket.

To be continued...