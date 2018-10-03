public class solution18And67 {

	/*
	 * Problem 18 and 67 are virtually the same,
	 * only differing in that 18 allows brute force
	 * whereas in problem 67 it is impossible.
	 * 
	 * In order to solve this problem we must
	 * go from the bottom up rather than from the
	 * top down. Let me propose an example:
	 * 
	 *      5
	 *     2 4
	 *    9 4 2
	 *    
	 * In this case, the most efficient solution
	 * is 5 + 2 + 9, or 16. We may break this triangle
	 * into smaller triangles. Lets start by looking at
	 * all the bottom triangles (2 in this case).
	 * 
	 * A:   B:
	 *   2    4
	 *  9 4  4 2
	 *  
	 *  When we get to the 2 in triangle A, we know that
	 *  we must travel to the 9. Similarly, when we get
	 *  to the 4 in triangle B we know we must travel to
	 *  the next 4. With this in mind, we know the sum of
	 *  A is 11 and B is 8, and we can update our initial
	 *  triangle accordingly:
	 *  
	 *      5
	 *    11 8
	 *  
	 *  If we do the same process again we can guarantee we
	 *  wish to travel to the 11, hence we can push it up
	 *  and have 16 at the top, our answer.
	 */
	
	public static void solveTriangle(int[][] nums){
		// Passed in a matrix of the numbers.
		
		// Start at the bottom (largest) row of numbers,
		// head up until we below the top (smallest,
		// size = 1) row.
		for(int a = nums.length - 1; a >= 1; a--){
			// Loop through every number within the row
			for(int b = 0; b < nums[a].length - 1; b++){
				// Set the number of the higher row equal to
				// the sum of itself as well as the larger of
				// either the number we currently are on or the
				// next number over, the other vertex of our
				// triangle.
				nums[a-1][b] = nums[a-1][b] + (nums[a][b] > nums[a][b+1] ? nums[a][b] : nums[a][b+1]);
			}
		}
		// Print the result at the top of our triangle.
		System.out.println(nums[0][0]);
	}
	
}
