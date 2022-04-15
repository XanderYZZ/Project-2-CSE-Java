//**************************************************************************************************
// CLASS: Sorter
//
// DESCRIPTION
// Implements the insertion sort algorithm to sort an ArrayList<> of Students.
//
// AUTHOR
// Kevin R. Burger (burgerk@asu.edu)
// Computer Science & Engineering Program
// Fulton Schools of Engineering
// Arizona State University, Tempe, AZ 85287-8809
//**************************************************************************************************

/*************************************************************************************************
 * CLASS: Sorter (Sorter.java)
 *
 * DESCRIPTION
 * This is the Sorter class. We call this for the insertion sort in the main file.
 *
 * COURSE AND PROJECT INFORMATION
 * CSE205 Object Oriented Programming and Data Structures, Spring 2022
 * Project Number: Project #2
 *
 * AUTHOR: Xander Arnspiger, xarnspig, xarnspig@asu.edu, ASU ID: 1220789908 **
 ******************************************************************************************************/

import java.util.ArrayList;

public class Sorter {

    // Pass one of these constants to insertionSort() to specify an ascending or descending sort.
    public static final int SORT_ASCENDING  = 0;
    public static final int SORT_DESCENDING = 1;

    /**
     * Sorts pList into ascending (pOrder = SORT_ASCENDING) or descending (pOrder =
     * SORT_DESCENDING) order using the insertion sort algorithm.
     */
    public static void insertionSort(ArrayList<Student> pList, int pOrder) {
        for (int i = 1; i < pList.size(); ++i) {
            for (int j = i; keepMoving(pList, j, pOrder); --j) {
                swap(pList, j, j - 1);
            }
        }
    }

    /**
     * Returns true if we need to continue moving the element at pIndex until it reaches its
     * proper location.
     *
     * This method uses the ternary operator ?: which has this syntax:
     *
     *     (conditional-expression) ? true-expression : false-expression
     *
     * The behavior is that the conditional-expression is evaluated and it will be either true or
     * false. If the conditional-expression is true, then the expression (true-expression) following
     * the ? symbol is evaluated. If the conditional expression is false, then the expression
     * (false-expression) following the : symbol is evaluated. For example:
     *
     *     x = (a < b) ? 1 : 0;
     *
     * would compare a to see if it is less than b. If a < b is true, then 1 is assigned to x. If
     * a < b is false, then 0 would be assigned to x. Note that the ternary operator is just a
     * shorter way to write an if-else statement. The statement above could have been written as:
     *
     *     if (a < b) {
     *         x = 1;
     *     } else {
     *         x = 0;
     *     }
     *
     * Whether you prefer to write such code using an if-else statement or using the ternary
     * operator is a personal choice, but you will see other programmers using the ternary operator
     * so you should know how it works.
     */
    private static boolean keepMoving(ArrayList<Student> pList, int pIndex, int pOrder) {
        if (pIndex < 1) return false;
        Student after = pList.get(pIndex);
        Student before = pList.get(pIndex - 1);
        return (pOrder == SORT_ASCENDING) 
            ? after.compareTo(before) < 0 
            : after.compareTo(before) > 0;
    }

    /**
     *  Swaps the elements in pList at pIndex1 and pIndex2.
     */
    private static void swap(ArrayList<Student> pList, int pIndex1, int pIndex2) {
        Student temp = pList.get(pIndex1);
        pList.set(pIndex1, pList.get(pIndex2));
        pList.set(pIndex2, temp);
    }

}
