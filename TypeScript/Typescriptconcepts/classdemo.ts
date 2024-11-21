class Employee
{
    eid: number;
    ename: string;
    department: number;

    display():void
    {
        console.log(this.eid);
        console.log(this.ename);
        console.log(this.department);
    }
}
var emp = new Employee(); //object creation
emp.eid = 101;
emp.ename = "john";
emp.department = 10;
emp.display();

class Student
{
    sid:number;
    sname:string;
    course:string;
    //constructor();
    constructor(sid?: number, sname?: string, course?: string);

    constructor(sid ?:number,sname ?:string,course ?:string)
    {
        this.sid=sid || 0;
        this.sname=sname || "Default Name";;
        this.course=course || "Default Name";;
    }
    setdata(sid:number,sname:string,course:string):void
    {
        this.sid=sid;
        this.sname=sname;
        this.course=course;
    }
    display():void
    {
        console.log(this.sid);
        console.log(this.sname);
        console.log(this.course);
    }
}
var stud1=new Student(101,"john","cse");
stud1.display();
var stud= new Student(); 
stud.setdata(101,"john","cse");
stud1.display();