package main;

import java.io.FileNotFoundException;

import shape.Circle;
import shape.Rectangle;
import shape.Rhombus;
import shape.Square;
import shape.Trapezoid;
import shape.Triangle;


public class Main
{

    public static void main(String[] args)
    {
        ShapeManager shapeManager = new ShapeManager();

        shapeManager.addShape(new Triangle(3, 4, 5));
        shapeManager.addShape(new Circle(6));
        shapeManager.addShape(new Rhombus(4, 2));
        shapeManager.addShape(new Rectangle(4, 2));
        shapeManager.addShape(new Square(2));
        shapeManager.addShape(new Trapezoid(2, 4, 6, 2, 2));

        //shapeManager.printAllShapes();

        // save to file
        try
        {
            shapeManager.saveToFile("shapes");
        }
        catch (FileNotFoundException e)
        {
            System.err.println("The file was not found.");
        }

        // load from file
        try
        {
            shapeManager = ShapeManager.loadFromFile("shapes");
            shapeManager.printAllShapes();
            shapeManager.printSumOfAreaOfAllShapes();
        }
        catch (FileNotFoundException e)
        {
            System.err.println("The file was not found.");
        }
    }

}
