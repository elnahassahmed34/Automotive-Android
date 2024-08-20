class Myclass{
    private int x ;
    private static int y ;

    public Myclass(){
        x = 0 ;
        System.out.println("constructor");
    }

    public static void initY(int yv){
        y = yv ;
    }

    //free floating block
    // static initializer
    static{
        System.out.println("Static Init");
        y = 5+6;
    }

    public static void main(String[] args){
        Myclass m = new Myclass();
        Myclass m2 = new Myclass();
        Myclass.initY(5);
    }
}



