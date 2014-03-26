package hr.fer.zemris.java.tecaj.hw3;

import static java.lang.Math.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class that offers a bunch of functions to work with complex numbers.
 * 
 * @author Igor Petkovski
 * 
 */
public class ComplexNumber {

	private double real;
	private double imaginary;

	/**
	 * Creates new instance of {@link ComplexNumber} with property variables
	 * real and imaginary.
	 * 
	 * @param real
	 *            Real part of complex number.
	 * @param imaginary
	 *            Imaginary part of complex number.
	 */
	public ComplexNumber(double real, double imaginary) {
		this.real = real;
		this.imaginary = imaginary;
	}

	/**
	 * Creates new instance of ComplexNumber with real part with value
	 * <code>real</code> and imaginary part of value 0.0.
	 * 
	 * @param real
	 *            Real part of ComplexNumber
	 * @return New Instance of {@link ComplexNumber}
	 */
	public static ComplexNumber fromReal(double real) {
		return new ComplexNumber(real, 0.0);
	}

	/**
	 * Creates new instance of ComplexNumber with imaginary part with value
	 * <code>imaginary</code> and real part of value 0.0.
	 * 
	 * @param imaginary
	 *            Imaginary part of ComplexNumber
	 * @return New Instance of {@link ComplexNumber}
	 */
	public static ComplexNumber fromImaginary(double imaginary) {
		return new ComplexNumber(0.0, imaginary);
	}

	/**
	 * Method returns new instance of ComplexNumber.
	 * 
	 * @param magnitude
	 *            Magnitude of complex number.
	 * @param angle
	 *            an angle, in radians
	 * @return New instance of Complex number.
	 */
	public static ComplexNumber fromMagnitudeAndAngle(double magnitude,
			double angle) {
		return new ComplexNumber( cos(angle) * magnitude, sin(angle) * magnitude);
	}

	/**
	 * Returns new instance of {@link ComplexNumber} from String input argument
	 * s. Method accepts strings such as: "3.51", "-3.17", "-2.71i", "i", "1",
	 * "-2.71-3.15i".
	 * 
	 * @param s
	 *            String parameter.
	 * @return New instance of {@link ComplexNumber}.
	 */
	public static ComplexNumber parse(String s) {
		// If only real component is present
		if (s.matches("\\s*[+|-]?\\d+.?\\d*\\s*")) {
			return fromReal(Double.parseDouble(s));
			// Else if only imaginary componenet is present
		} else if (s.matches("\\s*[+|-]?\\d+.?\\d*i\\s*")) {
			return fromImaginary(Double.parseDouble(s.substring(0,
					s.length() - 1)));
			// Else if both components are present
		} else if (s.trim().matches(
				"([+|-]?\\d+.?\\d*\\s*)?([-|\\+]\\d+.?\\d*i)")) {

			Pattern pattern = Pattern.compile("[+|-]?\\d+.?\\d*");
			Matcher matcher = pattern.matcher(s.trim());
			matcher.find();
			String real = matcher.group(0);
			s = matcher.replaceFirst("");

			return new ComplexNumber(Double.parseDouble(real),
					Double.parseDouble(s.substring(0, s.length() - 1)));
		}
		// Else wrong input string type
		throw new IllegalArgumentException(
				"You have tried to create new ComplexNumber with wrong string format: "
						+ s);
	}

	/**
	 * Returns real component of {@link ComplexNumber}.
	 * 
	 * @return Real component of {@link ComplexNumber}.
	 */
	public double getReal() {
		return real;
	}

	/**
	 * Returns imaginary component of ComplexNumber.
	 * 
	 * @return Imaginary component of ComplexNumber.
	 */
	public double getImaginary() {
		return imaginary;
	}

	/**
	 * Method returns magnitude of ComplexNumber.
	 * 
	 * @return Magnitude of ComplexNumber.
	 */
	public double getMagnitude() {
		return sqrt(pow(real, 2) + pow(imaginary, 2));
	}

	/**
	 * Returns the angle of a complex number. Value is in radians, check
	 * <code>java.lang.Math.atan2()</code>.
	 * 
	 * @return angle - in radians
	 */
	public double getAngle() {
		return atan2(imaginary, real);
	}

	public ComplexNumber add(ComplexNumber c) {
		return new ComplexNumber(real + c.getReal(), imaginary
				+ c.getImaginary());
	}

	public ComplexNumber sub(ComplexNumber c) {
		return new ComplexNumber(real - c.getReal(), imaginary
				- c.getImaginary());
	}

	public ComplexNumber mul(ComplexNumber c) {
		return new ComplexNumber((real * c.getReal() - imaginary * c.getImaginary()),
				(real * c.imaginary + imaginary * c.getReal()));
	}
	
	public ComplexNumber div(ComplexNumber c) {
		double magnitude = this.getMagnitude() / c.getMagnitude();
		double angle = this.getAngle() - c.getAngle();
		
		return ComplexNumber.fromMagnitudeAndAngle(magnitude, angle);
	}
	
	public ComplexNumber power(int n) {
		if (n<0) {
			throw new IllegalArgumentException("n must be >= 0");
		}
		return new ComplexNumber(pow(this.getMagnitude(), n), this.getAngle()*n);
	}

	
	public ComplexNumber[] root(int n) {
		if (n<1) {
			throw new IllegalArgumentException("n must be > 0");
		}
		ComplexNumber[] results = new ComplexNumber[n];
		for (int i = 0; i<n; i++) {
			
		}
	}
	
	
	public String toString() {
		if (imaginary > 0) {
			return real + " + " + imaginary + "i";
		} 	
		return real + " " + imaginary + "i";
	}
	/**
	 * Checks if complex numbers are equal with precision 1E-6.
	 * 
	 * @param c
	 *            ComplexNumber to compare to.
	 * @return true or false
	 */
	public boolean equals(ComplexNumber c) {
		if (real - c.getReal() < 1E-6 && imaginary - c.getImaginary() < 1E-6) {
			return true;
		}
		return false;
	}

}
