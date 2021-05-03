Array.prototype.removeNum = async function(element) {
  return await promise(this, element).then(result => console.log(result));
};

function promise(array, element) {
  return new Promise((resolve, reject) => {
    array.forEach(e => {
      if (e === element) {
        array.splice(array.indexOf(e), 1);
      }
    });

    resolve(array);
  });
}

console.log("Start");
[1, 3, 4, 2, 1, 5].removeNum(1);
console.log("Finish");
