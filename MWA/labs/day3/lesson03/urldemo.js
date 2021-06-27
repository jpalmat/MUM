const url = require('url');
const myURL = url.parse('https://user:pass@sub.host.com:8080/p/a/t/h?course1=nodejs&course2=angular#hash');
console.log(myURL);

const myURL2 = url.parse('https://user:pass@sub.host.com:8080/p/a/t/h?course1=nodejs&course2=angular#hash', true);
console.log(myURL2);

const urlObject = {
    protocol: 'http',
    host: 'www.mim.edu',
    search: '?q=cs',
    pathname: '/search',
};

console.log(url.format(urlObject)); // http://www.mim.edu/search?q=CS

