/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mynotepad;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

/**
 *
 * @author ahmed
 */
public class FXMLDocumentController implements Initializable {
    
    private Label label;
    @FXML
    private MenuBar menuBar;
    @FXML
    private Menu fileMenu;
    @FXML
    private MenuItem mnuitmNew;
    @FXML
    private MenuItem mnuitmOpenLL;
    @FXML
    private MenuItem mnuitmOpenHL;
    @FXML
    private MenuItem mnuitmSaveLL;
    @FXML
    private MenuItem mnuitmSaveHL;
    @FXML
    private MenuItem mnuitmExit;
    @FXML
    private Menu editMenu;
    @FXML
    private MenuItem mnuitmCut;
    @FXML
    private MenuItem mnuitmCopy;
    @FXML
    private MenuItem mnuitmPaste;
    @FXML
    private MenuItem mnuitmDelete;
    @FXML
    private MenuItem mnuitmSelectAll;
    @FXML
    private Menu helpMenu;
    @FXML
    private MenuItem mnuitmAbout;
    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
