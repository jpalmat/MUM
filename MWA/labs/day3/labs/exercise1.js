/*
Create a https server which is listen to 3000 port. The home page “/” which displays an html page which one input to enter any text message, 
after click “Submit” button, the user’s inputs are stored in a local file on the server side. User will be redirect to home page after saving 
successfully.

https://nodejs.org/en/knowledge/HTTP/servers/how-to-create-a-HTTPS-server/
*/

const http = require('https');
const fs = require('fs');
const path = require('path');

const options = {
    key: fs.readFileSync('./privatekey.key'),
    cert: fs.readFileSync('./certificate.crt')
  };

const server = http.createServer(options, function(req, res) {
    const url = req.url;
    if(url === '/') {
        fs.createReadStream(path.join(__dirname, 'form.html')).pipe(res);
    } else if (url === '/save') {
        req.pipe(fs.createWriteStream(path.join(__dirname, 'user.txt')));
        fs.createReadStream(path.join(__dirname, 'index.html')).pipe(res);
    }
}).listen(3000);