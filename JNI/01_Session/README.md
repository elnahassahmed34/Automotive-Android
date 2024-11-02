## JNI


## comp :

- Native shared libs : .so

- native static libs .a

- java native interface JNI

- App binary interface ABI , arm ,AArch64 x86 x64

- Manifest -> activity be written in c++
	- app comp may be native
	- works through NDK : native dev kit

- APK Analysis
	- classes.dex
		- one of files compressed classes 

## what is JNI

- JNI is a tandard prog interface for writting java native methods
	- and embedded jvm into native app

- primary foal comp of nattive method libs
	- all jvm imp on a given platform

- jni deifnes a way for code in c++

## ROle

- two interface that allows java paps to invoke code and vice verce

- examples handling/ interfacing hw events

- and app that process real time aufi data 

- this app leverage bative c++ fir oerfinabce ubtebsive and audo whule using java for user


## Implictions of using JNI

- app uses JNI 
	- loses portability + type safety

- as a genereal rule yous houd arch the app that natice merhods are defined as few classes as possible

- this entails a cleaner isolation between native and rest of app

## alternativess
- before you embark on a project using JNI
	- it is worth taking a step back tp investigart whether there are ateernative solutions aprropriate like 
	- commun through TCP/IP con
	- IPC mechanism

## suporting native resources

1. creating new project with c/c++ support

2. adding new c/c++ module to an existing project

3. importing c/c++ native code

## 1

- new project -> Native c++

## 2

- file -> add c++ to module
	- cpp -> include -> CMakeLists.txt
	- hellomix.cpp

## Calling a Native Method from Java

1 - create native method in your java code

```
public class Utility{
	native int getNumber();
}

```
- can't resolve corresponding JNI function java

2. implement native method in JNI

```
extern "C"

- ptr for struct JNI
- ptr to class

JNIEXPORT kint JNICALL
java eg_jetsmobilelab_Utility_getnumber(JNI *env , jobject this){
	
}

```
- JNIEXPORT : return JNICALL
-Java_FUllyQualfireldClaassName_method()

## java example

class Utility{
	native int getnumber();
}

class MAin{
	public void main(){
		utiliti i = new Utility
		int output = u.getnumber
		System.out.prntln();
	}
	
	static {System.loadLibrary("lib");}
}

```
JNIEXPORT jint JNICALL

JAva_Utitli_getNumber(JNIEnv * env , jonect)

``

## java example paramter

- *jenv ptr to pptrs

- second one ref to helloworld

- java mapping of types
- 

## JNI functions

- complete listing of fin , layout function table

- version infto , class op , exceptions
- gloval or local ref
- acc field 
- calling static
- ref natic
- 
- reflections support : i donot know details but i can question about details , libs where classes can be thought in it

- weak global ref , calling instance , monitor , obj ope , acc static fields , array operation ,

## calling a java method from c++
```
## class operations c++

- jni functions - class operations 
	- find class
		- signature : jclass FindClass(JNIEnv * env , const cahr * name)
	
	- jclass clz = env -> FindClass('com/example/demo/Complex')


- Getsuperclass

## JNI function object operations

- allocObject 
	- joject aloocate(JNIEnv * env , jclass clazz)

- IsInstanceOf : jbooleran IsInstanceOf(JNIEnv * env jobject obj , jclass)

- IsSameObject
	- jboolean IsSameObject(JNIEnv * env jobject ref1 , jobject ref2)

## jni functions - object operations :

- new object A-> array  V
- Newobject (env , class ,jmethod method,..)
- knowns number of paramters . cons jvalue * args

## NewObject

```
JNIEnv * env

jclass cls = (*env) -> FindClass(env , "")

jmethodID constructor = (*env) -> GetMehtodID(env , cls , "<init>" , "(I(/string)V")

jobject(env , cls , constructor , 42 , (*env)->NewStringUTF())
```


```

jvalue args[2]
, args


```



## access instance fiels

- get fields
- get fireld routines
- set field 








## Access Instance fmethods

1. use the find class
2. method id
3. call method
- getmethod ID (env , calss , const char * name , const cjar * sig)

- calling method :
	- CallShortMethodAV
## - signature
- long fn (int n , String s , int[] arr)
- (ILjava/langString;[I)J
- int method(boolean double) -> (ZD)I

## invoking constructirs
- to opantn pass <init>
	- and V as the return type 
	
## demo
- primitive paramter

- public native Complex create comprelx(int real , int img)
- go to JNI 
	- create object
	- pass arg
	- return obj
```
jclass cls = env -> findClass(/com/example/comple)//fully qualified class name
jmethodID constructorID = env -> GetmethidID(cls , <init> , (II)V) -> signature
jobject obj = env->NewObject(cls , constructorOD , real , img);
return obj
```



- public native String processEmployee(Employee employee);

```
jclass cls = env -> findClass(/com/example/employee)//fully qualified class name

jmethodID methodID = env -> GetmethidID(cls , "getformatData" , ()java/lang/string) -> signature

//callJavaMethod(env , thiz)


return (jstring) env->VallObjectMethid(employee , methidId)
```


### 3 files
- class employee -> methods
- mainactivity -> native method
- native-lib.cpp -> code
```
extern "C"

JNIEXPORT jstring JNICALL

Java_com_example_jnidemo_MainActivity_processEmployee

```


## access static fireld
```
GetStaticMethod or 
- GetStaticMethodID


- public static native complex meth (complex c1 c2)

```

public static Complex sum (c1 c2)
return new complex

```
- but here we donot create object
```
## string operation 
- new string UTF
- GetStringUTFLenth
- ReleaseStringUTFCjars

## array
- getarray len
- newobject
- getonject array element
- New<primitiveArray>

## accessing object's field


## general tips

- try to minimize the footprint of your JNI layer

- there are several dimensions to consider here

## mini marshaling of resources across JNI layer

- has non trivial

- send and return patamters are less

## avoid async com

- avoidd async com between code written in a managed prog lang and code written in c++

- this will keep your jni interface easier to maintain

- you can simpilfy asyn UI updated by keeping the async update in same lang as UI

## mini number of thread with JNI

- minmize no of thread that need 

- if you need to utilize thread pool in both java and c++ 
- try to keep

## Kotlin Language

- instead of native used in java , in kilin we use external

- to load lib whre native coad is located

class Myclass{
	companion objectP
	{
		init{
			System.load("")
		}
	}
	
}


## kotlin and java Interoperabiblity
- jvm lang -> comp -> .class

- typical sdk whose api migh
-sdk dev might want to write 

## class operations

```

val employee : Employee = Employee("nahass" , 26 , "ID")


```



## calling kotlin from java

```
Student s = new Student("name",12);

fun myTopLevelMeth() : String = "String from Kotlin"

@JVMstatic
@JVMOverloads
fun mydefault(inpit L int =10) : String = "you passed $input"

String str = Studentkt.myTopLevelMeth()

String str2 = Studentkt.mydefaultfun():

companion


```

- create obj from clas
- or static func ,

```
fun main(){
	println("heloo")
}
```
- kotlinc Mydemo.class
- mydemokt.class
- top level function will be static function in this class


## exception
- @Throws(IOExceptionLLclass)

## lab 1

- create an android app where the user inputs a number and the app calc the factorial of that number using c++ code , the result is then diplayed in the a[[

- kotlin handle event and call java method

- java call c++ methods 

- c++ factorial computation

- kotlin shows results on text view

- java returns the result to kotlin

- c++ call java method
















































































