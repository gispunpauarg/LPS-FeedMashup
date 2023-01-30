import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JButton;

public class ConfigProducto extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConfigProducto frame = new ConfigProducto();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/
	/**
	 * Create the frame.
	 */
	public ConfigProducto() {
		setTitle("LPS-FeedMashup - Linea de Productos de Sofwtare para aplicaciones Feed Mashup");
		// Crea una instancia de la clase Image a partir de la imágen que quieres usar como ícono
		Image icono = Toolkit.getDefaultToolkit().getImage("icono.png");  
		// Define el icono
		this.setIconImage(icono);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ButtonGroup grupoRequired, grupoIntegration;
		grupoRequired=new ButtonGroup();
		grupoIntegration=new ButtonGroup();
				
		JPanel panelManipulate = new JPanel();
		panelManipulate.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelManipulate.setBounds(412, 75, 440, 80);
		contentPane.add(panelManipulate);
		panelManipulate.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Manipulate");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(184, 11, 74, 14);
		panelManipulate.add(lblNewLabel);
		
		JCheckBox chbFilter = new JCheckBox("Filter");
		chbFilter.setBounds(20, 32, 57, 23);
		panelManipulate.add(chbFilter);
		
		JCheckBox chbReplace = new JCheckBox("Replace");
		chbReplace.setBounds(73, 32, 77, 23);
		panelManipulate.add(chbReplace);
		
		JCheckBox chbUnique = new JCheckBox("Unique");
		chbUnique.setBounds(152, 32, 65, 23);
		panelManipulate.add(chbUnique);
		
		JCheckBox chbTruncate = new JCheckBox("Truncate");
		chbTruncate.setBounds(219, 32, 81, 23);
		panelManipulate.add(chbTruncate);
		
		JCheckBox chbSort = new JCheckBox("Sort");
		chbSort.setBounds(302, 32, 49, 23);
		panelManipulate.add(chbSort);
		
		JCheckBox chbShorten = new JCheckBox("Shorten");
		chbShorten.setBounds(350, 32, 73, 23);
		panelManipulate.add(chbShorten);
		
		JPanel panelCreate = new JPanel();
		panelCreate.setLayout(null);
		panelCreate.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelCreate.setBounds(412, 325, 440, 80);
		contentPane.add(panelCreate);
		
		JLabel lblCreate = new JLabel("Create");
		lblCreate.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCreate.setBounds(197, 11, 74, 14);
		panelCreate.add(lblCreate);
		
		JCheckBox chbExtract = new JCheckBox("Extract");
		chbExtract.setBounds(20, 32, 69, 23);
		panelCreate.add(chbExtract);
		
		JCheckBox chbImages = new JCheckBox("Images");
		chbImages.setBounds(91, 32, 70, 23);
		panelCreate.add(chbImages);
		
		JCheckBox chbTables = new JCheckBox("Tables");
		chbTables.setBounds(163, 32, 67, 23);
		panelCreate.add(chbTables);
		
		JCheckBox chbInsert = new JCheckBox("Insert");
		chbInsert.setBounds(232, 32, 70, 23);
		panelCreate.add(chbInsert);
		
		JCheckBox chbBuildfeed = new JCheckBox("BuildFeed");
		chbBuildfeed.setBounds(304, 32, 89, 23);
		panelCreate.add(chbBuildfeed);
		
		JPanel panelControl = new JPanel();
		panelControl.setLayout(null);
		panelControl.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelControl.setBounds(412, 198, 440, 80);
		contentPane.add(panelControl);
		
		JLabel lblControl = new JLabel("Control");
		lblControl.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblControl.setBounds(191, 11, 54, 14);
		panelControl.add(lblControl);
		
		JCheckBox chbCombine = new JCheckBox("Combine");
		chbCombine.setBounds(20, 32, 76, 23);
		panelControl.add(chbCombine);
		
		JCheckBox chbDuplicate = new JCheckBox("Duplicate");
		chbDuplicate.setBounds(108, 32, 87, 23);
		panelControl.add(chbDuplicate);
		
		JCheckBox cbMergeitems = new JCheckBox("MergeItems");
		cbMergeitems.setBounds(205, 32, 109, 23);
		panelControl.add(cbMergeitems);
		
		JCheckBox chbForeach = new JCheckBox("ForEach");
		chbForeach.setBounds(316, 32, 97, 23);
		panelControl.add(chbForeach);
		
		JPanel panelInputIntegration = new JPanel();
		panelInputIntegration.setLayout(null);
		panelInputIntegration.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelInputIntegration.setBounds(31, 75, 350, 330);
		contentPane.add(panelInputIntegration);
		
		JLabel lblInputintegration = new JLabel("InputIntegration");
		lblInputintegration.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblInputintegration.setBounds(113, 11, 105, 14);
		panelInputIntegration.add(lblInputintegration);
		
		JPanel panelInput = new JPanel();
		panelInput.setBounds(20, 36, 159, 270);
		panelInputIntegration.add(panelInput);
		panelInput.setLayout(null);
		panelInput.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JLabel lblInput = new JLabel("Input");
		lblInput.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblInput.setBounds(10, 11, 78, 14);
		panelInput.add(lblInput);
		
		JCheckBox chckbxTextinput = new JCheckBox("TextInput");
		chckbxTextinput.setBounds(20, 32, 84, 23);
		panelInput.add(chckbxTextinput);
		
		JPanel panelRequired = new JPanel();
		panelRequired.setBounds(10, 60, 128, 183);
		panelInput.add(panelRequired);
		panelRequired.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelRequired.setLayout(null);
		
		JLabel lblRequired = new JLabel("Required");
		lblRequired.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblRequired.setBounds(10, 11, 78, 14);
		panelRequired.add(lblRequired);
		
		JRadioButton rbFeed = new JRadioButton("Feed");
		rbFeed.setBounds(10, 46, 78, 36);
		panelRequired.add(rbFeed);
		
		JRadioButton rbDownload = new JRadioButton("Download");
		rbDownload.setBounds(10, 71, 94, 36);
		panelRequired.add(rbDownload);
		
		JRadioButton rbWebhook = new JRadioButton("Webhook");
		rbWebhook.setBounds(10, 96, 94, 36);
		panelRequired.add(rbWebhook);
		
		JRadioButton rbPipe = new JRadioButton("Pipe");
		rbPipe.setBounds(10, 122, 78, 36);
		panelRequired.add(rbPipe);
		
		grupoRequired.add(rbFeed);
		grupoRequired.add(rbDownload);
		grupoRequired.add(rbWebhook);
		grupoRequired.add(rbPipe);
		
		JPanel panelIntegration = new JPanel();
		panelIntegration.setBounds(199, 36, 128, 270);
		panelInputIntegration.add(panelIntegration);
		panelIntegration.setLayout(null);
		panelIntegration.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JLabel lblIntegration = new JLabel("Integration");
		lblIntegration.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblIntegration.setBounds(10, 11, 78, 14);
		panelIntegration.add(lblIntegration);
		
		JRadioButton rbDailymotion = new JRadioButton("Dailymotion");
		rbDailymotion.setBounds(10, 32, 93, 36);
		panelIntegration.add(rbDailymotion);
		
		JRadioButton rbMixcloud = new JRadioButton("Mixcloud");
		rbMixcloud.setBounds(10, 57, 78, 36);
		panelIntegration.add(rbMixcloud);
		
		JRadioButton rbPeriscope = new JRadioButton("Periscope");
		rbPeriscope.setBounds(10, 82, 94, 36);
		panelIntegration.add(rbPeriscope);
		
		JRadioButton rbReddit = new JRadioButton("Reddit");
		rbReddit.setBounds(10, 106, 78, 36);
		panelIntegration.add(rbReddit);
		
		JRadioButton rbSpeedrun = new JRadioButton("Speedrun");
		rbSpeedrun.setBounds(10, 131, 93, 36);
		panelIntegration.add(rbSpeedrun);
		
		JRadioButton rbSvtplay = new JRadioButton("SVTPlay");
		rbSvtplay.setBounds(10, 156, 78, 36);
		panelIntegration.add(rbSvtplay);
		
		JRadioButton rbTweets = new JRadioButton("Tweets");
		rbTweets.setBounds(10, 181, 94, 36);
		panelIntegration.add(rbTweets);
		
		JRadioButton rbUstream = new JRadioButton("Ustream");
		rbUstream.setBounds(10, 205, 93, 36);
		panelIntegration.add(rbUstream);
		
		JRadioButton rbVimeo = new JRadioButton("Vimeo");
		rbVimeo.setBounds(10, 234, 78, 29);
		panelIntegration.add(rbVimeo);
		
		grupoIntegration.add(rbDailymotion);
		grupoIntegration.add(rbMixcloud);
		grupoIntegration.add(rbPeriscope);
		grupoIntegration.add(rbReddit);
		grupoIntegration.add(rbSpeedrun);
		grupoIntegration.add(rbSvtplay);
		grupoIntegration.add(rbTweets);
		grupoIntegration.add(rbUstream);
		grupoIntegration.add(rbVimeo);	
		
		JLabel lblNewLabel_1 = new JLabel("CONFIGURACION DE MASHUP");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_1.setBounds(311, 31, 295, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton bAceptar = new JButton("Aceptar");
		bAceptar.setBounds(344, 460, 89, 23);
		contentPane.add(bAceptar);
		
		JButton bCancelar = new JButton("Cancelar");
		bCancelar.setBounds(486, 460, 89, 23);
		contentPane.add(bCancelar);
		
	}
}
