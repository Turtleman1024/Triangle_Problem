/*
 * Author: Kenneth M. Murry
 * CptS 422 Homework 1
 * 
 * Purpose: This class holds the representation of a test to check side b's boundary values of the triangle.
 */
package testpackage;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import shape.Triangle;

class TestCheckRangeB {

	private Triangle triangleUnderTest;
	
	@BeforeEach
	void setUp() throws Exception {
		
		triangleUnderTest = new Triangle("Triangle", 0, 0, 0);
		
	}

	@Test
	void testCheckRangeB() throws IOException {
		
		File file = new File("TestResults.txt");	//created a file object 
		FileWriter writer = new FileWriter(file, true);   //create a FileWrite object
		PrintWriter pw = new PrintWriter(writer);   //create a PrintWriter

		
		pw.println("-------Test Suite Check Range B------");
		
		pw.println("Test Cases\t\t\tA\t\tB\t\tC\t\tOutPut\t\t\t\t\t\t\t\t\t\t\t\tResult ");
		
		for(int index = 0; index < 102; index++)
		{
			pw.print("-");
		}
		pw.println();
		
		String output;
		int[] testValues = {0,1,2,100,199,200,201};
		String[] testOutputs = {"Value of a is not in the range of permitted values",
							    "Value of b is not in the range of permitted values",
							    "Value of c is not in the range of permitted values",
							    "Valid"};
		
		triangleUnderTest.setA(testValues[3]);
		triangleUnderTest.setC(testValues[3]);
		
		for(int index = 0; index < testValues.length; index++)
		{
			triangleUnderTest.setB(testValues[index]);
			
			if(index == 0 || index == 6)
			{
				pw.print("B Out of bounds \t");
				pw.print(triangleUnderTest.getA() + "\t\t");
				pw.print(triangleUnderTest.getB() + "\t\t");
				pw.print(triangleUnderTest.getC() + "\t\t");
				output = triangleUnderTest.checkRange();
				pw.print(output + "\t");
				assertEquals(output, testOutputs[1]);
				pw.println("Passed");
			}
			else
			{
				pw.print("B In the bounds \t");
				pw.print(triangleUnderTest.getA() + "\t\t");
				pw.print(triangleUnderTest.getB() + "\t\t");
				pw.print(triangleUnderTest.getC() + "\t\t");
				output = triangleUnderTest.checkRange();
				pw.print(output + "\t\t\t\t\t\t\t\t\t\t\t\t");
				assertEquals(output, testOutputs[3]);
				pw.println("Passed");
			}	
		}
		
		for(int index = 0; index < 102; index++)
		{
			pw.print("-");
		}
		pw.println();
		pw.println("-----End Test Suite Check Range B-----");
		pw.println(" ");
		pw.close(); //close the print write
	}
}
