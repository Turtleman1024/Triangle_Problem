/*
 * Author: Kenneth M. Murry
 * CptS 422 Homework 1
 * 
 * Purpose: This class holds the representation of a Robust Boundary Values test of a triangle.
 */
package testpackage;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import shape.Triangle;

class RobustBoundaryValueTest {

	private Triangle triangleUnderTest;
	private ArrayList<Integer> testValues = new ArrayList<Integer>();
	private ArrayList<String> testResults = new ArrayList<String>();
	private int caseCount;
	private boolean valid;
	
	@BeforeEach
	void setUp() throws Exception {
		triangleUnderTest = new Triangle("Triangle", 0, 0,0);
		caseCount = 1;
		testValues.add(0);
		testValues.add(1);
		testValues.add(2);
		testValues.add(100);
		testValues.add(199);
		testValues.add(200);
		testValues.add(201);
		testResults.add("Equilateral");
		testResults.add("Scalene");
		testResults.add("Isosceles");
		testResults.add("NotATraingle");
		valid = true;
	}

	@Test
	void testTriangleType() throws IOException {
		String output;
		File file = new File("RBVTResults.txt");	//created a file object 
		FileWriter writer = new FileWriter(file);   //create a FileWrite object
		PrintWriter pw = new PrintWriter(writer);   //create a PrintWriter
		
		pw.println("----Robust Boundary Value Test---");
		pw.println("Test Cases\t\t\tA\t\tB\t\tC\t\tOutPut\t\t\tResult ");
		
		for(int index = 0; index < 66; index++)
		{
			pw.print("-");
		}
		pw.println();
		
		//Begin Robust Boundary Test
		triangleUnderTest.setA(100);
		triangleUnderTest.setB(100);
		
		for(int index = 0; index < testValues.size(); index++)
		{
			triangleUnderTest.setC(testValues.get(index));
			
			if(triangleUnderTest.isATriangle() == true)
			{
				pw.print("       " + caseCount + "\t\t\t");
				pw.print(triangleUnderTest.getA() + "\t\t");
				pw.print(triangleUnderTest.getB() + "\t\t");
				pw.print(triangleUnderTest.getC() + "\t\t");
				output = triangleUnderTest.triangleType();
				pw.print(output + "\t\t");
				valid = testResults.contains(output);
				try
				{
					assertEquals(true, valid);
					pw.println("Passed");
				}
				catch(AssertionError e)
				{
					pw.println("Failed");
				}
			}
			else
			{
				pw.print("       " + caseCount + "\t\t\t");
				pw.print(triangleUnderTest.getA() + "\t\t");
				pw.print(triangleUnderTest.getB() + "\t\t");
				pw.print(triangleUnderTest.getC() + "\t\t");
				pw.print(testResults.get(3) + "\t");
				try
				{
					assertEquals(false, triangleUnderTest.isValid());
					pw.println("Passed");
				}
				catch(AssertionError e)
				{
					pw.println("Failed");
				}
			}
			
			caseCount++;
		}
		
		testValues.remove(3);
		triangleUnderTest.setA(100);
		triangleUnderTest.setC(100);
		
		for(int index = 0; index < testValues.size(); index++)
		{			
			triangleUnderTest.setB(testValues.get(index));
			
			if(triangleUnderTest.isATriangle() == true)
			{			
				pw.print("       " + caseCount + "\t\t\t");
				pw.print(triangleUnderTest.getA() + "\t\t");
				pw.print(triangleUnderTest.getB() + "\t\t");
				pw.print(triangleUnderTest.getC() + "\t\t");
				output = triangleUnderTest.triangleType();
				pw.print(output + "\t\t");
				valid = testResults.contains(output);
				try
				{
					assertEquals(true, valid);
					pw.println("Passed");
				}
				catch(AssertionError e)
				{
					pw.println("Failed");
				}

			}
			else
			{
				pw.print("       " + caseCount + "\t\t\t");
				pw.print(triangleUnderTest.getA() + "\t\t");
				pw.print(triangleUnderTest.getB() + "\t\t");
				pw.print(triangleUnderTest.getC() + "\t\t");
				pw.print(testResults.get(3) + "\t");
				try
				{
					assertEquals(false, triangleUnderTest.isValid());
					pw.println("Passed");
				}
				catch(AssertionError e)
				{
					pw.println("Failed");
				}

			}
			
			caseCount++;
		}
		
		triangleUnderTest.setB(100);
		triangleUnderTest.setC(100);
		
		for(int index = 0; index < testValues.size(); index++)
		{
			triangleUnderTest.setA(testValues.get(index));
			
			if(triangleUnderTest.isATriangle() == true)
			{			
				pw.print("       " + caseCount + "\t\t\t");
				pw.print(triangleUnderTest.getA() + "\t\t");
				pw.print(triangleUnderTest.getB() + "\t\t");
				pw.print(triangleUnderTest.getC() + "\t\t");
				output = triangleUnderTest.triangleType();
				pw.print(output + "\t\t");
				valid = testResults.contains(output);
				try
				{
					assertEquals(true, valid);
					pw.println("Passed");
				}
				catch(AssertionError e)
				{
					pw.println("Failed");
				}

			}
			else
			{
				pw.print("       " + caseCount + "\t\t\t");
				pw.print(triangleUnderTest.getA() + "\t\t");
				pw.print(triangleUnderTest.getB() + "\t\t");
				pw.print(triangleUnderTest.getC() + "\t\t");
				pw.print(testResults.get(3) + "\t");
				try
				{
					assertEquals(false, triangleUnderTest.isValid());
					pw.println("Passed");
				}
				catch(AssertionError e)
				{
					pw.println("Failed");
				}

			}
			
			caseCount++;
		}
		
		//End Robust Boundary Test
				
		for(int index = 0; index < 66; index++)
		{
			pw.print("-");
		}
		pw.println();
		pw.println("--End Normal Boundary Value Test--");
		pw.println(" ");
		pw.close(); //close the print write
	}

}
