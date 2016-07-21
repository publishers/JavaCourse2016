package ua.nure.malahin.SummaryTask3;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

import ua.nure.malahin.SummaryTask3.constants.Constants;
import ua.nure.malahin.SummaryTask3.controller.DOMController;
import ua.nure.malahin.SummaryTask3.controller.SAXController;
import ua.nure.malahin.SummaryTask3.controller.STAXController;
import ua.nure.malahin.SummaryTask3.entity.Weapon;
import ua.nure.malahin.SummaryTask3.util.Sorter;

public class Main {

    public static void usage() {
	System.out.println("Usage:\njava -jar ST3ExampleSimple.jar xmlFileName");
	System.out.println("java ua.nure.your_last_name.SummaryTask3.Main xmlFileName");
    }

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, XMLStreamException, TransformerException {
	if (args.length != 1) {
	    usage();
	    return;
	}
	String xmlFileName = args[0];
	System.out.println("Input ==> " + xmlFileName);
	
	////////////////////////////////////////////////////////
	// DOM
	////////////////////////////////////////////////////////
	
	// get
	DOMController domController = new DOMController(xmlFileName);
	domController.parse(true);
	Weapon weapon = domController.getWeapon();

	// sort (case 1)
	Sorter.sortKnifesByOrigin(weapon);
	
	// save
	DOMController.saveToXML(weapon, Constants.OUTPUT_DOM_XML_FILE);
	System.out.println("Output ==> " + Constants.OUTPUT_DOM_XML_FILE);

	////////////////////////////////////////////////////////
	// SAX
	////////////////////////////////////////////////////////
	
	// get
	SAXController saxController = new SAXController(xmlFileName);
	saxController.parse(true);
	weapon = saxController.getWeapon();
	
	// sort  (case 2)
	Sorter.sortKnifesByVisualSize(weapon);
	
	// save
	
	// other way: 
	DOMController.saveToXML(weapon, Constants.OUTPUT_SAX_XML_FILE);
	System.out.println("Output ==> " + Constants.OUTPUT_SAX_XML_FILE);
	
	////////////////////////////////////////////////////////
	// StAX
	////////////////////////////////////////////////////////
	
	// get
	STAXController staxController = new STAXController(xmlFileName);
	staxController.parse();
	weapon = staxController.getWeapon();
	
	// sort  (case 3)
	Sorter.sortKnifesByVisualWidth(weapon);
	
	// save
	DOMController.saveToXML(weapon, Constants.OUTPUT_STAX_XML_FILE);
	System.out.println("Output ==> " + Constants.OUTPUT_STAX_XML_FILE);
	
    }

}
