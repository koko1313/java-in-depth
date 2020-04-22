package shape;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Circle extends Shape
{
    private float r;


    public Circle()
    {
        // Externalizable requires no-argument constructor
    }


    public Circle(float r)
    {

        this.r = r;

        super.calculateAreaAndPerimeter();
    }


    @Override
    public String toString()
    {
        return super.toString() + "\n"
                        + "\t" + "Radius: " + r;
    }


    @Override
    protected float calculatePerimeter()
    {
        return (float) (2 * Math.PI * r);
    }


    @Override
    protected float calculateArea()
    {
        return (float) (Math.PI * Math.pow(r, 2));
    }


    @Override
    public void writeExternal(ObjectOutput out) throws IOException
    {
        out.writeFloat(r);
    }


    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException
    {
        r = in.readFloat();

        super.calculateAreaAndPerimeter();
    }
}
