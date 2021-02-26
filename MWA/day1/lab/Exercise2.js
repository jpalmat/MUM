/*
// Fix the slow function to be asynchronous/non-blocking
function slow(callback){
for(let i=0; i<= 5e8; i++){} if (Math.random() > 0.5) {
return callback("Error",null) callback(null, {id:12345})
function exec(fn){
// Complete the code here to implement chaining with callback
}
*/
// Fix the slow function to be asynchronous/non-blocking
function slow(callback) {

  if (Math.random() > 0.5) {
      return callback("Error", null)
  }
  return callback(null, { id: 12345 })
}

function exec(fn) {
  let obj = {};

  fn(function (err, data) {
      obj.done = function (cb) {
          if (err === null) {
              cb(data);
          }
          return this;
      }
      obj.fail = function (cb) {
          if (err !== null) {
              cb(err);
          }
          return this;
      }
  });
  return obj;
}

exec(slow).done(function (data) { console.log(data); })
  .fail(function (err) { console.log("Error: " + err); });
// Will resolve after 200ms
/*let promiseA = new Promise((resolve, reject) => {
    let wait = setTimeout(() => {
      resolve('Promise A win!');
    }, 200)
  })
  
  // Will resolve after 400ms
  let promiseB = new Promise((resolve, reject) => {
    let wait = setTimeout(() => {
      resolve('Promise B win!');
    }, 400)
  })
  
  // Let's race our promises
  let race = Promise.race([
    promiseA,
    promiseB
  ])
  
  race.then((res) => console.log(res))*/