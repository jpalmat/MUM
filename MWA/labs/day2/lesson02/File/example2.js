var fs = require('fs');
var path = require('path');

// Reading from a file: 
fs.readFile(path.join(__dirname, 'greet.txt'),
    { encoding: 'utf-8' }, function (err, data) {
        if (err) throw err;
        console.log(data);
    });

// Writing to a file: 
fs.writeFile('students.txt', 'Hello World!', function (err) {
    if (err) throw err;
    console.log('Done');
});
