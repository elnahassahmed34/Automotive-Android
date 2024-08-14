
class Parent{
    private int no1 ;
    private int no2 ;

    public Parent(){
        System.out.println("default parent");
    }
    
    public Parent(int x , int y){
        no1 = x ;
        no2 = y ; 
        System.out.println("parametrized parent");
    }

    public void setNo1(int n1){
        no1 = n1 ;
    }
    
    public int getNo1(){
        return no1 ;
    }
    
    public void setNo2(int n2){
        no2 = n2 ;
    }
    
    public int getNo2(){
        return no2 ;
    }

    public int sum(){
        return no1 + no2 ;
    }

}

class Child extends Parent{

    private int no3 ;

    public Child(int x , int y , int z){
        super(x,y);
        no3 = z ;
        System.out.println("default child");
    }

    public void setNo3(int n3){
        no3 = n3 ;
    }
    
    public int getNo3(){
        return no3 ;
    }

    public int sum(){
        return super.sum() + no3 ;
    }

}

class Main{
    public static void main(String[] args){
        Child c = new Child(10,20,30);
        c.setNo1(5);
        c.setNo2(10);
        c.setNo3(15);
        
        System.out.println("sum=" + c.sum());

    }
}
