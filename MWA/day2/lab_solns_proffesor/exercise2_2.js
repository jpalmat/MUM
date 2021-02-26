const fs = require('fs');
const server = require('http').createServer();

server.on('request', (request, response) => {
    fs.readFile('./tiles.jpg', (err, data) => {
        if (err) throw err;
        response.end(data);
    });
});

server.listen(8000);