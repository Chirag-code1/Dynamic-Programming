
import java.io.*;

class Main {


	static int FriendsPair(int n)
	{
		int dp[] = new int[n + 1];

		// Filling dp[] in bottom-up manner using
		
		for (int i = 0; i <= n; i++) {
			if (i <= 2)
				dp[i] = i;
			else
				dp[i] = dp[i - 1] + (i - 1) * dp[i - 2];
		}

		return dp[n];
	}


	public static void main(String[] args)
	{
		int n = 3;
		System.out.println(FriendsPair(n));
	}
}

// This code is contributed by vt_m
