/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contactlist;


import DOA.DOA;
import DTO.Contact;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.apache.derby.impl.sql.compile.InListOperatorNode;
import org.apache.derby.jdbc.ClientDriver;

/**
 *
 * @author WEWE
 */
public class FXMLDocumentController implements Initializable {
    
    private Label label;
    @FXML
    private TextField TextFieldFrameID;
    @FXML
    private TextField TextFieldFirst;
    @FXML
    private TextField TextFieldFrameMiddle;
    @FXML
    private TextField TextFieldLast;
    @FXML
    private TextField TextFieldFrameEmail;
    @FXML
    private TextField TextFieldFramePhone;
    @FXML
    private Button BtnNew;
    @FXML
    private Button BtnUpdate;
    @FXML
    private Button BtnDelete;
    @FXML
    private Button BtnFirst;
    @FXML
    private Button BtnPrevious;
    @FXML
    private Button BtnNext;
    @FXML
    private Button BtnLast;
    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Contact contact = new Contact();

    }    

    @FXML
    private void HandlerBtnNew(ActionEvent event) {
        
        try {
            Contact contact = new Contact();
            contact.setId(Integer.parseInt(TextFieldFrameID.getText()));
            contact.setFirstName(TextFieldFirst.getText());
            contact.setMiddleName(TextFieldFrameMiddle.getText());
            contact.setLastName(TextFieldLast.getText());
            contact.setEmail(TextFieldFrameEmail.getText());
            contact.setPhone(TextFieldFramePhone.getText());
            DOA.newContact(contact);
     
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void HandlerBtnUpdate(ActionEvent event) throws SQLException {
        
        Contact contact = new Contact();
        contact.setFirstName(TextFieldFirst.getText());
        contact.setMiddleName(TextFieldFrameMiddle.getText());
        contact.setLastName(TextFieldLast.getText());
        contact.setEmail(TextFieldFrameEmail.getText());
        contact.setPhone(TextFieldFramePhone.getText());
        DOA.updateContact(contact);
        
     
    }

    @FXML
    private void HandlerBtnDelete(ActionEvent event) {
        try {
            Contact contact = new Contact();
            contact.setId(Integer.parseInt(TextFieldFrameID.getText()));
            DOA.deleteContact(contact);
     
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void HandlerBtnFirst(ActionEvent event) throws SQLException {
        ResultSet rs = null;
        Contact contact = new Contact();
        contact.setId(Integer.parseInt(TextFieldFrameID.getText()));
            
    try {
        rs = DOA.FirstContact(contact);
        while (rs.next()) {
        // Process the ResultSet
        }
    } finally {
        if (rs != null) {
        rs.getStatement().close(); // This closes both the statement and the connection
        rs.close();
    }
}

    }

    @FXML
    private void HandlerBtnPrevious(ActionEvent event) {
    }

    @FXML
    private void HandlerBtnNext(ActionEvent event) {
    }

    @FXML
    private void HandlerBtnLast(ActionEvent event) {
        
    }
    
}
