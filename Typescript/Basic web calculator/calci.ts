//inputs from the user using id (HTMLInputElement)
const number1= document.getElementById("num1") as HTMLInputElement
const number2= document.getElementById("num2") as HTMLInputElement

//Buttons (HTMLButtonElement)
const Addbtn = document.getElementById("add") as HTMLButtonElement
const Subbtn = document.getElementById("sub") as HTMLButtonElement
const Mulbtn = document.getElementById("mul") as HTMLButtonElement
const Divbtn = document.getElementById("div") as HTMLButtonElement

//output 
const printresult = document.getElementById("output") as HTMLOutputElement

//Add numbers
function AddNumbers()
{
    let a = parseFloat(number1.value); //by default the html input is string
    let b = parseFloat(number2.value);
    let result = a+b;
    printresult.textContent = result.toString();
}
Addbtn.addEventListener("click",AddNumbers)

function subNumbers()
{
    let a = parseFloat(number1.value);
    let b = parseFloat(number2.value);
    let result = a - b;
    printresult.textContent = result.toString();
}
Subbtn.addEventListener("click",subNumbers);
