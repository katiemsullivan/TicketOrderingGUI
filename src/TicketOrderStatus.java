import java.awt.Graphics;

import javax.swing.JComponent;

public class TicketOrderStatus extends JComponent{
	private int x = 5;
	private int y = 5;
	private int width = 300;
	private double percent = 0;

	public void paintComponent(Graphics g) {
		g.drawRect(x, y, 300, 30);
		int tempWidth = (int) (percent * width);
		g.fillRect(x, y, tempWidth, 30);
		
	}	
	
	public void setPercent(double percent) {
		this.percent = percent;	
		
		repaint();
	}
}
