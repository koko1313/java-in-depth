package shape;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public final class Rectangle extends Quadrilateral
{
    public Rectangle()
    {
        // Externalizable requires no-argument constructor
    }


    public Rectangle(float side1, float side2)
    {
        super(side1, side2, side1, side2);

        super.calculateAreaAndPerimeter();
    }


    @Override
    public String toString()
    {
        return super.toString() + "\n"
                        + "\t Side 1: " + side1 + "\n"
                        + "\t Side 2: " + side2;
    }


    @Override
    protected float calculateArea()
    {
        return side1 * side2;
    }


    @Override
    public void writeExternal(ObjectOutput out) throws IOException
    {
        out.writeFloat(side1);
        out.writeFloat(side2);
    }


    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException
    {
        side1 = in.readFloat();
        side2 = in.readFloat();
        side3 = side1;
        side4 = side2;

        super.calculateAreaAndPerimeter();
    }
}
