const fs = require('fs');
const zlib = require('zlib');
const gzip = zlib.createGzip();
// this is a readable & writable stream and it returns a zipped stream 

const readable = fs.createReadStream(__dirname + '/source.txt');
const compressed = fs.createWriteStream(__dirname + '/destination.txt.gz');

readable.pipe(gzip).pipe(compressed); 
