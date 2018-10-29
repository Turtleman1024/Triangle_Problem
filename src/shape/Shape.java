/*
 * Author: Kenneth M. Murry
 * CptS 422 Homework 1
 * 
 * Purpose: This class holds the representation of a Shape.
 */
package shape;



public abstract class Shape {
	

	private String shapeName;

	//Constructor
	public Shape(String name)
	{
		shapeName = name;
	}


	public String getShapeName() {
		return shapeName;
	}


	public void setShapeName(String shapeName) {
		this.shapeName = shapeName;
	}
	

	public abstract Boolean isATriangle();
	

	public abstract String triangleType();
	

	public abstract String checkRange();

	public abstract void printShape();
	
	public abstract Boolean isValid();
}
