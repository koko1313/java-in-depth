package shape;

import java.io.Externalizable;

public abstract class Shape implements Externalizable
{
    protected transient float area;
    protected transient float perimeter;


    @Override
    public String toString()
    {
        return this.getClass().getSimpleName() + " (Area: " + area + ", Perimeter: " + perimeter + ")";
    }


    protected abstract float calculateArea();


    protected abstract float calculatePerimeter();


    public void calculateAreaAndPerimeter()
    {
        area = calculateArea();
        perimeter = calculatePerimeter();
    }


    public float getArea()
    {
        return area;
    }


    public float getPerimeter()
    {
        return perimeter;
    }
}
