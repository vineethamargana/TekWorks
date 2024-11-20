//rest parameters --- we can pass the parameters how many we can want while calling functions . 
//used especially when we dont know how mant parameters we have to pass
function greeti(greet:string,...name:string[]):string
{
    return greet+" "+name;
}
console.log(greeti("hello","rtyui"));
console.log(greeti("hee"));
console.log(greeti("ghj","hj","fghj"));//first value is passed to greet and next two values passed to the name

function sum111(...numbers: number[]): number 
{
    return numbers.reduce((total, num) => total + num, 0);
}
  
  console.log(sum111(1, 2, 3));      // Output: 6
  console.log(sum111(1, 2, 3, 4, 5)); 

  function createPerson(firstName: string, lastName: string, ...skills: string[]): void {
    console.log(`${firstName} ${lastName} has the following skills: ${skills.join(", ")}`);
  }
  
  createPerson("Alice", "Smith", "JavaScript", "TypeScript", "React");
  // Output: Alice Smith has the following skills: JavaScript, TypeScript, React
  