import java.util.*;

public class financeforecast{

	public double futurevalue(double initval,double years,double growth_rate){
		if(years==0)return initval;
		return (futurevalue(initval,years-1,growth_rate)*(1+growth_rate));
	}

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		financeforecast fr = new financeforecast();
		System.out.println("Enter initial value : ");
		double val = sc.nextDouble();
		System.out.println("Enter number of years : ");
		double y = sc.nextDouble();
		System.out.println("Enter growth rate (in %) : ");
		double gt = sc.nextDouble();
		gt/=100;
		double result = fr.futurevalue(val,y,gt);
		System.out.println("Final result after growth : "+result);
	}
}