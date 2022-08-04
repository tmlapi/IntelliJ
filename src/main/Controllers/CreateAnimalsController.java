package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.DataProvider;
import model.Dog;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class CreateAnimalsController implements Initializable {

    Stage stage;
    Parent scene;

    @FXML
    private TextField animalBehaviorTxt;

    @FXML
    private TextField animalBreedTxt;

    @FXML
    private TextField animalIDTxt;

    @FXML
    private TextField animalLifespanTxt;

    @FXML
    private TextField animalPriceTxt;

    @FXML
    private RadioButton vacYesBtn;

    @FXML
    private RadioButton vanNoBtn;

    @FXML
    void onActionBackToMain(ActionEvent event) throws IOException {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "All data will be forgotten, do you wish to continue?");

        Optional<ButtonType> result = alert.showAndWait();
        // isPresent() checks to see if a button was clicked. The Optional object records button that was clicked
        if (result.isPresent() && result.get() == ButtonType.OK) {

            stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
            scene = FXMLLoader.load(getClass().getResource("/Views/MainMenu.fxml"));
            stage.setScene(new Scene(scene));
            stage.show();
        }

    }

    @FXML
    void onActionSaveAnimal(ActionEvent event) throws IOException {

        try {

            int id = Integer.parseInt(animalIDTxt.getText());
            String breed = animalBreedTxt.getText();
            int lifespan = Integer.parseInt(animalLifespanTxt.getText());
            String behavior = animalBehaviorTxt.getText();
            double price = Double.parseDouble(animalPriceTxt.getText());
            boolean vaccinated;
            String special = null;

            if (vacYesBtn.isSelected())
                vaccinated = true;
            else
                vaccinated = false;

            DataProvider.addAnimal(new Dog(id, lifespan, breed, behavior, price, vaccinated, special));

            stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
            scene = FXMLLoader.load(getClass().getResource("/Views/MainMenu.fxml"));
            stage.setScene(new Scene(scene));
            stage.show();

        } catch (NumberFormatException e) {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error WILL ROBINSON");
            alert.setContentText("Please enter valid value for each text field!");
            alert.showAndWait();
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}