package shape;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public final class Triangle extends Shape
{
    private float side1;
    private float side2;
    private float side3;


    public Triangle()
    {
        // Externalizable requires no-argument constructor
    }


    public Triangle(float side1, float side2, float side3)
    {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;

        super.calculateAreaAndPerimeter();
    }


    @Override
    public String toString()
    {
        return super.toString() + "\n"
                        + "\t Side 1: " + side1 + "\n"
                        + "\t Side 2: " + side2 + "\n"
                        + "\t Side 3: " + side3;
    }


    @Override
    protected float calculatePerimeter()
    {
        return side1 + side2 + side3;
    }


    @Override
    protected float calculateArea()
    {
        float p = calculatePerimeter() / 2;
        float s = (float)Math.sqrt(p * (p - side1) * (p - side2) * (p - side3));
        return s;
    }


    @Override
    public void writeExternal(ObjectOutput out) throws IOException
    {
        out.writeFloat(side1);
        out.writeFloat(side2);
        out.writeFloat(side3);
    }


    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException
    {
        side1 = in.readFloat();
        side2 = in.readFloat();
        side3 = in.readFloat();

        super.calculateAreaAndPerimeter();
    }
}
