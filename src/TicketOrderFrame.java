import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TicketOrderFrame extends JFrame {
	private TicketSales ticketOrder;
	private JLabel userPrompt = new JLabel("Enter how many tickets you'd like to purchase (1-6):");
	private JTextField inputBox = new JTextField(7);
	private JButton purchaseTickets = new JButton("Purchase Tickets");
	private JLabel outputInfo = new JLabel();
	private TicketOrderStatus statusBar = new TicketOrderStatus();
	private JLabel soldOut = new JLabel();
	
	public TicketOrderFrame(TicketSales x) {
		this.ticketOrder = x;
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		
		
		userPrompt.setPreferredSize(new Dimension (0, 40));//Width is 0 because it isn't taken into account
		inputBox.setMaximumSize(new Dimension (75, 75));
//		inputBox.setAlignmentX(CENTER_ALIGNMENT); //I couldn't get the alignment to work
		purchaseTickets.setPreferredSize(new Dimension(0, 25));
//		purchaseTickets.setAlignmentX(CENTER_ALIGNMENT);
		outputInfo.setPreferredSize(new Dimension (0, 40));
		statusBar.setPreferredSize(new Dimension(315, 35));
		
		mainPanel.add(userPrompt);
		mainPanel.add(inputBox);
		mainPanel.add(purchaseTickets);
		mainPanel.add(outputInfo);
		mainPanel.add(statusBar);	
		mainPanel.add(soldOut);
		add(mainPanel);
		
		purchaseTicketsClickListener a = new purchaseTicketsClickListener();
		purchaseTickets.addActionListener(a);
	}
	
	class purchaseTicketsClickListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			int numberTickets = 0;
			
			String a = inputBox.getText();
			if (!(a.equals(""))) { //checks for input in the box
			} try {
				numberTickets = Integer.parseInt(a);
				if (numberTickets >= 1 && numberTickets <= TicketSales.MAX_PER_BUYER) {
					if (numberTickets <= ticketOrder.getTicketsRemaining()) {
						ticketOrder.purchaseTickets(numberTickets); //reduces tickets remaining
						outputInfo.setText(numberTickets + " tickets purchased. " + 
								ticketOrder.getTicketsRemaining() + " tickets remaining.");
						statusBar.setPercent(ticketOrder.getPercentSold()); //calls method that calcs total % sold
						inputBox.setText(""); //reset the box after purchase
					} else if (numberTickets > ticketOrder.getTicketsRemaining() 
							&& ticketOrder.getTicketsRemaining()!=0){
						outputInfo.setText(ticketOrder.getTicketsRemaining() + " tickets remaining.");
						inputBox.setText(""); 
					} else {
						outputInfo.setText(ticketOrder.getTicketsRemaining() + " tickets remaining.");
						soldOut.setText("Event is sold out");
					}	
				} else {
					outputInfo.setText("6 is the max available per order. " 
							+ ticketOrder.getTicketsRemaining() + " tickets remaining.");
					inputBox.setText("");
				} 
				
			} catch (NumberFormatException ex){  //throws exception if input can't be converted to valid input
				outputInfo.setText("Please enter a number only.");
				inputBox.setText("");
			}

		}
	}
	
	

}
