# Interfaces
- how we can communcate and intefrate with each others
- interface is a fully abstract class
- so we have new relation which is implement not extend
- it specifies what must be done but not how to do it
- class can implement more than one interface
- similar to multiple inhertance but classes don't have implemented methods

## example
- Myinterface (implemnts) -> Shape(extends)-> cir + rec , building(extends)-> aprtement + villa

## usage of interface
- integration which happens at first
- make interface to be implemented
- syntax -> specifier interface name
- methods are public abstract
- no instace member vars , they are static public final

```java
public interface Numbers{
    int getNext();
    void reset();
    void setStart();
}
```
## we can make ref. from interface to point to what it implements


# Threading
- diff between multithreading and multitasking
    - threads run on same core
    - dif process run on diff cores

- each process has at least two threads 
    - main and garbage collector
- cm same arch -> but scheduling diff

## catogries
- Daemon thread
    - garbage collector
    - event dispatcher
- User created thread
    - Main thread + thr1 2 3

### - thread has life cycle + run method
- start() -> run() (call back method) (overrided) -> sleep -> suspend -> resume() -> stop()
- class object -> wait() , notify() , notifyAll()

### working with threads
- define class extends Thread
- override its run() method
- call start
- don't call run because it will work on same
- blocking code needs thread (as downloading or reading or lengthy operations)
    - make these operations in thread and put them inside



## task
1. 
- text Banner Applet
- create applet that displays marquee string on it

2. 
- Animation Ball Applet
- Create an applet that displays the ball which moves in the randomly on the applet

