class byThrees implements Numbers{
    
    private int start ;
    private int current ;


    // when you override you should extend specifiers
    public void setStart(int v){
        start = current = v ;
    }
    public void reset(){current = start ;}

    public int getNext(){return current+=3;}

    public void extra(){
        System.out.println("extra");
    }

}


