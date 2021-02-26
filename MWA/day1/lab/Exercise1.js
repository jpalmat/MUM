/*
Write the necessary Node script to make this code work for all arrays:  
[1,2,3,4,5,6,7,8].even(); // [2,4,6,8] 
[1,2,3,4,5,6,7,8].odd(); // [1,3,5,7]  

Test your code in Node.JS CLI 
*/

// Starting Array
var a = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 100, 112, 113];

function getEven() {
    return this.filter(n => n % 2 == 0);
}

function getOdd() {
    return this.filter(n => n % 2 !== 0);
}

Array.prototype.even = getEven;
Array.prototype.odd = getOdd;

console.log(a.even());
console.log(a.odd());