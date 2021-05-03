# MWA Homework05 - Expressjs 01
## Exercise
Create an Express application that will accept a `GET` request from route `/users` and send a `JSON` response with users data.  
  
* Create a new project: `npm init`, and then download the necessary dependencies: `npm i express rxjs axios`
* JSON data to be fetched from `https://randomuser.me/api/?results=10` using `axios` and `async/await`
* Note that response data from `axios` is usually wrapped in `data` property.
* Use `rxjs` to filter the `JSON` response and send the user first and last name only.
* Your application should run fluently behind any proxy without revealing the framework name to clients, proxy should not cache the response.
* Your route should be case sensitive and strict.
* Send standard pagination options in the response headers (check the [pagination docs](https://randomuser.me/documentation#pagination)).
* Allow the response to be cached at the client for one day if no change occur at the server.
