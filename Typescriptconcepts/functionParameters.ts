//function parameters
function getparameters(greet:string,ing:string)
{
    console.log(greet+ing);
}
getparameters("namaste","jaan");
//getparameters("namaste"); //Expected 2 arguments, but got 1.
//getparameters("namaste","jaan","ghjk"); //Expected 2 arguments, but got 3.





//optional parameters (?) we use question to indicate that it can be optional
//---------------------------
function getparameters1(greet:string,ing ?:string)
{
  console.log(greet+" "+ing);
}
getparameters1("j","k");// j k
getparameters1("i"); //i undefined
//getparameters("l","k","j"); //Expected 1-2 arguments, but got 3.



//default parameters
function greetin(name:string,greet:string="hello")
{
    console.log(greet+" "+name);
}
greetin("jaan"); // hello jaan
greetin("jaan","welcome"); //welcome jaan
greetin("smith"); //hello smith
greetin("","ghjk");