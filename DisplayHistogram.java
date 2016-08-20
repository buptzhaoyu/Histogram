import java.awt.*;
import javax.swing.*;

public class DisplayHistogram extends JPanel{

		double lb, ub, bs;
		double[] hob;

	//constructor, just used to get 4 variables for the paint method.
	public DisplayHistogram(double a, double b, double c, double[] d){
		lb = a;//lower bound
		ub = b;//upper bound
		bs = c;//bin size
		hob = d;//height of bins
	}

	public void paint (Graphics g){

        //get the maximum value of the input array
		double max = hob[0];
		for (int i = 0; i < hob.length; i++){
			if(hob[i] > max){
				max = hob[i];
			}
		}

        //calculate the width of each bin showed on the frame
		int width = (int)(600 / hob.length);

        //font configuration
		Font font1 = new Font("Times new roman", Font.BOLD, 16);
	    g.setFont(font1);

        //draw the lines of the coordinate
		g.drawLine(100, 100, 100, 500);
		g.drawLine(100, 500, 700, 500);
		g.setColor(Color.WHITE);
		g.drawLine(100, 480, 100, 465);
		g.setColor(Color.BLACK);
		g.drawLine(100, 465, 95, 470);
		g.drawLine(95, 470, 105, 475);
		g.drawLine(105, 475, 100, 480);

        //draw the bins
		for (int n = 0; n < hob.length; n++){
			g.setColor(Color.BLACK);
            //calculate the height of (n+1)th bin
			int height = (int)(400 / max * hob[n]);
            //draw the numbers on both x-axis and y-axis
			g.drawString(""+ (int)(lb + n * bs), width * n + 95, 525);
			g.drawString("" + (int)(max / 4 * (n + 1)), 75, 500 - 100 * (n + 1));
            //I use two different colors to paint the bins so that they are easily to recognize and prettier.
			if (n % 2 == 0){
				g.setColor(Color.GRAY);
                //some coordinates calculation
				g.fillRect(width * n + 100, 500-height, width, height);
			} else {
				g.setColor(Color.BLACK);
				g.fillRect(width * n + 100, 500-height, width, height);
			}
		}

	}



}
