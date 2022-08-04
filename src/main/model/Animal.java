package model;

public abstract class Animal {

    private int id, lifespan;
    private String breed, behavior;
    private double price;
    private boolean vaccinated;

    public Animal(int id, int lifespan, String breed, String behavior, double price, boolean vaccinated) {
        this.id = id;
        this.lifespan = lifespan;
        this.breed = breed;
        this.behavior = behavior;
        this.price = price;
        this.vaccinated = vaccinated;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLifespan() {
        return lifespan;
    }

    public void setLifespan(int lifespan) {
        this.lifespan = lifespan;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getBehavior() {
        return behavior;
    }

    public void setBehavior(String behavior) {
        this.behavior = behavior;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isVaccinated() {
        return vaccinated;
    }

    public void setVaccinated(boolean vaccinated) {
        this.vaccinated = vaccinated;
    }
}
