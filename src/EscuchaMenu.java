
import java.awt.*;
import java.awt.event.*;

public class EscuchaMenu implements ActionListener {
	Panel pa;
	
	public EscuchaMenu(Panel text){
		this.pa = text;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		MenuItem mi = (MenuItem) e.getSource();

		String item = mi.getLabel();
		
		switch (item) {
			case "Configuración de Mashup":
				ConfigProducto frame = new ConfigProducto();
				frame.setVisible(true);
				break;
			case "Azul":
				pa.setBackground(Color.blue);
				break;
			case "Rojo":
				pa.setBackground(Color.red);
				break;
			case "Verde":
				pa.setBackground(Color.green);
				break;
			case "Rosado":
				pa.setBackground(Color.pink);
				break;
			case "Blanco":
				pa.setBackground(Color.white);
				break;
			case "Negro":
				System.exit(0);;
				break;
			case "Salir":
				System.exit(0);
				break;
		}
		
	}
}