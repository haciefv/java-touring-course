//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.Lab1;

public class Movie {
    private String name;
    private double rating;

    public Movie(String name, double rating) {
        this.name = name;
        this.rating = rating;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRating() {
        return this.rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String toString() {
        return "Movie{name='" + this.name + "', rating=" + this.rating + "}";
    }
}
