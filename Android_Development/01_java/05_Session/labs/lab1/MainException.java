import java.io.FileNotFoundException;
import java.io.IOException;

class ParentException{
    public void method()throws IOException{

        System.out.println("hello from Parent");
    }
}
class ChildException extends ParentException{
    public void method()throws FileNotFoundException{
        System.out.println("hello from child");
    }
}

class MainException{
    public static void main(String[] args){
        ParentException parent = new ChildException();
        try{

            parent.method();
        }catch(IOException ie){
            ie.printStackTrace();
        }
    
    }
}