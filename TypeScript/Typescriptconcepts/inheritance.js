var __extends = (this && this.__extends) || (function () {
    var extendStatics = function (d, b) {
        extendStatics = Object.setPrototypeOf ||
            ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
            function (d, b) { for (var p in b) if (Object.prototype.hasOwnProperty.call(b, p)) d[p] = b[p]; };
        return extendStatics(d, b);
    };
    return function (d, b) {
        if (typeof b !== "function" && b !== null)
            throw new TypeError("Class extends value " + String(b) + " is not a constructor or null");
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
var car = /** @class */ (function () {
    function car(cid, cname) {
        this.cid = cid;
        this.cname = cname;
    }
    car.prototype.display = function () {
        console.log(this.cid);
        console.log(this.cname);
    };
    return car;
}());
var Sumo = /** @class */ (function (_super) {
    __extends(Sumo, _super);
    function Sumo(millage, cid, cname) {
        var _this = _super.call(this, cid, cname) || this;
        _this.millage = millage;
        return _this;
    }
    Sumo.prototype.display = function () {
        _super.prototype.display.call(this);
        console.log(this.millage);
    };
    return Sumo;
}(car));
var sumo = new Sumo(900, 10, "sumo");
sumo.display();
