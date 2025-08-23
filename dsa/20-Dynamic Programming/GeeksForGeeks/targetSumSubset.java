class Solution {

    static Boolean isSubsetSum(int arr[], int sum) {
        boolean dp[][]=new boolean[arr.length+1][sum+1];
        for(int i=0;i<dp.length;i++){
            dp[i][0]=true;
        }

        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                int v=arr[i-1];
                if(v<=j && dp[i-1][j-v]){
                    dp[i][j]=true;
                }

                if(dp[i-1][j]){
                    dp[i][j]=true;
                }
            }
        }

        return dp[arr.length][sum];
    }
}