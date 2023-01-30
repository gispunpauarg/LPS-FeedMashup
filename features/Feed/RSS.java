import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

class RSS {
	
	// Feature FEED

	public void procesar(String f) {
		try {
			System.out.println("Noooo");
			rss_input = ingresoFeed(f);
			root = creaDocRSS(db);
			seccionRSS(root);
			seccionChannel(root, rss_input);
			seccionItems(root, rss_input);
			generaXML(root);
			// faltaria ver si posee sort truncate 
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public Document ingresoFeed(String f) throws ParserConfigurationException, SAXException, IOException {
		fact = DocumentBuilderFactory.newInstance();
		db = fact.newDocumentBuilder();
		return db.parse(f);
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

	public void seccionItems(Document root, Document rss_input) {
		items = rss_input.getElementsByTagName("item");
		for (int i = 0; i < items.getLength(); i++) {
			Element item_noticia = (Element) items.item(i);
			txtTitle = ((Element) item_noticia.getElementsByTagName("title").item(0)).getTextContent();
			txtLink = ((Element) item_noticia.getElementsByTagName("link").item(0)).getTextContent();
			txtDescri = ((Element) item_noticia.getElementsByTagName("description").item(0)).getTextContent();
			itPubdate = ((Element) item_noticia.getElementsByTagName("pubDate").item(0)).getTextContent();
			if (RSSsort) {
				System.out.println("entro seccion items Feed");
				arrayRss.add(new Tags(txtTitle, txtLink, txtDescri, itPubdate));
			}
			else {
				System.out.println("NO entro seccion items Feed");
				Element element_item = root.createElement("item");
				channel.appendChild(element_item);
				Element element_title = root.createElement("title");
				element_title.setTextContent(txtTitle);
				element_item.appendChild(element_title);
				Element element_link = root.createElement("link");
				element_link.setTextContent(txtLink);
				element_item.appendChild(element_link);
				Element element_description = root.createElement("description");
				element_description.setTextContent(txtDescri);
				element_item.appendChild(element_description);
				Element element_pubdate = root.createElement("pubDate");
				element_pubdate.setTextContent(itPubdate);
				element_item.appendChild(element_pubdate);
			}
		}
	}

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