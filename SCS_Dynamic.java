import java.util.*;
public class SCS_Dynamic{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string x : ");
        String x = sc.next();
        System.out.println("Enter a string y : ");
        String y = sc.next();
        int m = x.length();
        int n = y.length();
        int dp[][] = new int[m+1][n+1] ;
        for(int i = 0 ; i <= m ; i++){
            for(int j = 0 ; j <= n ; j++){
                if(i == 0 ){
                    dp[i][j] = j ;
                }
                else if(j == 0) {
                    dp[i][j] = i ;
                }
                else if(x.charAt(i-1) == y.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1] ;
                }
                else{
                    dp[i][j] = 1 + Math.min(dp[i-1][j] , dp[i][j-1]);
                }
            }
        }
        for(int i = 0 ; i <= m ; i++){
            for(int j = 0 ; j <= n ; j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        sc.close();
    }
}
/* output 
X = abac (m = 4)
Y = cab  (n = 3)
DP Table:
0 1 2 3
1 2 2 3
2 3 3 3
3 4 4 4
4 4 5 5

Length of SCS = 5
SCS = cabac */