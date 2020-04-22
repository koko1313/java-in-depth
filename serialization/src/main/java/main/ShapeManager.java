package main;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import shape.Shape;


public class ShapeManager implements Serializable
{
    private static final long serialVersionUID = 1L;

    private List<Shape> shapeList = new ArrayList<>();


    public void addShape(Shape shape)
    {
        shapeList.add(shape);
    }


    public void printSumOfAreaOfAllShapes()
    {
        float sum = 0;

        for (Shape shape : shapeList)
        {
            sum += shape.getArea();
        }

        System.out.println("Sum of area of all shapes: " + sum);
    }


    public void printAllShapes()
    {
        shapeList.forEach(System.out::println);
    }


    public void saveToFile(String fileName) throws FileNotFoundException
    {
        try (FileOutputStream fileOutputStream = new FileOutputStream(fileName);
                        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream))
        {
            outputStream.writeObject(this);
        }
        catch (FileNotFoundException e)
        {
            throw e;
        }
        catch (IOException e)
        {
            // TODO
            e.printStackTrace();
        }
    }


    public static ShapeManager loadFromFile(String fileName) throws FileNotFoundException
    {
        ShapeManager shapeManager = new ShapeManager();

        try (FileInputStream fileInputStream = new FileInputStream(fileName);
                        ObjectInputStream inputStream = new ObjectInputStream(fileInputStream))
        {
            shapeManager = (ShapeManager)inputStream.readObject();
        }
        catch (FileNotFoundException e) {
            throw e;
        }
        catch (Exception e)
        {
            System.out.println("Unexpected exception" + e.getMessage());
        }

        return shapeManager;
    }
}
