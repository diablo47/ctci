package newones;

import java.util.HashMap;
import java.util.Map;

public class InterleavingString {

	class Key {
		int left;
		int right;

		public Key(int left, int right) {
			this.left = left;
			this.right = right;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + left;
			result = prime * result + right;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Key other = (Key) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (left != other.left)
				return false;
			if (right != other.right)
				return false;
			return true;
		}

		private InterleavingString getOuterType() {
			return InterleavingString.this;
		}

	}

	public static boolean isInterleave(String s1, String s2, String s3) {
		if (s3 == null)
			return false;
		if (s1 == null && s2 == null)
			return false;
		if (s1 == null && s2 != null)
			return s2.equals(s3);
		if (s2 == null && s1 != null)
			return s1.equals(s3);
		int length1 = s1.length();
		int length2 = s2.length();
		int length3 = s3.length();
		if ((length1 + length2) != length3)
			return false;
		return isInterleave(s1, s2, s3, 0, 0, new HashMap<Long, Boolean>());

	}

	public static boolean isInterleave(String s1, String s2, String s3,
			int start1, int start2, Map<Long, Boolean> cache) {
		long left = (long) start1;
		Long key = (left << 32) + start2;
		if (cache.get(key) != null)
			return cache.get(key);
		boolean ret = false;
		int start3 = start1 + start2;
		if (start1 == s1.length()) {
			ret = isSame(s2, start2, s3, start3);
			cache.put(key, ret);
			return ret;
		}
		if (start2 == s2.length()) {
			ret = isSame(s1, start1, s3, start3);
			cache.put(key, ret);
			return ret;
		}
		if (s1.charAt(start1) == s3.charAt(start3)) {
			ret = isInterleave(s1, s2, s3, start1 + 1, start2, cache);
			if (ret) {
				cache.put(key, ret);
				return ret;
			}
		}
		if (s2.charAt(start2) == s3.charAt(start3)) {
			ret = isInterleave(s1, s2, s3, start1, start2 + 1, cache);
			if (ret) {
				cache.put(key, ret);
				return ret;
			}
		}
		ret = false;
		cache.put(key, ret);
		return ret;
	}

	private static boolean isSame(String s1, int start1, String s2, int start2) {
		while (start1 <= s1.length() - 1 && start2 <= s2.length() - 1) {
			if (s1.charAt(start1) != s2.charAt(start2))
				return false;
			start1++;
			start2++;
		}
		return true;
	}

	public static void main(String[] args) {
		String s1 = "aa";
		String s2 = "ab";
		String s3 = "aaba";
		// String s1 = "aabcc";
		// String s2 = "dbbca";
		// String s3 = "aadbbcbcac";

		long left = 1;
		int right = 2;
		left = left << 32;
		System.out.println(1 << 32);
		System.out.println(0 << 32);
		long key = left + right;
		System.out.println(Long.toBinaryString(key));
		System.out.println(key);

		// System.out.println(isInterleave(s1, s2, s3));
		System.out.println(isSame(s1, 4, s3, 9));

	}
}
