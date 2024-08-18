# Qt framework

## parts of framework
###  modules
- Qtcore -> non-gui
- qt widgets -> GUI
    - doesn't respond to touch
- qt quick -> GUI
    - respond to touch
- those two modules inherit qtcore 

- there will be headers inside these modules
    - inside these headers there will be class
- ex :
```cpp
#include <QpushButton>
QPushButton button("press");
button.show();
```

### libs
- binary code
- lib 1 , 2 , 3
- main.cpp + .pro(config file){qt = widgets} -> qmake -> Makefile -> .exe 



### tools
- moc -> meta object compiler
- rcc -> qt resource compiler


## qt creator
- .pro -> config file
```cpp
#include <QCoreApplication>

int main(int argc, char *argv[])
{
    QCoreApplication a(argc, argv);

    return a.exec();
}
```
-  return a.exec();
    - event loop

## classes -> signals & slots (SS)
- class 1 
    - timer(5,func)
    - class 2 , class 3
- when clicking button -> handler
- communicating between classes happends by SS
    - connect(obj1 , signal1 , obj2 , slot1)


### usage SS
1. enable
    - class inherit QObject
    - put object macro in private section
2. define
3. connect 
4. emit


## MOC -> meta object compiler
- qmake testqt.pro
- make
- extract moc objects
- link those with main.c

