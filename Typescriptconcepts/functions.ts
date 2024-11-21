//Named functions
//--------------------------


//no parameters and no return type
function display(){
    console.log("hello world!");
}
display(); //hello world

//with parameters and return type
function sum(x:number,y:number):number{
    return x+y;
}
console.log(sum(10,78)); //88

//with parameters and without return type
function differ(a:number,b:number)
{
    console.log(a-b);
}
differ(50,10);

//without parameters and with retunr type
function display1():string
{
  return "vineetha";
}
console.log(display1());


//anonymous functions
//---------------------------------

//no parameters and no return type
var namaste = function()
{
    console.log("namaste jaans!");
}
namaste();

//with parameters and with return type
var concatstring = function(c:string,d:string):string
{
    return c+d;
}
console.log(concatstring("hii","  ghjk"));

//with parameters and no return type
var plus =function(c:number,d:number)
{
    console.log(c+d);
}
plus(10,70);


//with out parameters and with return type
var noparam=function():string
{
    return "hjkk";
}
console.log(noparam());