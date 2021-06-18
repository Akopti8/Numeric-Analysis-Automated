
public class ModEuler 
{

	//data
	double ykMin2;  //y sub k- 2
	double xkMin2;
	double stepSize;
	double ykMin1;   //y sub -1
	double xkMin1;
	double yk;  //y sub k
	double xk;
	double minOfXk = 3;
	//constructor
	
	public ModEuler(double x, double y, double z)
	{
		ykMin2= y;
		xkMin2 = x;
		stepSize = z;
		xk = xkMin2;
		System.out.println("initial value of x = " + x);
		System.out.println("///////");
		System.out.println("initial value of y = " + y);
		System.out.println("///////");
	}
	
	//methods 
	public double yPrime(double yVal, double xVal)
	{
		return(yVal*xVal +2*yVal);
		
	}
	public double[] DiffrentialEquation()
	{
		//takes in the diffrential Equation
		double yprime = yPrime(ykMin2, xkMin2);
		double yDoublePrime = ykMin2+ xkMin2*yprime + 2*yprime;
		double yTriplePrime = yprime + yprime + xkMin2*yDoublePrime + 2*yDoublePrime;
		double [] arr = {yprime, yDoublePrime, yTriplePrime};
		return arr;
	}
	public void findYsubOne()
	{
		//finds new Y sub one and x sub one
		double [] arr = DiffrentialEquation();
		 ykMin1 = ykMin2 + arr[0]*stepSize + ((arr[1]*(stepSize*stepSize))/2) +((arr[2]*(stepSize*stepSize*stepSize)/6));
		 xk = stepSize+ xk;
		 System.out.println("value of X:" + xk);
		 System.out.println("Y Sub One is: " + ykMin1);
		 System.out.println("Y sub one prime is: " + yPrime(ykMin1, xk));		 System.out.println("///////");
	}
	
	public double predictedYPrime()
	{
		double newY = ykMin2 + 2*(stepSize)*yPrime(ykMin1, xk);
		System.out.println("predicted y = " + newY);
		System.out.println("///////");
		double predictedYPrime = yPrime(newY,xk +stepSize);
		System.out.println("predicted y prime = " + predictedYPrime);
		System.out.println("///////");
		return predictedYPrime; 
	}
	
	public void correctedY() //find corrected value of Y
	{
		
		yk  = ykMin1 + (stepSize)*((yPrime(ykMin1, xk) + predictedYPrime())/2);
		xk = stepSize+ xk;
		System.out.println("value of X:" + xk);
		System.out.println(" new Corrected value of Y: " + yk);
		System.out.println("////////////////*******////////////////");
		
	}
	
	public void ModEulerMeth()
	{
		this.findYsubOne();
		while(xk<minOfXk)
		{
			
			correctedY();
			ykMin2 = ykMin1;
			xkMin2 = xkMin1;
			ykMin1 = yk;
		}
		
	}
	
	public static void main(String args[])
	{
		ModEuler ME = new ModEuler(/**initial x value**/ 0, /**initial Y value**/ 1, /**stepSize**/1);
		ME.ModEulerMeth();
	}
}
