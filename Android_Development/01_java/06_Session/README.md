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

# Event Handling
- Gui -> button , checkbox
- button b = new button("ok");
- MyListner myL = new Mylistener();
- b.addActionListiener(myL);
- Interface ActionListener
    - void	actionPerformed(ActionEvent e)
    - Invoked when an action occurs.
- we should implement the interface and implement the callback

## Event dispatching thread
- button <-> register <-> ActionListener
- Event Queue (JVM) 
- button will throw action event 
    - then event queue deliver to the listner
- no blocking code or lengthy should be done in this handler

## example
- applet two buttons inc , dec for text

## Events Classes and Listner Interfaces
- Event , Listner Interface , Methods
- key event -> key listner -> methods
- Mouse Event -> mouse listner + mouse motion listner -> mouse pressed + mouse moved
- keybord

## window listner -> window Adapter , just implement this interface 

## tasks
### task1
- 2 buttons
    - unless one listner anomyous local class


### bonnus task2
- create an applet that displays string which user move it using arrow key
- key listner
- applet will be the source
- click on applet before 

### task3
- make the oval constant so don't start the thread
- two buttons to start and pause the ball
- use suspend with pause
- same start button will resume it

### bonus task4
- create an applet that draws an oval which the user can drag
- listner mouse motion
- source applet

### task 5 draw one line
- draw a line x1 y1 x2 y2
- get x and get y
- press
- dragged -> get x and y then repaint




### task6 draw three using array
draw only three lines
- release create line object
- no thread
- class lines to store it  just draw 3 lines


### bonus task7 draw three using vector
draw only three lines
- release create line object
- no thread
- class lines to store it  just draw 3 lines


## task weekend
- make a draw brusher

