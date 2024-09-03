# Java Darabase Connectivity (JDBC)

- Java Api for connecting to any DBMS -> excuting SQL statments
- Hides DB specific details app
- consists of classes + interfaces 
- JDBC interfaces imp. by DBMS vendors in order to provide their own vendor specific JDBC drivers
- JDBC driver -> Data imp. of JDBC interfaces
    - every database servers has coressbonding JDBC drivers

## JDBC driver
- java app
- JDBC API
- drivers -> oracle , pointery , derby

## types of JDBC Drivers
### type 1
- Translates all JDBC calls into ODBC calls and sends them to ODBC driver
- ODBC -> controls system calls
- classes are already with jdk
- rather slow in perf. due to overhead of sevral layers
- usualy used for testing at early stages of building system or when there are no other alternative drivers type

### type 2 Native API (partly java) Driver
- converts JDBC calls into direct database specifi call
- classes are provided by DBMS vendors (Oracle OCI Driver)
- fastest in performance (no transltion overhead)
- native therfore it is not portable
- requires setup at client side = it is not appropriate for use with applets


### type 4 pure java native protocol driver
- communicates directly with database
- classes re provide by DMBS vendors -> oracle thin driver
- classes are 100% written in java lang, -> portable (may be included in JAR files of app)
- this is most commnly used


### type 3 : pure java - Network Driver
- Requests are passed through the network to the middleware server
- app -> middleware -> DB
- midlleware translates the req. to DB -> middleware server can in turn of type 1 , 2 , 4
- classes are n't vendor specicf , can be connect to any type of DB

### type 5 ORM -> object relational mapping
- instead of writing queries
- change it into objects
- only one database in mobile -> SQlite -> build in OS (android or IOS)


## Steps for connecting and dealing with database
1. load register DB driver
2. connction
3. ecute queries
4. process results
5. closing


## example
```java
driverManager.retrieveDriver(new OracleDriver()); //1
connection con = DriverManager.getconncection(jdbc:oracle@127.0.0.1.1521:xe , "username" , "password"); //2

statment stmt = con.createStatment();
String queryString = new String("select * from tab");
Result rs = stmt.excutteQuery(queryString); //3

while(rs.next()){
    System.out.println(rs.getString(1)); //4
}

stmt.close();
con.close();//5

//if there is error
catch(SQLEXCEPTION ex){
    ex.printStackTrace();
}



```


### working with DB using statment
```java
Statment stmt = con.createStatmet();
String queryString = new String("select * from tab where name='Ali' and age>20")
String queryString = new String("select * from tab where name='"+nameVar+"' and age>20)
ReasultSet rs = stmt.excuteQuery(queryString);
```


## Prepared Statment
```java
PreparedStatmet pst = con.preparedStatment("select * from Emplyee where gender = ? AND salary > ?");
pst.setString(1,"male");

resultSet rs = pst.excuteQuery();

//if you want to excute
pst.excuteUpdate(); //return id of recorde that was inserted or deleted

```

## Statment types
- Statment
- PreparedStatement
- callable Statement


## ResultSet
- JDBC provide cinnection methods
- types
    - forward only
    - Scroll Intensive
    - Scroll Sensetive

### methods
- Novigtional -> next , previous , first , last , beforefirst , afterLast
- gettters    -> get int , long , string , float , boolean , Blob(binary large object) , object

## batch update
- more than one statment
1. disable auto commit mode
2. create a Statement isntance
3. add SQL command
4. excute
5. close

### example
```java
con.setAutoCommit(false);

preparedStatement pst = con.prepareStatment();

pst.addBatch();

Int[] updateCounts = pst/excuteBatch();

con.commit();

```

## lab
- add table
- add coulmns
- sccene builder
- make new pkg -> DAO -> data access object
```java


public class DAO{
    public static int newContact() throws SQLException{
        int insertionStatus = 0 ;

        DriverManager.registerDriver(new ClientDriver()); //add throws
        Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/ContactList","root","root");
        PreparedStatment statement = con.prepareStatment("INSERT INTO contact ? ,? ,?");
        statment.setInt(1 , contact.getId);
        insertionStatus = statement.excuteUpdate();


        return insertionStatus ;
    }
}

//in initialize method
Contact contact = new Contact();
contact.setId(textfield.get);

DAO.newContact(); // surrounds try catch

```

- new pkg DTO -> data transfere object
    - have other names
        - data class , model
        - POJO -> Plain Old Java object
        - Bean - Java Bean

```java
public class Contact{
    private int id;
    private String firstName;
    private String MiddleName;
    private String LastName;
    private String PhoneNumberName;
    private String Name;
    
}

```

































