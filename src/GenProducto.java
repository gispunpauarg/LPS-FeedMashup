import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.Image;

public class GenProducto extends JFrame {

	private JPanel contentPane;
	private JTextField txtINombre;
	private JTextField txtC;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GenProducto frame = new GenProducto();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GenProducto() {
		setTitle("LPS-FeedMashup: Nuevo Mashup");
		// Crea una instancia de la clase Image a partir de la imágen que quieres usar como ícono
		Image icono = Toolkit.getDefaultToolkit().getImage("icono.png");  
		// Define el icono
		this.setIconImage(icono);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre Mashup:");
		lblNewLabel.setBounds(31, 89, 104, 14);
		contentPane.add(lblNewLabel);
		
		txtINombre = new JTextField();
		txtINombre.setText("Ingrese un nombre");
		txtINombre.setBounds(139, 86, 229, 20);
		contentPane.add(txtINombre);
		txtINombre.setColumns(10);
		
		JButton bBuscar = new JButton("Buscar");
		bBuscar.setBounds(31, 119, 89, 23);
		contentPane.add(bBuscar);
		
		txtC = new JTextField();
		txtC.setBackground(SystemColor.controlHighlight);
		txtC.setText("C:\\LPS-FeedMashup\\default.config");
		txtC.setColumns(10);
		txtC.setBounds(139, 120, 229, 20);
		contentPane.add(txtC);
		
		JButton bGenerarProducto = new JButton("Generar");
		bGenerarProducto.setBounds(154, 196, 136, 23);
		contentPane.add(bGenerarProducto);
		
		JButton bCancelar = new JButton("Cancelar");
		bCancelar.setBounds(306, 196, 117, 23);
		contentPane.add(bCancelar);
		
		JLabel lblGenerarProducto = new JLabel("GENERAR MASHUP");
		lblGenerarProducto.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblGenerarProducto.setBounds(206, 29, 192, 14);
		contentPane.add(lblGenerarProducto);
		
		JButton bConfiguracion = new JButton("Configuraci\u00F3n");
		bConfiguracion.setBounds(428, 85, 126, 23);
		contentPane.add(bConfiguracion);
	}
}
