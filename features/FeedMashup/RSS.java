import org.w3c.dom.*;
import org.xml.sax.SAXException;

import java.io.*;
import java.util.ArrayList;

import javax.swing.*;

import javax.xml.parsers.*;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class RSS {
	
	// Feature FEEDMASHUP
	
	private boolean RSSfeed=false, RSSfilter=false, RSSsort=false, RSScombine=false, RSStruncate=false, RSSduplicate=false;
	
	/// agregado sabado 4/9
	public static final String xmlDireccion = "rss.xml";
	private DocumentBuilderFactory fact, fact2;
	private DocumentBuilder db;
	// public static Document rss_input;
	private Document rss_input, rss_input1, rss_input2;
	private Document root;
	private Element rss, channel, chTitle, chLink, chDescription;
	private NodeList items, items1, items2;
	private String txtTitle, txtLink, txtDescri, itPubdate;
	private String txtTitle1, txtLink1, txtDescri1, itPubdate1;
	private String txtTitle2, txtLink2, txtDescri2, itPubdate2;
	////////
	
	private String feed;
	private String[] feeds;
	//boolean sort=false;
	// 30/08/22
	//public ArrayList<Tags> arrayRss = new ArrayList();
	private ArrayList<Tags> arrayRss = new ArrayList();
	//

	public RSS(String feed) {
		this.feed = feed;
	}
	public RSS(String[] feeds) {
		this.feeds = feeds;
	}
	
	public void procesar() {
	}
	public void procesar(String[] filtros) {
	}
	public void procesar(String[] filtros, boolean sort) {
	}
	public void procesar(String filtros, boolean sort) {
	}
	public void procesar(String[] feed, String filtro, int nTruncate) {
	}
	// 30/8/22 //////////////////////////////////////////////////////////
	public void procesar(String[] filtros, boolean sort, int nTruncate) {
	}
	public void procesar(String[] feed, String filtro) {
	}
	public void procesar(String txtFeed, String txtFilter, int nTruncate) {}
	public void procesar(String txtFeed, String txtFilter) {}
	public void procesar(String txtFeed, int nTruncate) {}
	public void procesar(String txtFeed) {}
	/////////////////////////////////////////////////////////////////
	
	
	public Document ingresoFeed(String feed) throws ParserConfigurationException, SAXException, IOException {
		fact = DocumentBuilderFactory.newInstance();
		db = fact.newDocumentBuilder();
		return db.parse(feed);
	}

	public Document creaDocRSS(DocumentBuilder db) {
		return db.newDocument();
	}

	public void seccionRSS(Document root) {
		rss = root.createElement("rss");
		rss.setAttribute("version", "2.0");
		rss.setAttribute("xmlns:atom", "http://www.w3.org/2005/Atom");
		root.appendChild(rss);
		channel = root.createElement("channel");
		rss.appendChild(channel);
	}

	public void seccionChannel(Document root, Document rss_input) {
		items = rss_input.getElementsByTagName("channel");

		Element elementos_channel = (Element) items.item(0);
		txtTitle = ((Element) elementos_channel.getElementsByTagName("title").item(0)).getTextContent();
		chTitle = root.createElement("title");
		chTitle.setTextContent(txtTitle);
		channel.appendChild(chTitle);

		txtLink = ((Element) elementos_channel.getElementsByTagName("link").item(0)).getTextContent();
		Element chLink = root.createElement("link");
		chLink.setTextContent(txtLink);
		channel.appendChild(chLink);

		txtDescri = ((Element) elementos_channel.getElementsByTagName("description").item(0)).getTextContent();
		chDescription = root.createElement("description");
		chDescription.setTextContent(txtDescri);
		channel.appendChild(chDescription);
	}

	
	// falta seccionItems
	
	public void generaXML(Document doc) {
		try {
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			// para indentar
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			//
			DOMSource domSource = new DOMSource(doc);
			StreamResult streamResult = new StreamResult(new File(xmlDireccion));
			transformer.transform(domSource, streamResult);
		} catch (TransformerException tfe) {
			tfe.printStackTrace();
		}
	}

}