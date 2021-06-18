
public class RungeKutta 
{
	//data
	double initialX;
	double initialY;
	double stepSize;

	public RungeKutta(double x, double y, double stp)
	{
		initialX= x;
		initialY= y;
		stepSize = stp;
		System.out.println("initial value of x = " + x);
		System.out.println("///////");
		System.out.println("initial value of y = " + y);
		System.out.println("///////");
	}
	
	//methods 
	
	public double diffrentialEquation(double x, double y)
	{
		double dif = x*y + 2*y;
		return dif;
	}
	
	public double k1()
	{
		double k1 = diffrentialEquation(initialX, initialY);
		//System.out.println("k1: f("+initialX+","+initialY+")");
		//System.out.println("K1 is: " +  k1);
		//System.out.println("//////////////////////////");
		return k1;
	}
	
	public double k2()
	{
		double x1 = initialX + stepSize/2;
		double y1 = initialY + (k1()*stepSize)/2;
		//System.out.println("k2: f("+x1+","+y1+")");
		//System.out.println("K2 is: " +  diffrentialEquation(x1, y1));
		//System.out.println("//////////////////////////");
		return diffrentialEquation(x1, y1);
	}
	
	public double k3()
	{
		double x1 = initialX + stepSize/2;
		double y1 = initialY + (k2()*stepSize)/2;
		System.out.println("k3: f("+x1+","+y1+")");
		System.out.println("K3 is: " +  diffrentialEquation(x1, y1));
		System.out.println("//////////////////////////");
		return diffrentialEquation(x1, y1);
	}
	
	public double k4()
	{
		double x1 = initialX + stepSize;
		double y1 = initialY + (k3()*stepSize);
		//System.out.println("K4 is: " +  diffrentialEquation(x1, y1));
		//System.out.println("//////////////////////////");
		//System.out.println("k4: f("+x1+","+y1+")");
		//System.out.println("K4 is: " +  diffrentialEquation(x1, y1));
		//System.out.println("//////////////////////////");
		return diffrentialEquation(x1, y1);
	}
	public void newY()
	{
		double newY = initialY + ((stepSize/6)*(k1()+2*k2()+2*k3()+k4()));
		initialY = newY;
		initialX = initialX + stepSize;
		//System.out.println("*****************");
		//System.out.println("the new X is: "+ initialX);
		//System.out.println("the new Y is: "+ newY);
		//System.out.println("*****************");
	}
	
	public void process()
	{
		while(initialX<1)
		{
			newY();
		}
	}
	
	public static void main(String args[])
	{
		long startTime = System.nanoTime();
		RungeKutta rk = new RungeKutta(0,1,1);
		rk.process();
		long endTime = System.nanoTime();
		System.out.println("Took "+(endTime - startTime) + " ns"); 
	}
}
