import javax.swing.JFrame;

public class TicketOrderViewer {
	
	public static void main(String[] args) {
		TicketSales newOrder = new TicketSales();
		JFrame frame = new TicketOrderFrame(newOrder);
		
		frame.setSize(350, 250);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}

}
