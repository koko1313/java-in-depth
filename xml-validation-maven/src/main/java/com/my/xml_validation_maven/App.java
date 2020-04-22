package com.my.xml_validation_maven;

import java.io.File;

public class App 
{
    public static void main(String[] args)
    {
    	try
    	{
	        File xmlFile = new File(args[0]);
	        File xsdFile = new File(args[1]);
	        
	        if (!xmlFile.exists())
	        {
	        	System.err.println("File " + xmlFile.getName() + " does not exist!");
	        	return;
	        }
	        
	        if (!xsdFile.exists())
	        {
	        	System.err.println("File " + xsdFile.getName() + " does not exist!");
	        	return;
	        }
	        
	        boolean isValid = MyValidator.validate(xmlFile, xsdFile);
	        
	        if (isValid)
	        {
	        	System.out.println("Valid!");
	        }
	        else
	        {
	        	System.out.println("Invalid!");
	        }
    	}
    	catch(ArrayIndexOutOfBoundsException e)
    	{
    		System.err.println("Insert xml and xsd file name!");
    	}
    }
}
