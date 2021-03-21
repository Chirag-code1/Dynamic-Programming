#include <iostream>
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
	int n = 5;
	int a[] = {1,1,1,1,1};
	//here taking target as Sum.
	int target = 3;
	
	int sum,sum_array,i;
	for(i=0;i<n;i++){
	    sum_array+=a[i];
	}
	
	//let's consider that all the elements with +ve sign are put in one subset and all other with -ve sign are put in another subset. Then adding these two subsets will yeild the TARGET Sum. 
	//or, S1-S2= Target Sum.------(1)
	//& we also know and S1+S2 = array_sum.
	// therefore, we can also write S2 as, (S2= array_sum - S1)-----(2).
	//On putting eq(2) in eq(1). we get,
	//S1 -(array_sum - S1) = Target Sum.   or,
	// 2(s1)-array_sum= Target Sum.     or,
	// *******s1 = (array_sum + Target Sum)/2;*****
	// And tus, this Target sum problem has reduced to Subset Sum Problem.
	
	sum=(sum_array+target)/2;

	cout << (subsetSum(a, n, sum));
}
