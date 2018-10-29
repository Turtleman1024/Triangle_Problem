/*
 * Author: Kenneth M. Murry
 * CptS 422 Homework 1
 * 
 * Purpose: This class holds the representation of a concrete shape Triangle.
 */
package shape;


public class Triangle extends Shape {

	private	int a;
	private int b;
	private int c;
	private Boolean valid;
	

	public Triangle(String name, int a, int b, int c) {
		super(name);
		this.a = a;
		this.b = b;
		this.c = c;
		this.valid = false;
	}


	@Override
	public Boolean isATriangle() {
		
		if (a < (b + c) && b < (a + c) && c < (a + b))
		{
			valid = true;
			return true;
		}
		else
		{
			valid = false;
			return false;
		}
	}


	@Override
	public String triangleType() {
		
		if (a == b && b == c)
		{
			return "Equilateral";
		}
		else if (a != b && a != c && b != c)
		{
			return "Scalene";
		}
		else
		{
			return "Isosceles";
		}
	}


	@Override
	public String checkRange() {

		if (a < 1 || a > 200)
		{
			valid = false;
			return "Value of a is not in the range of permitted values";
		}		
		else if (b < 1 || b > 200)
		{
			if (valid == true || valid == false)
			{
				valid = false;
			}
			return "Value of b is not in the range of permitted values";
		}
		else if (c < 1 || c > 200)
		{
			if (valid == true || valid == false)
			{
				valid = false;
			}
			return "Value of c is not in the range of permitted values";
		}
		else
		{
			valid = true;
			return "Valid";
		}
	}


	@Override
	public void printShape() {
		System.out.println( getShapeName() + ":");
		System.out.println("Side a = " + a);
		System.out.println("Side b = " + b);
		System.out.println("Side c = " + c);
		
	}

	@Override
	public Boolean isValid() {
		return valid;
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}

	public int getC() {
		return c;
	}

	public void setC(int c) {
		this.c = c;
	}


	


}
