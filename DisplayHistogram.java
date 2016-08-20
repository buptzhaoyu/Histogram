import java.awt.*;
import javax.swing.*;

public class DisplayHistogram extends JPanel{
	
		double lb, ub, bs;
		double[] hob;
		
	public DisplayHistogram(double a, double b, double c, double[] d){
		lb = a;
		ub = b;
		bs = c;
		hob = d;
	}
	
	public void paint (Graphics g){
		
		double max = hob[0];
		for (int i = 0; i < hob.length; i++){
			if(hob[i] > max){
				max = hob[i];
			}
		}
		int width = (int)(600 / hob.length);
		Font font1 = new Font("Times new roman", Font.BOLD, 16);
		
		g.setFont(font1);
		g.drawLine(100, 100, 100, 500);
		g.drawLine(100, 500, 700, 500);
		g.setColor(Color.WHITE);
		g.drawLine(100, 480, 100, 465);
		g.setColor(Color.BLACK);
		g.drawLine(100, 465, 95, 470);
		g.drawLine(95, 470, 105, 475);
		g.drawLine(105, 475, 100, 480);
		for (int n = 0; n < hob.length; n++){
			g.setColor(Color.BLACK);
			int height = (int)(400 / max * hob[n]);
			g.drawString(""+ (int)(lb + n * bs), width * n + 95, 525);
			g.drawString("" + (int)(max / 4 * (n + 1)), 75, 500 - 100 * (n + 1));
			if (n % 2 == 0){
				g.setColor(Color.GRAY);
				g.fillRect(width * n + 100, 500-height, width, height);
			} else {
				g.setColor(Color.BLACK);
				g.fillRect(width * n + 100, 500-height, width, height);
			}
		}
		
	}
	

		
}