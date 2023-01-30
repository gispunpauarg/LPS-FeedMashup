import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JCheckBox;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

import java.awt.Color;
import java.awt.TextField;

import java.awt.*;

/**
 * TODO description
 */
public class FeedMashup extends JFrame{
	// Feature: FEEDMASHUP
	private static final long serialVersionUID = 1; // clase ppal Ventana
	
	//RSS n;
	//public RSS rss = new RSS(this);
	public RSS rss;
	//
	private JPanel panel0, panel1; 
	//public boolean feed, filter, extract, sort, combine;
	
	public boolean FMfeed, FMfilter, FMsort, FMcombine, FMtruncate, FMduplicate;
	
	//boolean truncate=false;
	////////boolean truncate;
	//private String txtFeed, txtFilter;
	private JTextField jtfFeed = new JTextField(45);
	private JTextField jtfFeed1 = new JTextField(45);
	private JTextField jtfFeed2 = new JTextField(45);
	private JTextField jtfFilter = new JTextField(45);
	private JTextField jtfFilter1 = new JTextField(45);
	private JTextField jtfTruncate = new JTextField(10);
	private String txtFeed, txtFeed1, txtFeed2, txtFilter, txtFilter1;
	//
	//private int nTruncate;
	//
	private JCheckBox check1=new JCheckBox("Title");
	private JCheckBox check2=new JCheckBox("Description");
	private JCheckBox check3=new JCheckBox("Link");
	private JCheckBox check4=new JCheckBox("Pubdate");
    // ver
	String[] filtros;
	/*
	public DocumentBuilderFactory factO;
	public DocumentBuilder dbO;
	public static Document rss_inputO;
	public Document rootO;
	*/
	// finver
	//public ArrayList<Tags> arrayRss = new ArrayList();
	
	public FeedMashup() {
		// para acceder clase FeedMashup
		///this.n = n;
		//
		FMfeed=false; FMfilter=false; FMsort=false; FMcombine=false; FMtruncate=false; FMduplicate=false;
		int nTruncate=0;
		
		setTitle("LPS-FeedMashup - Linea de Productos de Sofwtare para aplicaciones Feed Mashup");
		// Crea una instancia de la clase Image a partir de la imágen que quieres usar como ícono
		Image icono = Toolkit.getDefaultToolkit().getImage("icono.png");  
		// Define el icono
		this.setIconImage(icono);
				
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 650, 450);
		setBounds(100, 100, 670, 490);
		panel0 = new JPanel();
		panel0.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel0);
		panel0.setLayout(null);
		
		panel1 = new JPanel();
		panel1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel1.setBounds(26, 198, 583, 200);
		panel0.add(panel1);
		panel1.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		JLabel lblFunciones = new JLabel("Funcionalidades");
		lblFunciones.setBounds(227, 11, 173, 14);
		panel0.add(lblFunciones);
		lblFunciones.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JLabel lblManipulate = new JLabel("MANIPULATE: Filter - Replace - Unique - Truncate - Sort - Shorten");
		lblManipulate.setBounds(26, 95, 506, 14);
		panel0.add(lblManipulate);
		
		JLabel lblInput = new JLabel("INPUT: Feed - Download - Webhook - Text Input - Pipes");
		lblInput.setBounds(26, 47, 506, 14);
		panel0.add(lblInput);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 170, 634, 2);
		panel0.add(separator);
		
		JLabel lblIntegration = new JLabel("INTEGRATION: Dailymotion - Mixcloud - Periscope - Reddit - Speedrun - SVT Play - Tweets - Ustream - Vimeo");
		lblIntegration.setBounds(26, 72, 608, 14);
		panel0.add(lblIntegration);
		
		JLabel lblControl = new JLabel("CONTROL: Combine - Duplicate - Merge Items - ForEach");
		lblControl.setBounds(26, 120, 506, 14);
		panel0.add(lblControl);
		
		JLabel lblCreate = new JLabel("CREATE: Extract - Images -Tables - Insert - Build Feed");
		lblCreate.setBounds(26, 145, 506, 14);
		panel0.add(lblCreate);
		
		JLabel lblProcesar = new JLabel("Complete las funcionalidades elegidas y presione el bot\u00F3n <Procesar>");
		lblProcesar.setBounds(26, 405, 431, 14);
		panel0.add(lblProcesar);
		
		JButton btnProcesar = new JButton("Procesar");
		btnProcesar.setBounds(520, 405, 89, 23);
		panel0.add(btnProcesar);
		btnProcesar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int nTruncate=0;
				if (FMtruncate==true) {
					System.out.println("Se ejecuta Truncate");
					try {
						nTruncate = Integer.parseInt(jtfTruncate.getText());
						System.out.println(nTruncate);
					} catch (NumberFormatException er) {
						System.out.println("Error: Un operando no es un numero entero");
					}
				}
				if (FMfeed==true) {
					System.out.println("Se ejecuta Feed");
					//recupera contenido de Feeds
					txtFeed = jtfFeed.getText();
					System.out.println(txtFeed);
					txtFeed1 = jtfFeed1.getText();
					System.out.println(txtFeed1);
					txtFeed2 = jtfFeed2.getText();
					System.out.println(txtFeed2);
				} 
				else {
					
				if (FMfilter==true) {
					System.out.println("Se ejecuta Filter");
					txtFilter = jtfFilter.getText();
					System.out.println(txtFilter);
					txtFilter1 = jtfFilter1.getText();
					System.out.println(txtFilter1);					
					
					// para 1 filtro y 1 feed
					if(txtFilter1.length()==0){	
						if(txtFeed1.length()==0){
							RSS miRSS = new RSS(txtFeed);
							// verifica si elegio sort
							if (check1.isSelected()==true || check2.isSelected()==true || check3.isSelected()==true   ) {
								//miRSS.procesar(txtFeed, txtFilter); 
								if (FMtruncate==true)
									miRSS.procesar(txtFeed, txtFilter, nTruncate);
								else 
									miRSS.procesar(txtFeed, txtFilter);
							}
							else 
								if (FMtruncate==true)
									//miRSS.procesar(feeds, txtFilter, nTruncate);
									miRSS.procesar(txtFeed, txtFilter, nTruncate);
								else 
									miRSS.procesar(txtFeed, txtFilter);
							    
							System.out.println("Quedo ok 1 feed 1 filtro");							
						} else { // + 1 feed y 1 filtro
							if(txtFeed2.length()==0){ // 2 feeds y 1 filtro
								System.out.println("entro 1 filtro y 2 feeds");
								String[] feeds={txtFeed, txtFeed1}; 
								RSS miRSS = new RSS(feeds);
								//
								if (FMtruncate==true)
									miRSS.procesar(feeds, txtFilter, nTruncate);
								else
									miRSS.procesar(feeds, txtFilter);
									//miRSS.procesar(feeds, txtFilter, nTruncate); // vemos
								//miRSS.procesar(feeds, txtFilter);
								
							System.out.println("Quedo ok 2 feeds");							
							} else { // 3 feeds y 1 filtro
								System.out.println("entro 1 filtro y 3 feeds");
								String[] feeds={txtFeed, txtFeed1, txtFeed2}; 
								
								RSS miRSS = new RSS(feeds);
	/*							 
								 if (check1.isSelected()==true || check2.isSelected()==true || check3.isSelected()==true   ) {
										miRSS.procesar(filtros, true);
									} else
										miRSS.procesar(filtros);
											
									System.out.println("Quedo ok2");
									*/	
								if (FMtruncate==true)
									miRSS.procesar(feeds, txtFilter, nTruncate);
								else
									miRSS.procesar(feeds, txtFilter);
								
									//miRSS.procesar(feeds, txtFilter, nTruncate);
								    //miRSS.procesar(feeds, txtFilter);
								
							System.out.println("Quedo ok 3 feeds");	
							}
						}
	
					} else {
						System.out.println("entro 2 filtros");
						 RSS miRSS = new RSS(txtFeed);
							//miRSS.procesar(txtFilter, txtFilter1);
						 //filtros={txtFilter, txtFilter1};
						 String[] filtros={txtFilter, txtFilter1};
						 
						 if (check1.isSelected()==true || check2.isSelected()==true || check3.isSelected()==true   ) {
							 
								if (FMtruncate==true)
									miRSS.procesar(filtros, true, nTruncate);
								else 
									miRSS.procesar(filtros, true);
							 
							 
								//miRSS.procesar(filtros, true);
							} else {
								if (FMtruncate==true)
									miRSS.procesar(filtros, false, nTruncate);
								else 
									miRSS.procesar(filtros, false);
							}
								//miRSS.procesar(filtros);
									
							System.out.println("Quedo ok2");						
					} 
				} else { // SIN FILTRO
					RSS miRSS = new RSS(txtFeed);
					// verifica si elegio sort
					if (check1.isSelected()==true || check2.isSelected()==true || check3.isSelected()==true   ) {
						//miRSS.procesar(txtFeed); 
						if (FMtruncate==true)
							miRSS.procesar(txtFeed, nTruncate);
						else 
							miRSS.procesar(txtFeed);
					} else 
						if (FMtruncate==true)
							miRSS.procesar(txtFeed, nTruncate);
						else 
							miRSS.procesar(txtFeed);
					    
					System.out.println("Quedo ok 1 feed 0 filtro");		
				}
				}
				System.out.println("FIN");
			}
		});
	}

    //Main Method
    public static void main(String[] args){
        FeedMashup v =new FeedMashup();
        v.setVisible(true);

    }
}