public class EsempioGetterSetter {
    
    private int myInt;

    //myInt viene gestito internamente alla classe

    //Getter di myInt
    public int GetMyInt(){
        return myInt;
    }

    public int GetMyIntNegato(){
        return -myInt;
    }

    //Setter di myInt
    public void SetMyINt(int myInt){
        this.myInt = myInt;
    }

    public void SetMyINt(int myInt, int moltiplicatore){
        this.myInt = myInt * moltiplicatore;
    }
}
