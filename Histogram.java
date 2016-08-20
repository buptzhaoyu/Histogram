public class Histogram{
    //initiate the bounds of histogram and the size of each bin
    private double lowerBound;
    private double upperBound;
    private double binSize;

    //initiate setter and getter
    public void setLowerBound(double l){
        lowerBound = l;
    }
    public void setUpperBound(double u){
        upperBound = u;
    }
    public void setBinSize(double b){
        binSize = b;
    }

    public double getLowerBound(){
        return lowerBound;
    }
    public double getUpperBound(){
        return upperBound;
    }
    public double getBinSize(){
        return binSize;
    }


    //get the value of each bin, in other words, the height of each bin
    public double[] heightOfBin(double[] value, double[] freq){//two arrays representing the pairs (value, freq)
        //get the size of the final array - heightOfEachBin by the user's input
        int count = (int)((upperBound - lowerBound)/binSize);
        double[] heightOfEachBin = new double[count];

        int n = 0;
        int i = 0;

        //set the value bin by bin
        while (n < count && i < value.length){//loop until the last bin
                if (value[i] >= lowerBound + n * binSize && value[i] < lowerBound + (n+1) * binSize){//if the value is inside the range of the current bin
                    heightOfEachBin[n] += freq[i];
                    i++;
                } 
                else{
                    n++;
                }
        }

        return heightOfEachBin;
    }
}
