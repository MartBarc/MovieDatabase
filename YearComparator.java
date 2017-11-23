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
 *  This year comparator implements comparator. This comparator takes two 
 * movie objects and returns 0 if the two movie year are the same, 1 if the
 * leading movie input is greater than the latter movie, and -1 if the latter
 * movie's year is greater than the leading one.
 * ----------------------------------------------------------------------------
 */

import java.util.Comparator;

public class YearComparator implements Comparator<Movie> {

    public int compare(Movie input_1, Movie input_2) {
        Movie e1 = (Movie) input_1;
        Movie e2 = (Movie) input_2;
        if (e1.getYear() == e2.getYear()) {
            return 0;
        } else if (e1.getYear() > e2.getYear()) {
            return 1;
        } else {
            return -1;
        }
    }
}
