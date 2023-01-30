public class RSS {
	
	// Feature: TRUNCATE

	public void procesar(String f, int nTruncate) {
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
	
	public void procesar(String f, String filtro, int nTruncate) {
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
	
}