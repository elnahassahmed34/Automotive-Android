/*
 * complex class
 * 1 + 2i
 * 3 + 4i
 * 
 * 4 + 6i
 * 
 * summation
 * subtract
 * print
 * 
 */

class Complex {
    
    public int real ;
    public int complex ;

    Complex (int x , int y){
        real    = x ;
        complex = y ;
    }

    public void setReal(int r){
        real = r ;
    }
    public int getReal(){
        return real ;
    }
    
    public void setComplex(int c){
        complex = c;
    }
    public int getComplex(){
        return complex ;
    }

    static public Complex summation(Complex C1 , Complex C2){
        int r = C1.getReal() + C2.getReal() ;
        int c = C1.getComplex() + C2.getComplex() ;
        Complex C = new Complex(r, c);
        return C; 
    }    
    static public Complex subtraction(Complex C1 , Complex C2){
        int r = C1.getReal()  - C2.getReal() ;
        int c = C1.getComplex() - C2.getComplex() ;
        Complex C = new Complex(r, c);
        return C; 
    }

    static public void Print(Complex C){
        
        if(C.complex < 0){

            System.out.println(C.real + " " +  C.complex + "i");
        }
        else{
            
            System.out.println(C.real + "  +" +  C.complex + "i");
        }
        
    }

}

class Main{

    public static void main(String[] args){

        Complex c1 = new Complex(1, 2);
        Complex c2 = new Complex(1, 2);
        Complex c3 = Complex.summation(c1, c2);
        
        Complex c4 = new Complex(4, 5);
        Complex c5 = Complex.subtraction(c1, c4);

        Complex.Print(c3);
        Complex.Print(c5);


    }

}