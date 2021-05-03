/*
Note that I've the function pluck using async&wait with promise, setTimeout, process.next and queueMicroTask methods 
*/

Array.prototype.pluck = async function(val) {
  return await promise(this, val).then(res => console.log(res));
};

function promise(arr, val) {
  return new Promise((resolve, reject) => {
    const max = arr.reduce(callbackMax);
    const min = arr.reduce(callbackMin);

    if (val) {
      resolve(max);
    } else {
      resolve(min);
    }
  });
}

const callbackMax = (a, b) => Math.max(a, b);
const callbackMin = (a, b) => Math.min(a, b);

console.log("start");
[1, 2, 3, 4, 5, 6, 7, 8].pluck(true); // pluck largest
[1, 2, 3, 4, 5, 6, 7, 8].pluck(false); // pluck smallest
console.log("end");

//   Array.prototype.pluck2 = function (val){

//     //setTimeout(() => maxMin(this, val), 2000)
//     //queueMicrotask(()=>maxMin(this, val))
//     process.nextTick(()=>maxMin(this, val), 2000)
// }

// function maxMin(arr, val){

//     const max = arr.reduce(callbackMax)
//     const min = arr.reduce(callbackMin)

//     if(val){
//         console.log(max)
//     }else{
//         console.log(min)
//     }
// }

// // const callbackMax = (a, b)=>Math.max(a,b);
// // const callbackMin = (a, b)=>Math.min(a,b);

// console.log('start');
// [1,2,3,4,5,6,7,8].pluck2(true); // pluck largest
// [1,2,3,4,5,6,7,8].pluck2(false); // pluck smallest
// console.log('end');
