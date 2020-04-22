package com.my.xml_validation_maven;

import java.io.File;
import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.SchemaFactory;

import org.xml.sax.SAXException;


public class MyValidator 
{
	public static boolean validate(File xmlFile, File xsdFile)
	{
		try 
		{
			SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			schemaFactory.newSchema(xsdFile).newValidator().validate(new StreamSource(xmlFile));
			return true;
		} 
		catch (SAXException | IOException e) 
		{
			return false;
		}
	}
}
