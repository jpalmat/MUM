const fs = require('fs');

var options = {
    key: fs.readFileSync('./privateKey.key'),
    cert: fs.readFileSync('./certificate.crt')
};

const server = require('https')
    .createServer(options);

server.on('request', (req, res) => {
    res.writeHead(200, { 'content-type': 'text/plain' });
    res.end('Hello from my HTTPS Web server!!!\n');
});

server.listen(443);