import java.io.File;
import java.io.IOException;

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
	// Feature FILTER
	
	public void procesar(String f, String filtro) {
		try {
			RSSfilter=true;
			rss_input = ingresoFeed(f);
			root = creaDocRSS(db);
			seccionRSS(root);
			seccionChannel(root, rss_input);
			seccionItems(root, rss_input, filtro);
			generaXML(root);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void seccionItems(Document root, Document rss_input, String filtro) {
		items = rss_input.getElementsByTagName("item");
		for (int i = 0; i < items.getLength(); i++) {
			Element item_noticia = (Element) items.item(i);
			txtTitle = ((Element) item_noticia.getElementsByTagName("title").item(0)).getTextContent();
			txtLink = ((Element) item_noticia.getElementsByTagName("link").item(0)).getTextContent();
			txtDescri = ((Element) item_noticia.getElementsByTagName("description").item(0)).getTextContent();
			itPubdate = ((Element) item_noticia.getElementsByTagName("pubDate").item(0)).getTextContent();
			if ((txtTitle.indexOf(filtro) != -1)) {
				if (RSSsort)
					arrayRss.add(new Tags(txtTitle, txtLink, txtDescri, itPubdate));
				else {
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
	}

}