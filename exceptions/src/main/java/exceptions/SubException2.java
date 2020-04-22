package exceptions;


public class SubException2 extends CustomException
{
    /** field <code>serialVersionUID</code> */
    private static final long serialVersionUID = 1L;


    public SubException2()
    {
        super();
    }


    public SubException2(String message)
    {
        super(message);
    }


    public SubException2(Throwable t)
    {
        super(t);
    }

}
