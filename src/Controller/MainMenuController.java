package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class MainMenuController {

    @FXML
    void onActionCreateAnimal(ActionEvent event) {

        System.out.println("Create Button clicked!");
    }

    @FXML
    void onActionDisplayAnimals(ActionEvent event) {

        System.out.println("Display Button clicked!");

    }

    @FXML
    void onActionExit(ActionEvent event) {

        System.out.println("Exit Button clicked!");

    }

}
