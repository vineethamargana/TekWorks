class car 
{
    cid:number;
    cname:string;
    constructor(cid:number,cname:string)
    {
        this.cid=cid;
        this.cname=cname;
    }
    display():void
    {
       console.log(this.cid);
       console.log(this.cname);
    }

}
class Sumo extends car
{
    millage:number;
    constructor(millage:number,cid:number,cname:string)
    {
        super(cid,cname);
        this.millage=millage;
    }
    display():void
    {
        super.display();
        console.log(this.millage);
    }
}
var sumo = new Sumo(900,10,"sumo");
sumo.display();