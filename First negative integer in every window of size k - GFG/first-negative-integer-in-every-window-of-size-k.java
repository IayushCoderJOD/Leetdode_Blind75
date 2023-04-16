//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            long a[] = new long[(int)(n)];
            // long getAnswer[] = new long[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            int k = Integer.parseInt(br.readLine().trim());
            
            Compute obj = new Compute();
            long answer[] = obj.printFirstNegativeInteger(a, n, k);
            int sz = answer.length;
            
            StringBuilder output = new StringBuilder();
            for(int i=0;i<sz;i++)
                output.append(answer[i]+" ");
            System.out.println(output);
            
        }
	}
}


// } Driver Code Ends


//User function Template for Java

class Compute {
    
    public long[] printFirstNegativeInteger(long A[], int N, int K)
    {
        long[] ans = new long[N-K+1]; // to store the answer for each window
        Queue<Integer> queue = new LinkedList<>(); // to maintain indices of negative elements in current window
        
        // process the first window
        for (int i = 0; i < K; i++) {
            if (A[i] < 0) {
                queue.add(i);
            }
        }
        ans[0] = queue.isEmpty() ? 0 : A[queue.peek()];
        
        // process remaining windows
        for (int i = K; i < N; i++) {
            // remove the leftmost element from the window and corresponding index from the queue
            if (!queue.isEmpty() && queue.peek() <= i-K) {
                queue.remove();
            }
            // add the index of new rightmost element to queue if it is negative
            if (A[i] < 0) {
                queue.add(i);
            }
            // get the answer for current window
            ans[i-K+1] = queue.isEmpty() ? 0 : A[queue.peek()];
        }
        
        return ans;
    }
}
