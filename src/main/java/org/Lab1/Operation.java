package org.Lab1;

import java.util.Objects;
import java.util.Scanner;

public class Operation {
    public static void movieListViewer(Movie[] moviesList, Scanner sc) {
        if (moviesList.length == 0) {
            System.out.println("No movies to display.");
        } else {
            System.out.println("\nMovies and Ratings:");
            for (Movie m : moviesList) {
                System.out.println(m.toString());
            }
        }
    }
    public static Movie[] movieAdder(Movie[] moviesList, Scanner sc) {
        System.out.println("Enter movie:");
        String nameOfMovie = sc.nextLine();
        System.out.println("Enter rating:");
        double ratingOfMovie = sc.nextDouble();
        sc.nextLine(); // Consume leftover newline


        Movie[] newArray = new Movie[moviesList.length + 1];
        System.arraycopy(moviesList, 0, newArray, 0, moviesList.length);
        newArray[moviesList.length] = new Movie(nameOfMovie, ratingOfMovie);
        return newArray;

    }
    public static Movie[] sortMovies(Movie[] moviesList) {
        int n = moviesList.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                // Compare ratings for ascending order
                if (moviesList[j].getRating() > moviesList[j + 1].getRating()) {

                    // Swap movies
                    Movie temp = moviesList[j];
                    moviesList[j] = moviesList[j + 1];
                    moviesList[j + 1] = temp;
                }
            }
        }

        return moviesList;
    }
    public static int findMovie(Scanner sc,Movie[] moviesList) {
        int filmIndex = 0;
        System.out.println("Enter movie Name");
        String movieName = sc.nextLine();
        boolean findMovie = false;
        for (int z = 0; z < moviesList.length; z++) {
            filmIndex = z;
            if (Objects.equals(moviesList[z].getName(), movieName)) {
                findMovie = true;
                break;
            }
        }
        if (findMovie) {

            return filmIndex;

        }else {return -1;}


    };

    public static void main(String[] args) {
        int findResult;
        Movie[] moviesList = new Movie[0];
        Scanner sc = new Scanner(System.in);
        int userSelect = 0;

        while (true) {

            System.out.println("Press 1 to input movies");
            System.out.println("Press 2 to display movies and ratings");
            System.out.println("Press 3 to input more movies.");
            System.out.println("Press 4 to find statistics.");
            System.out.println("Press 5 to search movie.");
            System.out.println("Press 6 to update movie rating ");
            System.out.println("Press 7 to delete movie.");
            System.out.println("Press 8 to sort movie list.");
            System.out.println("Press 0 to exit.");
            userSelect = sc.nextInt();
            sc.nextLine(); // Consume leftover newline

            switch (userSelect) {
                case 1:
                    moviesList = movieAdder(moviesList, sc);
                    break;

                case 2:
                    movieListViewer(moviesList, sc);
                    break;
                case 3:
                    System.out.println("How many additional movies you want to add?:");
                    int moiveCount = sc.nextInt();
                    sc.nextLine();

                    for (int i = 0; i < moiveCount; i++) {
                        moviesList = movieAdder(moviesList, sc);
                    }
                    break;

                case 4:
                    int maxRatingIndex = 0;
                    double maxRating = moviesList[0].getRating();
                    double minRating = moviesList[0].getRating();
                    int minRatingIndex = 0;
                    double avarageRating = 0;
                    double avarageSum = 0;
                    for (int k = 0; k < moviesList.length; k++) {
                        double currentRating = moviesList[k].getRating();
                        avarageSum += currentRating;
                        if (currentRating > maxRating) {
                            maxRating = currentRating;
                            maxRatingIndex = k;
                        }
                        if (currentRating < minRating) {
                            minRating = currentRating;
                            minRatingIndex = k;
                        }
                    }
                    avarageRating = avarageSum / moviesList.length;
                    System.out.println("Min rating: " + moviesList[minRatingIndex]);
                    System.out.println("Max rating: " + moviesList[maxRatingIndex]);
                    System.out.println("Avarage Rating " + avarageRating);
                    break;

                case 5:
                    findResult = findMovie(sc,moviesList);
                    if (findResult!=-1){
                        System.out.println(moviesList[findResult].toString());
                    }else {
                        System.out.println("Film not found!");
                    }
                    break;
                case 6:
                    findResult = findMovie(sc,moviesList);
                    if (findResult!=-1){
                        System.out.println(moviesList[findResult].toString());
                        System.out.println("Enter new rating for"+moviesList[findResult].getName());
                        double newRatingPoint= sc.nextDouble();
                        moviesList[findResult].setRating(newRatingPoint);
                    }else {
                        System.out.println("Film not found!");
                    }
                    break;
                case 7:
                    findResult = findMovie(sc, moviesList); // Find the index of the movie to delete
                    if (findResult == -1) {
                        System.out.println("Movie not found!");
                        break;
                    }

                    Movie[] newMoviesList = new Movie[moviesList.length - 1];
                    for (int i = 0, j = 0; i < moviesList.length; i++) {
                        // Skip the element at the findResult index
                        if (i != findResult) {
                            newMoviesList[j++] = moviesList[i];
                        }
                    }

                    moviesList = newMoviesList; // Update the moviesList to the new array
                    System.out.println("Movie Deleted:");
                    break;
                case 8:
                    if (moviesList.length == 0) {
                        System.out.println("No movies to sort.");
                    } else {
                        moviesList = sortMovies(moviesList);  // Sort in ascending order

                        System.out.println("Movies sorted by rating (Ascending):");
                        movieListViewer(moviesList,sc);
                    }
                    break;
                case 0:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid selection, please try again.");
            }
        }
    }
}
