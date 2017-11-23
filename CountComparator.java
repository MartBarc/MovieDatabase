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
 *  This CountComparator class implements comparator. This class sorts the 
 * number of appearances of the actor objects. So if the leading actor has
 * more appearances than the latter, the class returns 1. If the latter is
 * greater than the leading input then it returns -1. And it returns 0 if
 * both actors have the same number of appearances. 
 * ----------------------------------------------------------------------------
 */

import java.util.Comparator;

public class CountComparator implements Comparator<Actor> {

    public int compare(Actor input_1, Actor input_2) {
        Actor e1 = (Actor) input_1;
        Actor e2 = (Actor) input_2;
        if (e1.getCount() == e2.getCount()) {
            return 0;
        } else if (e1.getCount() > e2.getCount()) {
            return 1;
        } else {
            return -1;
        }
    }
}
