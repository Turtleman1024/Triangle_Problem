/*
 * Author: Kenneth M. Murry
 * CptS 422 Homework 1
 * 
 * Purpose: This class is the main driver of the Triangle Problem application.
 */
package shape;



public class Main {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		
		int a = 0;
		int b = 0;
		int c = 0;
		
		String error_message = "";
		String triangle_type = "";
		
		if(args.length != 3)
		{
			System.out.println("Usage: [Integer] [Integer] [Integer]");
			System.exit(-1);
		}
		
		try 
		{
			a = Integer.parseInt(args[0]);
			b = Integer.parseInt(args[1]);
			c = Integer.parseInt(args[2]);

		}
		catch (NumberFormatException e)
		{
			System.out.println("One of the arguments is not an integer");
			System.exit(-1);
		}
		
		Shape newShape = new Triangle("Triangle", a, b ,c);
		
		error_message = newShape.checkRange();
		
		if(newShape.isValid() == true && newShape.isATriangle() == true)
		{
			triangle_type = newShape.triangleType();
			System.out.println(triangle_type);
		}
		else if(newShape.isATriangle() == false)
		{
			error_message = "NotATriangle";
			System.out.println(error_message);
		}
		else
		{
			System.out.println(error_message);
		}
		
	}

}
