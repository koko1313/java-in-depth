package exceptions;


public class SubException1 extends CustomException
{
    /** field <code>serialVersionUID</code> */
    private static final long serialVersionUID = 1L;


    public SubException1()
    {
        super();
    }


    public SubException1(String message)
    {
        super(message);
    }


    public SubException1(Throwable t)
    {
        super(t);
    }

}
