import javax.swing.JTextField;

/**
 * TODO description
 */
class FeedMashup {
 
	private JLabel lbFeed, lbFeed1, lbFeed2;
	//private JTextField jtfFeed;
	
	FeedMashup() {
		// Feature FEED
		FMfeed=true;
		lbFeed = new JLabel("Feed1       :");
		lbFeed1 = new JLabel("Feed2       :");
		lbFeed2 = new JLabel("Feed3       :");
		panel1.add(lbFeed);
		//JTextField txtFeed = new JTextField(45);
		panel1.add(jtfFeed);
		panel1.add(lbFeed1);
		panel1.add(jtfFeed1);
		panel1.add(lbFeed2);
		panel1.add(jtfFeed2);		
	}

}