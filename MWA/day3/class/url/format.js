const url = require('url');
const urlObj = {
    protocol: null,
    slashes: null,
    auth: null,
    host: null,
    port: null,
    hostname: null,
    hash: null,
    search: null,
    query: null,
    pathname: '/favicon.ico',
    path: '/favicon.ico',
    href: '/favicon.ico'
  }

 const myUrl = url.format(urlObj);
 console.log(myUrl);