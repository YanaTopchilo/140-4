/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafx4fxml;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.text.*;
import javafx.scene.paint.Color; 
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import repositories.*;
import models.*;
import views.PersonStage;;
/**
 *
 * @author kosti
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label welcomLbl; 
    @FXML
    private Label userLbl;
    @FXML
    private TextField textUser;
    @FXML
    private Label passLbl;
    @FXML
    private TextField textPass;
     @FXML
    private Label enterLbl;
    
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
       String userEnter = textUser.getText();
        String passEnter = textPass.getText(); 
        RepositoryImpl catalogUser = new RepositoryImpl();
         for (int i = 0; i<catalogUser.getUsers().size(); i++){
             if (catalogUser.getUsers().get(i).getName().equals(userEnter) &
             catalogUser.getUsers().get(i).getPassword().equals(passEnter)){
                  new PersonStage().init();
             }
             else { enterLbl.setText("User or password is not correct");
               enterLbl.getStyleClass().add("enterLbl");}
    }}
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        welcomLbl.getStyleClass().add("welcomLbl");
    }    
    
}
