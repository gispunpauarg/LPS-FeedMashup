import org.w3c.dom.Document;
import org.w3c.dom.Element;

class RSS {
	
	// Feature: SORT
	
	public void procesar(String f, String filtro) {
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