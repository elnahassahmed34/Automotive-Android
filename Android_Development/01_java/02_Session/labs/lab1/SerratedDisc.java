class SerratedDisc{
    // public static void myMethod(){
    //     System.out.println("my static");
    // }
    private int size ;
    private static String name ;

    private static SerratedDisc disc = null ;
    private SerratedDisc(){};
    public static SerratedDisc create(){
        if(disc == null){
            
            disc = new SerratedDisc();
            System.out.println("singleton");

        }

        return disc ;
    }


    public void setSize(int s){size = s;}
    public int getSize(){return size ;}
    public static void setname(String s){name = s;}
    public static String getName(){
        return name ;
    }

    public SerratedDisc(int s){
        size = s ;
        System.out.println("paramatrized");
    }
}

class MAIN{
    
    public static void main (String[] args){
        
        SerratedDisc d3 = SerratedDisc.create();

        //SerratedDisc.myMethod();
        SerratedDisc Disc1 ;
        
        Disc1 = new SerratedDisc(5);
        SerratedDisc Disc2 = new SerratedDisc(5);
        
        Disc1.setname("nahass");
        Disc1.setname("ahmed");
        Disc2.setname("mohamed");

        System.out.println(SerratedDisc.getName());
        System.out.println(Disc1.getName());
        System.out.println(Disc2.getName());
        
        //String myname = new String("Ahmed");
        


    }   
    
}

