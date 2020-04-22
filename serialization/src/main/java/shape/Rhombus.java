package shape;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public final class Rhombus extends Quadrilateral
{
    private float height;

    public Rhombus()
    {
        // Externalizable requires no-argument constructor
    }


    public Rhombus(float side, float height)
    {
        super(side, side, side, side);
        this.height = height;

        super.calculateAreaAndPerimeter();
    }


    @Override
    public String toString()
    {
        return super.toString() + "\n"
                        + "\t Sides: " + side1 + "\n"
                        + "\t Height: " + height;
    }


    @Override
    protected float calculateArea()
    {
        return side1 * height;
    }


    @Override
    public void writeExternal(ObjectOutput out) throws IOException
    {
        out.writeFloat(side1);
        out.writeFloat(height);
    }


    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException
    {
        side1 = in.readFloat();
        side2 = side1;
        side3 = side1;
        side4 = side1;
        height = in.readFloat();

        super.calculateAreaAndPerimeter();
    }
}
