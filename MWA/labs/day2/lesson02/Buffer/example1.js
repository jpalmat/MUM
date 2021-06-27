var buf = Buffer.alloc(8); // allocate a Buffer with 8 bytes
var buf = Buffer.allocUnsafe(8); //allocated 8 bytes Buffer with random data
var buf = Buffer.allocUnsafe(8).fill(1); // fill buffer with 0
var buf = Buffer.from('Hello'); // create Buffer of 5 bytes and fill it
// var buf = new Buffer('Hello', 'utf8'); 
console.log(buf);
// 48 65 6c 6c 6f stored internally in binary but displayed as hex in CLI

console.log(buf[2]); // 108 (Charset)

console.log(buf.toString()); // Hello 

console.log(buf.toJSON());
// // {type: 'Buffer', data = [72, 101, 108, 108, 111 ] } Unicode characterset 

buf.write('wo'); // overwrite data in the buffer without changing its size 
console.log(buf.toString()); // wollo 
