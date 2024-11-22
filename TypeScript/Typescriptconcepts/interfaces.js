var emp = {
    empid: 1,
    empname: "hii",
    empsal: 90000,
    dispData: function () {
        console.log(this.empid + " " + this.empname + " " + this.empsal);
    }
};
emp.dispData();
