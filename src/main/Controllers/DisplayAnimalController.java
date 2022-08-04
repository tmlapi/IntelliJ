package Controllers;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Animal;
import model.DataProvider;
import model.Dog;

import java.io.IOException;
import java.net.URL;
import java.util.EventObject;
import java.util.ResourceBundle;

public class DisplayAnimalController implements Initializable {

    Stage stage;
    Parent scene;
    @FXML
    private TableColumn<Animal, String> animalBreedCol;

    @FXML
    private TableColumn<Animal, Integer> animalIDCol;

    @FXML
    private TableColumn<Animal, Integer> animalLifespanCol;

    @FXML
    private TableColumn<Animal, Double> animalPriceCol;

    @FXML
    private TableView<Animal> animalTableView;

    public void onActionDisplayAnimalDetails(ActionEvent actionEvent) throws IOException {
       FXMLLoader loader = new FXMLLoader();
       loader.setLocation(getClass().getResource("/Views/AnimalDetails.fxml"));
       loader.load();

        // So, from my understanding, we created a new loader. We told that loader what view we were interested in.
        // we then made an instance of AnimalDetailsController 'ADMController', and had it load the controller associated
        //weith AnimalDetails so we could use the ADMController to access and call any public methods within the
        //AnimalDetailsController file
       AnimalDetailsController ADMController = loader.getController();
       ADMController.sendAnimal(animalTableView.getSelectionModel().getSelectedItem());

        stage = (Stage) ((Button)actionEvent.getSource()).getScene().getWindow();
        Parent scene = loader.getRoot();
        stage.setScene(new Scene(scene));
        stage.show();
        /*// when show() is called, any code after it is immediatley run. showAndWait delays the code form running until
        //switch back or close the window
        stage.showAndWait();*/
    }

    public void onActionBackToMainMenu(ActionEvent event) throws IOException {
        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/Views/MainMenu.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    // This uses enhanced for loop. Essentially you're accessing an array (allAnimals) using the getter. This tells the
    //program how many elements are in the array. The left part of it essentially tells the system that we are looking for
    //dog objects in the animal class
    public boolean search (int id) {
        for (Animal dog : DataProvider.getAllAnimals()) {
            if (dog.getId() == id) {
                return true;
            }
        }
        return false;
    }


    public boolean update(int id, Animal animal) {
        int index = -1;

        for (Animal dog : DataProvider.getAllAnimals()) {
            index ++;
            if (dog.getId() == id) {
                DataProvider.getAllAnimals().set(index, animal);
                return true;
            }
        }
        return false;
    }

    public boolean delete (int id) {
        for (Animal dog : DataProvider.getAllAnimals()) {
            if (dog.getId() == id) {
                return DataProvider.getAllAnimals().remove(dog);
            }
        }
        return false;
    }

    // I used 'fish' here to show that since we are using a local Animal object, we can name it whatever we want
    //for the enhanced for loop as long as the rest of the method uses it too!
    public Animal selectAnimal(int id) {
        for (Animal fish: DataProvider.getAllAnimals()) {
            if (fish.getId() == id) {
                return fish;
            }
        }
        return null;
    }

    public ObservableList<Animal> filter(String breed) {

        // Had to throw this in because it never clears the filters array after hitting back. Now, everytime filer()
        //gets called, it first checks to see if the array is empty or not. If not, it runs the .clear() function
        //to clear it out and then proceeds with the rest of the code
        if(!(DataProvider.getAllFilteredAnimals().isEmpty())) {
            DataProvider.getAllFilteredAnimals().clear();
        }

        for (Animal dog : DataProvider.getAllAnimals()) {
            if (dog.getBreed().contains(breed)) {
                DataProvider.getAllFilteredAnimals().add(dog);
            }
        }
        // Added this conditional because if the filter doesn't return anything, we want to make sure we return the
        //original AllAnimals array
        if (DataProvider.getAllFilteredAnimals().isEmpty()) {
            return DataProvider.getAllAnimals();
        } else {
            return DataProvider.getAllFilteredAnimals();
        }
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //Set observableTable that tableview is going to be working with
        animalTableView.setItems(DataProvider.getAllAnimals());

        /*//Commenting up the above code because it loads the data from AllAnimals when we are trying to show how
        //to filter, which will load from a different table!
        animalTableView.setItems(filter("K"))*/;

        // Set columns. Somehow when passed a string, setCellValueFactory knows to run the getter methods
        animalIDCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        animalBreedCol.setCellValueFactory(new PropertyValueFactory<>("breed"));
        animalLifespanCol.setCellValueFactory(new PropertyValueFactory<>("lifespan"));
        animalPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));


        /*if (search(10))
            System.out.println("Matchy Match!");
        else
            System.out.println("No Matchy Match!");*/

        /*if (update(9, new Dog(5, 7, "Yorkie", "Alert", 1599.99, true, "Shops")))
            System.out.println("Update Successful!");
        else
            System.out.println("Update Failed...");*/

        /*if (delete(30)) {
            System.out.println("Dog deleted!");
        }
        else {
            System.out.println("No Id Matching!");
        }
        */

        /*// animalTableView references the table and since it comes AFTER the above code where the table gets loaded,
        //the below code loads the already filled in table. The getSelectionModel returns the installed selection model.
        // In this case, we use select() to select/highlight a single row of an object that we have told the system is just the one
        // that has an id of 3
        animalTableView.getSelectionModel().select(selectAnimal(3));*/



    }
}