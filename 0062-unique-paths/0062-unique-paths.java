class Solution {
    int [] [] arr;
    public int uniquePaths(int m, int n) {
        arr = new int [m+1][n+1];
        return uniquePath(m,n);
    }
    public int uniquePath(int m,int n){
        if(arr[m][n]!=0) return arr[m][n];
        if(m==1||n==1) return 1;
        int res = uniquePath(m-1,n)+uniquePath(m,n-1);
        arr[m][n]=res%2_000_000_000;
        return arr[m][n];
    }
}