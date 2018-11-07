package a03;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class AutoCompleteMain {
	public static void main(String[] args) {

		// read in the terms from a file
		String filename = "cities.txt";
		In in = new In(filename);
		int N = in.readInt();
		Term[] terms = new Term[N];
		for (int i = 0; i < N; i++) {
			double weight = in.readDouble(); // read the next weight
			in.readChar(); // scan past the tab
			String query = in.readLine(); // read the next query
			terms[i] = new Term(query, weight); // construct the term
		}

//		Arrays.sort(terms);

		// read in queries from standard input and print out the top k matching
		// terms
		int k = 10;
		Autocomplete autocomplete = new Autocomplete(terms);
		String prefix = "salt lake city";
		Term[] results = autocomplete.allMatches(prefix);
		if (results != null) {
			for (int i = 0; i < Math.min(k, results.length); i++)
				StdOut.println(results[i]);
		} else {
			System.out.println("No matches found");
		}
		System.out.println(autocomplete.numberOfMatches(prefix));
	}
}