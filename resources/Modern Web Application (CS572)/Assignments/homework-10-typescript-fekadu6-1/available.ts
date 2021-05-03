//@addAvailability(true)
//let // class Course {
//   name: string = "";
//available: boolean = true;
//}

export function addAvailability(val: boolean) {
  return function(targetClass: any) {
    return class {
      available: boolean = val;
      //   name = new targetClass().name;
    };
  };
}

//module.exports = addAvailability;
