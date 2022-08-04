package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DataProvider {

    private static ObservableList<Animal>allAnimals = FXCollections.observableArrayList();

    // Creating an observable list to house our filtered objects
    private static ObservableList<Animal>filteredAnimals = FXCollections.observableArrayList();
    public static void addAnimal(Animal animal) {
        allAnimals.add(animal);
    }

    public static ObservableList<Animal> getAllAnimals() {
        return allAnimals;
    }

    public static ObservableList<Animal> getAllFilteredAnimals() {
        return filteredAnimals;
    }
}
