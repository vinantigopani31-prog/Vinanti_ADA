import java.util.*;
public class LCS_Dynamic{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string x : ");
        String x = sc.next();
        System.out.println("Enter a string y : ");
        String y = sc.next();
        int m = x.length();
        int n = y.length();
        char b[][] = new char[m+1][n+1];
        int c[][] = new int[m+1][n+1];
        for(int i = 1 ; i < m ; i++){
            c[i][0] = 0 ;
        }
        for(int j = 0 ; j < n ; j++){
            c[0][j] = 0 ;
        }
        for(int i = 1 ; i <= m ; i++){
            for(int j = 1; j <= n ; j++){
                if(x.charAt(i-1) == y.charAt(j-1)){
                    c[i][j] = c[i-1][j-1] + 1 ;
                    b[i][j] = 'C' ;
                }
                else if(c[i-1][j] >= c[i][j-1]){
                    c[i][j] = c[i-1][j];
                    b[i][j] = 'U' ;
                }
                else{
                    c[i][j] = c[i][j-1] ;
                    b[i][j] ='L' ;
                }
            }
        }
        System.out.println("Matrix c : ");
        for(int i = 0 ; i <= m; i++){
            for(int j = 0 ; j <= n; j++){
                System.out.print(c[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("Matrix b : ");
        for(int i = 0 ; i <= m ; i++){
            for(int j = 0 ; j <= n ; j++){
                System.out.print(b[i][j] + " ");
            }
            System.out.println();
        }
        sc.close();
    }
}
/* output 
Enter a string x :
ABCBDAB
Enter a string y :
BDCABA
matrix c
0 0 0 0 0 0 0
0 0 0 0 1 1 1
0 1 1 1 1 2 2
0 1 1 2 2 2 2
0 1 1 2 2 3 3
0 1 2 2 2 3 3
0 1 2 2 3 3 4
0 1 2 2 3 4 4
matrix b
  U L L C L C L
  C L L U C L L
  U L C L L L L
  C L U L C L L
  U C L L U L L
  U U L C L L C
  C U L U C L L
Length of LCS = 4
LCS = BCBA */