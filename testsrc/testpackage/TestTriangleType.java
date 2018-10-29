/*
 * Author: Kenneth M. Murry
 * CptS 422 Homework 1
 * 
 * Purpose: This class holds the representation of a test to check what type of triangle.
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

class TestTriangleType {

	private Triangle triangleUnderTest;
	private ArrayList<Integer> testValues = new ArrayList<Integer>();
	@BeforeEach
	void setUp() throws Exception {
		triangleUnderTest = new Triangle("Triangle", 0, 0, 0);
		testValues.add(1);
		testValues.add(2);
		testValues.add(100);
		testValues.add(199);
		testValues.add(200);
	}


	@Test
	void testTriangleType() throws IOException {
		String output;
		File file = new File("TestResults.txt");	//created a file object 
		FileWriter writer = new FileWriter(file,true);   //create a FileWrite object
		PrintWriter pw = new PrintWriter(writer);   //create a PrintWriter

		pw.println("----Test Suite Check Triangle Type---");
		pw.println("Test Cases\t\t\tA\t\tB\t\tC\t\tOutPut\t\t\tResult ");
		
		for(int index = 0; index < 66; index++)
		{
			pw.print("-");
		}
		pw.println();
		
		for(int index = 0; index < testValues.size(); index++)
		{
			for(int index_2 = 0; index_2 < testValues.size(); index_2++)
			{
				for(int index_3 = 0; index_3 < testValues.size(); index_3++)
				{
					triangleUnderTest.setA(testValues.get(index));
					triangleUnderTest.setB(testValues.get(index_2));
					triangleUnderTest.setC(testValues.get(index_3));
					
					if(triangleUnderTest.isATriangle() == true)
					{
						output = triangleUnderTest.triangleType();
						
						if(triangleUnderTest.getA() == triangleUnderTest.getB() && 
						   triangleUnderTest.getB() == triangleUnderTest.getC())
						{
							pw.print("Equilateral     \t");
							pw.print(triangleUnderTest.getA() + "\t\t");
							pw.print(triangleUnderTest.getB() + "\t\t");
							pw.print(triangleUnderTest.getC() + "\t\t");
							pw.print(output + "\t\t");
							assertEquals("Equilateral", output);
							pw.println("Passed");
						}
						else if(triangleUnderTest.getA() != triangleUnderTest.getB() &&
								triangleUnderTest.getA() != triangleUnderTest.getC() &&
								triangleUnderTest.getB() != triangleUnderTest.getC())
						{
							pw.print("Scalene          \t");
							pw.print(triangleUnderTest.getA() + "\t\t");
							pw.print(triangleUnderTest.getB() + "\t\t");
							pw.print(triangleUnderTest.getC() + "\t\t");
							pw.print(output + "\t\t\t");
							assertEquals("Scalene", output);
							pw.println("Passed");
						}
						else
						{
							pw.print("Isosceles        \t");
							pw.print(triangleUnderTest.getA() + "\t\t");
							pw.print(triangleUnderTest.getB() + "\t\t");
							pw.print(triangleUnderTest.getC() + "\t\t");
							pw.print(output + "\t\t");
							assertEquals("Isosceles",output);
							pw.println("Passed");
						}
					}
					else
					{
						pw.print("NotATraingle     \t");
						pw.print(triangleUnderTest.getA() + "\t\t");
						pw.print(triangleUnderTest.getB() + "\t\t");
						pw.print(triangleUnderTest.getC() + "\t\t");
						pw.print("NotATriangle" + "\t");
						assertEquals(false, triangleUnderTest.isValid());
						pw.println("Passed");
					}
				}
			}
		}
		
		for(int index = 0; index < 66; index++)
		{
			pw.print("-");
		}
		pw.println();
		pw.println("--End Test Suite Check Triangle Type--");
		pw.println(" ");
		pw.close(); //close the print write
	}

}
