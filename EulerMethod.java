/**
 * this will take in an initial x and y values, the delta x
 *  and the value we are trying to extrapolate 
 * 
 * @author adopt
 *
 */
public class EulerMethod {

	//data 
	public double initialX;
	public double initialY;
	public double stepSize;
	public double extrapVal;
	
	public EulerMethod(double x, double y, double ss, double e)
	{
		initialX = x;
		initialY = y;
		System.out.println("initial X value is: " + initialX);
		System.out.println("initial Y value is: " + initialY);
		System.out.println("//////////*****///////////");
		stepSize = ss;
		extrapVal = e;
	}
	
	//methods 
	public double gradientFinder(double x, double y)
	{
		double gradient = x*y + 2*y;
		return gradient;
	}
	
	public void newY()
	{
		while(initialX<extrapVal)
		{
			initialY = initialY +gradientFinder(initialX, initialY) *stepSize;
			initialX += stepSize;
			System.out.println("X value is: " + initialX);
			System.out.println("Y value is: " + initialY);
			System.out.println("//////////*****///////////");
		}
	}
	
	public static void main(String args[])
	{
		EulerMethod em = new EulerMethod(0,1,1,3);
		em.newY();
	}
}
