import java.util.Scanner;

class Knapsack
{

    // A utility function that returns maximum of two integers
     static int max(int a, int b){
        return (a > b)? a : b;
      }

     // Returns the maximum value that can be put in a knapsack of capacity W
     static int knapSack(int m, int wt[], int val[], int n){
            // Base Case
        if (n == 0 || m == 0)
            return 0;

        // If weight of the nth item is more than Knapsack capacity W, then
        // this item cannot be included in the optimal solution
        if (wt[n-1] > m)
           return knapSack(m, wt, val, n-1);

        // Return the maximum of two cases:
        // (1) nth item included
        // (2) not included
        else
            return max( val[n-1] + knapSack(m-wt[n-1], wt, val, n-1),
                         knapSack(m, wt, val, n-1));
      }


   public static void main(String args[]){

      Scanner in = new Scanner(System.in);
      int n_case = in.nextInt();

      while(in.hasNext()){
        int n = in.nextInt(); //Number of item
        int max_w = in.nextInt(); //Max weight

        int w[] = new int[n]; // value
        int v[] = new int[n]; // weight of item

        for(int i=0;i<n;i++){
          w[i] = in.nextInt();
        }

        for(int i=0;i<n;i++){
          v[i] = in.nextInt();
        }
        System.out.println(knapSack(max_w, w, v, n));
      }
    }
}
