
public class TicketSales {
	
	private String eventTitle;
	final static public int MAX_PER_BUYER = 6;
	private int totalAvailable = 75;
	private int ticketsRemaining = 75;
	
	
	public int purchaseTickets(int numberTickets) {
		ticketsRemaining -= numberTickets;
		return ticketsRemaining;
	}

	public double getPercentSold() {
		return (totalAvailable-ticketsRemaining)/(totalAvailable*1.0); 
	}

	public String getEventTitle() {
		return eventTitle;
	}

	public void setEventTitle(String eventTitle) {
		this.eventTitle = eventTitle;
	}

	public int getTicketsRemaining() {
		return ticketsRemaining;
	}

	public void setTicketsRemaining(int ticketsRemaining) {
		this.ticketsRemaining = ticketsRemaining;
	}

	
	
}
