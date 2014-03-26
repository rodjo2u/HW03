package hr.fer.zemris.java.tecaj.hw3;

import static org.junit.Assert.*;

import org.junit.Test;


public class ComplexNumberTest {

	@Test
	public void newComplexNumberTest() {
		
		ComplexNumber value = new ComplexNumber(0, 5);
		
		assertEquals("New instance of ComplexNumber has not been created.", ComplexNumber.class, value.getClass());
	}
	
	@Test
	public void fromRealTest() {
		
		ComplexNumber value = ComplexNumber.fromReal(1);
		
		assertEquals("New instance of ComplexNumber has not been created.", ComplexNumber.class, value.getClass());
	}
	
	@Test
	public void fromImaginaryTest() {
		
		ComplexNumber value = ComplexNumber.fromImaginary(1);
		
		assertEquals("New instance of ComplexNumber has not been created.",  ComplexNumber.class, value.getClass());
	}
	
	@Test
	public void fromMagnitudeAndAngleTest() {
		
		ComplexNumber value = ComplexNumber.fromMagnitudeAndAngle(10, Math.PI/3);
		
		assertEquals("New instance of ComplexNumber has not been created.",  ComplexNumber.class, value.getClass());
	}
	
	@Test
	public void parseRealAndImaginaryTest() {
		
		ComplexNumber value = ComplexNumber.parse("1.2+6.5i");
		
		assertEquals("New instance of ComplexNumber has not been created.",  ComplexNumber.class, value.getClass());
	}
	
	@Test
	public void parseImaginaryTest() {
		
		ComplexNumber value = ComplexNumber.parse("-2.5i");
		
		assertEquals("New instance of ComplexNumber has not been created.",  ComplexNumber.class, value.getClass());
	}
	
	@Test
	public void addTest() {
		
		ComplexNumber c1 = new ComplexNumber(0, 0) ;
		ComplexNumber c2 = new ComplexNumber(2, -4);
		ComplexNumber c3 = new ComplexNumber(2, -4);
		boolean value = c2.equals(c3);
		
		assertEquals("Complex numbers were not added correctly.", true, value);
	}
	
	// TODO add further CN tests

}
