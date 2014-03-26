package hr.fer.zemris.java.tecaj.hw3;

public class Problem1 {

	public static void main(String[] args) {
		
		ComplexNumber c1 = new ComplexNumber(2, 3);
		ComplexNumber c2 = new ComplexNumber(4, 5);
		ComplexNumber c3 = c1.power(2);
		ComplexNumber c4 = ComplexNumber.fromImaginary(3);
		System.out.println(c4.toString());
		

	}

}
