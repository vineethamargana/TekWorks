interface Employee1
{
    empname:string;
    empid:number;
    empsal:number;
    dispData:() => void; //arrow function
}

var emp:Employee1=
{
   empname:"hii",
   empid:1,
   empsal:90000,
   dispData():void
   {
     console.log(this.empid+" "+this.empname+" "+this.empsal);
   }
}

emp.dispData();