
import java.io.*;

public class Main
{
	// Returns the minimum value of 
	//the difference of the two sets.
	static int findMin(int arr[], int n)
	{
		// Calculate Range/sum of all elements.
		int sum = 0; 
		for (int i = 0; i < n; i++)
			sum += arr[i];
	
		// Create an array to store 
		// results of subproblems
		boolean dp[][] = new boolean[n + 1][sum + 1];
	
		//initilizing ist row as F, coze no sum can be returned with 0 element in array, except for sum as 0. isiliye, loop 0 se start ni kiya, 1 se kiya hai.
		for (int i = 1; i <= sum; i++)
			dp[0][i] = false;
			
			
		//initilizing 1st column as TRUE, coze we are always in a condition to return sum as ZERO. no matter whichever elements we have in array.
		for (int i = 0; i <= n; i++)
			dp[i][0] = true;
		
	
		// Fill the partition table 
		// in bottom up manner
		for (int i = 1; i <= n; i++)
		{
			for (int j = 1; j <= sum; j++)
			{
				// If i'th element is included
				if (arr[i - 1] <= j)
					dp[i][j] = dp[i - 1][j - arr[i - 1]];
					
				else{
				    // If i'th element is excluded
				    dp[i][j] = dp[i - 1][j];
				}
			}
		}
	
		// Initialize difference of two sums. 
		int diff = Integer.MAX_VALUE;
		
		// Find the largest j such that dp[n][j]
		// is true where j loops from sum/2 t0 0
		//The idea is, sum of S1 is j and it should be closest
        //to sum/2, i.e., 2*j should be closest to sum. isiliye hmne sum/2 
        //se loop chalaya 0 tk and break; krva diya pehla True milte hi.
		for (int j = sum / 2; j >= 0; j--)
		{
			
			if (dp[n][j] == true)
			{
				diff = sum - 2 * j;
				break;
			}
		}
		return diff;
	}
	
	
	public static void main (String[] args) 
	{
		int arr[] = {1,2,7};
		int n = arr.length;
		System.out.println ("The minimum difference between 2 sets is "
							+ findMin(arr, n));
	
	}
}

