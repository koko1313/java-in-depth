package exceptions;


public class CustomException extends Exception
{
    /** field <code>serialVersionUID</code> */
    private static final long serialVersionUID = 1L;


    public CustomException()
    {
        super();
    }


    public CustomException(String message)
    {
        super(message);
    }


    public CustomException(Throwable t)
    {
        super(t);
    }
}
