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

        Shape s1 = new Circle(5);
        Shape s2 = new Rectangle(5, 10);
        Shape s3 = new Triangle(10, 10);
        
        System.out.println("Circle Area = "   + s1.calcArea());
        System.out.println("Rec Area = "      + s2.calcArea());
        System.out.println("Triangle Area = " + s3.calcArea());
    }

}