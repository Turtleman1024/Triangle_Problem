/*
 * Author: Kenneth M. Murry
 * CptS 422 Homework 1
 * 
 * Purpose: This class holds the representation of a test to check the boundary values of the triangle.
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

class TestIsTriangle {

	private Triangle triangleUnderTest;
	private ArrayList<Integer> testValues = new ArrayList<Integer>();
	
	@BeforeEach
	void setUp() throws Exception {
		triangleUnderTest = new Triangle("Triangle", 0, 0, 0);
		testValues.add(0);
		testValues.add(1);
		testValues.add(2);
		testValues.add(100);
		testValues.add(199);
		testValues.add(200);
		testValues.add(201);
		
	}

	@Test
	void testIsATriangle() throws IOException {
		Boolean output;
		
		File file = new File("TestResults.txt");	//created a file object 
		FileWriter writer = new FileWriter(file,true);   //create a FileWrite object
		PrintWriter pw = new PrintWriter(writer);   //create a PrintWriter

		
		pw.println("-------Test Suite Is A Triangle------");
		
		pw.println("Test Cases\t\t\tA\t\tB\t\tC\t\tOutPut\tResult ");
		
		for(int index = 0; index < 58; index++)
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
					
					output = triangleUnderTest.isATriangle();
					
					if(output == true)
					{
						pw.print("IsATriangle   \t");
						pw.print(triangleUnderTest.getA() + "\t\t");
						pw.print(triangleUnderTest.getB() + "\t\t");
						pw.print(triangleUnderTest.getC() + "\t\t");
						pw.print(output + "\t");
						try
						{
							assertEquals(true, output);
							pw.println("Passed");
						}
						catch(AssertionError e)
						{
							pw.println("Failed");
						}
						
					}
					else
					{
						pw.print("IsNotATriangle \t");
						pw.print(triangleUnderTest.getA() + "\t\t");
						pw.print(triangleUnderTest.getB() + "\t\t");
						pw.print(triangleUnderTest.getC() + "\t\t");
						pw.print(output + "\t");
						assertEquals(false, output);
						pw.println("Passed");
					}
				}
			}
		}
		
		for(int index = 0; index < 58; index++)
		{
			pw.print("-");
		}
		pw.println();
		pw.println("-----End Test Suite Is A Triangle-----");
		pw.println(" ");
		pw.close(); //close the print write
		
	}

}
