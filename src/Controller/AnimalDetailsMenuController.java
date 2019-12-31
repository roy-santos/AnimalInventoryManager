package Controller;

import Model.Animal;
import Model.Dog;
import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AnimalDetailsMenuController implements Initializable {

    Stage stage;
    Parent scene;

    @FXML
    private Label lifespanLbl;

    @FXML
    private Label animalIdLbl;

    @FXML
    private Label breedLbl;

    @FXML
    private Label behaviorLbl;

    @FXML
    private Label priceLbl;

    @FXML
    private Label vaccLbl;

    @FXML
    private Label specialLbl;

    @FXML
    void onActionDisplayMainMenu(ActionEvent event) throws IOException {

        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view/DisplayAnimalsMenu.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();

    }

    public void sendAnimal(Animal animal) {

        animalIdLbl.setText(String.valueOf(animal.getId()));
        breedLbl.setText(animal.getBreed());
        lifespanLbl.setText(String.valueOf(animal.getLifespan()));
        behaviorLbl.setText(animal.getBehavior());
        priceLbl.setText(String.valueOf(animal.getPrice()));

        if(animal.isVaccinated()) {
            vaccLbl.setText("Yes");
        } else {
            vaccLbl.setText("No");
        }

        if(animal instanceof Dog) {
            specialLbl.setText(((Dog) animal).getSpecial());
        }


    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}
