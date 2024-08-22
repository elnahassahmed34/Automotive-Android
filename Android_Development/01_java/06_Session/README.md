## Inner class
- helps the outcome
- it increases encapsulation
- readbility 

## four types of inner class
- normal member inner class
- static member inner class
- local inner class inside method
- Anonymous Inner Class

### - normal member inner class
- class inside class
- public class OuterClass{ 
    MyInnerclass m = this.new MyInnerClass();
    class MyInnerClass {}}
- main function
    - outerclass obj = new Outerclass;
    - outerckass.myinnerclass m = obj.new MyInnerclass
- instace member inner ckass
- can be private , friendly , protected , public
- if there the same name and you need the outer class member
    - this.x = 10
    - myclass.this.x = 20

### static Inner class
- public static class InnerClass(){
    
}

### Local Inner class
- class inside method
- public void myMethod(){
    class mylocal{

    }
    MylocalInnerclass myobj = new mylocal();
}
- can access outer class members
- 


