// class Main{
//     public static void main(String[] args){
        
//         // int[] arr = {1,2,3,4};

//         // int[] myArr;
//         // //ref in stack points to contigious mem in heap
//         // myArr = new int[3];

//         // int sub1 ;
//         // int sub2 ;
//         // int sub3 ;

//         // sub1 = 60 ;
//         // sub2 = 70 ;
//         // sub3 = 80 ;

//         // int[] subjects = new int[3];
//         // subjects[0] = 60 ;
//         // subjects[1] = 70 ;
//         // subjects[2] = 80 ;

//         // String name1 = null  ;
//         // String name2 = null  ;
//         // String name3 = null  ;

//         // name1 = new String("Ahmed");
//         // name2 = new String("Nahas");
//         // name3 = new String("Mohamed");


//         // //array of string refrences
//         // String[] namesArr;

//         // // if you call a method on namesArr[0].length -> null exception
//         // namesArr = new String[3];

//         // //each refrence will points to value in heap
//         // namesArr[0] = new String("Hello");
//         // namesArr[1] = new String("hi");
//         // namesArr[2] = new String("nahass");

        

//     }
// }


abstract class Shape{
    
    public int dim1 ;

    public Shape(int x){
        dim1 = x ;
    }

    public void setdim(int dim){
        dim1 = dim ;
    }
    
    public int getdim(){
        return dim1 ;
    }

    abstract double calcArea();

}

class Circle extends Shape{

    Circle(int r){
        super(r);
    }

    public double calcArea(){
        return (super.dim1 * super.dim1) * 3.14 ;
    }

}

class Rectangle extends Shape {
    
    public int dim2 ;

    Rectangle(int x , int y){
        super(x);
        dim2 = y ;
    }

    public void setdim(int dim){
        dim2 = dim ;
    }
    
    public int getdim(){
        return dim2 ;
    }


    public double calcArea(){
        return super.dim1 * dim2 ;
    }
}

class Triangle extends Shape {
    
    public int dim2 ;

    Triangle(int x , int y){
        super(x);
        dim2 = y ;
    }

    public void setdim(int dim){
        dim2 = dim ;
    }
    
    public int getdim(){
        return dim2 ;
    }


    public double calcArea(){
        return 0.5 * super.dim1 * dim2 ;
    }
}

class Main{

    public static void main(String[] args){

        Shape[] s = new Shape[3];


        s[0] = new Circle(5);
        s[1] = new Rectangle(5, 10);
        s[2] = new Triangle(10, 10);

        String s1 = new String("nahass");
        s1 = s1.concat("language");
        s1 += " progamer";
        
        //don't map to same addr in heap
        String s3 = new String("nahass");
        String s2 = new String("nahass");
        
        // map to same addr in heap -> string pool
        String strp1 = "Welcome";
        String strp2 = "Welcome";

        strp2 += " java";
        System.out.println(strp1);
        strp1.substring(2);

        int x = 0 ;
        if(x == 0 ){System.out.println(strp1);
        }
        else if (x == 3){System.out.println(strp1);
        }
        else
        {System.out.println(strp1);
        }

    }

}