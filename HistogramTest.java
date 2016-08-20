import java.util.*;
import java.awt.*;
import javax.swing.*;


public class HistogramTest{

    //Test Program

    public static void main(String[] args){
        //initialize
        Histogram h = new Histogram();
        //feed some value for test
        double[] value = {2.3, 2.4, 5.2, 6, 9.6, 9.8, 16, 17.2};
        double[] freq = {7, 8, 2, 3, 1, 1, 3, 6};

        //get user input
        System.out.println("Please enter the lower bound: ");
        Scanner sc = new Scanner(System.in);
        h.setLowerBound(sc.nextDouble());
        System.out.println("Please enter the upper bound: ");
        h.setUpperBound(sc.nextDouble());
        System.out.println("Please enter the size of bin: ");
        h.setBinSize(sc.nextDouble());
        sc.close();

        //get values from object h
        double[] height = h.heightOfBin(value, freq);
        double lowerBound = h.getLowerBound();
        double upperBound = h.getUpperBound();
        double binSize = h.getBinSize();

        //print each value in array height, just for testing and debugging
        for (int i = 0; i < height.length; i++){
            System.out.println(height[i]);
        }

        //draw the histogram
        JFrame frame = new JFrame("Histogram");
        frame.setSize(800,600);
        frame.getContentPane().add(new DisplayHistogram(lowerBound, upperBound, binSize, height));
        frame.setLocationRelativeTo(null);
        frame.setBackground(Color.WHITE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
