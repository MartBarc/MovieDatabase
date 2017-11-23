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
 *   This TitleComparator implements comparator. This sorts the titles of two
 * movies based on alphabetical order.
 * ----------------------------------------------------------------------------
 */

import java.util.Comparator;

public class TitleComparator implements Comparator<Movie> {

    public int compare(Movie input_1, Movie input_2) {
        Movie e1 = (Movie) input_1;
        Movie e2 = (Movie) input_2;
        return (e1.getTitle().compareTo(e2.getTitle()));
    }
}
