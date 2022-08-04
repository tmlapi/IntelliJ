package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import model.Animal;
import model.Dog;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AnimalDetailsController implements Initializable {

    Stage stage;
    Parent scene;
    @FXML
    private Label animalBehaviorLbl;

    @FXML
    private Label animalBreedLbl;

    @FXML
    private Label animalIDLbl;

    @FXML
    private Label animalLifespanLbl;

    @FXML
    private Label animalPriceLbl;

    @FXML
    private Label animalSpecialLbl;

    @FXML
    private Label animalVacLbl;

    @FXML
    void onActionBackToMain(ActionEvent event) throws IOException {
        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/Views/DisplayAnimalsMenu.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    public void sendAnimal(Animal dog) {
        animalIDLbl.setText(String.valueOf(dog.getId()));
        animalBreedLbl.setText(dog.getBreed());
        animalLifespanLbl.setText(String.valueOf(dog.getLifespan()));
        animalBehaviorLbl.setText(dog.getBehavior());
        animalPriceLbl.setText(String.valueOf(dog.getPrice()));
        if (dog.isVaccinated()) {
            animalVacLbl.setText("Yes");
        } else {
            animalVacLbl.setText("No");
        }
        // Hard time casting because i didn't use parenthesis correctly. ((Dog) dog).getSpecial()) needs to go inside
        //of .setText()
        if(dog instanceof Dog) {
            animalSpecialLbl.setText(((Dog) dog).getSpecial());
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}