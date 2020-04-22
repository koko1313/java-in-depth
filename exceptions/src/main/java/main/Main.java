package main;


import exceptions.CustomError;
import exceptions.CustomException;
import exceptions.CustomUncheckedException;
import exceptions.SubException1;
import exceptions.SubException2;


public class Main
{

    public static void main(String[] args) throws CustomException
    {
//        throwExceptionDirect();

//        try
//        {
//            throwRandomException();
//        }
//        catch (SubException1 e)
//        {
//            System.out.println("There is a sub exception 1");
//        }

//        throwException2CausedByException1();

//        throwCustomUncheckedException();

//        throwCustomError();
    }


    public static void throwExceptionDirect() throws CustomException
    {
        throw new SubException1("Exception Message!!!!!!!!");
//        throw new SubException2();
    }

    public static void throwRandomException() throws SubException1
    {
        try
        {
//            throw new SubException1();
            throw new SubException2();
        }

        // group exceptions
//        catch (CustomException e)
//        {
//            System.out.println("There is an exception!");
//        }

        // multiple exeptions
//        catch (SubException1 | SubException2 e)
//        {
//            System.out.println("There is an exception!");
//        }

        // catch SubException2
        catch (SubException2 e)
        {
            System.out.println("There is a sub exception 2!");
        }

        finally
        {
            System.out.println("Ready!");
        }
    }

    public static void throwException2CausedByException1() throws SubException2
    {
        Exception subException1 = new SubException1();
        throw new SubException2(subException1);
    }

    public static void throwCustomUncheckedException()
    {
        throw new CustomUncheckedException();
    }

    public static void throwCustomError()
    {
        throw new CustomError();
    }

}
