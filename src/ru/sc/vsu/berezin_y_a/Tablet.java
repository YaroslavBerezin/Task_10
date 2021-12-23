package ru.sc.vsu.berezin_y_a;

public class Tablet {

    private final String name;
    private final int memory;
    private final int rating;
    private final int price;

    public Tablet(String name, int memory, int rating, int price) {
        this.name = name;
        this.memory = memory;
        this.rating = rating;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getMemory() {
        return memory;
    }

    public int getRating() {
        return rating;
    }

    public int getPrice() {
        return price;
    }

}
