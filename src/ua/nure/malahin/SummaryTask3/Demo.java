package ua.nure.malahin.SummaryTask3;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

/**
 * Contains static methods for sorting.
 * 
 * @author S.Malahin
 * 
 */
public class Demo {

    public static void main(String[] args)  throws ParserConfigurationException, SAXException, IOException, XMLStreamException, TransformerException {
	Main.main(new String[] { "input.xml" });	
    }

}
