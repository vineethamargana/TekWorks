class Bank
{
    rateofinterest:number=0;
    roi():number
    {
        return this.rateofinterest;
    }
}
class Bankx extends Bank
{
    // rateofinterest: number=9;
    roi():number //overriding
    {
        return 10.5;
    }
}
class Banky extends Bank
{
    roi():number //overriding
    {
        return 11;
    }
}

var x  = new Bankx();
console.log(x.roi());

var y = new Banky();
console.log(y.roi());

var z = new Bank();
console.log(z.roi()); 