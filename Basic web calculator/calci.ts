//inputs from the user using id (HTMLInputElement)
const number1= document.getElementById("num1") as HTMLInputElement;
const number2= document.getElementById("num2") as HTMLInputElement;

console.log(number1); 
// Logs: <input id="num1" type="text" value="42">

console.log(number1.value); 
// Logs: "42" (the value entered in the input field)

console.log(number1.type); 
// Logs: "text" (the type of the input field) 

//Buttons (HTMLButtonElement)
const Addbtn = document.getElementById("add") as HTMLButtonElement;
const Subbtn = document.getElementById("sub") as HTMLButtonElement;
const Mulbtn = document.getElementById("mul") as HTMLButtonElement;
const Divbtn = document.getElementById("div") as HTMLButtonElement;

//output 
const printresult = document.getElementById("output") as HTMLOutputElement;

const validateInput = (): boolean =>{
    if(isNaN(parseFloat(number1.value)) || isNaN(parseFloat(number2.value)))
    {
        printresult.textContent="please enter a valid number";
        return false;
    }
    return true;
};

const AddNumbers = () => {
    if (!validateInput()) return;
    const a = parseFloat(number1.value);
    const b = parseFloat(number2.value);
    printresult.textContent = (a + b).toString();
};

const SubNumbers = () => {
    if (!validateInput()) return;
    const a = parseFloat(number1.value);
    const b = parseFloat(number2.value);
    printresult.textContent = (a - b).toString();
};

const MultiplyNumbers = () => {
    if (!validateInput()) return;
    const a = parseFloat(number1.value);
    const b = parseFloat(number2.value);
    printresult.textContent = (a * b).toString();
};

const DivideNumbers = () => {
    if (!validateInput()) return;
    const a = parseFloat(number1.value);
    const b = parseFloat(number2.value);
    printresult.textContent = b === 0 ? "Cannot divide by zero" : (a / b).toString();
};

const operations = [
    { button: Addbtn, handler: AddNumbers },
    { button: Subbtn, handler: SubNumbers },
    { button: Mulbtn, handler: MultiplyNumbers },
    { button: Divbtn, handler: DivideNumbers },
];

operations.forEach(({ button, handler }) => button?.addEventListener("click", handler));