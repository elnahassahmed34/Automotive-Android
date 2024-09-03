# java collections
- they inherits collection class
- java collection framework -> create collction classes
- store and monage of objects in memory
 
## types
- sets , sequences , maps
- collections store refrences -> the objects themselves are external to objects

### Sets
- it has iterface set that extends collection
- not allow redundncy
- unique things (classes that implement set)
- unique objects

### sequences = lists + queues
- list -> lists of things
    - care about index

- queus -> things that arranged in which they are to be processed

### maps
- things with a unique ID (classes that implemnt map)
- unique keys


## Sets
- simplest kind
- cares about uniqueness , it doesn't allow dupliction
- add object -> if it is n't available
- can be asked about the availability of object

### classes that implements sets
comparison | HashSet | LinkedHashSet | TreeSet
----------------------------------
### HashSet -> hashed uniqueness
- not sorted
- not ordered
- better performance with effecient hashcode()

### - LinkedHashSet
- Linked list + set(unique) + hashed
- not sorted
- Elements are in order in which they were inserted
- Maintains a doubly linked list across all elements
- good in insertion and deletion but bad in searching

### - Tree set
-  sorted because of tree
- elements will be in asc. order
- you can use a constructor takes comparator 

## sequences -> implemtation
- arrays or vectors
- linked list
- stack LIFO
- queue FIFO

### lists
- cares about index
- get(index) , add , indexof
- add in the last

### vector
- methods are syncronized for thread safety

### ArrayList
- better iteration perf. than linked list
- better than vector if sync is not needed


### Linked list
- Elements are doubly linked -> implemts stack or queue
- fast insertion and deletion


### Queue
- designed FIFI
- priority queue is to create (priority in / out) pririty oppesed 

## maps
- they use keys and values
- get object by key or value

### hash map
- hash code for key
- not sorted + ordered
- better perf . with effienct hashcode()

### hash table
- not sorted
- but ordered in which inserted
- methods are sync
- no null keys or objects

### Linked hash map
- not sorted
- but ordered in which inserted
- faster iteration but not sync

### Tree map
- sorted by nature order or custom comparison of elemtns
- they are ordered


## iterator
- object that can access each element of collection
- can be used with set or seqences but not map

### usage
- collection -> iterator -> stands before first object
- iterator -> return object of class that implements iterator
- iterator -> hasNext()
- next -> object

### collection of classes [java.util]
- iterable -> higher class
- collection
- list queeu set
- but map has another method

### Generics
- Generics allow you to abstarct over types
- most common examples are container types such as collection herichy
- List myUntList = new LinkedList();
- myIntList.add(new Integer(0));
- Integer x = (Integer) myIntKist.iterator()..next();
- the cast in line three is annoying
- so we use generics
- List<Integer> myUntList = new LinkedList<Integer>();
- myIntList.add(new Integer(0));
- Integer x = myIntKist.iterator()..next();
#### if you don't specify the type of generics so it will be Obect (top class)


## Example
- java TreeSet class
- unique elements + asc order
- TreeSet<String> al = new TreeSet<String>()
- ai.add

## example 2
- hashmap
- HashMap<Integer , string> hm = new HashMap<Integer , String>(); 
- for(Map.Entry(inner class) m:hm.entrySet()){
    System.out.println(m.getKey() + " " + m.getValue);    
}
- every run will have another order 


# java sockets 

## TCP vs UDP
### - TCP
- connection oriented -> handshaking procedure
- continious stream
- Reliable

### UDP
- message priented
- not reliable

## Establishing connection
- in order to remote hist -> two pieces
    - IP addr (remote machine)
    - port number (identify the servicce at the remote machine)
- socket = addr + port
- range of port numbers -> 0 -> 65,535
- from 0->1024 reserved of well known service
    - httpo 80 
    - ftp 21 
    - telnet 24

## Basic client / server communication

| Server      | Client |
|:----------|----:|
| create a server socket (bind the service to a certain port)  |   |
| listen for connection|  create a socket (connect to server) |
| Accet connection and transfere the client req. to the virual port |  28 |
|obtain input and output streams | obtain input and output streams| 
|Send and recieve data | Send and recieve data| 
|Terminate connection after communication ended | Terminate connection after communication ended | 


- server
    - open + bind + accept + send recieve + end
- client 
    - open + connect + send recieve + end 

- they should talk in the same level of input output stream

## server socket class
- constructors
    - server socket (port)
    - serversocker(port , int maxcon)
    - ip is for machine

- commonly used methods
    - socket accept 
        - the methods blocks until a connection
        - return socket -> clinet 

    - close


### Socket address
- constructors
    - socket (addr , port)
    - socket (InetAddr , int port)

- commonly used methods
    - Input stream getinputstream()
    - Output stream getoutputstream()

- you should deal on high level or level streams

### Inet address class
- has no public const
- get address


## simple clinet server

## chat room Gui app example
- server
- clients 1 2 3 4 .. n
- msgs to all clients from on server
- server keeps array of sockets
- server keeps input output streams of sockets
- threads to listen to every client

public class chatserver{
    
    chatserver{

    serversocket serversocket;
    public ChatServer{
        serversocket = new serverSoket();
        while(ture){
            socket s = server
            new Chathandler
        }
    }
    }

    public static void main(String[] args){new ChatServer();}
}


class ChatHandler extnds Thread{

    DataInputstream dis;
    PrintStream ps

    static vector<chathandler> clents vetor = new chathandlervector

public chahandle(socket cs){
    cs = new data input
    ps = new printstream
    chathandler.clientsvector.add(this);
}

public void rin()
while(){
    string str dis.realine();
    sendmesshatoAll(str);
}

void sendMessage to all (string msg)
for(chatHandler ch : clients vector){

    ch.ps.println(msg);

}

## create a gui desktop app
- create a gui desktop app which you can use as a simple chatting program interface


