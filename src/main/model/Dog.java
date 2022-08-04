package model;

public class Dog extends Animal{

    private String special;

    public Dog(int id, int lifespan, String breed, String behavior, double price, boolean vaccinated, String special) {
        super(id, lifespan, breed, behavior, price, vaccinated);
        this.special = special;
    }

    public String getSpecial() {
        return special;
    }

    public void setSpecial(String special) {
        this.special = special;
    }
}
