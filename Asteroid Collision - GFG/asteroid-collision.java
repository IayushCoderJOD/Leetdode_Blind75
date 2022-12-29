//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {

            int N;
            N = sc.nextInt();

            int[] asteroids = new int[N];
            for (int i = 0; i < N; i++) asteroids[i] = sc.nextInt();

            Solution obj = new Solution();
            int[] res = obj.asteroidCollision(N, asteroids);

            for (int e : res) System.out.print(e + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
//   public static int[] asteroidCollision(int N, int[] asteroids) {
//         // code here
//         Stack<Integer> stack = new Stack<>();
//         for(int i=0;i<N;i++) {
//             while(stack.size()>0) {
//                 int idx = stack.peek();
//                 if(asteroids[i]<0) {
//                     // left-movement
//                     if(asteroids[idx]>0) {
//                         // right-movement
//                         if(-asteroids[i]<asteroids[idx]) {
//                             asteroids[i]=0;
//                             break;
//                         } else if(-asteroids[i]==asteroids[idx]) {
//                             asteroids[i]=0;
//                             asteroids[idx]=0;
//                             stack.pop();
//                             break;
//                         } else {
//                             asteroids[idx]=0;
//                             stack.pop();
//                         }
//                     } else {
//                         // left-movement
//                         break;
//                     }
//                 } else if(asteroids[i]==0) {
//                     break;
//                 } else {
//                     // right-movement
//                     break;
//                 }
//             }
            
//             if(asteroids[i]!=0) {
//                 stack.push(i);
//             }
//         }
//         int[] ans = new int[stack.size()];
//         int idx=ans.length-1;
//         while(stack.size()>0) {
//             ans[idx]=asteroids[stack.pop()];
//             idx--;
//         }
//         return ans;
//     }

public static int[] asteroidCollision(int N, int[] asteroids) {
    Stack<Integer> stack = new Stack<>();
    for (int asteroid : asteroids) {
        // If the asteroid is moving right or the stack is empty, just push it onto the stack
        if (asteroid > 0 || stack.isEmpty()) {
            stack.push(asteroid);
            continue;
        }
        
        // If the asteroid is moving left and the top of the stack is moving right, we need to check for a collision
        while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < -asteroid) {
            stack.pop();
        }
        
        // If the top of the stack is moving left or the asteroid is larger, push the asteroid onto the stack
        if (stack.isEmpty() || stack.peek() < 0) {
            stack.push(asteroid);
        }
        // If the top of the stack is moving right and the asteroid is smaller, they will collide and both explode
        else if (stack.peek() == -asteroid) {
            stack.pop();
        }
    }
    
    // Convert the stack to an array and return it
    int[] result = new int[stack.size()];
    for (int i = stack.size() - 1; i >= 0; i--) {
        result[i] = stack.pop();
    }
    return result;
}

}
