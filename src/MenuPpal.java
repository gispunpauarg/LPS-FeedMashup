//package e12;

import java.awt.*;

public class MenuPpal extends Frame {

	private Panel panel;

	public MenuPpal() {
		
		paneles();
		menu();
	}
	
	private void paneles() {
        this.setSize(250,150);
		panel = new Panel();
		this.add(panel);
	}

	public void menu() {
		this.setTitle("LPS-FeedMashup - Linea de Productos de Sofwtare para aplicaciones Feed Mashup");
		// Crea una instancia de la clase Image a partir de la imágen que quieres usar como ícono
		Image icono = Toolkit.getDefaultToolkit().getImage("icono.png");  
		// Define el icono
		this.setIconImage(icono);

		Menu menuO = new Menu("Operaciones");
		Menu menuV = new Menu("Ver");
		Menu menuA = new Menu("Ayuda");
		Menu menuF = new Menu("Fin");

		EscuchaMenu escucha = new EscuchaMenu(panel);

		// Menu Operaciones
		MenuItem menuO1 = new MenuItem("Configuración de Mashup");
		MenuItem menuO2 = new MenuItem("Generación de Mashup");
		// Menu Ver
		MenuItem menuV1 = new MenuItem("RSS");
		MenuItem menuV2 = new MenuItem("Codigo Javascript");
		// Menu Ayuda
		MenuItem menuA1 = new MenuItem("Contenido");
		MenuItem menuA2 = new MenuItem("Acerca de");		
		// Menu Salir
		MenuItem fin = new MenuItem("Salir");
		
		menuO1.addActionListener(escucha);
		menuO2.addActionListener(escucha);
		menuV1.addActionListener(escucha);
		menuV2.addActionListener(escucha);		
		menuA1.addActionListener(escucha);
		menuA2.addActionListener(escucha);		
		fin.addActionListener(escucha);
		
		menuO.add(menuO1);
		menuO.add(menuO2);
		menuV.add(menuV1);
		menuV.add(menuV2);
		menuA.add(menuA1);
		menuA.add(menuA2);
		menuF.add(fin);
		
		// Barra de menus
		MenuBar mb = new MenuBar();
		setMenuBar(mb);
		mb.add(menuO);
		mb.add(menuV);
		mb.add(menuA);
		mb.add(menuF);
	}
}
