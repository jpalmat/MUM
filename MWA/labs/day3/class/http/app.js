//req -x509 -sha256 -nodes -days 365 -newkey rsa:2048 -keyout privatekey.key -out certificate.crt
const https=require('https');
const fs =require('fs');

const server = https.createServer({
    cert: fs.readFileSync('./certificate.crt'),
    key: fs.readFileSync('./privatekey.key')
});

server.on('request', function(req, res) {
    res.end('hello....');
});

server.listen(443, function(){
    console.log('server running 443');
});