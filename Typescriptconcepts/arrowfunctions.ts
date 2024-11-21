//anonymous functions


//fat arrow functions without parameters
//------------------------------------------------
//1. if there are multiple printing statements 
var print1 = () => {
    console.log("welcome");
    console.log("to typescript");
}
print1();

// 2. if we have single printing statement we dont need to use curly brackets
var print2 = () => console.log("welcome");
print2();



//fat arrow functions with parameters and return type
//1.
var sum1 = (x: number, y: number): number => {
    return x + y;
}
console.log(sum1(45, 789));

//2. if the function body consists of only one statement then no need for the curly brackets and return keyword and return type;
var sum2 = (x: number, y: number) => x + y;
console.log(sum2(23, 54));



