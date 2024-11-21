//anonymous functions
//fat arrow functions with parameters and return type
var sum1 = function (x, y) {
    return x + y;
};
console.log(sum1(45, 789));
//fat arrow functions without parameters
//1. if there are multiple printing statements 
var print1 = function () {
    console.log("welcome");
    console.log("to typescript");
};
// 2. if we have single printing statement we dont need to use urly brackets
var print2 = function () { return console.log("welcome"); };
