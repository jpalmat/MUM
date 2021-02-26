const fs = require('fs');

const server = require('http').createServer();

server.on('request', (req, res) => {
	fs.createReadStream('./big.txt').pipe(res);
});

server.listen(8000);
