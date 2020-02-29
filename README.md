## Get list of all users
GET
https://atw-users.herokuapp.com

## Get user by id
GET
https://atw-users.herokuapp.com/{id}

## Get user by nickname
GET
https://atw-users.herokuapp.com/nick/{nickname}

## Create user
POST
https://atw-users.herokuapp.com/create
body: {name, nickname, birthYear ,password}

## Edit user
PUT
https://atw-users.herokuapp.com/update
body: {name, nickname, birthYear ,password}

## Delete user
DELETE
https://atw-users.herokuapp.com/delete/{id}