# Data types + operators

## Identifiers -> start _ $ letter

## Data types

### primitives
- boolean 1bit 
- integer : byte 1B , short 2B , int 4B , long 8B
- floating point  float 4B , double 8B
- char 2B
- you should respect memory espacially in servers
- each primitive data type has a corresponding wrapper class 
    - Integer i2 = new Integer(42);
    - byte b = i2.byteValue();
    - String  s3 = Integer.toHexString(254); 

### - Object is the top parent -> root of class hierarchy
- it has some methods to be inherited

### value for types
- char : unicode : '\u0000' .... '\uFFFF'
    - another representation for chars is ASCII

- Int : 0 -> octal , 0x -> hex

- from small types to big -> implicit castig
    - other is explicit casting

- instance of : check for class



## Refrence 
### Classes 
- Myclass myref -> just a ref
- myRef = new Myclass
- An object is garbage collected when there is no ref ponting to it
- can i enforce garbage collector to do somthing ?
    - no you can request
    - System.gc()
- see the return of process 
    - echo $?

### Arrays
- array of primitive or object refrence
- size of array in creation
- java array are homogenous
- array of shapes can contain cir , rec ,tri

## strings
- don't compare by ==  
    - shallow comparison
- but by equals or equalsIgnoreCase
- and other refrences types
- object of class is immutable
    - so when you adjust on one of it 

## control flow in java
- else if -> else {if{}}
- switch(){} -> byte , shor , int , char , enum , String
    - case val : 
        break ;
    - defualt:
        break ;
- while(boolean_condition(true|false));
- do .. while()
- enhance for loop
    - for(double value : samples){}
- break , continue

## comments
/** 
    */
- javadoc ...








