package a03;

import java.util.Comparator;

/**
 * Assignment: 2420_A03_AUTOCOMPLETE: 
 * This is a functionality where it auto completes the name user is searching for in JTextField.
 * program:    BinarySearchDeluxe
 * Created:    Oct 9, 2017
 * 
 * @author Jingshi
 *
 */
public class BinarySearchDeluxe{
	private final static int KEYNOTFOUND = -1;
	
	// Returns the index of the first key in a[] that equals the search key, or -1 if no such key
	// Tests values using standard binary search except that an upper boundary key will change if the value on that key is equal to the search value
    public static <Key> int firstIndexOf(Key[] a, Key key, Comparator<Key> comparator) {
    	if(a.length == 0) { return KEYNOTFOUND; }
    	int lo = 0;
    	int hi = a.length - 1;
    	while (hi - lo > 1 ) {
    		int mid = lo + (hi - lo) / 2;
    		if (comparator.compare(key, a[mid]) > 0) lo = mid;
    		else hi = mid;
    	}
 
    	if (comparator.compare(key, a[lo]) == 0) return lo;
    	if (comparator.compare(key, a[hi]) == 0) return hi;
    	return KEYNOTFOUND;
    }
    

    // Returns the index of the last key in a[] that equals the search key, or -1 if no such key
	// Tests values using standard binary search except that a lower boundary key will change if the value on that key is equal to the search value
    public static <Key> int lastIndexOf(Key[] a, Key key, Comparator<Key> comparator) {
    	if(a.length == 0) { return KEYNOTFOUND; }
    	int lo = 0;
    	int hi = a.length - 1;
    	while (hi - lo > 1 ) {
    		int mid = lo + (hi - lo) / 2;
    		if (comparator.compare(key, a[mid]) < 0) hi = mid;
    		else lo = mid;
    	}
    	
    	if (comparator.compare(key, a[hi]) == 0) return hi;
    	if (comparator.compare(key, a[lo]) == 0) return lo;
    	return KEYNOTFOUND;
    }   
}
