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
 *  This NameComparator implements comparator. This sorts the names of two
 * actors based on alphabetical order.
 * ----------------------------------------------------------------------------
 */

import java.util.Comparator;

public class NameComparator implements Comparator<Actor> {

    public int compare(Actor input_1, Actor input_2) {
        Actor e1 = (Actor) input_1;
        Actor e2 = (Actor) input_2;
        return (e1.getName().compareTo(e2.getName()));
    }
}
