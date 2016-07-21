package ua.nure.malahin.SummaryTask3.controller;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import ua.nure.malahin.SummaryTask3.constants.Constants;
import ua.nure.malahin.SummaryTask3.constants.XML;
import ua.nure.malahin.SummaryTask3.entity.Haft;
import ua.nure.malahin.SummaryTask3.entity.Knife;
import ua.nure.malahin.SummaryTask3.entity.Visual;
import ua.nure.malahin.SummaryTask3.entity.Weapon;

/**
 * Controller for SAX parser.
 * 
 * @author S.Malahin
 * 
 */
public class SAXController extends DefaultHandler {

    private String xmlFileName;

    // current element name holder
    private String currentElement;

    // main container
    private Weapon weapon;

    private Knife knife;

    private Visual visual;

    private Haft haft;

    public SAXController(String xmlFileName) {
	this.xmlFileName = xmlFileName;
    }

    /**
     * Parses XML document.
     * 
     * @param validate
     *            If true validate XML document against its XML schema. With
     *            this parameter it is possible make parser validating.
     */
    public void parse(boolean validate) throws ParserConfigurationException, SAXException, IOException {

	// obtain sax parser factory
	SAXParserFactory factory = SAXParserFactory.newInstance();

	// XML document contains namespaces
	factory.setNamespaceAware(true);

	// set validation
	if (validate) {
	    factory.setFeature(Constants.FEATURE_TURN_VALIDATION_ON, true);
	    factory.setFeature(Constants.FEATURE_TURN_SCHEMA_VALIDATION_ON, true);
	}

	SAXParser parser = factory.newSAXParser();
	parser.parse(xmlFileName, this);
    }

    // ///////////////////////////////////////////////////////////
    // ERROR HANDLER IMPLEMENTATION
    // ///////////////////////////////////////////////////////////

    @Override
    public void error(org.xml.sax.SAXParseException e) throws SAXException {
	// if XML document not valid just throw exception
	throw e;
    };

    public Weapon getWeapon() {
	return weapon;
    }

    // ///////////////////////////////////////////////////////////
    // CONTENT HANDLER IMPLEMENTATION
    // ///////////////////////////////////////////////////////////

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

	currentElement = qName;
	if ("st3:Weapon".equals(currentElement)) {
	    weapon = new Weapon();
	    return;
	}
	if (XML.KNIFE.value().equals(currentElement)) {
	    knife = new Knife();
	    return;
	}
	if (XML.VISUAL.value().equals(currentElement)) {
	    visual = new Visual();
	    return;
	}
	if (XML.HAFT.value().equals(currentElement)) {
	    haft = new Haft();
	    String type = (attributes.getValue("xsi:type"));
	    if (type.equals("st3:Steel")) {
		haft.setTypeHaft("Steel");
	    } else if (type.equals("st3:Plastic")) {
		haft.setTypeHaft("Plastic");
	    } else {
		haft.setTypeHaft("Wood");
	    }
	}
	if (XML.KROVOSTOK.value().equals(currentElement) && attributes.getLength() > 0) {
	    visual.setKrovostok(Boolean.parseBoolean(attributes.getValue(uri, "isIt")));
	    visual.setHaft(haft);
	}

    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {

	String elementText = new String(ch, start, length).trim();
	if (elementText.equals("")) {
	    return;
	}
	if (XML.TYPE.value().equals(currentElement)) {
	    knife.setType(elementText);
	    return;
	}
	if (XML.HANDY.value().equals(currentElement)) {
	    knife.setHandy(Integer.parseInt(elementText));
	    return;
	}
	if (XML.VALUE.value().equals(currentElement)) {
	    knife.setValue(Boolean.parseBoolean(elementText));
	    return;
	}
	if (XML.TYPEWOOD.value().equals(currentElement)) {
	    haft.setTypeWood(elementText);
	    return;
	}
	if (XML.ORIGIN.value().equals(currentElement)) {
	    knife.setOrigin(elementText);
	    return;
	}
	if (XML.SIZE.value().equals(currentElement)) {
	    visual.setSize(Integer.parseInt(elementText));
	    return;
	}
	if (XML.WIDTH.value().equals(currentElement)) {
	    visual.setWidth(Integer.parseInt(elementText));
	    return;
	}

	if (XML.MATERIAL.value().equals(currentElement)) {
	    visual.setMaterial(elementText);
	    return;
	}
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {

	if (XML.KNIFE.value().equals(qName)) {
	    weapon.add(knife);
	}

	if (XML.VISUAL.value().equals(qName)) {
	    knife.setVisual(visual);

	}

    }

 
}