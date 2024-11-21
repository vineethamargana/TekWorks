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
var validateInput = function () {
    if (isNaN(parseFloat(number1.value)) || isNaN(parseFloat(number2.value))) {
        printresult.textContent = "please enter a valid number";
        return false;
    }
    return true;
};
var AddNumbers = function () {
    if (!validateInput())
        return;
    var a = parseFloat(number1.value);
    var b = parseFloat(number2.value);
    printresult.textContent = (a + b).toString();
};
var SubNumbers = function () {
    if (!validateInput())
        return;
    var a = parseFloat(number1.value);
    var b = parseFloat(number2.value);
    printresult.textContent = (a - b).toString();
};
var MultiplyNumbers = function () {
    if (!validateInput())
        return;
    var a = parseFloat(number1.value);
    var b = parseFloat(number2.value);
    printresult.textContent = (a * b).toString();
};
var DivideNumbers = function () {
    if (!validateInput())
        return;
    var a = parseFloat(number1.value);
    var b = parseFloat(number2.value);
    printresult.textContent = b === 0 ? "Cannot divide by zero" : (a / b).toString();
};
var operations = [
    { button: Addbtn, handler: AddNumbers },
    { button: Subbtn, handler: SubNumbers },
    { button: Mulbtn, handler: MultiplyNumbers },
    { button: Divbtn, handler: DivideNumbers },
];
operations.forEach(function (_a) {
    var button = _a.button, handler = _a.handler;
    return button === null || button === void 0 ? void 0 : button.addEventListener("click", handler);
});
