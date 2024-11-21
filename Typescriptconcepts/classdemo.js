var Employee = /** @class */ (function () {
    function Employee() {
    }
    Employee.prototype.display = function () {
        console.log(this.eid);
        console.log(this.ename);
        console.log(this.department);
    };
    return Employee;
}());
var emp = new Employee(); //object creation
emp.eid = 101;
emp.ename = "john";
emp.department = 10;
emp.display();
var Student = /** @class */ (function () {
    function Student(sid, sname, course) {
        this.sid = sid || 0;
        this.sname = sname || "Default Name";
        ;
        this.course = course || "Default Name";
        ;
    }
    Student.prototype.setdata = function (sid, sname, course) {
        this.sid = sid;
        this.sname = sname;
        this.course = course;
    };
    Student.prototype.display = function () {
        console.log(this.sid);
        console.log(this.sname);
        console.log(this.course);
    };
    return Student;
}());
var stud1 = new Student(101, "john", "cse");
stud1.display();
var stud = new Student(); //
stud.setdata(101, "john", "cse");
stud1.display();
