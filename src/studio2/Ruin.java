package studio2;
import java.util.Scanner;
import java.util.Random;

public class Ruin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		Random rand = new Random();
		System.out.println("Start Amount: ");
		int startAmount = in.nextInt();
		System.out.println("Win Chance: ");
		double winChance = in.nextDouble();
		System.out.println("Win Limit: ");
		int winLimit = in.nextInt();
		System.out.println("Total days of simulation");
		int totalSimulations = in.nextInt();
		int k = 1;
		int j = startAmount;
		int successTime=0;
		int ruinTime=0;
		double successRate = 0.0;
		int b = 1;
		double expected = 0.0;
		if(winChance==50)
		{
			expected = 1.0-(startAmount*1.0/winLimit*1.0);
		}
	while(k < totalSimulations)
	{
		while(startAmount>0 && startAmount<winLimit)
		{
			int n = rand.nextInt(101);
			if (winChance>=n)
			{
				startAmount++;
			}
			else
			{
				startAmount--;
			}
			b++;
		}
		if(startAmount>0)
		{
			System.out.println("Simulation "+k+": "+b+" Win");
			successTime++;
		}
		else
		{
			System.out.println("Simulation "+k+": "+b+" Ruin");
			ruinTime++;
		}
		b=0;
		k++;
		startAmount = j;
	}
	successRate = 1.0*ruinTime/k;
	System.out.println("Losses: "+ruinTime+" Simulations: "+k);
	System.out.println("Ruin Rate From Simulation: "+successRate+" Expected Ruin Rate: "+expected);
	}

}
