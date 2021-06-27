const fs = require('fs');

const name = fs.readFileSync('./names.txt', 'utf8');
console.log(name);

fs.readFile('./names.txt', {encoding: 'utf8'}, function(err, data){
    if(err) console.log('errorrrrrr');
    console.log(data);
})

fs.writeFileSync('./greeting.txt', 'hello Jimmy', 'utf8');

fs.writeFile('./bla.txt', 'bla', 'utf8', function(err){
    if(err) console.log('erroooor');
    console.log('done');
})