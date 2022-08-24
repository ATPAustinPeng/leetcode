public class Problem443 {
    public int compress(char[] chars) {
		// three pointers (start of uncompressed str, end of uncompressed str, index of compressed str)
        // if chars[start] == chars[end], end++ (aka keep looking for similar chars)
        // if chars[start] != chars[end], then end - start = number of chars to compress
			// Note: only add the number when end - start > 1
        // move start to end 
        
        // tracks our compressed string (in-place)
        int index = 0;
        
        // tracks the uncompressed string
        int start = 0;
        
        while (start < chars.length) {
            int end = start + 1;

            while (end < chars.length && chars[start] == chars[end]) {
                end++;
            }
			
			// track char for compressed string, then increment counter
            chars[index++] = chars[start];
			
			// if end - start > 1, then we want to add the value of (end - start) into the compressed string
            int startCharCount = end - start;
            if (startCharCount > 1) {
                String strStartCharCount = startCharCount + "";
                for (char c : strStartCharCount.toCharArray()) {
                    chars[index++] = c;
                }
            }
            start = end;
        }
        return index;
    }
}