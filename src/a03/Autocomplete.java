package a03;

import java.util.Arrays;
import edu.princeton.cs.algs4.Quick3way;

/**
 * @author Jingshi
 * 
 * Implements an immutable data type that provides autocomplete functionality
 * uses a set of strings and weights using Term and BinarySearchDeluxe classes.
 * First, sorts terms in lexicographic order with a binary search of a set of terms from a given prefix
 * then sorts those terms in descending order by weight
 */
public class Autocomplete {
	private final Term[] terms;

    // Initializes the data structure from the given array of terms.
    public Autocomplete(Term[] theseTerms) { 
    	Quick3way.sort(theseTerms);
    	terms = theseTerms; 
    }

    // Returns all terms that start with the given prefix, in descending order of weight.
    public Term[] allMatches(String prefix) {
    	int firstIndex = getFirstIndex(prefix);
    	if (firstIndex == -1) { return new Term[0]; }
    	int lastIndex = getLastIndex(prefix);
    	Term[] returnTerms = new Term[numberOfMatches(firstIndex,lastIndex)];
    	for (int i = 0; i < returnTerms.length; i++) { returnTerms[i] = terms[i + firstIndex]; }
    	Arrays.sort(returnTerms, Term.byReverseWeightOrder());
    	return returnTerms;
    }

    
    // Returns the number of terms that start with the given prefix
    public int numberOfMatches(String prefix) {
    	int firstIndex = getFirstIndex(prefix);
    	if (firstIndex == -1) { return 0; }
    	int lastIndex = getLastIndex(prefix);
    	return numberOfMatches(firstIndex,lastIndex);
    }
    
    /*
     * -----------------------------------Helper Methods-----------------------------------------------
     */
    // Returns the first index that matches the prefix
    private int getFirstIndex(String prefix) { return BinarySearchDeluxe.<Term>firstIndexOf(terms, new Term(prefix,0), Term.byPrefixOrder(prefix.length())); }
    // Returns the last index that matches the prefix
    private int getLastIndex(String prefix) { return BinarySearchDeluxe.<Term>lastIndexOf(terms, new Term(prefix,0), Term.byPrefixOrder(prefix.length())); }
    // Returns the size matching the given prefix
    private int numberOfMatches(int firstIndex, int lastIndex) { return lastIndex - firstIndex + 1; }

}