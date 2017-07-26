

/**
 * @author santhoshsrinivasan
 *
 */
public class MedianOfSortedArray {
	public static void main(String[] args) {
		int[] nums1 = new int[] { 1, 2 };
		int[] nums2 = new int[] { 1, 1 };
		System.out.println(findMedianSortedArrays(nums1, nums2));
	}

	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int m = nums1.length;
		int n = nums2.length;
		int median = (m + n) / 2;

		boolean odd = (m + n) % 2 == 1;
		int required = median + 1;

		int res1 = 0;
		int res2 = 0;

		if (nums1.length == 0 && nums2.length == 0) {
			return 0.0;
		}
		if (nums1.length == 0) {

			for (int p = 0; p < required; p++) {
				if (p % 2 == 0) {
					res1 = nums2[p];
				} else {
					res2 = nums2[p];
				}
			}

			if (odd) {
				return res1 != 0 ? res1 : res2;
			} else {
				return ((double) (res1 + res2)) / 2;
			}
		}
		if (nums2.length == 0) {
			for (int p = 0; p < required; p++) {
				if (p % 2 == 0) {
					res1 = nums1[p];
				} else {
					res2 = nums1[p];
				}
			}

			if (odd) {
				return res1 != 0 ? res1 : res2;
			} else {
				return ((double) (res1 + res2)) / 2;
			}
		}

		int i = 0;
		int j = 0;
		int c = 0;
		// int[] nums1 = new int[] { 1, 2 };
		// int[] nums2 = new int[] { 1, 2, 3 };
		for (i = 0, j = 0; i < m && j < n;) {
			if (nums1[i] <= nums2[j]) {
				if (c % 2 == 0) {
					res1 = nums1[i];
				} else {
					res2 = nums1[i];
				}
				i++;
			} else {
				if (c % 2 == 0) {
					res1 = nums2[j];
				} else {
					res2 = nums2[j];
				}
				j++;
			}
			c++;
			required--;
			if (required <= 0) {
				break;
			}
		}

		if (i >= m) {
			required += j;
			for (int p = j; p < required; p++) {
				if (c % 2 == 0) {
					res1 = nums2[p];
				} else {
					res2 = nums2[p];
				}
				c++;
			}

			if (odd) {
				return res1 > res2 ? res1 : res2;
			} else {
				return ((double) (res1 + res2)) / 2;
			}
		} else if (j >= n) {
			required += i;
			for (int p = i; p < required; p++) {
				if (c % 2 == 0) {
					res1 = nums1[p];
				} else {
					res2 = nums1[p];
				}
				c++;
			}

			if (odd) {
				return res1 > res2 ? res1 : res2;
			} else {
				return ((double) (res1 + res2)) / 2;
			}
		}

		if (odd) {
			return res1 > res2 ? res1 : res2;
		} else {
			return ((double) (res1 + res2)) / 2;
		}

	}
}
