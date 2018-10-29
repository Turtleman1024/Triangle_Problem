/*
 * Author: Kenneth M. Murry
 * CptS 422 Homework 1
 * 
 * Purpose: This class holds the representation of a Robust Worst-Case Boundary Values test of a triangle.
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

class RobustWorstCaseBoundaryValueTest {

	private Triangle triangleUnderTest;
	private ArrayList<Integer> testValues = new ArrayList<Integer>();
	private int caseCount;
	
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
	}

	@Test
	void testTriangleType() throws IOException {
		String output;
		
		File file = new File("RWCBVTResults.txt");	//created a file object 
		FileWriter writer = new FileWriter(file);   //create a FileWrite object
		PrintWriter pw = new PrintWriter(writer);   //create a PrintWriter

		
		pw.println("-------Robust Worst-Case Boundary Value Test------");
		
		pw.println("Test Cases\t\t\tA\t\tB\t\tC\t\tOutPut\t\t\tResult ");
		
		for(int index = 0; index < 66; index++)
		{
			pw.print("-");
		}
		pw.println();
		
		//Begin Robust Worst-Case Boundary Value Test
		for(int index = 0; index < testValues.size(); index++)
		{
			for(int index_2 = 0; index_2 < testValues.size(); index_2++)
			{
				for(int index_3 = 0; index_3 < testValues.size(); index_3++)
				{
					triangleUnderTest.setA(testValues.get(index));
					triangleUnderTest.setB(testValues.get(index_2));
					triangleUnderTest.setC(testValues.get(index_3));
					
					if(triangleUnderTest.isATriangle() == true &&
					   triangleUnderTest.checkRange() == "Valid" )
					{
						output = triangleUnderTest.triangleType();
						
						if(output == "Equilateral")
						{
							pw.print("       " + caseCount + "\t\t\t");
							pw.print(triangleUnderTest.getA() + "\t\t");
							pw.print(triangleUnderTest.getB() + "\t\t");
							pw.print(triangleUnderTest.getC() + "\t\t");
							pw.print("Equilateral" + "\t\t");
							try
							{
								assertEquals("Equilateral", output);
								pw.println("Passed");
							}
							catch(AssertionError e)
							{
								pw.println("Failed");
							}

						}
						else if(output == "Scalene")
						{
							pw.print("       " + caseCount + "\t\t\t");
							pw.print(triangleUnderTest.getA() + "\t\t");
							pw.print(triangleUnderTest.getB() + "\t\t");
							pw.print(triangleUnderTest.getC() + "\t\t");
							pw.print("Scalene" + "\t\t\t");
							try
							{
								assertEquals("Scalene", output);
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
							pw.print("Isosceles" + "\t\t");
							try
							{
								assertEquals("Isosceles",output);
								pw.println("Passed");
							}
							catch(AssertionError e)
							{
								pw.println("Failed");
							}

						}
					}
					else
					{
						pw.print("       " + caseCount + "\t\t\t");
						pw.print(triangleUnderTest.getA() + "\t\t");
						pw.print(triangleUnderTest.getB() + "\t\t");
						pw.print(triangleUnderTest.getC() + "\t\t");
						pw.print("NotATriangle" + "\t");
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
			}
		}
		//End Robust Worst-Case Boundary Value Test		
		
		for(int index = 0; index < 66; index++)
		{
			pw.print("-");
		}
		pw.println();
		pw.println("--End Robust Worst-Case Boundary Value Test--");
		pw.println(" ");
		pw.close(); //close the print write
	}

}
