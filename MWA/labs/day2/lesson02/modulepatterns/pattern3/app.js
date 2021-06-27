const personObj = require('./pattern3');
personObj.getName(); // Josh Edward
personObj.name = 'Emma Smith';
personObj.getName(); //Emma Smith
const personObj2 = require('./pattern3');// cached 
personObj2.getName(); //Emma Smith


