const fs = require('fs');

const readable = fs.createReadStream(__dirname + '/card.jpg');
const writable = fs.createWriteStream(__dirname + '/destinationImage.jpg');

readable.pipe(writable); 
