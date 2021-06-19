import java.util.*;
public class RowReduce 
{
	//data 
	Scanner sc=new Scanner(System.in);  
	double [][] arr;
	int n;
	//constructor
	public RowReduce()
	{
		System.out.println("Please state the number of rows your array will contain:");
		int n= sc.nextInt();
		arr = new double[n][n];
		this.setValues();
	}
	//method 
		//this method will print the matrix 
	public void print()
	{
		for(int i =0;i<arr.length;i++)
		{
			for(int j =0; j<arr.length;j++)
			{
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
		//this method will take in the values of the array
	public void setValues()
	{
		System.out.println("State the values of your coefficients and then the value at the end.");
		System.out.println("For example if your equation is 3x +4y+7z=9 then you will input 3 and then 4 and then 7 and finally 9, repeat for all your equations.");
		for(int i=0;i<arr.length;i++)
		{
			for(int j=0;j<arr[0].length;j++)
			{
				arr[i][j]= sc.nextDouble();
			}
		}
	}
	
		//the method for making the array for which rows will be changed
	public void reducedRow()
	{
		int pointer = 0;
		while(pointer<arr.length) 
		{
			
			boolean h = true;
			if(arr[pointer][pointer]!=1)
			{
				for(int j=0;j<arr.length;j++)
				{
					arr[pointer][j] /= arr[pointer][pointer];
				}
				h=false;
			}
			if(arr[pointer][pointer]==1 || h)
			{
				int i = pointer;
				if(pointer==0 || i<arr.length)
				{
					for(int l=pointer+1;l<arr.length;l++) 
					{
						double x = (-1*arr[l][pointer])/arr[pointer][pointer];
						for(int k=0;k<arr.length;k++)
						{
							arr[l][k] += arr[k][pointer] * x;
						}
					}
				}
				if(i>=0)
				{
					for(int l=pointer-1;l>0;l--) 
					{
						double x = (-1*arr[l][pointer])/arr[pointer][pointer];
						for(int k=0;k<arr.length;k++)
						{
							arr[l][k] += arr[k][pointer] * x;
						}
					}
				}
			}
			pointer++;
		}
		this.print();
	}
	
	//main
	public static void main(String ars[])
	{
		RowReduce rr = new RowReduce();
		rr.reducedRow();
	}

}
