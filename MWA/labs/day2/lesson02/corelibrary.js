const util = require('util'); // We do not use ./ before the filename
const sayHi = util.format("Hi, %s", 'Josh');
util.log(sayHi); //22 Feb 11:04:59 - Hi, Josh
