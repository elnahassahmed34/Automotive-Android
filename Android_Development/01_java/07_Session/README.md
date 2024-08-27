# UI
## - AWT -> platform dep. + heavy wight

## - Swing -> top of AWT + platform ind. + lightwight

## AWT vs SWING
- AWT doesn't follows MVC (model view controller)
    - model = data
    - view = virsulization of data (table or other)

- Swing follows MVC
- maintainbility + extensibility + testing

## JAVA FX
- F3 -> FOrm Folows 
- java FX included a feauture of customized style using CSS (Cascading Style Sheets)
- UI is the most important thing in the software industry
- javafx has many components

## compirason
- AWT -> platform spec.
- Swing -> only desktop apps
- java FX -> desktop + websites + handheld devices friendly

## - Drag and drop -> IDE

## java Swing vs java FX
-Swing -> java frame (top level container) -> jave panel -> components
- Javafx -> all the world is the stage (top level container)
    - java fx .scene -> compnents

##  three ways to create program
- simple code using classes
- using FXML
- using Scene builder

## hello world
```java

public class HelloWorld extends Application{
    public void start(Stage primaryStage throws EXception){
        Text hellowworld = new Text("hello nahass");
        StackPane rootPane = new StackPane(hello world);
        Sene scene = new scene (rootpan , 400 , 300)
        primary Stage.setScene(scene);
        primary Stage.show(scene);

    
    }   

    public static void main(String [] args){
        Application.launch(args);
    }
}
```

### Application class
- entry point for java fx
- init , start , stop
- launch

### launch
- called from main
- two override 
    - args
    - class extends app + args

### life cycle of java fx
- java fx runtime -> - create app object in app thread

-  java fx launcher launcher thread -> - call init() on the created Object

-  java fx app thread -> calls the start method of the specific app class

## Platform class
- public staic void runLater(Runable runnable)
    - it will be done after collecting data
    - it will run over the same thread
    - run over app thread

## Stage
- top level javaFX  containers
- primary stage constructed by platform
- stage obj. must be constructed and modified by java app thread
- types
    - decorated , transparent , utility

### Stage modality
- window blocks the parent window
- types
    - none -> not block 
    - window modal -> block its parent
    - app modal -> blocks all


## control
- control - > Region -> Parent -> node
- class control base class for all javafx controls
- button based class
    - you can make a default button -> 
- menu classes
- text input control
- Text Area
- html editor

### menu
- menu bar -> menu -> menu items

### event handler -> two methods
- add Event Handler (ActionEvent.Action , new Event Handler <Action Event>)(){
    public void handle(ActionEvent event){

    }
}
- b.setaction(evemt)

## Building UI Using JavaFx (Layout)
- all layouts -> panes -> nodes
### - BorderPane -> nodes
- BOrderBane(left , right)

### - flow Pane
- FlowPane -> Orientation (horz. or vertical)
- alingment -> x , y align them

### Anchor Pane
- distance is stable when resizing

## app
- border bane
- menu on the top
- add menu items
- give it a name from lower right
- close
- generate class -> notebad border pane
- mnuitem.setonaction(new Eventhandler<ActionEvent>(){
    @override
    public void ahndle(ActionHandler event){
        textArea.clear();
    }
});
- in the .java
    - Parent root = new NotePadBorder();

# i/o stream
- java app <-Streams-> Data Source 
                            - (file Hard disk)
                            - Network (Remote host)
                            - Standard I/O (keyboard , mouse , Screen)
                            - Ports (Parllel , Serial)

- refrence is always the application 
- java app -> output stream -> Data source
- java app <- input stream  <- Data source

## two levels of streams
### - Low level Stream[Bytes , chars]
- speak in language of media
- Bytes
    - fileinputstream
    - fileoutputstream

- Char[]
    - File reader -> input  stream
    - File Writer -> output stream

- R/W -> randomAcessFile

### High Level Stream -> it is manager who will manage the process
- has an low level stream but you abstract from him
- Int , String , Float
    - DataInputStream
    - DataOutputStream

## file class
- directory is a file -> has its ptrs to files
### - constructors
    - File(String Path)
    - File(String Parent , String Child)
        - parent = directory , child = file
    - File(File Parent , String Child)
        - File object

### - methods
- boolean exists()
- boolean isFile()
- boolean isDirectory()
- String getName()
- String getParent()
- String getPath()
- String list
- boolean canRead
- boolean canwrite
- boolean delete
- long length
- create director or file


### file input stream
### constructors
- File Input Stram(String file or File file)

#### methods
- int read
- int read(byte[] b)
- int read(byte[] b , int offset , int length)
- int available
    - data is left to be read
- long skip(long)
    - move forward (offset)
- void close

### file output stream
-- File output Stram(String file or File file)
#### methods
- write(bute , offset , length)
- close 
- flush
    - move data from cache to ram to harddisk

### file reader class
- same as previous but on the scale of chars[]


### RandomAccessFile Class
#### constructor
- RandomAccessFile(String|File file , string mode)

#### - methods
- getFileptr
- seek
- length
- read
- write

##### download manager
- read -> download
- if you want to pause getfileptr -> seek -> read
- accelrate -> thread read -> seek , another thread
- when you download you open socket and streams
- utilize bandwidth (speed of download)
- that's why the net will be slower


### Data Input/output stream
- use low level
- write utf(String str)
- when reading you should use utf


### lab
- add low level
- add high level
- menuItemSaveaddEvent(Action.Action , new event handler eh){
    public void handle(ActionEvent event){
        FileChooser fc = new File chooser();
        File file = fc.showSaveDialogue(mystage);
        if(file != null){
            try catch :
            FileOutput fos = new FileoutStream(file);
            {

            DataOutputStream dos = new DataOutput stream(fos);
            dos.writeUTF(text.getText);
            }
            textArea.getText().getBytes
            fos.write(data);
            fos.flush();
            fos.close();
        }
    }
}

- create a constructor mystage


## install netbeans

### download 
https://dlc-cdn.sun.com/netbeans/8.2/final/bundles/netbeans-8.2-javaee-linux.sh

```sh
sudo apt-get install libcanberra-gtk-module libcanberra-gtk3-module

sudo apt-get install openjdk-8-jdk

export JAVA_HOME=/usr/lib/jvm/java-8-openjdk-amd64
export PATH=$JAVA_HOME/bin:$PATH

./netbeans-8.2-javaee-linux.sh 
```






