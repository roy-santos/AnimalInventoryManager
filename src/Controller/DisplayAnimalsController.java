package Controller;

import Model.Animal;
import Model.DataProvider;
import Model.Dog;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DisplayAnimalsController implements Initializable {

    Stage stage;
    Parent scene;

    @FXML
    private TableView<Animal> animalTableView;

    @FXML
    private TableColumn<Animal, Integer> animalIdCol;

    @FXML
    private TableColumn<Animal, String> breedCol;

    @FXML
    private TableColumn<Animal, Integer> lifespanCol;

    @FXML
    private TableColumn<Animal, Double> priceCol;

    @FXML
    void onActionDisplayAnimalDetailsMenu(ActionEvent event) throws IOException {

        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view/AnimalDetailsMenu.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();

    }

    @FXML
    void onActionDisplayMainMenu(ActionEvent event) throws IOException {

        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view/MainMenu.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();

    }

    public boolean search(int id) {

        for(Animal dog : DataProvider.getAllAnimals()) {
            if (dog.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public boolean update(int id, Animal animal) {

        int index = -1;

        for(Animal dog : DataProvider.getAllAnimals()) {
            index++;

            if(dog.getId() == id) {
                DataProvider.getAllAnimals().set(index, animal);
                return true;
            }
        }
        return false;
    }

    public boolean delete(int id) {

        for(Animal dog : DataProvider.getAllAnimals()) {
            if(dog.getId() == id) {
                return DataProvider.getAllAnimals().remove(dog);
            }
        }
        return false;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Set table view
        animalTableView.setItems(DataProvider.getAllAnimals());

        // Fill column with values
        animalIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        breedCol.setCellValueFactory(new PropertyValueFactory<>("breed"));
        lifespanCol.setCellValueFactory(new PropertyValueFactory<>("lifespan"));
        priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));

        /*
        if(search(14)) {
            System.out.println("Match!");
        } else {
            System.out.println("No Match!");
        }


        if(update(66, new Dog(5, "German Shepard", 13, "Alert", 1599.99, true, "Drools"))) {
            System.out.println("Update successful!");
        } else {
            System.out.println("Update failed!");
        }
         */

        if(delete(3)) {
            System.out.println("Delete successful!");
        } else {
            System.out.println("Delete failed!");
        }
    }

}
