/**
 * -------------------------------------Info-----------------------------------
 *	Name:			Date:			Current Version:
 *	Martin Barcelon		12-04-2016		1.0
 *
 *	Email:
 *	martin.barcelon@stonybrook.edu
 *
 *	Student ID:
 *	110250249	
 */
/**
 * -------------------------------Short Description----------------------------
 *   MovieManager holds an ArrayList of movie objects and actor objects. Also,
 * this class holds methods that adds a movie object to the ArrayList, add 
 * several actors from their respective movie to the ArrayList of actors, 
 * remove a movie from the ArrayList, and removes the movie's actors from the 
 * ArrayList. Print all movies and actors methods are given. Methods for 
 * getting the ArrayList are given. Sorting methods allow both ArrayLists 
 * to be sorted by taking a specific Comparator class. Note that moviesIndex 
 * and actorsIndex are used for testing purposes.
 * ----------------------------------------------------------------------------
 */

import java.util.*;

public class MovieManager {

    private ArrayList<Movie> movies;
    private ArrayList<Actor> actors;
    int moviesIndex;
    int actorsIndex;

    public MovieManager() {
        movies = new ArrayList<Movie>();
        actors = new ArrayList<Actor>();
        moviesIndex = 0;
        actorsIndex = 0;
    }

    public void addMovie(Movie input) {
        movies.add(input);
        moviesIndex++;
    }

    public void addActor(Actor input) {
        actors.add(input);
        actorsIndex++;
    }

    public void addAllActors(Movie input) {
        ArrayList<Actor> tempActors = input.getActors();
        if (actors.isEmpty()) {
            actors.addAll(input.getActors());
        } else {
            for (int j = 0; j < actors.size(); j++) {
                for (int i = 0; i < tempActors.size(); i++) {
                    if (tempActors.get(i).getName().equalsIgnoreCase
        (actors.get(j).getName())) {
                        actors.get(j).addCount();
                        tempActors.remove(tempActors.get(i));
                    }
                }
            }
            actors.addAll(tempActors);
        }
    }

    public void removeAllActors(Movie input) {
        ArrayList<Actor> tempActors = input.getActors();
        for (int j = 0; j < actors.size(); j++) {
            for (int i = 0; i < tempActors.size(); i++) {
                if (tempActors.get(i).getName().equalsIgnoreCase
        (actors.get(j).getName())) {
                    if (actors.get(j).getCount() > 1) {
                        actors.get(j).removeCount();
                    } else {
                        actors.remove(actors.get(j));
                    }
                }
            }
        }
    }

    public void removeMovie(Movie input) {
        Iterator<Movie> iterator = movies.iterator();
        while (iterator.hasNext()) {
            Movie temp = iterator.next();
            if (temp.getTitle().equals(input.getTitle())) {
                iterator.remove();
            }
        }
        moviesIndex--;
    }

    public void removeActor(Actor input) {
        actors.remove(input);
        actorsIndex--;
    }

    public void printMovies() {
        System.out.format("%-35s%-6s%-22s", "Title", "Year", "Actor(s)");
        System.out.println();
        for (int i = 0; i < movies.size(); i++) {
            System.out.format("%-35s%-6s%-22s", movies.get(i).getTitle(),
                    movies.get(i).getYear(),
                    movies.get(i).printActors());
            System.out.println();
        }
    }

    public void printActors() {
        System.out.format("%-20s%-20s", "Actor(s)", "Appearance(s)");
        System.out.println();
        for (int i = 0; i < actors.size(); i++) {
            System.out.format("%-20s%-20s", actors.get(i).getName(),
                    actors.get(i).getCount());
            System.out.println();
        }
    }

    public ArrayList<Movie> getMovies() {
        return movies;
    }

    public ArrayList<Actor> getActors() {
        return actors;
    }

    public ArrayList<Movie> getSortedMovies(Comparator comp) {
        ArrayList<Movie> temp = movies;
        Collections.sort(temp, comp);
        return temp;
    }

    public ArrayList<Actor> getSortedActors(Comparator comp) {
        ArrayList<Actor> temp = actors;
        Collections.sort(temp, comp);
        return temp;
    }

}
