const buffer1 = Buffer.alloc(8);
console.log(buffer1);

const buffer2 = Buffer.from([1, 4, 6, 8]);
console.log(buffer2);

const buffer3 = Buffer.from('Jimmy Palma', 'utf-8');
console.log(buffer3.toString());