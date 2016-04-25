import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


/**
 * A class to implement a Polynomial as a list of terms, where each term has
 * an integer coefficient and a nonnegative integer exponent
 * @author your name
 */
public class Polynomial {
	
	// instance variable declarations 
	private ArrayList<Term> polynomial;
	private String funcName;

    /**
	 * Creates a new Polynomial object with no terms
	 */
	public Polynomial(){
		polynomial = new ArrayList<Term>();
	}
	
	
	public void Read(){
		String text = "/src/infile.txt";
		String dir = System.getProperty("user.dir");
		
		File file = new File(dir+text);
		
		try {
			Scanner in = new Scanner(file);
			
			String input = "";
		    String[] i ;
		    
			
			input = in.nextLine();
			i = input.split(";");
			funcName = i[0];
			
			//reads first line and  creates the equation
			for(int j = 1; j < i.length; j+=2 ){
				Insert(Integer.parseInt(i[j]), Integer.parseInt(i[j+1])); 
				Product();
			}
			
			Reverse();
			Product();
			while(in.hasNextLine()){
				input = in.nextLine();
				
			}
			
			in.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	  /**
	    * Inserts a new term into its proper place in a Polynomial
	    * @param x the coefficient of the new term
	    * @param y the exponent of the new term
	    */
	public void Insert(int x, int y){
		System.out.println("Insert function called");
		
		Term temp = new Term(x,y);
		
		polynomial.add(temp);

		for(int i = 0; i < polynomial.size(); i++){
			if(y > polynomial.get(i).getExponent()){
				Collections.swap(polynomial, polynomial.size()-1, i);
			    break;
			}
		}	
	}
	
	 /**
	    * Deletes the first occurrence of a specified term from a Polynomial, or
	    * prints an appropriate message if the term does not appear in the 
	    * Polynomial
	    * @param x the coeffiecent of the term to be deleted
	    * @param y the exponent of the term to be deleted
	    */
	
	public void Delete(int x, int y){
		System.out.println("Delete function called");
		;
		ArrayList<Term> temp = new ArrayList<Term>();
		for(Term t : polynomial){
			if(t.getCoefficient() == x && t.getExponent() == y)
				temp.add(t);
		}
		polynomial.removeAll(temp);		
	}
	
	
	/**
	    * Reverses the order of the terms of a Polynomial.
	    * E.g. the polynomial 3x^2 + 7x^3 + 2x^5 would be 2x^5 + 7x^3 + 3x^2 after
	    * reversal
	    */
	public void Reverse(){
		System.out.println("Reverse function called");
		Collections.reverse(polynomial);
	}
	
	
	/**
	    * Returns a polynomial as a String in this form: 3x^2 + 7x^3 + 2x^5
	    * @return the polynomial as a String
	    */
	
	public void Product(){
		System.out.println("Product function called");
		System.out.print(funcName+ " = ");
		for(int i = 0; i < polynomial.size(); i++){
			if((i+1) == polynomial.size() || i==0)
				System.out.print(polynomial.get(i).toString());
			else if(polynomial.get(i).getCoefficient() > 0)
				System.out.print("+" + polynomial.get(i).toString());
			else
				System.out.print(polynomial.get(i).toString());
		}
		
		System.out.println();
	
	}
}
