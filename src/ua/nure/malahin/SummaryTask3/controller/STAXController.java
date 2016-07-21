package ua.nure.malahin.SummaryTask3.controller;

import java.io.IOException;

import javax.xml.namespace.QName;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import javax.xml.transform.stream.StreamSource;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import ua.nure.malahin.SummaryTask3.constants.XML;
import ua.nure.malahin.SummaryTask3.entity.Haft;
import ua.nure.malahin.SummaryTask3.entity.Knife;
import ua.nure.malahin.SummaryTask3.entity.Visual;
import ua.nure.malahin.SummaryTask3.entity.Weapon;
/**
 * Controller for StAX parser.
 * 
 * @author S.Malahin
 * 
 */
public class STAXController extends DefaultHandler {

    private String xmlFileName;

    // main container
    private Weapon weapon;

    public Weapon getWeapon() {
	return weapon;
    }

    public STAXController(String xmlFileName) {
	this.xmlFileName = xmlFileName;
    }

    /**
     * Parses XML document with StAX (based on event reader). There is no
     * validation during the parsing.
     */
    public void parse() throws ParserConfigurationException, SAXException, IOException, XMLStreamException {

	Knife knife = null;

	Visual visual = null;

	Haft haft = null;

	// current element name holder
	String currentElement = null;

	XMLInputFactory factory = XMLInputFactory.newInstance();

	factory.setProperty(XMLInputFactory.IS_NAMESPACE_AWARE, true);

	XMLEventReader reader = factory.createXMLEventReader(new StreamSource(xmlFileName));

	while (reader.hasNext()) {
	    XMLEvent event = reader.nextEvent();

	    // skip any empty content
	    if (event.isCharacters() && event.asCharacters().isWhiteSpace()) {
		continue;
	    }

	    // handler for start tags
	    if (event.isStartElement()) {
		StartElement startElement = event.asStartElement();
		currentElement = startElement.getName().getLocalPart();
		if ("Weapon".equals(currentElement)) {
		    weapon = new Weapon();
		    continue;
		}
		if (XML.KNIFE.value().equals(currentElement)) {
		    knife = new Knife();
		    continue;
		}
		if (XML.VISUAL.value().equals(currentElement)) {
		    visual = new Visual();
		    continue;
		}
		if (XML.HAFT.value().equals(currentElement)) {
		    haft = new Haft();		    
		    String tmp = startElement.getAttributes().next().toString(); 
		    String type = tmp.substring(10, tmp.length()-1);
		    if (type.equals("st3:Steel")) {
			haft.setTypeHaft("Steel");
		    } else if (type.equals("st3:Plastic")) {
			haft.setTypeHaft("Plastic");
		    }else {
			haft.setTypeHaft("Wood");
		    }
		    continue;
		}
		if (XML.KROVOSTOK.value().equals(currentElement)) {
		    Attribute attribute = startElement.getAttributeByName(
			    new QName("isIt"));
		    if (attribute != null) {
			visual.setKrovostok(Boolean.parseBoolean(attribute.getValue()));
			visual.setHaft(haft);
			knife.setVisual(visual);
		    }
		}
	    }

	    // handler for contents
	    if (event.isCharacters()) {
		Characters characters = event.asCharacters();

		String elementText = characters.getData();

		if (XML.TYPE.value().equals(currentElement)) {
		    knife.setType(elementText);
		    continue;
		}
		if (XML.HANDY.value().equals(currentElement)) {
		    knife.setHandy(Integer.parseInt(elementText));
		    continue;
		}
		if (XML.TYPEWOOD.value().equals(currentElement)) {
		    haft.setTypeWood(elementText);
		    continue;
		}
		if (XML.ORIGIN.value().equals(currentElement)) {
		    knife.setOrigin(elementText);
		    continue;
		}
		if (XML.SIZE.value().equals(currentElement)) {
		    visual.setSize(Integer.parseInt(elementText));
		    continue;
		}
		if (XML.WIDTH.value().equals(currentElement)) {
		    visual.setWidth(Integer.parseInt(elementText));
		    continue;
		}
		if (XML.MATERIAL.value().equals(currentElement)) {
		    visual.setMaterial(elementText);
		    continue;
		}
		if (XML.VALUE.value().equals(currentElement)) {
		    knife.setValue(Boolean.parseBoolean(elementText));
		}
	    }

	    // handler for end tags
	    if (event.isEndElement()) {
		EndElement endElement = event.asEndElement();
		String localName = endElement.getName().getLocalPart();

		if (XML.KNIFE.value().equals(localName)) {
		    weapon.add(knife);
		}

	    }
	}
	reader.close();
    }

}