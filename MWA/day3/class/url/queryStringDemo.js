const queryString = require('querystring');
const obj = queryString.parse('username=jimmy&password=palma');
console.log(obj);

const myurl = queryString.stringify(obj);
console.log(myurl);