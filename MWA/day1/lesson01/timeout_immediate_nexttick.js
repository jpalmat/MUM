// let bar;

// // this has an asynchronous signature, but calls callback synchronously
// function someAsyncApiCall(callback) { callback(); }

// // the callback is called before `someAsyncApiCall` completes.
// someAsyncApiCall(() => {
//   // since someAsyncApiCall has completed, bar hasn't been assigned any value
//   console.log('bar', bar); // undefined
// });

// bar = 1;

setTimeout(() => { console.log('timeout 1'); }, 0);
setImmediate(() => { console.log('immediate'); });
process.nextTick(() => console.log('nexttick'));
setTimeout(() => { console.log('timeout 2'); }, 0); 
