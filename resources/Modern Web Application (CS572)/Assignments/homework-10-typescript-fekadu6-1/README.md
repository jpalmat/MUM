# MWA - Homework 10 - Typescript

Create a Module called `available.ts` in TypeScript that exports one factory decorator `addAvailability` to be used as a decorator for a simple empty class with a new `Boolean` property called `available`.  
Use your custom decorator in `app.ts`:
```javascript
@addAvailability(true) 
class Course {} 

console.log(new Course()); // object {available: true}
```
Transpile your code to JS, then bundle it, and test your final bundle in the browser.
