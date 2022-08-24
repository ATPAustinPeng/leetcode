/*
    8. String to Integer (atoi)

    Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer (similar to C/C++'s atoi function).

    The algorithm for myAtoi(string s) is as follows:
        1. Read in and ignore any leading whitespace.
        2. Check if the next character (if not already at the end of the string) is '-' or '+'. Read this character in if it is either. This determines if the final result is negative or positive respectively. Assume the result is positive if neither is present.
        3. Read in next the characters until the next non-digit character or the end of the input is reached. The rest of the string is ignored.
        4. Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32). If no digits were read, then the integer is 0. Change the sign as necessary (from step 2).
        5. If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then clamp the integer so that it remains in the range. Specifically, integers less than -231 should be clamped to -231, and integers greater than 231 - 1 should be clamped to 231 - 1.
        6. Return the integer as the final result.

    Note:
    Only the space character ' ' is considered a whitespace character.
    Do not ignore any characters other than the leading whitespace or the rest of the string after the digits.
*/

public class Problem8 {
    public int myAtoi(String s) {
        s = s.strip();
        
        // emtpry string case
        if (s.length() == 0) {
            return 0;
        }
        
        int sign = 1;
        
        // negative value case
        if (s.charAt(0) == '-') {
            sign = -1;
            s = s.substring(1);
        } else if (s.charAt(0) == '+') {
            s = s.substring(1);
        }
        
        int result = 0;
        
        for (int i = 0; i < s.length(); i++) {
            // special character case
            if (s.charAt(i) > '9' || s.charAt(i) < '0' || s.charAt(i) == ' ') {
                break;
            }
            
            int digit = s.charAt(i) - '0';
            
            // overflow/underflow case
            // Note: don't need to handle 0-7 for positive, 0-8 for negative separately
            // since positive case considers any digit > 7 to be too large (which includes 8, 9)
            if ((result > Integer.MAX_VALUE / 10) || (result == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
                System.out.println(digit + " " + result);
                if (sign == -1) {
                    return Integer.MIN_VALUE;
                    
                }
                return Integer.MAX_VALUE;
            }
            
            result = result * 10 + digit;
        }
        
        return sign * result;
    }
}