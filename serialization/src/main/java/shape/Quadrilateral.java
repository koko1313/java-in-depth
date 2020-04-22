package shape;

public abstract class Quadrilateral extends Shape
{
    protected float side1;
    protected float side2;
    protected float side3;
    protected float side4;


    public Quadrilateral()
    {
        // Externalizable requires no-argument constructor
    }


    public Quadrilateral(float side1, float side2, float side3, float side4)
    {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        this.side4 = side4;
    }


    @Override
    protected float calculatePerimeter()
    {
        return side1 + side2 + side3 + side4;
    }
}
