
public class Term {

	private int coefficient;
	private int exponent;
	
	public Term(int coefficient, int exponent){
		this.coefficient = coefficient;
		this.exponent = exponent;
	}
	
	public String toString(){
		String out;
		if(exponent == 0)
			out = String.valueOf(coefficient) ; 
		else if(exponent == 1)
			out = (coefficient + "x");
		else
			out = (coefficient + "x^" + exponent);

		return out;		
	}
	
	public int getCoefficient(){
		return coefficient;
	}
	
	public int getExponent(){
		return exponent;
	}
}
