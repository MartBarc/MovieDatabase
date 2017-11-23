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
 *   This movie object stores a title, year and a ArrayList of actor objects. 
 * Two constructor classes are given, one takes a string and integer and sets
 * the title and year of the movie. The other takes a url of a html database of
 * movies and based on the title, adds all the relevant information of title,
 * year, and actors. Set/get methods for title,year and actors are given as 
 * well; along with a print all actors method is given.
 * ----------------------------------------------------------------------------
 */

import big.data.DataSource;
import java.util.*;

public class Movie {

    private String title;
    private int year;
    private ArrayList<Actor> actors;

    public Movie(String title, int year) {
        this.title = title;
        this.year = year;
        actors = new ArrayList<Actor>();
    }

    public Movie(String url, String titleInput) throws Exception {
        actors = new ArrayList<Actor>();
        if (titleInput.length() > 0) {
            DataSource ds = DataSource.connectXML(url);
            ds.load();
            title = ds.fetchString("movie/title");
            year = ds.fetchInt("movie/year");
            List<String> list = Arrays.asList(
                    (ds.fetchString("movie/actors")).split(", "));
            for (int i = 0; i < list.size(); i++) {
                Actor temp = new Actor(list.get(i));
                actors.add(temp);
            }
        }
        System.out.println("Done!");
    }

    public void setTitle(String input) {
        title = input;
    }

    public String getTitle() {
        return title;
    }

    public void setYear(int input) {
        year = input;
    }

    public int getYear() {
        return year;
    }

    public void setActors(ArrayList<Actor> input) {
        actors = input;
    }

    public ArrayList<Actor> getActors() {
        return actors;
    }

    public String printActors() {
        String temp = "";
        for (int i = 0; i < actors.size(); i++) {
            temp += actors.get(i).getName() + "/";
        }
        return temp;
    }

}
