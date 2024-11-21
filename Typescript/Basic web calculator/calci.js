//inputs from the user using id (HTMLInputElement)
var number1 = document.getElementById("num1");
var number2 = document.getElementById("num2");
//Buttons (HTMLButtonElement)
var Addbtn = document.getElementById("add");
var Subbtn = document.getElementById("sub");
var Mulbtn = document.getElementById("mul");
var Divbtn = document.getElementById("div");
//output 
var printresult = document.getElementById("output");
//Add numbers
function AddNumbers() {
    var a = parseFloat(number1.value); //by default the html input is string
    var b = parseFloat(number2.value);
    var result = a + b;
    printresult.textContent = result.toString();
}
Addbtn.addEventListener("click", AddNumbers);
function subNumbers() {
    var a = parseFloat(number1.value);
    var b = parseFloat(number2.value);
    var result = a - b;
    printresult.textContent = result.toString();
}
Subbtn.addEventListener("click", subNumbers);
