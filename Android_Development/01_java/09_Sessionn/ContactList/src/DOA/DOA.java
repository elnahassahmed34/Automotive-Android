/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DOA;

import DTO.Contact;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.derby.jdbc.ClientDriver;

/**
 *
 * @author WEWE
 */
public class DOA {
    public static int newContact(Contact contact) throws SQLException{
        int insertionStatus = 0 ;

        DriverManager.registerDriver(new ClientDriver()); //add throws
        Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/ContactList","root","root");
        PreparedStatement statement = con.prepareStatement("INSERT INTO CONTACTTABLE values( ?, ?, ?, ?, ? ,?)");
        statement.setInt(1 , contact.getId());
        statement.setString(2, contact.getFirstName());
        statement.setString(3, contact.getMiddleName());
        statement.setString(4, contact.getLastName());
        statement.setString(5, contact.getEmail());
        statement.setString(6, contact.getPhone());
        
        insertionStatus = statement.executeUpdate();

        con.close();
        statement.close();
        return insertionStatus ;
    }
    
     public static int updateContact(Contact contact) throws SQLException{
        
        DriverManager.registerDriver(new ClientDriver()); //add throws
        Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/ContactList","root","root");
        PreparedStatement statement = con.prepareStatement("UPDATE CONTACTTABLE\n" +
"SET FNAME = ? , MNAME= ? , LNAME= ? , EMAIL= ? , PHONE= ?\n" +
"WHERE ID = ?");
        statement.setInt(6 , contact.getId());
        statement.setString(1, contact.getFirstName());
        statement.setString(2, contact.getMiddleName());
        statement.setString(3, contact.getLastName());
        statement.setString(4, contact.getEmail());
        statement.setString(5, contact.getPhone());
        int result = statement.executeUpdate();
        con.close();
        statement.close();
        return result;
    }
     
         public static int deleteContact(Contact contact) throws SQLException{
        DriverManager.registerDriver(new ClientDriver()); //add throws
        Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/ContactList","root","root");
        PreparedStatement statement = con.prepareStatement("DELETE FROM CONTACTTABLE WHERE ID=?");
        statement.setInt(1 , contact.getId());
        int result = statement.executeUpdate();
        con.close();
        statement.close();
        return result;
    }
        
    public static ResultSet FirstContact(Contact contact) throws SQLException {
    DriverManager.registerDriver(new ClientDriver());
    Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/ContactList", "root", "root");
    
    String sql = "SELECT * FROM CONTACTTABLE WHERE ID = ?";
    PreparedStatement statement = con.prepareStatement(sql);
    statement.setInt(1, contact.getId());  

    ResultSet result = statement.executeQuery();
    
    return result;
}
}
