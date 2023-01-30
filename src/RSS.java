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
import javax.xml.transform.stream.StreamResult; import java.io.File; 
import java.io.IOException; 

import javax.xml.parsers.DocumentBuilder; 
import javax.xml.parsers.DocumentBuilderFactory; 
import javax.xml.parsers.ParserConfigurationException; import org.w3c.dom.Document; 
import org.w3c.dom.Element; 

public  

class  RSS {
	
	
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

	
	
	public void procesar  (String f, String filtro, int nTruncate) {
		try {
			RSStruncate=true;
			rss_input = ingresoFeed(f);
			root = creaDocRSS(db);
			seccionRSS(root);
			seccionChannel(root, rss_input);
			seccionItems(root, rss_input, filtro);
			if (RSSsort) {
	            ordenadosPorTitle(arrayRss);
	    		grabarTags(root, arrayRss);
			}
			regenerarRSS(xmlDireccion, nTruncate);
			generaXML(root);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	
	
	// Feature: SORT
	
	public void procesar  (String f, String filtro) {
		try {
			RSSsort=true;
			rss_input = ingresoFeed(f);
			root = creaDocRSS(db);
			seccionRSS(root);
			seccionChannel(root, rss_input);
			seccionItems(root, rss_input, filtro);
		    ordenadosPorTitle(arrayRss);
		    grabarTags(root, arrayRss);
			generaXML(root);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	
	
	// Feature: TRUNCATE

	public void procesar  (String f, int nTruncate) {
		try {
			FeedMashup fm = new FeedMashup();
			
			System.out.println("entrooooooo");
			RSStruncate=true;
			rss_input = ingresoFeed(f);
			root = creaDocRSS(db);
			seccionRSS(root);
			seccionChannel(root, rss_input);
			seccionItems(root, rss_input);
			//if (RSSsort) {
			if (fm.FMsort) {
				System.out.println("entrooooooo sort true");
	            ordenadosPorTitle(arrayRss);
	    		grabarTags(root, arrayRss);
			}
			else
				System.out.println("entrooooooo sort false");
			//regenerarRSS(xmlDireccion, nTruncate);
			generaXML(root);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	
	
	// Feature FEED

	public void procesar  (String f) {
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

	

	public Document ingresoFeed  (String f) throws ParserConfigurationException, SAXException, IOException {
		fact = DocumentBuilderFactory.newInstance();
		db = fact.newDocumentBuilder();
		return db.parse(f);
	}

	

	public Document creaDocRSS  (DocumentBuilder db) {
		return db.newDocument();
	}

	

	public void seccionRSS  (Document root) {
		rss = root.createElement("rss");
		rss.setAttribute("version", "2.0");
		rss.setAttribute("xmlns:atom", "http://www.w3.org/2005/Atom");
		root.appendChild(rss);
		channel = root.createElement("channel");
		rss.appendChild(channel);
	}

	

	public void seccionChannel  (Document root, Document rss_input) {
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

	

	public void generaXML  (Document doc) {
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

	

	public void regenerarRSS(String archivo, int nTruncate) {
		try {
			int hasta = 0;
			fact = DocumentBuilderFactory.newInstance();
			db = fact.newDocumentBuilder();
			rss_input = db.parse(archivo);

			// ver cambio nombre root
			root = db.newDocument();
			// tag RSS
			rss = root.createElement("rss");
			rss.setAttribute("version", "2.0");
			rss.setAttribute("xmlns:atom", "http://www.w3.org/2005/Atom");
			root.appendChild(rss);

			// tag CHANNEL
			channel = root.createElement("channel");
			rss.appendChild(channel);
			items = rss_input.getElementsByTagName("channel");
			Element elementos_channel = (Element) items.item(0);

			txtTitle = ((Element) elementos_channel.getElementsByTagName("title").item(0)).getTextContent();
			chTitle = root.createElement("title");
			chTitle.setTextContent(txtTitle);
			channel.appendChild(chTitle);
			txtLink = ((Element) elementos_channel.getElementsByTagName("link").item(0)).getTextContent();
			chLink = root.createElement("link");
			chLink.setTextContent(txtLink);
			channel.appendChild(chLink);
			txtDescri = ((Element) elementos_channel.getElementsByTagName("description").item(0)).getTextContent();
			chDescription = root.createElement("description");
			chDescription.setTextContent(txtDescri);
			channel.appendChild(chDescription);

			// tag ITEM
			items = rss_input.getElementsByTagName("item");

			if (nTruncate <= items.getLength())
				hasta = nTruncate;
			else
				hasta = items.getLength();

			for (int i = 0; i < hasta; i++) {
				Element elementos_items = (Element) items.item(i);
				txtTitle = ((Element) elementos_items.getElementsByTagName("title").item(0)).getTextContent();
				txtLink = ((Element) elementos_items.getElementsByTagName("link").item(0)).getTextContent();
				txtDescri = ((Element) elementos_items.getElementsByTagName("description").item(0)).getTextContent();
				String itPubdate = ((Element) elementos_items.getElementsByTagName("pubDate").item(0)).getTextContent();

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
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	
	////////////////////////////////////////////////// 4/9
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

	
	//////////////////////////////////////////////////
	public void ordenadosPorTitle(ArrayList<Tags> arrayRss){
        int i, j, k;
        Tags aux;
        for(i = 0; i < arrayRss.size()-1; i++)
            for(j=0; j < arrayRss.size()-i-1; j++) {
            	k = arrayRss.get(j+1).getTitle().compareTo(arrayRss.get(j).getTitle());
                if(k<0){
                	aux = arrayRss.get(j+1);
                	arrayRss.set(j+1, arrayRss.get(j));
                	arrayRss.set(j, aux);                
                }           	
            }
    }

	
	
	public void grabarTags(Document root, ArrayList<Tags> arrayRss) {  
	    for(int i = 0; i< arrayRss.size(); i++) {
			txtTitle = arrayRss.get(i).getTitle();
			txtLink = arrayRss.get(i).getLink();
			txtDescri = arrayRss.get(i).getDescription();
			itPubdate = arrayRss.get(i).getPubDate();

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
	    System.out.println("ordenado");
	}


}
