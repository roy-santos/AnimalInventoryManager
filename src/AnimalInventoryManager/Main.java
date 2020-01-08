package AnimalInventoryManager;

import Model.DataProvider;
import Model.Dog;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../View/MainMenu.fxml"));
        primaryStage.setTitle("Animal Inventory Manager");
        primaryStage.setScene(new Scene(root, 320, 200));
        primaryStage.show();
    }


    public static void main(String[] args) {

        Dog dog1 = new Dog(1, "Siberian Husky", 15, "Crafty", 599.99, true, "Howls");
        Dog dog2 = new Dog(2, "Alaskan Malamute", 12, "Energetic", 999.99, true, "Climbs");
        Dog dog3 = new Dog(3, "Dalmatian A", 13, "Energetic", 1999.99, false, "Gymnast");
        Dog dog4 = new Dog(4, "Anatolian Shepard", 16, "Protective", 1599.99, false, "Whistles");
        Dog dog5 = new Dog(5, "English Bulldog", 12, "Lazy", 899.99, true, "Drools");

        DataProvider.addAnimal(dog1);
        DataProvider.addAnimal(dog2);
        DataProvider.addAnimal(dog3);
        DataProvider.addAnimal(dog4);
        DataProvider.addAnimal(dog5);

        launch(args);
    }
}
