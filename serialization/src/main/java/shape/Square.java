package shape;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public final class Square extends Quadrilateral
{
    public Square()
    {
        // Externalizable requires no-argument constructor
    }


    public Square(float side)
    {
        super(side, side, side, side);

        super.calculateAreaAndPerimeter();
    }


    @Override
    public String toString()
    {
        return super.toString() + "\n"
                        + "\t Sides: " + side1;
    }


    @Override
    protected float calculateArea()
    {
        return side1 * side1;
    }


    @Override
    public void writeExternal(ObjectOutput out) throws IOException
    {
        out.writeFloat(side1);
    }


    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException
    {
        side1 = in.readFloat();
        side2 = side1;
        side3 = side1;
        side4 = side1;

        super.calculateAreaAndPerimeter();
    }
}
