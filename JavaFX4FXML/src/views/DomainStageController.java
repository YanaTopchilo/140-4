/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import repositories.*;
import static views.PersonStageController.person;
import javafx.scene.control.Button;
/**
 *
 * @author Topchilo
 */
public class DomainStageController implements Initializable {
   
    @FXML
    private TableView<DomainTable> table;
    @FXML
    private TableColumn<DomainTable, String> webnameColumn;
    @FXML
    private TableColumn<DomainTable, String>  domainNameColumn;
    @FXML
    private TableColumn<DomainTable, String> IPColumn;   
    @FXML
    private TableColumn<DomainTable, LocalDate> dateRegColumn;
    @FXML
    private TableColumn<DomainTable, String> countryColumn; 
    @FXML
    private Button change;
    
    
    private RepositoryImpl repository;
    private PersonStageController personStageController;
    boolean changeStyle = true;
    
    public DomainStageController(){
        repository = new RepositoryImpl();
        personStageController = new PersonStageController();
    }
      
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        if (changeStyle) {
            table.getStylesheets().clear();
            change.getStylesheets().clear();
            table.getStylesheets().add("views/styleDomain2.css");
            change.getStylesheets().add("views/styleDomain2.css");
        } else {
           table.getStylesheets().clear();
           change.getStylesheets().clear();
           table.getStylesheets().add("views/styleDomain1.css");
           change.getStylesheets().add("views/styleDomain1.css");
        }
        changeStyle = !changeStyle;
    }

     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    ObservableList<DomainTable> observableList = FXCollections.observableArrayList();
    repository.getDomainByPerson(person).forEach(domain -> {
        observableList.add(new DomainTable(domain.getWebname(), 
                domain.getDomainName(), 
                domain.getIP(), 
                domain.getDateReg(), 
                domain.getCountry()));
    });

    webnameColumn.setCellValueFactory(new PropertyValueFactory<DomainTable, String>("webname"));
    domainNameColumn.setCellValueFactory(new PropertyValueFactory<DomainTable, String>("domainName"));
    IPColumn.setCellValueFactory(new PropertyValueFactory<DomainTable, String>("IP"));
    dateRegColumn.setCellValueFactory(new PropertyValueFactory<DomainTable, LocalDate>("dateReg"));
    countryColumn.setCellValueFactory(new PropertyValueFactory<DomainTable, String>("country"));
    table.setItems(observableList);
         
        }          
    }    
    

