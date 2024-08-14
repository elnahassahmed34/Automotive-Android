
class Parent{
    private int no1 ;
    private int no2 ;
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

    public Parent(){
        System.out.println("default parent");
    }
    public Parent(int x){
        System.out.println("parametrized parent");
    }

}

class Child extends Parent{
    public Child(int x , int y){
        super(x);
        System.out.println("default child");
    }
}

class Main{
    public static void main(String[] args){
        Child c = new Child(10,20);
        c.setNo1(5);
        c.setNo2(10);
        System.out.println("sum=" + c.sum());

        Child c = new Parent();
    }
}
