//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int N=sc.nextInt();
			ArrayList<Integer> arr = new ArrayList<>();
			for(int i = 0; i < N ; i++){
			    arr.add(sc.nextInt());
			}
            Solution ob = new Solution();
         
            ArrayList<Integer> ans = ob.subsetSums(arr,N);
            Collections.sort(ans);
            for(int sum : ans){
                System.out.print(sum+" ");
            }
            System.out.println();
        }  
    }
}

// } Driver Code Ends


//User function Template for Java//User function Template for Java
class Solution{
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
        // code here
        ArrayList<Integer> subsets=new ArrayList<>();
        helper(subsets,arr,N, 0,0);
        Collections.sort(subsets);
        return subsets;
    }
    
    void helper(ArrayList<Integer> subsets,ArrayList<Integer> arr,int n,int sum, int i){
        if(i==n){
            subsets.add(sum);
            return ;
        }
        
        helper(subsets,arr,n,sum+arr.get(i),i+1);
        helper(subsets,arr,n,sum,i+1);
    }
}