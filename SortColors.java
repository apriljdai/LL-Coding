/*
Sort Colors

Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note:
You are not suppose to use the library's sort function for this problem.

Follow up:
A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.

Could you come up with an one-pass algorithm using only constant space?
*/

//runtime: O(n), two pointer, one points to the next index of 0, one points to the next index of 1 
public class SortColors{
	public void sortColors(int[] A){
		if (A == null || A.length == 0)
			return;

		int idx0 = 0;
		int idx1 = 0;
		for (int i = 0; i < A.length; i++){
			if (A[i] == 0){
				A[i] = 2;
				A[idx1++] = 1;
				A[idx0++] = 0;
			}
			if (A[i] == 1){
				A[i] = 2;
				A[idx1++] = 1;
			}
		}
	}
}
