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
 *   ASMDB is the driver class that allows the user to interact with the Movie
 * database from the MovieManager class. This database is an ArrayList of movie
 * objects and an ArrayList of actor objects. Each of these ArrayList can be
 * sorted by alphabetical order, by year(movie), and by number of appearances of
 * selected movies(actor). The added movies are pulled from the html website
 * "www.omdbapi.com". The menu consists of this user interface:
 * I - Import Movie <Title>
 * D - Delete Movie <Title>
 * M - Sort Movies
 *  By Title Ascending (TA)
 *  By Title Descending (TD)
 *  By Release Date Ascending (YA)
 *  By Release Date Descending (YD)
 * A - Sort Actors
 *  Alphabetically Ascending (AA)
 *  Alphabetically Descending (AD)
 *  By Number of Movies They Are In Ascending (NA)
 *  By Number of Movies They Are In (ND)
 * ----------------------------------------------------------------------------
 */
import java.util.Scanner;
import java.util.Collections;

public class ASMDB {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        MovieManager MovieList = new MovieManager();

        System.out.println("Welcome to ASMDB!");

        boolean quit = false;
        do {
            System.out.println();
            MovieList.printMovies();
            System.out.println();
            MovieList.printActors();
            System.out.println();
            System.out.println("Main Menu:");
            System.out.println("\tI) Import a Movie");
            System.out.println("\tD) Delete a Movie");
            System.out.println("\tA) Sort Actors");
            System.out.println("\tM) Sort Movies");
            System.out.println("\tQ) Quit");

            String input = "";
            System.out.print("Please select an option: ");
            input = scan.nextLine();

            switch (input.toUpperCase()) {
                case "I":
                    Movie addedMovie_I;
                    String title_I = "";
                    System.out.print("Enter the movie title: ");
                    title_I = scan.nextLine();
                    String url_I = "http://www.omdbapi.com/?t="
                            + title_I.replace(' ', '+')
                            + "&y=&plot=short&r=xml";
                    try {
                        addedMovie_I = new Movie(url_I, title_I);
                    } catch (Exception e) {
                        System.out.println("ERROR: Movie not found");
                        break;
                    }
                    MovieList.addMovie(addedMovie_I);
                    MovieList.addAllActors(addedMovie_I);
                    break;
                case "D":
                    Movie addedMovie_D;
                    String title_D = "";
                    System.out.print("Enter the movie title: ");
                    title_D = scan.nextLine();
                    String url_D = "http://www.omdbapi.com/?t="
                            + title_D.replace(' ', '+')
                            + "&y=&plot=short&r=xml";
                    try {
                        addedMovie_D = new Movie(url_D, title_D);
                    } catch (Exception e) {
                        System.out.println("ERROR: Movie not found");
                        break;
                    }
                    MovieList.removeMovie(addedMovie_D);
                    MovieList.removeAllActors(addedMovie_D);
                    break;
                case "A":
                    System.out.println("Main Menu:");
                    System.out.println("\tAA) Alphabetically Ascending");
                    System.out.println("\tAD) Alphabetically Descending");
                    System.out.println("\tNA) By Number of Movies They Are "
                            + "In Ascending");
                    System.out.println("\tND) By Number of Movies They Are "
                            + "In");

                    String input_A = "";
                    System.out.print("Please select an option: ");
                    input_A = scan.nextLine();

                    switch (input_A.toUpperCase()) {
                        case "AA":
                            NameComparator comp_AA = new NameComparator();
                            MovieList.getSortedActors(comp_AA);
                            break;
                        case "AD":
                            NameComparator comp_AD = new NameComparator();
                            MovieList.getSortedActors(comp_AD);
                            Collections.reverse(MovieList.getActors());
                            break;
                        case "NA":
                            CountComparator comp_NA = new CountComparator();
                            MovieList.getSortedActors(comp_NA);
                            break;
                        case "ND":
                            CountComparator comp_ND = new CountComparator();
                            MovieList.getSortedActors(comp_ND);
                            Collections.reverse(MovieList.getActors());
                            break;
                        default:
                            System.out.println("Error: invalid input.");
                            break;
                    }
                    break;
                case "M":

                    System.out.println("Movie Sorting Options:");
                    System.out.println("\tTA) Title Ascending (A-Z)");
                    System.out.println("\tTD) Title Descending (Z-A)");
                    System.out.println("\tYA) Year Ascending");
                    System.out.println("\tYD) Year Descending");

                    String input_M = "";
                    System.out.print("Please select an option: ");
                    input_M = scan.nextLine();

                    switch (input_M.toUpperCase()) {
                        case "TA":
                            TitleComparator comp_TA = new TitleComparator();
                            MovieList.getSortedMovies(comp_TA);
                            break;
                        case "TD":
                            TitleComparator comp_TD = new TitleComparator();
                            MovieList.getSortedMovies(comp_TD);
                            Collections.reverse(MovieList.getMovies());
                            break;
                        case "YA":
                            YearComparator comp_YA = new YearComparator();
                            MovieList.getSortedMovies(comp_YA);
                            break;
                        case "YD":
                            YearComparator comp_YD = new YearComparator();
                            MovieList.getSortedMovies(comp_YD);
                            Collections.reverse(MovieList.getMovies());
                            break;
                        default:
                            System.out.println("Error: invalid input.");
                            break;
                    }
                    break;
                case "Q":
                    System.out.println("Quiting program.");
                    quit = true;
                    break;
                default:
                    System.out.println("Input not recognized.");
                    quit = false;
            }
        } while (quit == false);
    }
}
