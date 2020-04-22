package xslt;

import java.io.File;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class XSLT
{
    public static void main(String[] args) throws TransformerException
    {
        File templateFile = new File("xslt-files/template.xml");
        File sourceFile = new File("xslt-files/source.xml");
        File resultFile = new File("xslt-files/result.html");

        TransformerFactory f = TransformerFactory.newInstance();
        Transformer t = f.newTransformer(new StreamSource(templateFile));

        Source source = new StreamSource(sourceFile);
        Result result = new StreamResult(resultFile);

        t.transform(source, result);
    }
}
