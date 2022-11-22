/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import models.Person;
import repositories.*;

/**
 *
 * @author Topchilo
 */
public class PersonStageController implements Initializable {
    
    @FXML
    private TableView<PersonTable> table;
    @FXML
    private TableColumn<PersonTable, Integer> idColumn;
    @FXML
    private TableColumn<PersonTable, String>  jobtitleColumn;
    @FXML
    private TableColumn<PersonTable, String> fullnameColumn;
    @FXML
    private TableColumn<PersonTable, String> phoneColumn;
    @FXML
    private TableColumn<PersonTable, String> emailColumn;
   
    @FXML
    private TableColumn<PersonTable, Integer>  qtyOfDomainsColumn;
    
      
 public static Person person;
    
   private RepositoryImpl repository;
 
   public PersonStageController(){
        repository = new RepositoryImpl();
    }
    
    @Override
        public void initialize(URL url, ResourceBundle rb) {
        ObservableList<PersonTable> observableList = FXCollections.observableArrayList();
        repository.getPersons().forEach(person -> {
             int qtyOfDomains = repository.getDomainByPerson(person).size();
            observableList.add(new PersonTable(person.getId(), 
                    person.getJobtitle(), 
                    person.getFullname(), 
                    person.getPhone(), 
                    person.getEmail(), 
                    qtyOfDomains));
        });
        
        idColumn.setCellValueFactory(new PropertyValueFactory<PersonTable, Integer>("id"));
        jobtitleColumn.setCellValueFactory(new PropertyValueFactory<PersonTable, String>("jobtitle"));
        fullnameColumn.setCellValueFactory(new PropertyValueFactory<PersonTable, String>("fullname"));
        phoneColumn.setCellValueFactory(new PropertyValueFactory<PersonTable, String>("phone"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<PersonTable, String>("email"));
        qtyOfDomainsColumn.setCellValueFactory(new PropertyValueFactory<PersonTable, Integer>("qtyOfDomains"));
        table.setItems(observableList);
        
       table.setOnMouseClicked(e->{
            if(e.getClickCount()==2){             
               try {
               PersonTable personTable = table.getSelectionModel().getSelectedItem();
               person = repository.getPersonById(personTable.getId());              
               new DomainStage(person).init();
                } catch (IOException ex) {
                    Logger.getLogger(PersonStageController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        }
    }    
    

