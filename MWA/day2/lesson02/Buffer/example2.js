var buffer = new Buffer('this is the string in my buffer');
var slice = buffer.slice(10, 20);

console.log(slice.toString());
// console.log(JSON.stringify(slice.toString()));


var buffer = new Buffer('this is the string in my buffer');
var targetBuffer = new Buffer(10);
var targetStart = 0,
    sourceStart = 10,
    sourceEnd = 20;
buffer.copy(targetBuffer, targetStart, sourceStart, sourceEnd);

console.log(targetBuffer.toString());
