package ua.nure.malahin.SummaryTask3.controller;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import ua.nure.malahin.SummaryTask3.constants.Constants;
import ua.nure.malahin.SummaryTask3.constants.XML;
import ua.nure.malahin.SummaryTask3.entity.Haft;
import ua.nure.malahin.SummaryTask3.entity.Knife;
import ua.nure.malahin.SummaryTask3.entity.Visual;
import ua.nure.malahin.SummaryTask3.entity.Weapon;

/**
 * Controller for DOM parser.
 * 
 * @author S.Malahin
 * 
 */
public class DOMController {

    private String xmlFileName;

    // main container
    private Weapon weapon;

    public DOMController(String xmlFileName) {
	this.xmlFileName = xmlFileName;
    }

    public Weapon getWeapon() {
	return weapon;
    }

    /**
     * Parses XML document.
     * 
     * @param validate
     *            If true validate XML document against its XML schema.
     * 
     * @throws ParserConfigurationException
     * @throws SAXException
     * @throws IOException
     */
    public void parse(boolean validate) throws ParserConfigurationException, SAXException, IOException {

	// obtain DOM parser
	DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

	// set properties for Factory

	// XML document contains namespaces
	dbf.setNamespaceAware(true);

	// make parser validating
	if (validate) {
	    // turn validation on
	    dbf.setFeature(Constants.FEATURE_TURN_VALIDATION_ON, true);

	    // turn on xsd validation
	    dbf.setFeature(Constants.FEATURE_TURN_SCHEMA_VALIDATION_ON, true);
	}

	DocumentBuilder db = dbf.newDocumentBuilder();
	//
	// // set error handler
	db.setErrorHandler(new DefaultHandler() {
	    @Override
	    public void error(SAXParseException e) throws SAXException {
		throw e;
	    }
	});
	//
	// // parse XML document
	Document document = db.parse(xmlFileName);

	// // get root element
	Element root = document.getDocumentElement();
	//
	// // create container
	weapon = new Weapon();
	//
	// // obtain questions nodes
	NodeList knifeNodes = root.getElementsByTagName("Knife");
	//
	// // process questions nodes
	for (int j = 0; j < knifeNodes.getLength(); j++) {
	    Knife knife = getKnife(knifeNodes.item(j));
	    System.out.println(knife);
	    weapon.add(knife);
	}
    }

    /**
     * Creates and returns DOM of the Weapon container.
     * 
     * @param test
     *            Weapon object.
     * @throws ParserConfigurationException
     */
    public static Document getDocument(Weapon weapon) throws ParserConfigurationException {

	// obtain DOM parser
	DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

	// set properties for Factory

	// XML document contains namespaces
	dbf.setNamespaceAware(true);

	DocumentBuilder db = dbf.newDocumentBuilder();
	Document document = db.newDocument();

	// create root element
	Element wElement = document.createElement("st3:" + XML.WEAPON.value());

	wElement.setAttribute("xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance");
	wElement.setAttribute("xmlns:st3", "http://nure.ua/malahin/SummaryTask3/entity");
	wElement.setAttribute("xsi:schemaLocation", "http://nure.ua/malahin/SummaryTask3/entity input.xsd");
	// add root element
	document.appendChild(wElement);

	// add questions elements
	for (Knife knife : weapon.getKnifes()) {

	    // add question
	    Element kElement = document.createElement(XML.KNIFE.value());
	    wElement.appendChild(kElement);

	    // add question text
	    Element tElement = document.createElement(XML.TYPE.value());
	    tElement.setTextContent(knife.getType());
	    kElement.appendChild(tElement);

	    // add question text
	    Element hElement = document.createElement(XML.HANDY.value());
	    hElement.setTextContent("" + knife.getHandy());
	    kElement.appendChild(hElement);

	    // add question text
	    Element oElement = document.createElement(XML.ORIGIN.value());
	    oElement.setTextContent(knife.getOrigin());
	    kElement.appendChild(oElement);

	    Element vElement = document.createElement(XML.VISUAL.value());
	    {
		Element widthElement = document.createElement(XML.WIDTH.value());
		widthElement.setTextContent("" + knife.getVisual().getWidth());
		vElement.appendChild(widthElement);

		Element sizeElement = document.createElement(XML.SIZE.value());
		sizeElement.setTextContent("" + knife.getVisual().getSize());
		vElement.appendChild(sizeElement);

		Element materialElement = document.createElement(XML.MATERIAL.value());
		materialElement.setTextContent(knife.getVisual().getMaterial());
		vElement.appendChild(materialElement);

		Element haftElement = document.createElement(XML.HAFT.value());
		haftElement.setAttribute("xsi:type", "st3:" + knife.getVisual().getHaft().getTypeHaft());
		
		if (knife.getVisual().getHaft().getTypeHaft().equals("Wood")) {
		    Element typeWoodElement = document.createElement(XML.TYPEWOOD.value());
		    typeWoodElement.setTextContent(knife.getVisual().getHaft().getTypeWood());

		    haftElement.appendChild(typeWoodElement);
		}

		vElement.appendChild(haftElement);
		Element krovostokElement = document.createElement(XML.KROVOSTOK.value());
		krovostokElement.setAttribute("isIt", "" + knife.getVisual().getKrovostok());
		vElement.appendChild(krovostokElement);
	    }
	    kElement.appendChild(vElement);
	    Element valueElement = document.createElement(XML.VALUE.value());
	    valueElement.setTextContent("" + knife.getValue());
	    kElement.appendChild(valueElement);

	}

	return document;
    }

    /**
     * Extracts knife object from the knife XML node.
     * 
     * @param kNode
     *            Knife node.
     * @return Knife object.
     */
    private Knife getKnife(Node kNode) {
	Knife knife = new Knife();
	Element kElement = (Element) kNode;

	Node knNode = kElement.getElementsByTagName("Type").item(0);
	knife.setType(knNode.getTextContent());

	Node hNode = kElement.getElementsByTagName("Handy").item(0);
	knife.setHandy(Integer.parseInt(hNode.getTextContent()));

	Node oNode = kElement.getElementsByTagName("Origin").item(0);
	knife.setOrigin(oNode.getTextContent());

	knife.setVisual(getVisual(kElement.getElementsByTagName("Visual").item(0)));

	Node vNode = kElement.getElementsByTagName("Value").item(0);
	
	knife.setValue(Boolean.valueOf(vNode.getTextContent()));

	return knife;
    }

    /**
     * Extracts Visual object from the Visual XML node.
     * 
     * @param vNode
     *            Visual node.
     * @return Visual object.
     */
    private Visual getVisual(Node vNode) {
	Visual visual = new Visual();
	Element kElement = (Element) vNode;
	Node wNode = kElement.getElementsByTagName("Width").item(0);
	visual.setWidth(Integer.parseInt(wNode.getTextContent()));

	Node sNode = kElement.getElementsByTagName("Size").item(0);
	visual.setSize(Integer.parseInt(sNode.getTextContent()));

	Node mNode = kElement.getElementsByTagName("Material").item(0);
	visual.setMaterial(mNode.getTextContent());

	Node hNode = kElement.getElementsByTagName("Haft").item(0);
	visual.setHaft(getHaft(hNode));

	Node kNode = kElement.getElementsByTagName("Krovostok").item(0);
	visual.setKrovostok(Boolean.parseBoolean(kNode.getAttributes().item(0).getNodeValue()));

	return visual;
    }

    /**
     * Extracts Haft object from the Haft XML node.
     * 
     * @param hNode
     *            Haft node.
     * @return Haft object.
     */
    private Haft getHaft(Node hNode) {
	Haft haft = new Haft();
	Element kElement = (Element) hNode;
	String type = kElement.getAttribute("xsi:type");
	if (type.equals("st3:Steel")) {
	    haft.setTypeHaft("Steel");
	} else if (type.equals("st3:Plastic")) {
	    haft.setTypeHaft("Plastic");
	} else {
	    Node wNode = kElement.getElementsByTagName("typeWood").item(0);
	    haft.setTypeHaft("Wood");
	    haft.setTypeWood(wNode.getTextContent());
	}

	return haft;
    }

    /**
     * Saves Weapon object to XML file.
     * 
     * @param weapon
     *            Weapon object to be saved.
     * @param xmlFileName
     *            Output XML file name.
     */
    public static void saveToXML(Weapon weapon, String xmlFileName)
	    throws ParserConfigurationException, TransformerException {
	// Test -> DOM -> XML
	saveToXML(getDocument(weapon), xmlFileName);
    }

    /**
     * Save DOM to XML.
     * 
     * @param document
     *            DOM to be saved.
     * @param xmlFileName
     *            Output XML file name.
     */
    public static void saveToXML(Document document, String xmlFileName) throws TransformerException {

	StreamResult result = new StreamResult(new File(xmlFileName));

	// set up transformation
	TransformerFactory tf = TransformerFactory.newInstance();
	javax.xml.transform.Transformer t = tf.newTransformer();
	t.setOutputProperty(OutputKeys.INDENT, "yes");

	// run transformation
	t.transform(new DOMSource(document), result);
    }
   
}
