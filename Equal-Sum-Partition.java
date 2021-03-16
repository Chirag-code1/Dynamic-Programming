
public class Main {

	
	static boolean isSubsetSum(int arr[],
							int n)
	{
		int sum = 0;
        int i, j;
 
        // Calculate sum of all elements
        for (i = 0; i < n; i++)
            sum += arr[i];
 
        if (sum % 2 != 0)
            return false;
            
            
		boolean t[][] = new boolean[sum/2 + 1][n + 1];

		
		//COLUMN:
		for ( i = 0; i <= n; i++)
			t[0][i] = true;

		
		//ROW:
		for ( j = 1; j <= sum/2; j++)
			t[j][0] = false;

		for ( i = 1; i <= sum/2; i++) {
			for ( j = 1; j <= n; j++) {
				
				if (arr[j - 1]<=i)
					t[i][j] = t[i][j-1]
								|| t[i - arr[j - 1]][j - 1];
								
								else{
							        t[i][j] = t[i][j - 1];
								}
			}
		}

		

		return t[sum/2][n];
	}

	
	public static void main(String args[])
	{
		int arr[] = { 1,5,5,11 };
		int n = arr.length;
		if (isSubsetSum(arr, n) == true)
			System.out.println("FOUND!!");
		else
			System.out.println("No subset with"
							+ " given sum");
	}
}

