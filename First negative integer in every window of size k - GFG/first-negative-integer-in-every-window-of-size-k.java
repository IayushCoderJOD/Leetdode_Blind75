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


// class Compute {
    
//     public long[] printFirstNegativeInteger(long A[], int N, int K)
//     {
//         long [] window=new long[N-K+1];
//         Queue<Long> q=new LinkedList<>();
        
//         int i=0;
//         int j=0;
//         while(j<N){
//             if(A[j]<0)q.add(A[j]); 
//             if(j-i+1 <K){
//                 j++;
//             }
//             if(j-i+1==K){
//                 // if(q.size()==0){
//                 //     window[i]=0;
//                 //     break;
//                 // }
//                 window[i]=q.peek();
//                 if(A[i]==q.peek())q.remove();
//                 i++;j++;
//             }
//         }
//         return window;
//     }
// }

// class Compute {
    
//     public long[] printFirstNegativeInteger(long A[], int N, int K)
//     {
//         long[] ans = new long[N-K+1]; // to store the answer for each window
//         Queue<Long> queue = new LinkedList<>(); // to maintain negative elements in current window
        
//         int i = 0;
//         int j = 0;
//         while (j < N) {
//             // add the current element to queue if it is negative
//             if (A[j] < 0) {
//                 queue.add(A[j]);
//             }
//             // if the window is not complete, move the right pointer forward
//             if (j-i+1 < K) {
//                 j++;
//             } else if(j-i+1==K) {
//                 // if the window is complete, get the answer and move the left pointer forward
//                 ans[i] = queue.isEmpty() ? 0 : queue.peek();
//                 if (A[i] == queue.peek()) {
//                     queue.remove();
//                 }
//                 i++;
//                 j++;
//             }
//         }
        
//         return ans;
//     }
// }
// class Compute {
    
//     public long[] printFirstNegativeInteger(long A[], int N, int K)
//     {
//         long [] window = new long[N-K+1];
//         Queue<Long> q = new LinkedList<>();
        
//         int i = 0;
//         int j = 0;
//         while (j < N) {
//             if (A[j] < 0) {
//                 q.add(A[j]); 
//             }
//             if (j-i+1 < K) {
//                 j++;
//             }
//             if (j-i+1 == K) {
//                 window[i] = q.isEmpty() ? 0 : q.peek();
//                 if (A[i] == q.peek()) {
//                     q.remove();
//                 }
//                 i++;
//                 j++;
//             }
//         }
//         return window;
//     }
// }

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
        for (int i = 1; i <= N-K; i++) {
            // remove the leftmost element from the window and corresponding index from the queue
            if (!queue.isEmpty() && queue.peek() < i) {
                queue.remove();
            }
            // add the index of new rightmost element to queue if it is negative
            if (A[i+K-1] < 0) {
                queue.add(i+K-1);
            }
            // get the answer for current window
            ans[i] = queue.isEmpty() ? 0 : A[queue.peek()];
        }
        
        return ans;
    }
}
