"use strict";
//@addAvailability(true)
//let // class Course {
//   name: string = "";
//available: boolean = true;
//}
Object.defineProperty(exports, "__esModule", { value: true });
function addAvailability(val) {
    return function (targetClass) {
        return /** @class */ (function () {
            function class_1() {
                this.available = val;
                //   name = new targetClass().name;
            }
            return class_1;
        }());
    };
}
exports.addAvailability = addAvailability;
//module.exports = addAvailability;
