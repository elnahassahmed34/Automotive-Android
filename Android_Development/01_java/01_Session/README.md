# Java

## Platform + OS independent

## Java Community Process
    - standards for using java : ex : OS
- java specification request
- Open JDK -> pareel project to oracele

## java usage + flavours
- java SE -> standard Edititon
    - what we will use
- java ME -> Micro Edition
    - mobile phones + routers
- Java EE -> ENterprise Edition
    - servers and other big machines

### Usage
- Desktop app
    - java SE
    - powerpoint + reservations
- WEb apps
- Enterprise apps
    - servers as vodafone
    - web services
        - code for backend 
- Mobile apss
    - starts with JAVA ME
    - now we use android
- smart card apps
    - java card APIs
- Emb. Systems (Sun Spot - RbPi)
    - Good performance with embedded java (SE | ME)

## java is easy to learn
- syntax of c++
- Dynamic Memory Mang. (garbage collector)
- no ptrs

## macine + Platform independent
- Java app -> JVM -> OS -> HW
- JVM -> abstract layer between JVM and OS

## java is both , compiled + interpreted
- compile -> one time
- interpreter -> line by line 

- source Code (Myfile.java) compile (one time only) -> intermediat code (Myclass.class) -> Interpret JVM (every time) -> Run

## Java Dynamic Linking libs
- JVM -> JRE (user) -> JDK (libs + compilers + utilities)

- JVM written in c++ 
- first compiler was c but now java
- JRE -> written in c

## JAVA is Fully OOP
- made up of classes
- no multiple inheritance
- no stand alone function (main)

## Java is multithreaded language
- parllel excution
- GUI , Event handling , GC : threads

## JAVA is Networked
- JSR for any network
- TCP / UDP support

## hello world
```java
class HelloWorld{
    public static void main (String[] args){
        System.out.println("Hello nahass");
    }   
}
```
- System : class
- out : object -> class member
- println : method
- to run
```sh
# compile
javac hello

# run it
java HelloWorld
```
- JRE -> call main (public)
- static -> make it class member and no ownership for specific object  
- JVM will return the exit status

## packaging
- javac -d . hello.java
- java mypkg.HelloWorld

## JAR File
- jar cf app.jar files

- to create excutable JAR file
    - jar cmf -> create mainfest file + archive name + files
- jar cef HelloWorld app.jar HelloWorld.class
- java -jar app.jar

### mainfest gives info about the program

## Applets
- works inside html pages and downloaded to user maching -> run by JVM

### applet security by JVM
- syntax checking
- no i/o ops
- communicates only with server from which it downloaded

### Applet life cycle -> methods calling without interfacing of developer (call back methods)
- applet manager calls the method of cycle
- start state -> constructor
- Applet constructing -> init()
- Applet init -> start
- applet run -> start | stop | paint
- Applet stopped -> destoryed
- Applet Destoryed -> end state

### callback method
- it is forbiddent to call these methods manually
- undefined behaviour

### you can repaint
- when change in paint , call this


### Basic Java applet
```java
import java.applet.Applet;
import java.awt.Graphics

public class HelloApplet extends Applet{
    public void paint(Graphics g){
        g.drawString("Hello nahass" , 50 , 100);
    }
}

```
- Applet : multi level inheratince
    - Panel + Container + component + Object
- awt -> Abstract Window Toolkit

- standalone applet
```java
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;

public class HelloApplet extends JPanel {

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawString("Hello nahass", 50, 100);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("HelloApplet");
        HelloApplet applet = new HelloApplet();
        frame.add(applet);
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

```

### run through html
```html
<html>
    <body>
        <applet code="HelloApplet.class" width="300" height="300">
        </applet>
    </body>
</html>
```
```sh
/usr/lib/jvm/java-8-openjdk-amd64/bin/javac HelloApplet.java
appletviewer applet.html
```
## pkg
```sh
lab4_pkg $ tree
.
└── mypkg
    ├── hello.java
    └── HelloWorld.class

javac  mypkg/hello.java

java mypkg.HelloWorld
```
