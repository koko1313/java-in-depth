package shape;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public final class Trapezoid extends Quadrilateral
{
    private float height;


    public Trapezoid()
    {
        // Externalizable requires no-argument constructor
    }


    public Trapezoid(float side1, float side2, float side3, float side4, float height)
    {
        super.side1 = side1;
        super.side2 = side2;
        super.side3 = side3;
        super.side4 = side4;
        this.height = height;

        super.calculateAreaAndPerimeter();
    }


    @Override
    public String toString()
    {
        return super.toString() + "\n"
                        + "\t Side 1: " + side1 + "\n"
                        + "\t Side 2: " + side2 + "\n"
                        + "\t Side 3: " + side3 + "\n"
                        + "\t Side 4: " + side4 + "\n"
                        + "\t Height: " + height;
    }


    @Override
    protected float calculateArea()
    {
        return ((side1 + side3) * height) / 2;
    }


    @Override
    public void writeExternal(ObjectOutput out) throws IOException
    {
        out.writeFloat(side1);
        out.writeFloat(side2);
        out.writeFloat(side3);
        out.writeFloat(side4);
        out.writeFloat(height);
    }


    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException
    {
        side1 = in.readFloat();
        side2 = in.readFloat();
        side3 = in.readFloat();
        side4 = in.readFloat();
        height = in.readFloat();

        super.calculateAreaAndPerimeter();
    }
}
