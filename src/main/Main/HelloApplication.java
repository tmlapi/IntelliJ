package Main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.DataProvider;
import model.Dog;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/Views/MainMenu.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {

        Dog dog1 = new Dog(1, 15, "Husky", "Laughy", 1030.5, true, "6 Legs");
        Dog dog2 = new Dog(2, 10, "German Shep", "Hyper", 689.9, true, "Swims");
        Dog dog3 = new Dog(3, 8, "Lab", "Loyal", 999.6, true, "Ball Lover");
        Dog dog4 = new Dog(4, 10, "Lil' Rottie", "Protective", 789.9, true, "Gang Member");
        Dog dog5 = new Dog(5, 7, "Poodle", "Annoying", 15.5, true, "Shops");

        DataProvider.addAnimal(dog1);
        DataProvider.addAnimal(dog2);
        DataProvider.addAnimal(dog3);
        DataProvider.addAnimal(dog4);
        DataProvider.addAnimal(dog5);

        launch(args);
    }
}