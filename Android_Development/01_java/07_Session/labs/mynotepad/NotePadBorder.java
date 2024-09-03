package mynotepad;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCombination;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class NotePadBorder extends BorderPane {

    protected final MenuBar menuBar;
    protected final Menu fileMenu;
    protected final MenuItem mnuitmNew;
    protected final MenuItem mnuitmOpenLL;
    protected final MenuItem mnuitmOpenHL;
    protected final MenuItem mnuitmSaveLL;
    protected final MenuItem mnuitmSaveHL;
    protected final MenuItem mnuitmExit;
    protected final Menu editMenu;
    protected final MenuItem mnuitmCut;
    protected final MenuItem mnuitmCopy;
    protected final MenuItem mnuitmPaste;
    protected final MenuItem mnuitmDelete;
    protected final MenuItem mnuitmSelectAll;
    protected final Menu helpMenu;
    protected final MenuItem mnuitmAbout;
    protected final TextArea textArea;
    protected Stage myStage;

    public NotePadBorder() {

        menuBar = new MenuBar();
        fileMenu = new Menu();
        mnuitmNew = new MenuItem();
        mnuitmOpenLL = new MenuItem();
        mnuitmOpenHL = new MenuItem();
        mnuitmSaveLL = new MenuItem();
        mnuitmSaveHL = new MenuItem();
        mnuitmExit = new MenuItem();
        editMenu = new Menu();
        mnuitmCut = new MenuItem();
        mnuitmCopy = new MenuItem();
        mnuitmPaste = new MenuItem();
        mnuitmDelete = new MenuItem();
        mnuitmSelectAll = new MenuItem();
        helpMenu = new Menu();
        mnuitmAbout = new MenuItem();
        textArea = new TextArea();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        BorderPane.setAlignment(menuBar, javafx.geometry.Pos.CENTER);
        menuBar.setId("menuBar");

        fileMenu.setId("fileMenu");
        fileMenu.setMnemonicParsing(false);
        fileMenu.setText("File");

        mnuitmNew.setId("mnuitmNew");
        mnuitmNew.setMnemonicParsing(false);
        mnuitmNew.setText("New");
        mnuitmNew.setAccelerator(new KeyCodeCombination(KeyCode.N, KeyCombination.CONTROL_DOWN));
        mnuitmNew.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                textArea.clear();
            }
        });

        mnuitmOpenLL.setMnemonicParsing(false);
        mnuitmOpenLL.setText("Open Low Level");
        mnuitmOpenLL.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                FileChooser fc = new FileChooser();
                File file = fc.showOpenDialog(myStage);
                if(file != null)
                {
                    FileInputStream fis;
                    try {
                        fis = new FileInputStream(file);
                        int size = fis.available();
                        byte[] b = new byte[size];
                        fis.read(b);
                        textArea.setText(new String(b));
                        fis.close();
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(NotePadBorder.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(NotePadBorder.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });

        mnuitmOpenHL.setId("mnuitmOpenHL");
        mnuitmOpenHL.setMnemonicParsing(false);
        mnuitmOpenHL.setText("Open High Level");
        mnuitmOpenHL.setAccelerator(new KeyCodeCombination(KeyCode.O, KeyCombination.CONTROL_DOWN));
        mnuitmOpenHL.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                FileChooser fc = new FileChooser();
                File file = fc.showOpenDialog(myStage);
                if(file != null)
                {
                    FileReader fis;
                    try {
                        fis = new FileReader(file);
                        char[] c = new char[1000];
                        fis.read(c);
                        textArea.setText(new String(c));
                        fis.close();
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(NotePadBorder.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(NotePadBorder.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        
        mnuitmSaveLL.setId("mnuitmSaveLL");
        mnuitmSaveLL.setMnemonicParsing(false);
        mnuitmSaveLL.setText("Save Low Level");
        mnuitmSaveLL.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event){
                FileChooser fc = new FileChooser();
                File file = fc.showSaveDialog(myStage);
                if(file != null)
                {
                    FileOutputStream fos;
                    try {
                        fos = new FileOutputStream(file);
                        byte[] b = textArea.getText().getBytes();
                        fos.write(b);
                        fos.close();
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(NotePadBorder.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(NotePadBorder.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });

        mnuitmSaveHL.setId("mnuitmSaveHL");
        mnuitmSaveHL.setMnemonicParsing(false);
        mnuitmSaveHL.setText("Save High Level");
        mnuitmSaveHL.setAccelerator(new KeyCodeCombination(KeyCode.S, KeyCombination.CONTROL_DOWN));
        mnuitmSaveHL.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                FileChooser fc = new FileChooser();
                File file = fc.showSaveDialog(myStage);
                if(file != null)
                {
                    FileWriter fos;
                    try {
                        fos = new FileWriter(file);
                        String str = textArea.getText();
                        fos.write(str);
                        fos.close();
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(NotePadBorder.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(NotePadBorder.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        
        mnuitmExit.setId("mnuitmExit");
        mnuitmExit.setMnemonicParsing(false);
        mnuitmExit.setText("Exit");
        mnuitmExit.setAccelerator(new KeyCodeCombination(KeyCode.E, KeyCombination.CONTROL_DOWN));
        mnuitmExit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                myStage.close();
            }
        });
        
        editMenu.setId("editMenu");
        editMenu.setMnemonicParsing(false);
        editMenu.setText("Edit");

        mnuitmCut.setId("mnuitmCut");
        mnuitmCut.setMnemonicParsing(false);
        mnuitmCut.setText("Cut");
        mnuitmCut.setAccelerator(new KeyCodeCombination(KeyCode.X, KeyCombination.CONTROL_DOWN));
        mnuitmCut.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                textArea.cut();
            }
        });

        mnuitmCopy.setId("mnuitmCopy");
        mnuitmCopy.setMnemonicParsing(false);
        mnuitmCopy.setText("Copy");
        mnuitmCopy.setAccelerator(new KeyCodeCombination(KeyCode.C, KeyCombination.CONTROL_DOWN));
        mnuitmCopy.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                textArea.copy();
            }
        });

        mnuitmPaste.setId("mnuitmPaste");
        mnuitmPaste.setMnemonicParsing(false);
        mnuitmPaste.setText("Paste");
        mnuitmPaste.setAccelerator(new KeyCodeCombination(KeyCode.V, KeyCombination.CONTROL_DOWN));
        mnuitmPaste.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                textArea.paste();
            }
        });

        mnuitmDelete.setId("mnuitmDelete");
        mnuitmDelete.setMnemonicParsing(false);
        mnuitmDelete.setText("Delete");
        mnuitmDelete.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                textArea.deleteText(textArea.getSelection());
            }
        });

        mnuitmSelectAll.setId("mnuitmSelectAll");
        mnuitmSelectAll.setMnemonicParsing(false);
        mnuitmSelectAll.setText("Select All");
        mnuitmSelectAll.setAccelerator(new KeyCodeCombination(KeyCode.A, KeyCombination.CONTROL_DOWN));
        mnuitmSelectAll.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                textArea.selectAll();
            }
        });

        helpMenu.setId("helpMenu");
        helpMenu.setMnemonicParsing(false);
        helpMenu.setText("Help");

        mnuitmAbout.setId("mnuitmAbout");
        mnuitmAbout.setMnemonicParsing(false);
        mnuitmAbout.setText("About");
        mnuitmAbout.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setContentText("Version: NotePad 1.0");
                alert.show();
            }
        });
        
        setTop(menuBar);

        BorderPane.setAlignment(textArea, javafx.geometry.Pos.CENTER);
        textArea.setPrefHeight(200.0);
        textArea.setPrefWidth(200.0);
        setCenter(textArea);

        fileMenu.getItems().add(mnuitmNew);
        fileMenu.getItems().add(mnuitmOpenLL);
        fileMenu.getItems().add(mnuitmOpenHL);
        fileMenu.getItems().add(mnuitmSaveLL);
        fileMenu.getItems().add(mnuitmSaveHL);
        fileMenu.getItems().add(mnuitmExit);
        menuBar.getMenus().add(fileMenu);
        editMenu.getItems().add(mnuitmCut);
        editMenu.getItems().add(mnuitmCopy);
        editMenu.getItems().add(mnuitmPaste);
        editMenu.getItems().add(mnuitmDelete);
        editMenu.getItems().add(mnuitmSelectAll);
        menuBar.getMenus().add(editMenu);
        helpMenu.getItems().add(mnuitmAbout);
        menuBar.getMenus().add(helpMenu);

    }
    
    public NotePadBorder(Stage stage) {
        this();
        myStage = stage;
    }
}
