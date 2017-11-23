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
 *   This Actor object class holds the data for the name and number of 
 * appearances of said actor. The constructor class sets the name of the actor
 * and sets the count (of appearances) to 1. A get method for name is given.To
 * change the count a add count method increases the count by one and a remove
 * count method decreases the count by one. A get count method is included as 
 * well. 
 * ----------------------------------------------------------------------------
 */

public class Actor {

    private String name;
    private int count;

    public Actor(String name) {
        this.name = name;
        this.count = 1;
    }

    public String getName() {
        return name;
    }

    public void addCount() {
        count++;
    }

    public void removeCount() {
        count--;
    }

    public int getCount() {
        return count;
    }
}
