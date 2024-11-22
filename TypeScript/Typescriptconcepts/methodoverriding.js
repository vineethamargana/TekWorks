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
var Bank = /** @class */ (function () {
    function Bank() {
        this.rateofinterest = 0;
    }
    Bank.prototype.roi = function () {
        return this.rateofinterest;
    };
    return Bank;
}());
var Bankx = /** @class */ (function (_super) {
    __extends(Bankx, _super);
    function Bankx() {
        return _super !== null && _super.apply(this, arguments) || this;
    }
    // rateofinterest: number=9;
    Bankx.prototype.roi = function () {
        return 10.5;
    };
    return Bankx;
}(Bank));
var Banky = /** @class */ (function (_super) {
    __extends(Banky, _super);
    function Banky() {
        return _super !== null && _super.apply(this, arguments) || this;
    }
    Banky.prototype.roi = function () {
        return 11;
    };
    return Banky;
}(Bank));
var x = new Bankx();
console.log(x.roi());
var y = new Banky();
console.log(y.roi());
var z = new Bank();
console.log(z.roi());
