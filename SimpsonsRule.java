/**
 * 
 * @author Anton Kopti
 * this code will numerically intergrate a function 
 * with a specified interval and data points 
 * it takes in the interval let's say from 0 to 1
 * then it devides it into portions so that it equals the
 * amountof data points the user wants 
 * then it runs the rule
 *
 */
public class SimpsonsRule 
{
	//data
	public double dataPNum;
	public double startP;
	public double endP;
	//constructors
	public SimpsonsRule(double x, double y, double z)
	{
		dataPNum = x;
		startP = y;
		endP = z;
	}
	//methods 
	public double function(double x)
	{
		return Math.cos(x);
	}
	public double Simpson()
	{
		double stepSize= (-startP +endP)/(dataPNum -1);
		System.out.println("Step Size: "+ stepSize);
		if(dataPNum==3) {
			
			return ((stepSize/3)*(function(startP)+4*function(startP+stepSize)+function(endP)));
		}
		else if(dataPNum == 5)
		{
			return ((stepSize/3)*(function(startP)+4*function(startP+stepSize)+function(startP +2*stepSize)) + (stepSize/3)*(function(startP + 2*stepSize)+4*function(startP+3*stepSize)+function(startP+4*stepSize)));
		}
		else if(dataPNum==7){
			return ((stepSize/3)*(function(startP)+4*function(startP+stepSize)+function(startP +2*stepSize)) + (stepSize/3)*(function(startP + 2*stepSize)+4*function(startP+3*stepSize)+function(startP+4*stepSize))+((stepSize/3)*(function(startP+4*stepSize)+4*function(startP+5*stepSize)+function(startP+6*stepSize))));
		}
		else
		{
			return -1;
		}
		
		
	}
	
	public static void main(String args[])
	{
		SimpsonsRule sr = new SimpsonsRule(5,0,Math.PI*2);
		System.out.println("Simpson's approximation: " + sr.Simpson());
	}
}
