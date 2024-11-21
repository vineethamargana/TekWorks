//rest parameters --- we can pass the parameters how many we can want while calling functions . 
//used especially when we dont know how mant parameters we have to pass
function greeti(greet) {
    var name = [];
    for (var _i = 1; _i < arguments.length; _i++) {
        name[_i - 1] = arguments[_i];
    }
    return greet + " " + name;
}
console.log(greeti("hello", "rtyui"));
console.log(greeti("hee"));
console.log(greeti("ghj", "hj", "fghj"));
