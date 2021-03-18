#include <bits/stdc++.h>
using namespace std;

int subsetSum(int a[], int n, int sum)
{
	// Initializing the matrix
	int t[n + 1][sum + 1];


    //initilizing Ist row, coze any array with 0 element cannot yeild any sum except for ZERO.
	for (int i = 0; i <= sum; i++)
		t[0][i] = 0;
		
		 //initilizing Ist column, coze it is always possible to return sum as ZERO with any number of elements in an array; coze in order to return ZERO, we just need an Empty set i.e { }.
	for (int i = 0; i <= n; i++)
		t[i][0] = 1;

	for (int i = 1; i <= n; i++)
	{
		for (int j = 1; j <= sum; j++)
		{
		// if a[i-1] is greater than the sum, we will never ever include that, therefore return the t[i-1][j] value.
			if (a[i - 1] > j)
				t[i][j] = t[i - 1][j];
			else
			{
				t[i][j] = t[i - 1][j] + t[i - 1][j - a[i - 1]];
			}
		}
	}


	return t[n][sum];
}

int main()
{
int set[] = {1,1,2,3};
		int diff=1;
		int n = 4;
		int sumArr=0;
		
		for(int i=0;i<n;i++){
		    sumArr+=set[i];
		}
		
		int sum=    (diff+sumArr)/2;
		
	cout << (subsetSum(set, n, sum));
}
